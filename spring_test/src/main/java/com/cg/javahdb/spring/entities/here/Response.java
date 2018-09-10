package com.cg.javahdb.spring.entities.here;

/**
 *
 * @author GBANGALO
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Response
{
	@JsonProperty("View")
    private View[] views;

    public View[] getViews ()
    {
        return views;
    }

    public void setViews (View[] views)
    {
        this.views = views;
    }
	
    public List<HashMap<String,String>> getResponseList()
    {
    	return views[0].getResultList();
    }

}
