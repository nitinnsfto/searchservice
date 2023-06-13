package com.javainuse.controller;

public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", dob=" + dob
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", policynum=" + policynum + ", ssnnum="
				+ ssnnum + ", klid=" + klid + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getAvailableUnits() {
		return availableUnits;
	}

	public void setAvailableUnits(Integer availableUnits) {
		this.availableUnits = availableUnits;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isLaundry() {
		return laundry;
	}

	public void setLaundry(boolean laundry) {
		this.laundry = laundry;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isUsername() {
		return username;
	}

	public void setUsername(boolean username) {
		this.username = username;
	}

	public String getPolicynum() {
		return policynum;
	}

	public void setPolicynum(String policynum) {
		this.policynum = policynum;
	}

	public String getSsnnum() {
		return ssnnum;
	}

	public void setSsnnum(String ssnnum) {
		this.ssnnum = ssnnum;
	}

	public String getKlid() {
		return klid;
	}

	public void setKlid(String klid) {
		this.klid = klid;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer id;
	private String name;
	private String city;
	private String state;
	private String photo;	
	private Integer availableUnits;	
	private boolean wifi;	
	private boolean laundry;	
	private String dob;
	private String firstname;
	private String lastname;
	private boolean username;
	private String policynum;
	private String ssnnum;
	private String klid;

	public Integer getId() {
		return id;
	}

}
