package com.cg.javahdb.springPool;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 
 
@RestController 
public class VendorController {
	
	@Autowired
    VendorDAOImpl vendorDAOImpl;

    @GetMapping("/vendors")
    public ResponseEntity<List<Vendor>> getAllVendors()
    {
        List<Vendor> vendorList = vendorDAOImpl.getAllVendors();
        return new ResponseEntity<List<Vendor>>(vendorList, HttpStatus.OK);
    }

    @GetMapping("/vendor/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable("id") Integer id)
    {
        Vendor vendor = vendorDAOImpl.getVendorById(id);
        return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
    }

    @PutMapping("/vendor")
    public ResponseEntity<Vendor> updateArticle(@RequestBody Vendor vendor)
    {
        vendorDAOImpl.updateVendor(vendor);
        return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
    }

    @PostMapping("/vendor")
    public ResponseEntity<Void> addArticle(@RequestBody Vendor vendor)
    {
        vendorDAOImpl.addVendor(vendor);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/vendor/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id)
    {
        vendorDAOImpl.deleteVendor(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
