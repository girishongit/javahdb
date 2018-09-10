package com.cg.javahdb.springPool;

/**
 *
 * @author GBANGALO
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper; 
 
public class VendorMapper implements RowMapper<Vendor>
{
    @Override
    public Vendor mapRow(ResultSet row, int rowNum) throws SQLException 
    {
         Vendor vendor = new Vendor();
         vendor.setvId(row.getInt("vId"));
         vendor.setVendorName(row.getString("vendorName"));
         vendor.setVendorPhone(row.getString("vendorPhone"));
         vendor.setVendorEmail(row.getString("vendorEmail"));
         return vendor;
    }
}