package demo.jsf_spring_app.dao;

public enum UsersTable {

	USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, CITY, AGE, SEX;

	public String getName() {
		return toString();
	}

}