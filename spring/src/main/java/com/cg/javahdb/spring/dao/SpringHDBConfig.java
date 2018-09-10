package com.cg.javahdb.spring.dao;

/**
 * @author GBANGALO
 * @Description Configuration to obtain HDB connection
 */
 
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sap.db.jdbcext.DataSourceSAP;
import com.sap.xs.env.Credentials;
import com.sap.xs.env.Service;
import com.sap.xs.env.VcapServices; 

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.cg.javahdb.spring")
public class SpringHDBConfig {
	
	private JdbcTemplate jdbcTemplateObject;
 
    @Autowired
    private Environment env;
 
    @Bean
    public DataSourceSAP dataSource() {
    	VcapServices services = VcapServices.fromEnvironment();
	
    	// find HDI service by label "hana"
    	Service service = services.findService("hana", "", "");
    	if (service == null) {
    	  return null;
    	}
	
    	Credentials credentials = service.getCredentials();
    	DataSourceSAP dataSource = new DataSourceSAP();
	
    	dataSource.setUser(credentials.getUser());
    	dataSource.setPassword(credentials.getPassword());
    	dataSource.setPort(Integer.parseInt(credentials.getPort()));
    	dataSource.setServerName(credentials.getHost());
    	
    	Map hdiCrediantials = credentials.any();
    	dataSource.setSchema(hdiCrediantials.get("schema").toString());
        return dataSource;
    }

}
