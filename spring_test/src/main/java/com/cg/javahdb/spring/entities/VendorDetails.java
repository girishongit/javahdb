package com.cg.javahdb.spring.entities;

/**
 * @author GBANGALO
 * @Description Pojo Class(Structure) for VendorDetails Table
 */
 
public class VendorDetails {
	
	private int fileId;
	private int recordId;
	private String firstName;
	private String lastName;
	private String companyName;
	private String houseNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String county;
	private String state;
	private String postalCode;
	private String country;
	private String primaryPhone;
	private String secondaryPhone;
	private String email;
	private String webLink;
	private String taxNumber1;
    private String taxNumber2;
    private String VATRegNumber;
    private String stdCommuMtd;
    private String bankKey;
    private int bankAccount;
    private String IBANValue;
    private String payTerms;

	public VendorDetails() {}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}

	public void setTaxNumber1(String taxNumber1) {
		this.taxNumber1 = taxNumber1;
	}

	public void setTaxNumber2(String taxNumber2) {
		this.taxNumber2 = taxNumber2;
	}

	public void setVATRegNumber(String vATRegNumber) {
		VATRegNumber = vATRegNumber;
	}

	public void setStdCommuMtd(String stdCommuMtd) {
		this.stdCommuMtd = stdCommuMtd;
	}

	public void setBankKey(String bankKey) {
		this.bankKey = bankKey;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void setIBANValue(String iBANValue) {
		IBANValue = iBANValue;
	}

	public void setPayTerms(String payTerms) {
		this.payTerms = payTerms;
	}

	public int getFileId() {
		return fileId;
	}

	public int getRecordId() {
		return recordId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public String getHouseNumber() {
		 return houseNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getCounty() {
		return county;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public String getEmail() {
		return email;
	}

	public String getWebLink() {
		return webLink;
	}

	public String getTaxNumber1() {
		return taxNumber1;
	}

	public String getTaxNumber2() {
		return taxNumber2;
	}

	public String getVATRegNumber() {
		return VATRegNumber;
	}

	public String getStdCommuMtd() {
		return stdCommuMtd;
	}

	public String getBankKey() {
		return bankKey;
	}

	public int getBankAccount() {
		return bankAccount;
	}

	public String getIBANValue() {
		return IBANValue;
	}

	public String getPayTerms() {
		return payTerms;
	}
	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[")
        		.append(fileId).append(", ")
				.append(recordId).append(", ")
				.append(firstName).append(", ")
				.append(lastName).append(", ")
				.append(companyName).append(", ")
				.append(addressLine1).append(", ")
				.append(addressLine2).append(", ")
				.append(city).append(", ")
				.append(county).append(", ")
				.append(state).append(", ")
				.append(postalCode).append(", ")
				.append(country).append(", ")
				.append(primaryPhone).append(", ")
				.append(secondaryPhone).append(", ")
				.append(email).append(", ")
				.append(webLink).append(", ")
				.append(taxNumber1).append(", ")
				.append(taxNumber2).append(", ")
				.append(VATRegNumber).append(", ")
				.append(stdCommuMtd).append(", ")
				.append(bankKey).append(", ")
				.append(bankAccount).append(", ")
				.append(IBANValue).append(", ")
				.append(payTerms).append(", ")
				.append("]");
        return builder.toString();
    }
}
