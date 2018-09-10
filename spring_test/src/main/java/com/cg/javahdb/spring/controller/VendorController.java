package com.cg.javahdb.spring.controller;

/**
 *
 * @author GBANGALO
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cg.javahdb.spring.dao.impl.VendorDAOImpl;

import com.cg.javahdb.spring.entities.VendorDetails;
import com.cg.javahdb.spring.entities.MetaData;
import com.cg.javahdb.spring.entities.AddressTemplate;

import com.cg.javahdb.spring.service.CsvReader;
import com.cg.javahdb.spring.service.ValidateAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@RestController
public class VendorController {
	
	private int batchSize;
	
	@Autowired
    VendorDAOImpl vendorDAOImpl;
    
    @Autowired
    CsvReader csvReader;
    
    @Autowired
    ValidateAddress validateAddress;
    
    @GetMapping("/data")
    public ResponseEntity<List<VendorDetails>> getAllData()
    {
        List<VendorDetails> dataList = vendorDAOImpl.getAllData();
        return new ResponseEntity<List<VendorDetails>>(dataList, HttpStatus.OK);
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<List<VendorDetails>> getDataById(@PathVariable("id") Integer id)
    {
        List<VendorDetails> data = vendorDAOImpl.getDataById(id);
        return new ResponseEntity<List<VendorDetails>>(data, HttpStatus.OK);
    }

    /*@PutMapping("/data")
    public ResponseEntity<VendorDetails> updateVendor(@RequestBody VendorDetails vendor)
    {
        vendorDAOImpl.updateVendor(vendor);
        return new ResponseEntity<VendorDetails>(vendor, HttpStatus.OK);
    }
	
    @PostMapping("/data")
    public ResponseEntity<Void> addVendor(@RequestBody VendorDetails vendor)
    {
        vendorDAOImpl.addData(vendor);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }*/

    @DeleteMapping("/data/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable("id") Integer id)
    {
        vendorDAOImpl.deleteFile(id);
        return new ResponseEntity<String>("File Deleted Successfully (FileID = "+id+").",HttpStatus.OK);
    }
    
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
    	 String data = csvReader.readCsvDatatoHDB(file);
    	 return data;
    }
    
    @GetMapping("/fileDetails")
    public ResponseEntity<List<MetaData>> getallFiles()
    {
        List<MetaData> fileDetails = vendorDAOImpl.getFileDetails("Girish");
        return new ResponseEntity<List<MetaData>>(fileDetails, HttpStatus.OK);
    }
    
    @GetMapping("/headerlist")
    public ResponseEntity<List<String>> getHeaderList()
    {
        List<String> headers = csvReader.getCSVHeaderList();
        return new ResponseEntity<List<String>>(headers, HttpStatus.OK);
    }
    
    /*****************************************Test*****************************************/
    @GetMapping("/getbingaddress")
    public String getbingaddress()
    {
        return validateAddress.bingValidation(new AddressTemplate());
    }
    
    @GetMapping("/gethereaddress")
    public String gethereaddress()
    {
        return validateAddress.hereValidation(new AddressTemplate());
    }
    
    @GetMapping("/getarcgisaddress")
    public String getarcgisaddress()
    {
        return validateAddress.arcgisValidation(new AddressTemplate());
    }
    
    @GetMapping("/getaddress")
    public ResponseEntity<List<AddressTemplate>> getaddress()
    {
        List<AddressTemplate> address = vendorDAOImpl.getTop50Address(28);
        return new ResponseEntity<List<AddressTemplate>>(address, HttpStatus.OK);
    }
    
    /*****************************************Test*****************************************/
    
}
