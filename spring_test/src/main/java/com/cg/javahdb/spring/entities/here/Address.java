package com.cg.javahdb.spring.entities.here;

/**
 *
 * @author GBANGALO
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address
{
	@JsonProperty("HouseNumber")
   	private String houseNumber;
	@JsonProperty("Street")
  	private String street;
	@JsonProperty("County")
   	private String county;
	@JsonProperty("Subdistrict")
   	private String subDistrict;
	@JsonProperty("District")
   	private String district;
	@JsonProperty("City")
   	private String city;
	@JsonProperty("State")
   	private String state;
	@JsonProperty("PostalCode")
   	private String postalCode;
	@JsonProperty("Country")
   	private String country;
	@JsonProperty("Label")
   	private String label;
	@JsonProperty("AdditionalData")
    private AdditionalData[] additionalData;
    
	public String getHouseNumber() {
		return houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public String getCounty() {
		return county;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public String getDistrict() {
		return district;
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

	public String getLabel() {
		return label;
	}

	public AdditionalData[] getAdditionalData() {
		return additionalData;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public void setLabel(String label) {
		this.label = label;
	}

	public void setAdditionalData(AdditionalData[] additionalData) {
		this.additionalData = additionalData;
	}

	@Override
    public String toString()
    {	StringBuilder data = new StringBuilder();
    	data
    		.append("HouseNumber")		.append(" : ").append(houseNumber)	.append(",")
    		.append("Street")			.append(" : ").append(street)		.append(",")
    		.append("County")			.append(" : ").append(county)		.append(",")
    		.append("Subdistrict")		.append(" : ").append(subDistrict)	.append(",")
    		.append("District")			.append(" : ").append(district)		.append(",")
    		.append("City")				.append(" : ").append(city)			.append(",")
    		.append("State")			.append(" : ").append(state)		.append(",")
    		.append("PostalCode")		.append(" : ").append(postalCode)	.append(",")
    		.append("Country")			.append(" : ").append(country)		.append(",")
    		.append("Label")			.append(" : ").append(label)		.append(",")
    		.append("AdditionalData")	.append(" : ").append(this.getAdditionalDataAsString());
    
        return data.toString();
    }
	
	private String getAdditionalDataAsString()
	{
		String[] data = new String[additionalData.length];
		int i=0;
		
		for(AdditionalData ad: additionalData)
		{
			data[i++] = "{"+ad.toString()+"}";
		}
		return "["+String.join(",",data)+"]";
	}
}
