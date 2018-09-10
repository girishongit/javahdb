package com.cg.javahdb.spring.entities.arcgis;

/**
 *
 * @author GBANGALO
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Arcgis {

	private Candidates[] candidates;

	public Candidates[] getCandidates() {
		return candidates;
	}

	public void setCandidates(Candidates[] candidates) {
		this.candidates = candidates;
	}

	public List<HashMap<String,String>> getValidatedAddress()
	{
		List<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
		for(Candidates candidate: candidates)
		{
			HashMap<String,String> eachData = new HashMap<String, String>();
		    eachData.put("score"				, candidate.getAttributes().getScore());
			eachData.put("matchAddr"			, candidate.getAttributes().getMatchedAddress());
			eachData.put("matchAddrType"		, candidate.getAttributes().getMatchedAddressType());
			eachData.put("houseNumber"		    , candidate.getAttributes().getHouseNumber());
			eachData.put("buildingNum"		    , candidate.getAttributes().getBuildingName());
			eachData.put("block"				, candidate.getAttributes().getBlock());
			eachData.put("streetName"   		, candidate.getAttributes().getStreet());
			eachData.put("sector"		    	, candidate.getAttributes().getSector());
			eachData.put("city"				    , candidate.getAttributes().getCity());
			eachData.put("metroArea"			, candidate.getAttributes().getMetroArea());
			eachData.put("subRegion"			, candidate.getAttributes().getSubRegion());
			eachData.put("region"		    	, candidate.getAttributes().getRegion());
			eachData.put("regionAbbr"	    	, candidate.getAttributes().getRegionAbbr());
			eachData.put("postal"		    	, candidate.getAttributes().getPostal());
			eachData.put("country"		    	, candidate.getAttributes().getCountry());
			eachData.put("formatedAddr"	    	, candidate.getAttributes().getFormatedAddr());
			eachData.put("unverifiedAddrPart"   , candidate.getAttributes().getExtraInfo());
			eachData.put("latitude"			    , candidate.getLocation().getLatitude());
			eachData.put("longitude"			, candidate.getLocation().getLongitude());
			data.add(eachData);
		}
		return data;
	}

}
