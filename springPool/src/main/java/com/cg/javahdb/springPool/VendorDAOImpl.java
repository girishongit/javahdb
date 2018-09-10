package com.cg.javahdb.springPool;

/**
 *
 * @author GBANGALO
 */
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sap.db.jdbcext.DataSourceSAP;

@Repository
public class VendorDAOImpl implements VendorDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public VendorDAOImpl(DataSourceSAP dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
    
    @Override
    public List<Vendor> getAllVendors()
    {
        String sql = "SELECT * FROM \"javaHDBConnet.hdb.data::tables.vendor\";";
        List vendorList = jdbcTemplate
                .query(sql, new VendorMapper());
        return vendorList;
    }

    @Override
    public Vendor getVendorById(int vId)
    {
        String sql = "SELECT * FROM \"javaHDBConnet.hdb.data::tables.vendor\" where \"vId\" =?";
        Vendor vendor = jdbcTemplate
                .queryForObject(sql, new VendorMapper(), vId);
        return vendor;
    }

    @Override
    public void addVendor(Vendor vendor)
    {
        String sql = "insert into \"javaHDBConnet.hdb.data::tables.vendor\" (\"vId\",\"vendorName\",\"vendorPhone\",\"vendorEmail\") values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, vendor.getvId(), vendor.getVendorName(), vendor.getVendorPhone(), vendor.getVendorEmail());
    }

    @Override
    public void updateVendor(Vendor vendor)
    {
        String sql = "update \"javaHDBConnet.hdb.data::tables.vendor\" set \"vendorName\" = ?, \"vendorPhone\" = ? where \"vId\" = ?";
        jdbcTemplate.update(sql, vendor.getVendorName(), vendor.getVendorPhone(), vendor.getvId() );
    }

    @Override
    public void deleteVendor(int id)
    {
        String sql = "delete from \"javaHDBConnet.hdb.data::tables.vendor\" where \"vId\" = ? ";
        jdbcTemplate.update(sql, id);
    }

}
