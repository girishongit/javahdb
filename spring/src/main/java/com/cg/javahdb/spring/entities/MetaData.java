package com.cg.javahdb.spring.entities;

/**
 *
 * @author GBANGALO
 */
public class MetaData {
	
	private int fileId;
	private String fileName;
	private String uploadedBy;
	private String uploadedAt;
	private Long noOfRecords;
	
	public MetaData()
	{
		
	}
	
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public void setUploadedAt(String uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	public void setNoOfRecords(Long noOfRecords) {
		this.noOfRecords = noOfRecords;
	}

	public int getFileId() {
		return fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public String getUploadedAt() {
		return uploadedAt;
	}

	public Long getNoOfRecords() {
		return noOfRecords;
	}
	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[")
        		.append(fileId).append(", ")
				.append(fileName).append(", ")
				.append(uploadedBy).append(", ")
				.append(uploadedAt).append(", ")
				.append(noOfRecords).append(", ")
				.append("]");
        return builder.toString();
    }
	
}
