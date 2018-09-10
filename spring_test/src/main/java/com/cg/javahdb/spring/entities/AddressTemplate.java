package com.cg.javahdb.spring.entities;

/**
 *
 * @author GBANGALO
 */
public class AddressTemplate {
	
	private int fileId;
	private int recordId;
	private String houseNumber;
	private String addressLine1;
	private String addressLine2;
	private String county;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	
	public AddressTemplate(){}
	
	public int getFileId() {
		return fileId;
	}
	public int getRecordId() {
		return recordId;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCounty() {
		return county;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
