package com.PatientModule.PatientModule.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.PatientModule.PatientModule.Model.Patient;

/**
 * interface PatientRepository
 * 
 * @created By Dinesh J
 * @created Date 07/12
 * @description PatientRepository used to perform db related patient operations
 */
//
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>,PagingAndSortingRepository<Patient, Long> {


	@Transactional
	@Query(nativeQuery = true , value = "select * from patient where patient_name = ?1")
	Patient findByPatientName(String patientName);
	
	@Transactional
	@Query(nativeQuery = true , value = "select count(*) from patient")
	int findPatientsCount();
}
