package demo.jsf_spring_app.model;

import java.text.DecimalFormat;

import demo.jsf_spring_app.presentation.FileResource;

public final class UserAndFile {

	private User user = new User();
	private File file = new File();

	private Long minFileDimension;
	private Long maxFileDimension;

	private Long size;

	//	
	// public User getUser() {
	// return user;
	// }
	//	
	// public void setUser(User user) {
	// this.user = user;
	// }
	//	
	// public File getFile() {
	// return file;
	// }
	//	
	// public void setFile(File file) {
	// this.file = file;
	// }

	public String getLastName() {
		return user.getLastName();
	}

	public void setLastName(String lastName) {
		this.user.setLastName(lastName);
	}

	public String getFirstName() {
		return user.getFirstName();
	}

	public void setFirstName(String firstName) {
		this.user.setFirstName(firstName);
	}

	public String getCity() {
		return user.getCity();
	}

	public void setCity(String city) {
		this.user.setCity(city);
	}

	public String getFileName() {
		return file.getFileName();
	}

	public void setFileName(String fileName) {
		this.file.setFileName(fileName);
	}

	public Long getMinFileDimension() {
		return minFileDimension;
	}

	public void setMinFileDimension(Long minFileDimension) {
		this.minFileDimension = minFileDimension;
	}

	public Long getMaxFileDimension() {
		return maxFileDimension;
	}

	public void setMaxFileDimension(Long maxFileDimension) {
		this.maxFileDimension = maxFileDimension;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getSizeInMb() {
		DecimalFormat format = new DecimalFormat("0.0000");
		return format.format(size * 9.53674316 * Math.pow(10, -7)) + "Mb";
	}

	public Integer getSex() {
		return user.getSex();
	}

	public void setSex(Integer sex) {
		this.user.setSex(sex);
	}

	public Integer getAge() {
		return user.getAge();
	}

	public void setAge(Integer age) {
		this.user.setAge(age);
	}

	public String getFilePath() {
		return file.getFileName();
	}

	public void setFilePath(String filePath) {
		this.file.setFilePath(filePath);
	}

	public FileResource getFileResource() {
		return new FileResource(this.file.getFileName(), this.file.getContent());
	}
	
	public void setFileContent(byte[] content){
		this.file.setContent(content);
	}

}