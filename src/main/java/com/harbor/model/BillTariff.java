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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "bill_tariffs")
public class BillTariff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	@JoinColumn(name = "bill_id")
	private Bill bill;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tariff_rate_id")
	private TariffRates tariff_rate;

	@Transient
	@JsonProperty("tariff_rate_id")
	private long tariff_rate_id;

	private float amount;

	private String remark;

	private Date created;

	private Date updated;

	public long getId() {
		return id;
	}

	public Bill getBill() {
		return bill;
	}

	

	public float getAmount() {
		return amount;
	}

	public String getRemark() {
		return remark;
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

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public TariffRates getTariff_rate() {
		return tariff_rate;
	}

	
	public void setTariff_rate(TariffRates tariff_rate) {
		this.tariff_rate = tariff_rate;
	}

	public long getTariff_rate_id() {
		return tariff_rate_id;
	}

	public void setTariff_rate_id(long tariff_rate_id) {
		this.tariff_rate_id = tariff_rate_id;
	}

	
	

}
