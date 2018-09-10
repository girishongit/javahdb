package com.cg.javahdb.spring.dao.impl;

/**
 * @author GBANGALO
 * @Description Mapper Class for Vendor DAO
 */
 
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper; 
 
import com.cg.javahdb.spring.entities.VendorDetails; 
 
public class VendorDAOMapper implements RowMapper<VendorDetails>
{
    @Override
    public VendorDetails mapRow(ResultSet row, int rowNum) throws SQLException 
    {
        VendorDetails vendor = new VendorDetails();
        vendor.setFileId(row.getInt("fileId"));
		vendor.setRecordId(row.getInt("recordId"));
		vendor.setFirstName(row.getString("firstName"));
		vendor.setLastName(row.getString("lastName"));
		vendor.setCompanyName(row.getString("companyName"));
		vendor.setHouseNumber(row.getString("houseNumber"));
		vendor.setAddressLine1(row.getString("addressLine1"));
		vendor.setAddressLine2(row.getString("addressLine2"));
		vendor.setCity(row.getString("city"));
		vendor.setCounty(row.getString("county"));
		vendor.setState(row.getString("state"));
		vendor.setPostalCode(row.getString("postalCode"));
		vendor.setCountry(row.getString("country"));
		vendor.setPrimaryPhone(row.getString("primaryPhone"));
		vendor.setSecondaryPhone(row.getString("secondaryPhone"));
		vendor.setEmail(row.getString("email"));
		vendor.setWebLink(row.getString("webLink"));
		vendor.setTaxNumber1(row.getString("taxNumber1"));
		vendor.setTaxNumber2(row.getString("taxNumber2"));
		vendor.setVATRegNumber(row.getString("VATRegNumber"));
		vendor.setStdCommuMtd(row.getString("stdCommuMtd"));
		vendor.setBankKey(row.getString("bankKey"));
		vendor.setBankAccount(row.getInt("bankAccount"));
		vendor.setIBANValue(row.getString("IBANValue"));
		vendor.setPayTerms(row.getString("payTerms"));
         return vendor;
    }
}