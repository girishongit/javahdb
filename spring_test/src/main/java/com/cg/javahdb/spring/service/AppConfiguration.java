package com.cg.javahdb.spring.service;

/**
 *
 * @author GBANGALO
 * @description: Component Accessing Application.properties with Variable prefixed with app.
 * 
 */
 
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfiguration {

	private Integer csvBatchSize;
	private String hereApiEndpoint;
	private String bingApiEndpoint;
	
	private String arcgisApiEndpoint;
	private String arcgisApiCity;
	private String arcgisApiRegion;
	private String arcgisApiPostal;
	private String arcgisApiCountry;
	private String arcgisApidefaultparm;
	
	public AppConfiguration(){}
	
	public Integer getCsvBatchSize() {
		return csvBatchSize;
	}
	public String getHereApiEndpoint() {
		return hereApiEndpoint;
	}
	public String getBingApiEndpoint() {
		return bingApiEndpoint;
	}
	public String getArcgisApiEndpoint() {
		return arcgisApiEndpoint;
	}
	public String getArcgisApiCity() {
		return arcgisApiCity;
	}
	public String getArcgisApiRegion() {
		return arcgisApiRegion;
	}
	public String getArcgisApiPostal() {
		return arcgisApiPostal;
	}
	public String getArcgisApiCountry() {
		return arcgisApiCountry;
	}
	public String getArcgisApidefaultparm() {
		return arcgisApidefaultparm;
	}
	public void setCsvBatchSize(Integer csvBatchSize) {
		this.csvBatchSize = csvBatchSize;
	}
	public void setHereApiEndpoint(String hereApiEndpoint) {
		this.hereApiEndpoint = hereApiEndpoint;
	}
	public void setBingApiEndpoint(String bingApiEndpoint) {
		this.bingApiEndpoint = bingApiEndpoint;
	}
	public void setArcgisApiEndpoint(String arcgisApiEndpoint) {
		this.arcgisApiEndpoint = arcgisApiEndpoint;
	}
	public void setArcgisApiCity(String arcgisApiCity) {
		this.arcgisApiCity = arcgisApiCity;
	}
	public void setArcgisApiRegion(String arcgisApiRegion) {
		this.arcgisApiRegion = arcgisApiRegion;
	}
	public void setArcgisApiPostal(String arcgisApiPostal) {
		this.arcgisApiPostal = arcgisApiPostal;
	}
	public void setArcgisApiCountry(String arcgisApiCountry) {
		this.arcgisApiCountry = arcgisApiCountry;
	}
	public void setArcgisApidefaultparm(String arcgisApidefaultparm) {
		this.arcgisApidefaultparm = arcgisApidefaultparm;
	}
	
}