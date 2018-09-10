package com.cg.javahdb.spring.service;

/**
 *
 * @author GBANGALO
 */
 
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import java.io.IOException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.javahdb.spring.entities.AddressTemplate;
import com.cg.javahdb.spring.dao.impl.VendorDAOImpl;
import com.cg.javahdb.spring.entities.arcgis.*;
import com.cg.javahdb.spring.entities.bing.*;
import com.cg.javahdb.spring.entities.here.*;

@Service
public class ValidateAddress {
	
	@Autowired
	AppConfiguration config;
	RestTemplate restTemplate = new RestTemplate();
	
	public String bingValidation(AddressTemplate address)
	{
		StringBuilder parameter = new StringBuilder();
		String url = String.format(config.getHereApiEndpoint(),"472+21st+B%20Cross+Road+MRS+LAYOUT+SUNKADAKATTE+BANGALORE+560091");
		VirtualEarth virtualEarth = restTemplate.getForObject("https://api.myjson.com/bins/15c1p8", VirtualEarth.class);
		return virtualEarth.getValidatedAddress().toString();
	}
	
	public String hereValidation(AddressTemplate address)
	{
		Here here = restTemplate.getForObject("https://api.myjson.com/bins/zj2jw", Here.class);
		return here.getValidatedAddress().toString();
	}
	
	public String arcgisValidation(AddressTemplate address)
	{
		String url = "https://geocode.arcgis.com/arcgis/rest/services/World/GeocodeServer/findAddressCandidates?Address=475+21st+B+CRossRoad+Sunkadakatte&City=Bangalore&Region=Karnataka&Postal=560091&Country=India&outFields=*&forStorage=false&f=json";
		Arcgis arcgis = restTemplate.getForObject(url, Arcgis.class);
		return arcgis.getValidatedAddress().toString();
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public void handleClientError(HttpClientErrorException ex) throws IOException {
		System.out.println("----------------StackTrace--------------------");
		System.out.println(ex.getStackTrace());
		System.out.println("-------------------Header---------------------");
		System.out.println(ex.getResponseHeaders());
		System.out.println("-------------------Body-----------------------");
	    System.out.println(ex.getResponseBodyAsString());
	}

}
