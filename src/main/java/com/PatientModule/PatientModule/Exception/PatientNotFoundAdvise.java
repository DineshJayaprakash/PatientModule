package com.PatientModule.PatientModule.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * PatientNotFoundAdvise
 * 
 * @created By Dinesh J
 * @created Date 04/12
 * @description used for global exceptionHandler
 */
public class PatientNotFoundAdvise {
	/**
	 * function patientNotFoundHandler 
	 * 
	 * @param ex
	 * @return Message
	 * @description used to display the exception messages
	 */
	@ResponseBody
	@ExceptionHandler(PatientNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String patientNotFoundHandler(PatientNotFoundException ex) {
		return ex.getMessage();
	}
	
	
	/**
	 * function patientNameNotFoundHandler 
	 * 
	 * @param ex
	 * @return Message
	 * @description used to display the exception messages
	 */
	@ResponseBody
	@ExceptionHandler(PatientNameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String patientNameNotFoundHandler(PatientNotFoundException ex) {
		return ex.getMessage();
	}

}
