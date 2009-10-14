package com.aci.training.presentation;

import java.util.List;

import com.aci.training.model.User;

public class ApplicationBean {

	private List<User> loggedInUsers = null;

	public ApplicationBean() {
	}

	public List<User> getLoggedInUsers() {
		return loggedInUsers;
	}

}