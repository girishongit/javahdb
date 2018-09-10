package com.cg.javahdb.spring.entities.bing;

/**
 *
 * @author GBANGALO
 */

public class Resources
{
    private Point point;
    private Address address;
    private String confidence;
    private String entityType;
    private String[] matchCodes;
   

    public void setPoint(Point point) {
		this.point = point;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public void setMatchCodes(String[] matchCodes) {
		this.matchCodes = matchCodes;
	}

	public Point getPoint() {
		return point;
	}

	public Address getAddress() {
		return address;
	}

	public String getConfidence() {
		return confidence;
	}

	public String getEntityType() {
		return entityType;
	}

	public String[] getMatchCodes() {
		return matchCodes;
	}

	@Override
    public String toString()
    {	
    	return "["+address.toString()+", confidence : "+confidence+", matchCodes : ["+ String.join(", ", matchCodes) +"], coordinates : "+point.toString()+"]";
    }
}

