package com.PatientModule.PatientModule.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.PatientModule.PatientModule.Aop.TrackExecutionTime;
import com.PatientModule.PatientModule.Dto.PatientDto;
import com.PatientModule.PatientModule.Exception.PatientNameNotFoundException;
import com.PatientModule.PatientModule.Exception.PatientNotFoundException;
import com.PatientModule.PatientModule.Model.Patient;
import com.PatientModule.PatientModule.Repository.PatientRepository;
import com.PatientModule.PatientModule.Repository.RedisPatientRepository;




/**
 * PatientModuleService
 * 
 * @created By Dinesh J
 * @created Date 07/12
 * @description used to implement ParentService
 */
@Service
public class PatientServiceImpl implements PatientService {
	
	
	private final PatientRepository patientRepository;  
	
	private final RedisPatientRepository redisPatientRepository;
	
	private ModelMapper modelMapper;  
	
	
	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper,RedisPatientRepository redisPatientRepository) {
		this.patientRepository = patientRepository;
		this.modelMapper = modelMapper;
		this.redisPatientRepository = redisPatientRepository;
	}
	
	@TrackExecutionTime
	public List<PatientDto> listOutAllPatients() {
		List<Patient> user = patientRepository.findAll();
		Type listType = new TypeToken<List<PatientDto>>(){}.getType();
		List<PatientDto> myUserDto = modelMapper.map(user, listType);
		return myUserDto;
	}
	
	@TrackExecutionTime
	public PatientDto listPatientById(Long id) {
		Patient patEntity = patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException(id));
		PatientDto myUserDto = modelMapper.map(patEntity, PatientDto.class);
		return myUserDto;
	}
	
	@TrackExecutionTime
	public PatientDto addPatient(PatientDto myPatient) {
		Patient MyUser = modelMapper.map(myPatient, Patient.class);
		Patient usrEntity = patientRepository.save(MyUser);
		PatientDto myUserDto = modelMapper.map(usrEntity, PatientDto.class);
		return myUserDto;
	}
	
	
	@TrackExecutionTime
	public PatientDto updatePatientById(PatientDto mypatient, Long id) {
		Patient MyPatient = modelMapper.map(mypatient,Patient.class);
		patientRepository.findById(id).map(patient->{patient.setPatientName(mypatient.getPatientName());
		patient.setAddress(MyPatient.getAddress());
		patient.setAge(MyPatient.getAge());
		patient.setEmail(MyPatient.getEmail());
		patient.setMobile(MyPatient.getMobile());
		return patientRepository.save(MyPatient);}).orElseGet(()->{MyPatient.setPatientId(id);
		return patientRepository.save(MyPatient);});
		PatientDto myPatientDto = modelMapper.map(MyPatient, PatientDto.class);
		return  myPatientDto;
	}
	
	@TrackExecutionTime
	public void deletePatientById(Long id) {
		try{
		 patientRepository.deleteById(id);
		}
		catch (Exception e) {
			throw new PatientNotFoundException(id);
		}
	}
	
	@TrackExecutionTime
	public List<PatientDto> getPaginatedPatientWithSorting(int pageNo, int pageSize, String sortBy) {
		Pageable paging =  PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        Page<Patient> pagedResult = patientRepository.findAll(paging);
        List<Patient> patient = pagedResult.toList();
		Type listType = new TypeToken<List<PatientDto>>(){}.getType();
		List<PatientDto> myPatientDto = modelMapper.map(patient, listType);
		return myPatientDto;
	}

	

	
	@TrackExecutionTime
	public PatientDto findByPatientName(String patientName) {
		try {
			PatientDto myPatientDtoFromCache = redisPatientRepository.findByName(patientName);
			System.out.println(myPatientDtoFromCache.getPatientName()+"=================>");
			return myPatientDtoFromCache;

		}
		catch(Exception ex) {
			Patient myPatientDB = patientRepository.findByPatientName(patientName);
			System.out.println(myPatientDB.getPatientName()+"<=================>");
			if(myPatientDB.getPatientName().isEmpty()) {
				System.out.println("=============================");
				throw new PatientNameNotFoundException();
			}
			PatientDto myPatientDtoFromCache = modelMapper.map(myPatientDB,PatientDto.class);
			redisPatientRepository.save(myPatientDtoFromCache);
			return myPatientDtoFromCache; 
		}		

	}


	

}
