package com.example.modelMapper.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//creating a configuration class for ModelMapper
// @configuration annotation indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime
@Configuration
public class ModelMapperConfig {

    //here we are creating a bean of ModelMapper
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
