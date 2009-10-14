package com.aci.training.presentation;

import com.aci.training.bl.Services;
import com.aci.training.model.User;
import com.aci.training.presentation.utils.JSFNavigationConstants;
import com.aci.training.presentation.utils.JSFUtil;
import com.aci.training.presentation.utils.SpringUtil;

public class LoginBean {

	private String username;
	private String password;

	public String login() {
		Services services = SpringUtil.getServices();
		User u = services.login(username, password);
		if (u != null) {
			SessionBean sessionBean = (SessionBean) JSFUtil
					.getBean(SessionBean.class.getSimpleName());
			sessionBean.setLoggedInUser(u);
			return JSFNavigationConstants.LOGIN;
		} else {
			return null;
		}
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

}