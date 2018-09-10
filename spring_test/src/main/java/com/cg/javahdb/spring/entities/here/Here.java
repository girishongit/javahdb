package com.cg.javahdb.spring.entities.here;

/**
 *
 * @author GBANGALO
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Here
	{
		@JsonProperty("Response")
		private Response response;

		public Response getResponse ()
	    {
	        return response;
	    }

	    public void setResponse (Response response)
	    {
	        this.response = response;
	    }

	    public List<HashMap<String,String>> getValidatedAddress()
	    {
	    	return response.getResponseList();
	    }
	}

