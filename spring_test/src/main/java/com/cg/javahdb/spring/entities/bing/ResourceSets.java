package com.cg.javahdb.spring.entities.bing;

/**
 *
 * @author GBANGALO
 */
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResourceSets
{
	private String estimatedTotal;
    private Resources[] resources;

    public Resources[] getResources ()
    {
        return resources;
    }

    public void setResources (Resources[] resources)
    {
        this.resources = resources;
    }

    public String getEstimatedTotal ()
    {
        return estimatedTotal;
    }

    public void setEstimatedTotal (String estimatedTotal)
    {
        this.estimatedTotal = estimatedTotal;
    }

    public List<HashMap<String,String>> getresourceList()
    {
    	List<HashMap<String,String>> data = new ArrayList<HashMap<String, String>>();
    	for(Resources resource : resources)
    	{
    		HashMap<String,String> eachData = new HashMap<String, String>();
    		eachData.put("confidence", 		resource.getConfidence());
    		eachData.put("matchEntityType", resource.getEntityType());
    		eachData.put("matchCodes", 		String.join(",", resource.getMatchCodes()));
    		eachData.put("addressLine",		resource.getAddress().getAddressLine());
    		eachData.put("adminDistrict",	resource.getAddress().getAdminDistrict());
    		eachData.put("adminDistrict2",	resource.getAddress().getAdminDistrict2());
    		eachData.put("locality",		resource.getAddress().getLocality());
    		eachData.put("countryRegion",	resource.getAddress().getCountryRegion());   
    		eachData.put("postalCode",		resource.getAddress().getPostalCode());   
    		eachData.put("formatedAddr",	resource.getAddress().getFormattedAddress());   
    		eachData.put("latitude",		resource.getPoint().getCoordinates()[0]);   
    		eachData.put("longitude",		resource.getPoint().getCoordinates()[1]);
    		data.add(eachData);
    	}
		return data;
    }
    
}