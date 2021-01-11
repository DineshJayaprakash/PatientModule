package com.PatientModule.PatientModule.Exception;

/**
 * class PatientNotFoundException
 * 
 * @created By Dinesh J
 * @created Date 07/12
 */
public class PatientNotFoundException extends RuntimeException {
	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * Parameterized Constructor 
	 * 
	 * @param id
	 * @Description Passing the Custom message to Super Class
	 */
	public PatientNotFoundException(Long id) {
		super("Could not find the Patient "+ id);
	}

}
