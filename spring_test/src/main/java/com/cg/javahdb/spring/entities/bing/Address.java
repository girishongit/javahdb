package com.cg.javahdb.spring.entities.bing;

/**
 *
 * @author GBANGALO
 */
public class Address
{
	private String addressLine;
	
    private String adminDistrict2;

    private String adminDistrict;

    private String locality;

    private String formattedAddress;

    private String countryRegion;
    
    private String postalCode;
      
    public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
    
    public String getAddressLine ()
    {
        return addressLine;
    }

    public void setAddressLine (String addressLine)
    {
        this.addressLine = addressLine;
    }

    public String getAdminDistrict2 ()
    {
        return adminDistrict2;
    }

    public void setAdminDistrict2 (String adminDistrict2)
    {
        this.adminDistrict2 = adminDistrict2;
    }

    public String getAdminDistrict ()
    {
        return adminDistrict;
    }

    public void setAdminDistrict (String adminDistrict)
    {
        this.adminDistrict = adminDistrict;
    }

    public String getLocality ()
    {
        return locality;
    }

    public void setLocality (String locality)
    {
        this.locality = locality;
    }

    public String getFormattedAddress ()
    {
        return formattedAddress;
    }

    public void setFormattedAddress (String formattedAddress)
    {
        this.formattedAddress = formattedAddress;
    }

    public String getCountryRegion ()
    {
        return countryRegion;
    }

    public void setCountryRegion (String countryRegion)
    {
        this.countryRegion = countryRegion;
    }

    @Override
    public String toString()
    {
        return "adminDistrict2 : "+adminDistrict2+", adminDistrict : "+adminDistrict+", locality : "+locality+", formattedAddress : ["+formattedAddress+"], countryRegion : "+countryRegion;
    }
}
