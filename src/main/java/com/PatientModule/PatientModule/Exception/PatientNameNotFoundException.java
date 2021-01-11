package com.PatientModule.PatientModule.Exception;



/**
 * class PatientNameNotFoundException
 * 
 * @created By Dinesh J
 * @created Date 11/12
 */
public class PatientNameNotFoundException extends RuntimeException {
	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * Parameterized Constructor 
	 * 
	 * @param none
	 * @Description Passing the Custom message to Super Class
	 */
	public PatientNameNotFoundException() {
		super("Could not find the Patient ");
	}


}
