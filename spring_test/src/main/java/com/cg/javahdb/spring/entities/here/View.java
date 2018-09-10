package com.cg.javahdb.spring.entities.here;

/**
 *
 * @author GBANGALO
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class View
{
	@JsonProperty("Result")
    private Result[] results;

    public Result[] getResults ()
    {
        return results;
    }

    public void setResults (Result[] results)
    {
        this.results = results;
    }

    public List<HashMap<String,String>> getResultList()
    {
        //return "{ Result : "+results[0].toString()+"}";
        
        List<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
        
        for(Result result: results)
        {
        	HashMap<String,String> eachData = new HashMap<String,String>();
            eachData.put("relavence"	, result.getRelavence() );
        	eachData.put("matchLevel"	, result.getMatchLevel() );
        	eachData.put("houseNumber"	, result.getLocation().getAddress().getHouseNumber() );
        	eachData.put("street"		, result.getLocation().getAddress().getStreet() );
        	eachData.put("county"		, result.getLocation().getAddress().getCounty() );
        	eachData.put("subDistrict"	, result.getLocation().getAddress().getSubDistrict() );
        	eachData.put("district"		, result.getLocation().getAddress().getDistrict() );
        	eachData.put("city"			, result.getLocation().getAddress().getCity() );
        	eachData.put("state"		, result.getLocation().getAddress().getState() );
        	eachData.put("postalCode"	, result.getLocation().getAddress().getPostalCode() );
        	eachData.put("country"		, result.getLocation().getAddress().getCountry() );
        	eachData.put("formatedAddr"	, result.getLocation().getAddress().getLabel() );
        	eachData.put("latitude"		, result.getLocation().getDisplayPosition().getLatitude() );
        	eachData.put("longitude"	, result.getLocation().getDisplayPosition().getLongitude() );
        	data.add(eachData);
        }
        	return data;
    }
}
