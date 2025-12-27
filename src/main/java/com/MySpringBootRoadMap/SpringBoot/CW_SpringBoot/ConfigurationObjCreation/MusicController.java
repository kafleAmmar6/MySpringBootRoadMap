package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.ConfigurationObjCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {

    @Autowired
    private MusicPlayer musicPlayer;

    @GetMapping("/music")
    public String playMusic(){
        return musicPlayer.play();
    }
}
