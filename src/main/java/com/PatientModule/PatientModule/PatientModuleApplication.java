package com.PatientModule.PatientModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * PatientModuleApplication
 * 
 * @created By Dinesh J
 * @CreatedDate : 07/12
 * @description PatientModuleApplication is used to Execute our Patient Moduke
 */
@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class PatientModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientModuleApplication.class, args);
	}

}
