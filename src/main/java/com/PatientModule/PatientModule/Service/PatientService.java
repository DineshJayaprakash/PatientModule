package com.PatientModule.PatientModule.Service;

import java.util.List;

import com.PatientModule.PatientModule.Dto.PatientDto;

/**
 * PatientService
 * 
 * @created By Dinesh J
 * @created Date 07/12
 * @description used for crud operations for patients 
 */
public interface PatientService {
	
	/**
	 * function listOutAllPatients 
	 * 
	 * @param nome
	 * @Description used to get all patients details from Db
	 */
	public List<PatientDto> listOutAllPatients();
	
	/**
	 * function listPatientById 
	 * 
	 * @param id
	 * @Description used get a detail of patient
	 */
	public PatientDto listPatientById(Long id);
	
	/**
	 * function addPatient 
	 * 
	 * @param myPatient
	 * @Description used to add a new patient to Db
	 */
	public PatientDto addPatient(PatientDto myPatient);
	
	/**
	 * function updatePatientById  
	 * 
	 * @param id
	 * @Description used to update a existing patient to Db
	 */
	public PatientDto updatePatientById(PatientDto mypatient, Long id);
	
	/**
	 * function deletePatientById 
	 * 
	 * @param id
	 * @Description used to delete a patient in Db
	 */
	public void deletePatientById(Long id);
	
	/**
	 * function getPaginatedPatientWithSorting 
	 * 
	 * @param pageNo,pageSize,sortBy
	 * @Description used to filter and sort patient records from db
	 */
	public List<PatientDto> getPaginatedPatientWithSorting(int pageNo, int pageSize, String sortBy);

	/**
	 * function findByUserName 
	 * 
	 * @param patientName
	 * @Description used to get list of patient details by search
	 */
	public PatientDto findByPatientName(String patientName);
	

}
