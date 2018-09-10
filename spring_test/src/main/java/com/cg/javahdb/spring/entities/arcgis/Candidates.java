package com.cg.javahdb.spring.entities.arcgis;

/**
 *
 * @author GBANGALO
 */

public class Candidates {

	private String address;
	private Location location;
	private Attributes attributes;
	
	public String getAddress() {
		return address;
	}

	public Location getLocation() {
		return location;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	

}
