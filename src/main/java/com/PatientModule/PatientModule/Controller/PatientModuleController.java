package com.PatientModule.PatientModule.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.PatientModule.PatientModule.Dto.PatientDto;
import com.PatientModule.PatientModule.Service.PatientService;



/**
 * class PatientModuleController
 * 
 * @created By Dinesh J
 * @created Date 07/12
 * @description used For PatientModule endpoint mapping
 */
@RestController
@RequestMapping("patients")
public class PatientModuleController {
	
	
	/**
	 * PatientService bean
	 */
	private PatientService patientService;    
	
	
	/**
	 * Parameterized Constructor 
	 * 
	 * @param userModuleService
	 * @description Dependency Injection
	 */
	@Autowired
	PatientModuleController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	
	/**
	 * function listOutAllPatients
	 * 
	 * @param none
	 * @return List Of Patient
	 * @description Getmapping used for getting all Patients Details
	 */
	@Cacheable("patients")
	@GetMapping("")
	public List<PatientDto> listOutAllPatients() {
		return patientService.listOutAllPatients();
	}
	
	
	/**
	 * function listPatientById
	 * 
	 * @param id
	 * @return Patient based on given id
	 * @description GetMapping used for getting PatientDetail By id
	 */
	@Cacheable(key="#id",value="patient")
	@GetMapping("/{id}")
	public PatientDto listPatientById(@PathVariable Long id) {
		return patientService.listPatientById(id);
	}
	
	
	/**
	 * function addPatient
	 * 
	 * @param myPatient
	 * @return saved Patient
	 * @description PostMapping used for adding patient details into Db
	 */
	@PostMapping("")
	public PatientDto addPatient(@RequestBody PatientDto myPatient) {
		return patientService.addPatient(myPatient);
	}
	
	/**
	 * function updatePatientById
	 * 
	 * @param myPatient
	 * @return updated Patient
	 * @description PutMapping used for updating patient details into Db
	 */
	@CachePut(key="#id",value = "patient")
	@PutMapping("/{id}")
	public PatientDto updatePatientById(@RequestBody PatientDto mypatient, @PathVariable Long id) {
		return patientService.updatePatientById(mypatient, id);
	}
	
	
	/**
	 * function deletePatientById
	 * 
	 * @param id
	 * @return none
	 * @description DeleteMapping used to Delete Patient detail from Db
	 */
	@CacheEvict(key="#id",value= "patient")
	@DeleteMapping("/{id}")
	public void deletePatientById(@PathVariable Long id) {
		patientService.deletePatientById(id);
	}
	
	
	/**
	 * function getPaginatedPatientWithSorting
	 * 
	 * @param pageNo,pageSize,sortBy
	 * @return List Of Patient based on Filter
	 * @description @GetMapping used for filtering and sorting patient records
	 */
	@GetMapping("/{pageNo}/{pageSize}/{sortBy}")
	public List<PatientDto> getPaginatedPatientWithSorting(@PathVariable int pageNo, @PathVariable int pageSize, @PathVariable String sortBy) {
		return patientService.getPaginatedPatientWithSorting(pageNo, pageSize, sortBy);
	}
	
	/**
	 * function getPatientId
	 * 
	 * @param none
	 * @return hardCoded patient id to implement feign Module
	 */
	@GetMapping("/getPatientId")
	public long getPatientId() {
		return 1;
	}
	
	/**
	 * function findByPatientName
	 * 
	 * @param none
	 * @return List of Patients
	 * @description GetMapping used to get the list of patients based on the search
	 */
	@GetMapping("checkBy/{patientName}")
	public PatientDto findByPatientName(@PathVariable String patientName) {
		return patientService.findByPatientName(patientName);
	}
	

}
