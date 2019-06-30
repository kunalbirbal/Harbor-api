package com.harbor.model;

import java.util.Date;
import java.util.List;

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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "aptmt_id")
	private Appointment appointment;

	@Transient
	@JsonIgnore
	@JsonProperty("appointment_id")
	private int appointment_id;

	private float additional_charges;

	private float discount_amount;

	private float net_amount;

	private float paid_amount;

	private String payment_mode;

//	private User created_by;
//
//	private User updated_by;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated;

	@Transient
	@JsonIgnore
	@JsonProperty("bill_tariffs")
	private List<BillTariff> bill_tariffs;

	public long getId() {
		return id;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public float getAdditional_charges() {
		return additional_charges;
	}

	public float getDiscount_amount() {
		return discount_amount;
	}

	public float getNet_amount() {
		return net_amount;
	}

	public float getPaid_amount() {
		return paid_amount;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

//	public User getCreated_by() {
//		return created_by;
//	}
//
//	public User getUpdated_by() {
//		return updated_by;
//	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public void setAdditional_charges(float additional_charges) {
		this.additional_charges = additional_charges;
	}

	public void setDiscount_amount(float discount_amount) {
		this.discount_amount = discount_amount;
	}

	public void setNet_amount(float net_amount) {
		this.net_amount = net_amount;
	}

	public void setPaid_amount(float paid_amount) {
		this.paid_amount = paid_amount;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

//	public void setCreated_by(User created_by) {
//		this.created_by = created_by;
//	}
//
//	public void setUpdated_by(User updated_by) {
//		this.updated_by = updated_by;
//	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getAppointment_id() {
		return appointment_id;
	}

	

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public List<BillTariff> getBill_tariffs() {
		return bill_tariffs;
	}

	public void setBill_tariffs(List<BillTariff> bill_tariffs) {
		this.bill_tariffs = bill_tariffs;
	}

	


	
	

}
