package com.aci.training.presentation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import com.icesoft.faces.context.Resource;

public class FileResource implements Resource, Serializable {

	private static final long serialVersionUID = 1L;

	private String fileName;
	private byte[] byteContent;

	public FileResource(String fileName, byte[] fileByteContent) {
		this.fileName = fileName;
		this.byteContent = fileByteContent;
	}

	public String calculateDigest() {
		return fileName;
	}

	public Date lastModified() {
		return new Date();
	}

	public InputStream open() throws IOException {
		return new ByteArrayInputStream(byteContent);
	}

	public void withOptions(Options arg0) throws IOException {
	}

}