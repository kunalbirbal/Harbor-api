package com.harbor.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "appointments")

public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "slot_id")
	private Slot slot;
	
	@Transient
	@JsonIgnore
	@JsonProperty("slot_id")
	private int slot_id;

	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@Transient
	@JsonIgnore
	@JsonProperty("patient_name")
	private String patient_name;
	
	@Transient
	@JsonIgnore
	@JsonProperty("mobile")
	private String mobile;
	
	@Transient
	@JsonIgnore
	@JsonProperty("doctor_id")
	private int doctor_id;	
	
	@JsonProperty("reason_for_visit")
	private String reason_for_visit;
	
	@JsonProperty("visit_type")
	private String visit_type;
	
	@JsonProperty("habits")
	private String habits;
	
	@JsonProperty("medicines")
	private String medicines;
	
	@JsonProperty("allergies")
	private String allergies;
	
	@JsonProperty("symptoms")
	private String symptoms;
	
	@JsonProperty("diagnosis")
	private String diagnosis;
	
	@Transient
	@JsonIgnore
	@JsonProperty("date")
	private Date date;
	

	private int status;

	private Date created;

	private Date updated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getSlot_id() {
		return slot_id;
	}

	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getDoctor_id() {
		return doctor_id;
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

	public Date getDate() {
		return date;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", slot=" + slot + ", slot_id=" + slot_id + ", patient=" + patient
				+ ", patient_name=" + patient_name + ", mobile=" + mobile + ", doctor_id=" + doctor_id
				+ ", reason_for_visit=" + reason_for_visit + ", visit_type=" + visit_type + ", habits=" + habits
				+ ", medicines=" + medicines + ", allergies=" + allergies + ", symptoms=" + symptoms + ", diagnosis="
				+ diagnosis + ", date=" + date + ", status=" + status + ", created=" + created + ", updated=" + updated
				+ "]";
	}
	
	
	
	
	
}
