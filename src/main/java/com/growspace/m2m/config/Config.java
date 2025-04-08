package com.growspace.m2m.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
