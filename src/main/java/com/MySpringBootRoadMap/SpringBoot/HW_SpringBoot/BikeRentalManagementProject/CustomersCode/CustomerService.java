package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode;

import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode.Bike;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode.BikeRepository;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BikeRepository bikeRepository;
    private final ChargeUtil chargeUtil;

    public CustomerService(CustomerRepository customerRepo,
                           BikeRepository bikeRepo,
                           ChargeUtil chargeUtil) {
        this.customerRepository = customerRepo;
        this.bikeRepository = bikeRepo;
        this.chargeUtil = chargeUtil;
    }

    public String issueBike(Long bikeCc,
                            String bikeModel,
                            String bikeBrand,
                            Customer customer) {
 try {
     // FOR CUSTOMER VALID
     if (customer == null) {
         throw new NotFoundException("Customer details required");
     }
     //FOR CUSTOMER NAME VALID
     if (customer.getCustomerName().trim().isEmpty())
         throw new NotFoundException("Name cannot be empty!");
     if (!customer.getCustomerName().matches("[a-zA-Z ]+"))
         throw new NotFoundException("Name cannot be numeric!");
     //FOR CUSTOMER ADDRESS VALID
     if (customer.getCustomerAddress().trim().isEmpty())
         throw new NotFoundException("Address cannot be empty!");
     //FOR CUSTOMER PHONE VALID
     if (!customer.getCustomerPhone().matches("\\d{10}"))
         throw new NotFoundException("Phone number must be 10 digits!");
     Bike bike = bikeRepository
             .findByBikeCcAndBikeBrandAndBikeModelAndBikeStatus(
                     bikeCc,
                     bikeBrand,
                     bikeModel,
                     "Available"
             )
             .orElseThrow(() -> new NotFoundException("Bike not available"));

     customer.setIssuedbikeBrand(bikeBrand);
     customer.setIssuedbikeModel(bikeModel);
     customer.setIssuedbikeCc(bikeCc);
     customer.setIssuedDate(LocalDate.now());
     customer.setIssuedTime(LocalTime.now());
     customer.setCustomerPaidStatus("Unpaid Yet");

     customer.setTotalCharge(
             chargeUtil.calculateTotal(bikeCc, customer.getRentalDays())
     );

     bike.setBikeStatus("Not Available");

     bikeRepository.save(bike);
     customerRepository.save(customer);

     return "Bike issued successfully to " + customer.getCustomerName() +
             " with total charges : " + customer.getTotalCharge();
 }catch(NotFoundException e){
     return e.getMessage();
 }
    }

    public String returnBike(Integer customerId) {

        try {

            Customer customer = customerRepository.findByCustomerId(customerId)
                    .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + customerId)
                    );


            if (customer.getIssuedbikeCc() == null) {
                throw new IllegalStateException("This customer has no issued bike");
            }


            Bike bike = bikeRepository
                    .findByBikeCcAndBikeBrandAndBikeModelAndBikeStatus(
                            customer.getIssuedbikeCc(),
                            customer.getIssuedbikeBrand(),
                            customer.getIssuedbikeModel(),
                            "Not Available"
                    )
                    .orElseThrow(() ->
                            new NotFoundException("Issued bike record not found")
                    );


            bike.setBikeStatus("Available");
            bikeRepository.save(bike);


            customer.setCustomerPaidStatus("Paid");

            customerRepository.save(customer);
            deleteCustomer(customerId);
            return "Bike returned successfully by customer ID: " + customerId;


        } catch (NotFoundException e) {
            return  e.getMessage();
        }
    }


    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Integer customerId) {

        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + customerId));

        customerRepository.deleteByCustomerId(customerId);
    }
}
