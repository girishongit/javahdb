package com.cg.javahdb.spring.entities.arcgis;

/**
 *
 * @author GBANGALO
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes {

	@JsonProperty("Status")
	private String status;
	@JsonProperty("Score") 
	private String score;
	@JsonProperty("Match_addr") 
	private String matchedAddress;
	@JsonProperty("Addr_type") 
	private String matchedAddressType;
	@JsonProperty("Type") 
	private String matchedAddressLevel;
	@JsonProperty("PlaceName")
	private String matchedPlaceName;
	@JsonProperty("AddNum")
	private String houseNumber;
	@JsonProperty("BldgName")
	private String buildingName;
	@JsonProperty("Block") 
	private String block;
	@JsonProperty("StName") 
	private String street;
	@JsonProperty("Sector") 
	private String sector;
	@JsonProperty("District") 
	private String district;
	@JsonProperty("City")
	private String city;
	@JsonProperty("MetroArea") 
	private String metroArea;
	@JsonProperty("Subregion")
	private String subRegion;
	@JsonProperty("Region") 
	private String region;
	@JsonProperty("RegionAbbr") 
	private String regionAbbr;
	@JsonProperty("Postal") 
	private String postal;
	@JsonProperty("Country") 
	private String country; 
	@JsonProperty("ExInfo") 
	private String extraInfo;
	@JsonProperty("Place_addr")
	private String formatedAddr;

	public String getFormatedAddr() {
		return formatedAddr;
	}
	public void setFormatedAddr(String formatedAddr) {
		this.formatedAddr = formatedAddr;
	}
	
	public String getStatus() {
		return status;
	}
	public String getScore() {
		return score;
	}
	public String getMatchedAddress() {
		return matchedAddress;
	}
	public String getMatchedAddressType() {
		return matchedAddressType;
	}
	public String getMatchedAddressLevel() {
		return matchedAddressLevel;
	}
	public String getMatchedPlaceName() {
		return matchedPlaceName;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public String getBlock() {
		return block;
	}
	public String getStreet() {
		return street;
	}
	public String getSector() {
		return sector;
	}
	public String getDistrict() {
		return district;
	}
	public String getCity() {
		return city;
	}
	public String getMetroArea() {
		return metroArea;
	}
	public String getSubRegion() {
		return subRegion;
	}
	public String getRegion() {
		return region;
	}
	public String getRegionAbbr() {
		return regionAbbr;
	}
	public String getPostal() {
		return postal;
	}
	public String getCountry() {
		return country;
	}
	public String getExtraInfo() {
		return extraInfo;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public void setMatchedAddress(String matchedAddress) {
		this.matchedAddress = matchedAddress;
	}
	public void setMatchedAddressType(String matchedAddressType) {
		this.matchedAddressType = matchedAddressType;
	}
	public void setMatchedAddressLevel(String matchedAddressLevel) {
		this.matchedAddressLevel = matchedAddressLevel;
	}
	public void setMatchedPlaceName(String matchedPlaceName) {
		this.matchedPlaceName = matchedPlaceName;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setMetroArea(String metroArea) {
		this.metroArea = metroArea;
	}
	public void setSubRegion(String subRegion) {
		this.subRegion = subRegion;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public void setRegionAbbr(String regionAbbr) {
		this.regionAbbr = regionAbbr;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	
	@Override
	public String toString()
	{
		StringBuilder data = new StringBuilder();
		data
		.append("Status : ")	.append(status).append(",")
		.append("Score : ") 	.append(score).append(",")
		.append("Match_addr : ").append(matchedAddress).append(",")
		.append("Addr_type : ")	.append(matchedAddressType).append(",")
		.append("Type : ") 		.append(matchedAddressLevel).append(",")
		.append("PlaceName : ")	.append(matchedPlaceName).append(",")
		.append("AddNum : ")	.append(houseNumber).append(",")
		.append("BldgName : ")	.append(buildingName).append(",")
		.append("Block : ") 	.append(block).append(",")
		.append("StName : ")	.append(street).append(",")
		.append("Sector : ") 	.append(sector).append(",")
		.append("District : ") 	.append(district).append(",")
		.append("City : ")		.append(city).append(",")
		.append("MetroArea : ")	.append(metroArea).append(",")
		.append("Subregion : ")	.append(subRegion).append(",")
		.append("Region : ") 	.append(region).append(",")
		.append("RegionAbbr : ").append(regionAbbr).append(",")
		.append("Postal : ") 	.append(postal).append(",")
		.append("Country : ")	.append(country).append(",") 
		.append("ExInfo : ") 	.append(extraInfo);
		
		return data.toString();
		
	}
	
	
}

