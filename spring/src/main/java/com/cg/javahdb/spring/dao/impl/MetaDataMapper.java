package com.cg.javahdb.spring.dao.impl;

/**
 *
 * @author GBANGALO
 */
 
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper; 

import com.cg.javahdb.spring.entities.MetaData; 
 
public class MetaDataMapper implements RowMapper<MetaData>
{
    @Override
    public MetaData mapRow(ResultSet row, int rowNum) throws SQLException 
    {
        MetaData fileDetails = new MetaData();
        fileDetails.setFileId(row.getInt("fileId"));
		fileDetails.setFileName(row.getString("fileName"));
		fileDetails.setUploadedBy(row.getString("uploadedBy"));
		fileDetails.setUploadedAt(row.getString("uploadedAt"));
		fileDetails.setNoOfRecords(row.getLong("noOfRecords"));
         return fileDetails;
    }
}