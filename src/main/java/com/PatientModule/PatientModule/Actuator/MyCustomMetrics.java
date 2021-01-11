package com.PatientModule.PatientModule.Actuator;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.PatientModule.PatientModule.Aop.TrackExecutionTime;
import com.PatientModule.PatientModule.Repository.PatientRepository;

/**
 * classs MyCustomMetrics
 * 
 * @created By Dinesh J
 * @CreatedDate : 10/12
 * @description used to display our custom metrics in the end point
 */
@Component
public class MyCustomMetrics implements InfoContributor {
	
	/**
	 * PatientRepository bean
	 */
	private final PatientRepository myPatientRepositoy;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param myPatientRepositoy
	 * @description used to display the patient's count
	 */
	@Autowired
	MyCustomMetrics(PatientRepository myPatientRepositoy)
	{
		this.myPatientRepositoy = myPatientRepositoy;
	}

	/**
	 * function contribute
	 * 
	 * @param builder
	 * @return none
	 * @description Add the custom metrices in the preffered endpoint
	 */
	@Override
	@TrackExecutionTime
	public void contribute(Builder builder) {
		
		HashMap<String,Integer> patientCount = new HashMap<>();
		patientCount.put("CurrentPatients", myPatientRepositoy.findPatientsCount());
		builder.withDetail("patientMetrics", patientCount);
	}

}
