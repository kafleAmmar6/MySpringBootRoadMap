package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.DB_Connection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDetail, String> {
}
