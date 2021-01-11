package com.PatientModule.PatientModule.Model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


/**
 * 
 * class Patient
 * 
 * @author dinesh
 * @description used to add the record into db table
 *
 */

@Entity
@Data
@Table(name = "patient")
public class Patient implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id of patient
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patientid")
	private long patientId;
	
	/**
	 * Name of patient
	 */
	@Column(name="patientName")
	private String patientName;
	
	/**
	 * Address of patient
	 */
	@Column(name="Address")
	private String address;
	
	/**
	 * Age of patient
	 */
	@Column(name="age")
	private int age;
	
	/**
	 * mobile no of patient
	 */
	@Column(name="mobile")
	private long mobile;
	
	/**
	 * email id of patient
	 */
	@Column(name="email")
	private String email;

}
