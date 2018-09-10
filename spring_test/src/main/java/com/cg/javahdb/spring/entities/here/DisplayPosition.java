package com.cg.javahdb.spring.entities.here;

/**
 *
 * @author GBANGALO
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayPosition
{
	@JsonProperty("Latitude")
    private String latitude;
	@JsonProperty("Longitude")
    private String longitude;

    public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	@Override
    public String toString()
    {
        return "Latitude : "+latitude+", Longitude : "+longitude;
    }
}