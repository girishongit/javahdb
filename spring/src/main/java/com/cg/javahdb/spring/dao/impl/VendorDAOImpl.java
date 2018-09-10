package com.cg.javahdb.spring.dao.impl;

/**
 * @author GBANGALO
 * @Description HDB implementation for Spring using JDBC Template
 */
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.*;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import com.sap.db.jdbcext.DataSourceSAP;

import com.cg.javahdb.spring.dao.VendorDAO;
import com.cg.javahdb.spring.dao.impl.VendorDAOMapper;
import com.cg.javahdb.spring.entities.VendorDetails;
import com.cg.javahdb.spring.entities.MetaData;

import com.cg.javahdb.spring.service.AppConfiguration;

@Repository
public class VendorDAOImpl implements VendorDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
    AppConfiguration config;
    
	@Autowired
	public VendorDAOImpl(DataSourceSAP dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
    public String getBatchSize()
    {
    	return config.getCsvBatchSize().toString();
    }
    
    @Override
    public List<VendorDetails> getAllVendors()
    {
        String sql = "SELECT * FROM \"javaHDBConnet.hdb.data::tables.data\";";
        List vendorList = jdbcTemplate
                .query(sql, new VendorDAOMapper());
        return vendorList;
    }

    @Override
    public VendorDetails getVendorById(int fileid)
    {
        String sql = "SELECT * FROM \"javaHDBConnet.hdb.data::tables.data\" where \"fileId\" =?";
        VendorDetails vendor = jdbcTemplate
                .queryForObject(sql, new VendorDAOMapper(), fileid);
        return vendor;
    }
    
    public int getNewFileID()
    {
    	String sql = "SELECT \"javaHDBConnet.hdb.sequence::fileId\".nextval as FILE_ID FROM DUMMY";
    	int fileId = jdbcTemplate.queryForObject(sql, Integer.class);
    	return fileId;
    }
    
    public void addMetaData(MetaData metaData)
    {
        String sql = "insert into \"javaHDBConnet.hdb.data::tables.metaData\" (\"fileId\",\"fileName\",\"uploadedBy\",\"uploadedAt\",\"noOfRecords\") values (?,?,?,CURRENT_TIMESTAMP,?)";
        jdbcTemplate.update(sql,
        						metaData.getFileId(),
								metaData.getFileName(),
								metaData.getUploadedBy(),
								metaData.getNoOfRecords());
    }

    @Override
    public void addData(VendorDetails vendor)
    {
        String sql = "insert into \"javaHDBConnet.hdb.data::tables.data\" (\"fileId\",\"recordId\",\"firstName\",\"lastName\",\"companyName\","+
        			"\"addressLine1\",\"addressLine2\",\"city\",\"county\",\"state\",\"zip\",\"country\",\"primaryPhone\",\"secondaryPhone\",\"email\","+
        			"\"webLink\",\"taxNumber1\",\"taxNumber2\",\"VATRegNumber\",\"stdCommuMtd\",\"bankKey\",\"bankAccount\",\"IBANValue\",\"payTerms\") "+
        			"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, vendor.getFileId(),
								vendor.getRecordId(),
								vendor.getFirstName(),
								vendor.getLastName(),
								vendor.getCompanyName(),
								vendor.getAddressLine1(),
								vendor.getAddressLine2(),
								vendor.getCity(),
								vendor.getCounty(),
								vendor.getState(),
								vendor.getZip(),
								vendor.getCountry(),
								vendor.getPrimaryPhone(),
								vendor.getSecondaryPhone(),
								vendor.getEmail(),
								vendor.getWebLink(),
								vendor.getTaxNumber1(),
								vendor.getTaxNumber2(),
								vendor.getVATRegNumber(),
								vendor.getStdCommuMtd(),
								vendor.getBankKey(),
								vendor.getBankAccount(),
								vendor.getIBANValue(),
								vendor.getPayTerms()
								);
    }
    
    public void addDataInBatch(List<VendorDetails> vendors)
    {
        String sql = "insert into \"javaHDBConnet.hdb.data::tables.data\" (\"fileId\",\"recordId\",\"firstName\",\"lastName\",\"companyName\","+
        			"\"addressLine1\",\"addressLine2\",\"city\",\"county\",\"state\",\"zip\",\"country\",\"primaryPhone\",\"secondaryPhone\",\"email\","+
        			"\"webLink\",\"taxNumber1\",\"taxNumber2\",\"VATRegNumber\",\"stdCommuMtd\",\"bankKey\",\"bankAccount\",\"IBANValue\",\"payTerms\") "+
        			"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, vendors.get(i).getFileId());
				ps.setInt(2, vendors.get(i).getRecordId());
				ps.setString(3, vendors.get(i).getFirstName());
				ps.setString(4, vendors.get(i).getLastName());
				ps.setString(5, vendors.get(i).getCompanyName());
				ps.setString(6, vendors.get(i).getAddressLine1());
				ps.setString(7, vendors.get(i).getAddressLine2());
				ps.setString(8, vendors.get(i).getCity());
				ps.setString(9, vendors.get(i).getCounty());
				ps.setString(10, vendors.get(i).getState());
				ps.setString(11, vendors.get(i).getZip());
				ps.setString(12, vendors.get(i).getCountry());
				ps.setString(13, vendors.get(i).getPrimaryPhone());
				ps.setString(14, vendors.get(i).getSecondaryPhone());
				ps.setString(15, vendors.get(i).getEmail());
				ps.setString(16, vendors.get(i).getWebLink());
				ps.setString(17, vendors.get(i).getTaxNumber1());
				ps.setString(18, vendors.get(i).getTaxNumber2());
				ps.setString(19, vendors.get(i).getVATRegNumber());
				ps.setString(20, vendors.get(i).getStdCommuMtd());
				ps.setString(21, vendors.get(i).getBankKey());
				ps.setInt(22, vendors.get(i).getBankAccount());
				ps.setString(23, vendors.get(i).getIBANValue());
				ps.setString(24, vendors.get(i).getPayTerms());
			}
			
			@Override
			public int getBatchSize() {
				return vendors.size();
			}
		});
    }
    
    public List<MetaData> getFileDetails(String userName)
    {
    	String sql = "SELECT \"fileId\",\"fileName\",\"uploadedBy\",\"uploadedAt\",\"noOfRecords\" FROM \"javaHDBConnet.hdb.data::tables.metaData\" where \"uploadedBy\" = ? ORDER BY \"uploadedAt\"";
    	//MetaData fileDetails = jdbcTemplate.queryForObject(sql, new MetaDataMapper() , userName);
    	List<MetaData> fileDetails = jdbcTemplate.query(sql, new MetaDataMapper() , new Object[] {userName});
    	return fileDetails;
    }

    @Override
    public void updateVendor(VendorDetails vendor)
    {
        String sql = "update \"javaHDBConnet.hdb.data::tables.data\" set \"firstName\" = ?, \"primaryPhone\" = ? where \"recordId\" = ?";
        jdbcTemplate.update(sql, vendor.getFirstName(), vendor.getPrimaryPhone(), vendor.getRecordId() );
    }

    @Override
    public void deleteFile(int id)
    {
        String sql = "delete from \"javaHDBConnet.hdb.data::tables.data\" where \"fileId\" = ? ";
        jdbcTemplate.update(sql, id);
    }

}
