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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tariff_rates")
public class TariffRates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tariff_id")
	private Tariff tariff;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "doctor_dept_id")
	@JsonIgnore
	private DoctorDepartment doctor_dept_assoc;

	private String service_name;

	private String service_category;

	private float rate;

	private boolean is_mandatory;
	
	private Date created;
	
	private Date updated;

	public long getId() {
		return id;
	}

	public Tariff getTariff() {
		return tariff;
	}

	public DoctorDepartment getDoctor_dept_assoc() {
		return doctor_dept_assoc;
	}

	public String getService_name() {
		return service_name;
	}

	public String getService_category() {
		return service_category;
	}

	public float getRate() {
		return rate;
	}

	public boolean isIs_mandatory() {
		return is_mandatory;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}

	public void setDoctor_dept_assoc(DoctorDepartment doctor_dept_assoc) {
		this.doctor_dept_assoc = doctor_dept_assoc;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public void setService_category(String service_category) {
		this.service_category = service_category;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public void setIs_mandatory(boolean is_mandatory) {
		this.is_mandatory = is_mandatory;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
	

}
