package demo.jsf_spring_app.dao;

public enum FilesTable {

	FILE_NAME, FILE_PATH, SIZE, USER_NAME, CONTENT;

	public String getName() {
		return toString();
	}

}