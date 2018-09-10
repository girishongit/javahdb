package com.cg.javahdb.spring.entities.bing;

/**
 *
 * @author GBANGALO
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VirtualEarth
	{
		
		private String statusCode;
	    private String statusDescription;
	    private ResourceSets[] resourceSets;

	    public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}

		public void setStatusDescription(String statusDescription) {
			this.statusDescription = statusDescription;
		}

		public void setResourceSets(ResourceSets[] resourceSets) {
			this.resourceSets = resourceSets;
		}

		public String getStatusCode() {
			return statusCode;
		}

		public String getStatusDescription() {
			return statusDescription;
		}

		public ResourceSets[] getResourceSets() {
			return resourceSets;
		}

		public List<HashMap<String,String>> getValidatedAddress()
		{
			return resourceSets[0].getresourceList();
		}
	}