package com.cg.javahdb.springPool;

/**
 *
 * @author GBANGALO
 */
 
import java.util.List;
 
public interface VendorDAO {
	
	List<Vendor> getAllVendors();
    Vendor getVendorById(int id);
    void addVendor(Vendor vendor);
    void updateVendor(Vendor vendor);
    void deleteVendor(int id);

}
