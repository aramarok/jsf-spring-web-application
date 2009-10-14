package demo.jsf_spring_app.presentation;

import demo.jsf_spring_app.bl.Services;
import demo.jsf_spring_app.model.User;
import demo.jsf_spring_app.presentation.utils.JSFNavigationConstants;
import demo.jsf_spring_app.presentation.utils.JSFUtil;
import demo.jsf_spring_app.presentation.utils.SpringUtil;

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