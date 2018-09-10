package com.cg.javahdb.spring.service;

/**
 * @author GBANGALO
 * @Description Service to Parse and Read CSV File
 */

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import org.springframework.util.StringUtils;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.lang.*;
import java.util.*;
import com.google.gson.*;

import com.cg.javahdb.spring.entities.VendorDetails;
import com.cg.javahdb.spring.entities.MetaData;
import com.cg.javahdb.spring.dao.impl.VendorDAOImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.Math.toIntExact;

@Service
public class CsvReader {
	
	private MultipartFile file;
	private String fileName;
	private Integer batchSize;
	
    @Autowired
    private void setBatchSize(AppConfiguration config)
    {
    	this.batchSize = config.getCsvBatchSize();
    };
    
    public CsvReader(){
    }
    
    public CsvReader(MultipartFile file){
    	this.file = file;
    	fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	//this.setBatchSize();
    }
    
    public String getBatchSize()
    {
    	return batchSize.toString();
    }
    
    public String getFileName(){
    	return this.fileName;
    }

	public String readCsvDatatoHDB(VendorDAOImpl vendorDAOImpl)
	{
		List<VendorDetails> vendors= new ArrayList<VendorDetails>();
		VendorDetails vendorDetails;
		MetaData metaData = new MetaData();
		Gson gson = new Gson();
		String status = "";
		int i = 0;
		long recordCount = 0;
		int fileId = -1;
		/*Set reqdHeader = new HashSet(Arrays.asList({"FirstName", "LastName", "CompanyName", "AddressLine1", "AddressLine2", "City", "County", "State", "ZipCode",
													"Country", "PrimaryContactNum", "SecondaryContactNum", "EmailId", "WebLink", "TaxNumber1", "TaxNumber2", 
													"VATRegNumber", "StdCommMethod", "BankKey", "BankAccount", "IBANValue", "PayTerms"}));*/
		
		System.out.println("This Batch Size : "+this.batchSize);
		//System.out.println("Congig Batch Size : "+config.getCsvBatchSize());
		
		try(
			Reader reader = new InputStreamReader(this.file.getInputStream());        
		    // Using Apache Common Csv
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
					                    .withFirstRecordAsHeader()
					                    .withDelimiter(';')
					                    .withIgnoreHeaderCase()
					                    .withTrim());
        	) {
        		
        		/*Set headers = csvParser.getHeaderMap().keySet());
        		for (String s : set) 
        		{
					if(!reqdHeader.contains(s))
				}*/
        		
        		fileId = vendorDAOImpl.getNewFileID();
        		for (CSVRecord csvRecord : csvParser) 
        		{
					//vendorDetails.setRecordNumber(csvRecord.getRecordNumber());
					vendorDetails = new VendorDetails();
				    vendorDetails.setFileId(fileId);
					vendorDetails.setRecordId(toIntExact(csvRecord.getRecordNumber()));
					vendorDetails.setFirstName(csvRecord.get("FirstName"));
					vendorDetails.setLastName(csvRecord.get("LastName"));
					vendorDetails.setCompanyName(csvRecord.get("CompanyName"));
					vendorDetails.setAddressLine1(csvRecord.get("AddressLine1"));
					vendorDetails.setAddressLine2(csvRecord.get("AddressLine2"));
					vendorDetails.setCity(csvRecord.get("City"));
					vendorDetails.setCounty(csvRecord.get("County"));
					vendorDetails.setState(csvRecord.get("State"));
					vendorDetails.setZip(csvRecord.get("ZipCode"));
					vendorDetails.setCountry(csvRecord.get("Country"));
					vendorDetails.setPrimaryPhone(csvRecord.get("PrimaryContactNum"));
					vendorDetails.setSecondaryPhone(csvRecord.get("SecondaryContactNum"));
					vendorDetails.setEmail(csvRecord.get("EmailId"));
					vendorDetails.setWebLink(csvRecord.get("WebLink"));
					vendorDetails.setTaxNumber1(csvRecord.get("TaxNumber1"));
					vendorDetails.setTaxNumber2(csvRecord.get("TaxNumber2"));
					vendorDetails.setVATRegNumber(csvRecord.get("VATRegNumber"));
					vendorDetails.setStdCommuMtd(csvRecord.get("StdCommMethod"));
					vendorDetails.setBankKey(csvRecord.get("BankKey"));
					vendorDetails.setBankAccount(Integer.parseInt(csvRecord.get("BankAccount")));
					vendorDetails.setIBANValue(csvRecord.get("IBANValue"));
					vendorDetails.setPayTerms(csvRecord.get("PayTerms"));
					
					//vendorDAOImpl.addVendor(vendorDetails);
					recordCount = csvRecord.getRecordNumber();
					vendors.add(vendorDetails);
					i += 1;
					if ( i == (10000 - 1))
					{
						vendorDAOImpl.addDataInBatch(vendors);
						vendors= new ArrayList<VendorDetails>();
						i = 0;
					}
        		}
        	vendorDAOImpl.addDataInBatch(vendors);
        	metaData.setFileId(fileId);
    		metaData.setFileName(this.fileName);
    		metaData.setUploadedBy("Girish");
    		metaData.setNoOfRecords(recordCount);
    		vendorDAOImpl.addMetaData(metaData);

        	status = "File Uploaded Successfully";
        	}catch(IOException e) {
        							e.printStackTrace();
        							status = e.getMessage();
									}
		
		return status;
	}

}
