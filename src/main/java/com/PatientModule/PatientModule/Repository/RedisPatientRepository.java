package com.PatientModule.PatientModule.Repository;

import java.util.Map;


import org.springframework.stereotype.Repository;

import com.PatientModule.PatientModule.Dto.PatientDto;
import com.PatientModule.PatientModule.Model.Patient;



/**
 * RedisPatientRepository
 * 
 * @created By Dinesh J
 * @created Date 11/12
 * @description used to store the cache details
 */
@Repository
public interface RedisPatientRepository {
	
	/**
	 * function save
	 * 
	 * @param patient
	 * @return none
	 * @description used to save the record in cache
	 */
    void save(PatientDto patient);
    
    /**
     * function findAll
     * 
     * 
     * @return all the records based on the given key
     */
    Map<String, PatientDto> findAll();
    
    /**
     * function findByName
     * 
     * 
     * @param name
     * @return Patient details 
     * @description Patient details from the redis cache
     */
    PatientDto findByName(String name);
    
    /**
     * function update
     * 
     * @param patient
     * @return none
     * @description used to update the record stored in cache
     */
    void update(PatientDto patient);
    
    /**
     * function delete
     * 
     * @param id
     * @return none
     * @description used to delete the record from cache memory
     */
    void delete(String id);


}
