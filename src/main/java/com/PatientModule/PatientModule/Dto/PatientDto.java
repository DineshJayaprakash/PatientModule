package com.PatientModule.PatientModule.Dto;


import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

/**
 * class PatientDto
 * 
 * @created By Dinesh J
 * @created Date 07/12
 * @description used for returning Db response
 */
@Data
@RedisHash("patient")
public class PatientDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id of patient
	 */
	private long patientId;   
	
	/**
	 * Name of patient
	 */
	private String patientName; 
	
	/**
	 * Adress of patient
	 */
    private String address;  
	
	/**
	 * Age of patient
	 */
    private int age; 
	
    /**
	 * Mobile no of patient
	 */
    private long mobile; 
	
    /**
	 * Email Id of patient
	 */
	private String email; 


}
