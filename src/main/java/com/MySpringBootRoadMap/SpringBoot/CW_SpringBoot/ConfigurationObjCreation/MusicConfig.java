package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.ConfigurationObjCreation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicConfig {

    @Bean
    public MusicPlayer musicplayer(){
        return new MusicPlayer();
    }
}
