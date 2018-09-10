package com.cg.javahdb.spring.entities.here;

/**
 *
 * @author GBANGALO
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location
{
	@JsonProperty("DisplayPosition")
	private DisplayPosition displayPosition;
	@JsonProperty("Address")
	private Address address;

	public DisplayPosition getDisplayPosition() {
		return displayPosition;
	}

	public Address getAddress() {
		return address;
	}

	public void setDisplayPosition(DisplayPosition displayPosition) {
		this.displayPosition = displayPosition;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
    public String toString()
    {
        return "{Coordinates : {"+ displayPosition.toString() +"},"+
        		"Address : {"+address.toString() +"}}";
    }
}