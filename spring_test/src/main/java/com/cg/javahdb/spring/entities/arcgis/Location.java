package com.cg.javahdb.spring.entities.arcgis;

/**
 *
 * @author GBANGALO
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	@JsonProperty("x")
	private String longitude;
	@JsonProperty("y")
	private String latitude;
	
	public String getLongitude() {
		return longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@Override
	public String toString()
	{
		return "Longitude : "+longitude+", Latitude : "+latitude;
	}

}
