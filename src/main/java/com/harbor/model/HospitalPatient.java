package com.harbor.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "hospital_patients")
public class HospitalPatient {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String reason_for_visit;
	private String visit_type;
	private String habits;
	private String medicines;
	private String allergies;
	private String symptoms;
	private String diagnosis;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name ="patient_id")
	private Patient patient;
	
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "docdpt_id")
	private DoctorDepartment docdpt_id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "doctor_id")
	private Doctor docid;
	
	private Date created;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReason_for_visit() {
		return reason_for_visit;
	}

	public void setReason_for_visit(String reason_for_visit) {
		this.reason_for_visit = reason_for_visit;
	}

	public String getVisit_type() {
		return visit_type;
	}

	public void setVisit_type(String visit_type) {
		this.visit_type = visit_type;
	}

	public String getHabits() {
		return habits;
	}

	public void setHabits(String habits) {
		this.habits = habits;
	}

	public String getMedicines() {
		return medicines;
	}

	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public DoctorDepartment getDocdpt_id() {
		return docdpt_id;
	}

	public void setDocdpt_id(DoctorDepartment docdpt_id) {
		this.docdpt_id = docdpt_id;
	}

	public Doctor getDocid() {
		return docid;
	}

	public void setDocid(Doctor docid) {
		this.docid = docid;
	}

	@Temporal(TemporalType.DATE)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}