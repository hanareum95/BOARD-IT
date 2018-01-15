package com.sonandhan.boardit.dto;

public class FileDTO {

	private int fileNum;
	private String filePath;
	private String fileSize;
	private String fileExtension;
	private int fileParent;

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public int getFileParent() {
		return fileParent;
	}

	public void setFileParent(int fileParent) {
		this.fileParent = fileParent;
	}

}
