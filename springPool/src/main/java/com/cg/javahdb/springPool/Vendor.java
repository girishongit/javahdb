package com.cg.javahdb.springPool;

public class Vendor {
	
	private int vendorId;
	private String vendorName;
	private String vendorPhone;
	private String vendorEmail;

	public Vendor() {}
	
	public Vendor(int vendorId, String vendorName, String vendorPhone, String vendorEmail) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorPhone = vendorPhone;
		this.vendorEmail = vendorEmail;
	}

	public int getvendorId() {
		return vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setvendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	 @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Vendor Id:- " + getvendorId() + " Vendor Name:- " + getVendorName() + " Vendor Phone:- " +
        		getVendorPhone() + " Vendor Email:- " + getVendorEmail());
        return builder.toString();
    }

}
