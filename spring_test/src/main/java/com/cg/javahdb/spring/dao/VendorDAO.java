package com.cg.javahdb.spring.dao;

/**
 *
 * @author GBANGALO
 */
 
import java.util.List;
import com.cg.javahdb.spring.entities.VendorDetails;
import com.cg.javahdb.spring.entities.AddressTemplate;
import com.cg.javahdb.spring.entities.MetaData;
 
public interface VendorDAO {
	
	List<VendorDetails> getAllData();
    List<VendorDetails> getDataById(int vid);
    
    void updateVendor(VendorDetails vendor);
    void deleteFile(int vid);
    
    void addData(VendorDetails vendor);
    void addDataInBatch(List<VendorDetails> vendor);
    
    int getNewFileID();
    List<MetaData> getFileDetails(String userName);
    
    List<AddressTemplate> getTop50Address(int fileId);
    
}
