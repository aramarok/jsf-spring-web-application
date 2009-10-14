package demo.jsf_spring_app.presentation;

import java.util.List;

import demo.jsf_spring_app.model.User;

public class ApplicationBean {

	private List<User> loggedInUsers = null;

	public ApplicationBean() {
	}

	public List<User> getLoggedInUsers() {
		return loggedInUsers;
	}

}