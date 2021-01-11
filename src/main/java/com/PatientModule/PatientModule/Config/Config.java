package com.PatientModule.PatientModule.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import com.PatientModule.PatientModule.Model.Patient;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Class Config
 * 
 * @created By Dinesh J
 * @Created Date 04/12
 * @description used to create singleton bean 
 */
@Configuration
public class Config {
	
	
	/**
	 * method modelMapper
	 * 
	 * @param none
	 * @return ModelMapper bean
	 * @description used for predefined utility operation
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	/**
	 * productApi
	 * 
	 * @param none
	 * @return new Docket
	 * @description used for swagger Documentation
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("UserModule.UserModule")).build();
	}
	

}
