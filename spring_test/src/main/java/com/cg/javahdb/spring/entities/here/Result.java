package com.cg.javahdb.spring.entities.here;

/**
 *
 * @author GBANGALO
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result
{
	@JsonProperty("Relevance")
	private String relavence;
	@JsonProperty("MatchLevel")
    private String matchLevel;
	@JsonProperty("Location")
    private Location location;
    
    public String getRelavence() {
		return relavence;
	}

	public String getMatchLevel() {
		return matchLevel;
	}

	public Location getLocation() {
		return location;
	}

	public void setRelavence(String relavence) {
		this.relavence = relavence;
	}

	public void setMatchLevel(String matchLevel) {
		this.matchLevel = matchLevel;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


	@Override
    public String toString()
    {
        return 	"{ 	MatchLevel : "+ matchLevel +","+
        		"	Relevance : "+ relavence +","+
        		"	Location : "+location.toString() +"}";
    }
}