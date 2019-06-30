package com.harbor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "doctors")
public class Doctor  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String code;
	
	private String name;	
	
	private String photo;
	
	private String address;
	
	private String city;
	
	private String state; 
	
	private String pincode;
	
	private String email; 
	
	private int gender;
	
	private String qualification;	
	
//	@OneToMany(mappedBy="doctor_specialities")
//	private List<Speciality> specialities;
	
	private Date created;
	
	private Date updated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	

//	public List<Speciality> getSpecialities() {
//		return specialities;
//	}
//
//	public void setSpecialities(List<Speciality> specialities) {
//		this.specialities = specialities;
//	}

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

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", code=" + code + ", name=" + name + ", photo=" + photo + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", email=" + email + ", gender="
				+ gender + ", qualification=" + qualification + ", created=" + created + ", updated=" + updated + "]";
	}
	
	
	
	

}
