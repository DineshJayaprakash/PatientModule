package com.PatientModule.PatientModule.Repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.PatientModule.PatientModule.Dto.PatientDto;
import com.PatientModule.PatientModule.Model.Patient;

/**
 * RedisPatientRepository
 * 
 * @created By Dinesh J
 * @created Date 11/12
 * @description used to store the cache details in redis 
 */
@Service
public class RedisPatientServiceImpl implements RedisPatientRepository {
	
	
    @SuppressWarnings("unused")
	private RedisTemplate<String, Patient> redisTemplate;

    private HashOperations<String, String, PatientDto> hashOperations;

    
    
    public RedisPatientServiceImpl(RedisTemplate<String, Patient> redisTemplate ) {
    	this.redisTemplate = redisTemplate;
    	hashOperations = redisTemplate.opsForHash();
    }

	@Override
	public void save(PatientDto patient) {
		
		System.out.println("data added as cache in redis repository");
		System.out.println("key is Patient"+" "+"hash key is"+ patient.getPatientName() + " "+ "value is "+ patient);
		hashOperations.put("Patient", patient.getPatientName(), patient);
		
	}

	@Override
	public Map<String, PatientDto> findAll() {
		return hashOperations.entries("Patient");
	}

	@Override
	public PatientDto findByName(String name) {
		System.out.println("List of Keys available "+ " " + hashOperations.keys("Patient"));
		System.out.println("Redis Check has happened initially");
		 return (PatientDto)hashOperations.get("Patient", name);
	}

	@Override
	public void update(PatientDto patient) {
		  save(patient);
		
	}

	@Override
	public void delete(String id) {
		
		hashOperations.delete("Patient", id);
	}

}
