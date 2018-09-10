package com.cg.javahdb.spring.dao.impl;

/**
 *
 * @author GBANGALO
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper; 
 
import com.cg.javahdb.spring.entities.AddressTemplate; 
 
public class AddressMapper implements RowMapper<AddressTemplate>
{
    @Override
    public AddressTemplate mapRow(ResultSet row, int rowNum) throws SQLException 
    {
        AddressTemplate address = new AddressTemplate();
        address.setHouseNumber(row.getString("houseNumber"));
        address.setAddressLine1(row.getString("addressLine1"));
        address.setAddressLine2(row.getString("addressLine2"));
        address.setCounty(row.getString("city"));
        address.setCity(row.getString("county"));
        address.setState(row.getString("state"));
        address.setPostalCode(row.getString("postalCode"));
        address.setCountry(row.getString("country"));
        address.setFileId(row.getInt("fileId"));
        address.setRecordId(row.getInt("recordId"));
        return address;
    }
}
