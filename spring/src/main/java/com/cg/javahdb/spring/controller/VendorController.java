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
import com.cg.javahdb.spring.service.CsvReader;
import com.cg.javahdb.spring.service.AppConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@RestController
public class VendorController {
	
	private int batchSize;
	
	@Autowired
    VendorDAOImpl vendorDAOImpl;
    
    @Autowired
    AppConfiguration config;
    
    @Autowired
    CsvReader csv;
    
    @GetMapping("/data")
    public ResponseEntity<List<VendorDetails>> getAllVendors()
    {
        List<VendorDetails> vendorList = vendorDAOImpl.getAllVendors();
        return new ResponseEntity<List<VendorDetails>>(vendorList, HttpStatus.OK);
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<VendorDetails> getVendorById(@PathVariable("id") Integer id)
    {
        VendorDetails vendor = vendorDAOImpl.getVendorById(id);
        return new ResponseEntity<VendorDetails>(vendor, HttpStatus.OK);
    }

    @PutMapping("/data")
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
    }

    @DeleteMapping("/data/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable("id") Integer id)
    {
        vendorDAOImpl.deleteFile(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
    	 CsvReader csvReader = new CsvReader(file);
    	 String data = csvReader.readCsvDatatoHDB(vendorDAOImpl);
    	 return data;
    }
    
    @GetMapping("/fileDetails")
    public ResponseEntity<List<MetaData>> getallFiles()
    {
        List<MetaData> fileDetails = vendorDAOImpl.getFileDetails("Girish");
        return new ResponseEntity<List<MetaData>>(fileDetails, HttpStatus.OK);
    }
    
    @GetMapping("/")
    public String getbatchsize()
    {
        return config.getCsvBatchSize().toString();
    }
    
    @GetMapping("/test")
    public String getbatchsizefromDAO()
    {
        return vendorDAOImpl.getBatchSize();
    }
    
    @GetMapping("/test1")
    public String getbatchsizefromservice()
    {
        return csv.getBatchSize();
    }

}
