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

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.Math.toIntExact;
import java.lang.reflect.Field;

@Service
public class CsvReader {
	
	private MultipartFile file;
	private String fileName;
	private Integer batchSize;
	
	@Autowired
	VendorDAOImpl vendorDAOImpl;
	
    @Autowired
    private void setBatchSize(AppConfiguration config)
    {
    	this.batchSize = config.getCsvBatchSize();
    };
    
    public CsvReader(){
    }

    public String getBatchSize()
    {
    	return batchSize.toString();
    }
    
    public String getFileName(){
    	return this.fileName;
    }

	public String readCsvDatatoHDB(MultipartFile file)
	{
		this.file = file;
    	fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	
		List<VendorDetails> vendors= new ArrayList<VendorDetails>();
		VendorDetails vendorDetails;
		MetaData metaData = new MetaData();
		Gson gson = new Gson();
		String status = "";
		int i = 0;
		long recordCount = 0;
		int fileId = -1;

		try(
			Reader reader = new InputStreamReader(this.file.getInputStream());        
		    // Using Apache Common Csv
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
					                    .withFirstRecordAsHeader()
					                    .withDelimiter(';')
					                    .withIgnoreHeaderCase()
					                    .withIgnoreEmptyLines(true)
					                    .withTrim());
        	) {

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
					vendorDetails.setHouseNumber(csvRecord.get("HouseNumber"));
					vendorDetails.setAddressLine1(csvRecord.get("AddressLine1"));
					vendorDetails.setAddressLine2(csvRecord.get("AddressLine2"));
					vendorDetails.setCity(csvRecord.get("City"));
					vendorDetails.setCounty(csvRecord.get("County"));
					vendorDetails.setState(csvRecord.get("State"));
					vendorDetails.setPostalCode(csvRecord.get("PostalCode"));
					vendorDetails.setCountry(csvRecord.get("Country"));
					vendorDetails.setPrimaryPhone(csvRecord.get("PrimaryPhone"));
					vendorDetails.setSecondaryPhone(csvRecord.get("SecondaryPhone"));
					vendorDetails.setEmail(csvRecord.get("Email"));
					vendorDetails.setWebLink(csvRecord.get("WebLink"));
					vendorDetails.setTaxNumber1(csvRecord.get("TaxNumber1"));
					vendorDetails.setTaxNumber2(csvRecord.get("TaxNumber2"));
					vendorDetails.setVATRegNumber(csvRecord.get("VATRegNumber"));
					vendorDetails.setStdCommuMtd(csvRecord.get("StdCommuMtd"));
					vendorDetails.setBankKey(csvRecord.get("BankKey"));
					vendorDetails.setBankAccount(Integer.parseInt(csvRecord.get("BankAccount")));
					vendorDetails.setIBANValue(csvRecord.get("IBANValue"));
					vendorDetails.setPayTerms(csvRecord.get("PayTerms"));
					
					//vendorDAOImpl.addVendor(vendorDetails);
					recordCount = csvRecord.getRecordNumber();
					vendors.add(vendorDetails);
					i += 1;
					if ( i == (batchSize - 1))
					{
						vendorDAOImpl.addDataInBatch(vendors);
						vendors= new ArrayList<VendorDetails>();
						i = 0;
					}
        		}
        	vendorDAOImpl.addDataInBatch(vendors);
        	if(recordCount > 0)
        	{
	        	metaData.setFileId(fileId);
	    		metaData.setFileName(this.fileName);
	    		metaData.setUploadedBy("Girish");
	    		metaData.setNoOfRecords(recordCount);
	    		vendorDAOImpl.addMetaData(metaData);
	        	status = "File Uploaded Successfully";
        	}
        	else
        	{
        		status = "Empty File, Noting to Upload.";	
        	}
        	}catch(IOException e) {
        							e.printStackTrace();
        							status = e.getMessage();
									}
		
		return status;
	}
	
	public List<String> getCSVHeaderList()
	{
		Field[] fields = VendorDetails.class.getDeclaredFields();
		List<String> headers = new ArrayList<>();
		String fieldName = "";
		String fieldType = "";
		
		for (Field field : fields) {
			fieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			fieldType = field.getType().toString().substring(field.getType().toString().lastIndexOf(".") + 1 );
			if (!fieldName.equals("FileId") && !fieldName.equals("RecordId"))
            	headers.add( fieldName + " : " + fieldType );
        }
        return headers;
	}
}
