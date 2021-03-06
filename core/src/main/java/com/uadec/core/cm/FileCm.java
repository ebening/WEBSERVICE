package com.uadec.core.cm;

public class FileCm {
	private String name;
	private String contentType;
	private byte[] bytes;
	
	public FileCm(String name, byte[] bytes) {
		this(name, null, bytes);
	}
	public FileCm(String name, String contentType, byte[] bytes) {
		super();
		this.name = name;
		this.contentType = contentType;
		this.bytes = bytes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}