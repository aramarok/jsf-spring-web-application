package com.aci.training.presentation.tabs;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.aci.training.model.User;
import com.aci.training.presentation.SessionBean;
import com.aci.training.presentation.utils.JSFUtil;
import com.aci.training.presentation.utils.SpringUtil;

public class ProfilBean {

	private String username;
	private String password;

	private String nume;
	private String prenume;
	private String localitate;
	private int varsta;
	private String sex;
	private String spatiuFolosit;

	public ProfilBean() {
		SessionBean sessionBean = (SessionBean) JSFUtil
				.getBean(SessionBean.class.getSimpleName());// (SessionBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("SessionBean");
		User u = SpringUtil.getServices().getUser(
				sessionBean.getLoggedInUser().getUserName());
		username = u.getUserName();
		password = u.getPassword();
		nume = u.getLastName();
		prenume = u.getFirstName();
		localitate = u.getCity();
		varsta = u.getAge();
		sex = String.valueOf(u.getSex());
		
		DecimalFormat format = new
		DecimalFormat("0.00");
		spatiuFolosit = format.format(SpringUtil.getServices().getFilesBytesForUser(u.getUserName())*9.53674316*Math.pow(10, -7));
	}

	public List<SelectItem> getVarstaItems() {
		List<SelectItem> varstaItems = new ArrayList<SelectItem>();
		varstaItems.add(new SelectItem(null, ""));
		for (int i = 1; i < 101; i++) {
			varstaItems.add(new SelectItem(i, String.valueOf(i)));
		}
		return varstaItems;
	}

	public List<SelectItem> getSexItems() {
		List<SelectItem> sexItems = new ArrayList<SelectItem>();
		sexItems.add(new SelectItem("0", "F"));
		sexItems.add(new SelectItem("1", "M"));
		sexItems.add(new SelectItem("", "N/A"));
		return sexItems;
	}

	public String salveaza() {
		User user = new User();
		user.setUserName(username);
		user.setLastName(nume);
		user.setFirstName(prenume);
		user.setCity(localitate);
		user.setAge(varsta);
		user.setSex(Integer.parseInt(sex));
		User u = SpringUtil.getServices().updateUser(user);

		this.username = u.getUserName();
		this.password = u.getPassword();
		this.nume = u.getLastName();
		this.prenume = u.getFirstName();
		this.localitate = u.getCity();
		this.varsta = u.getAge();
		this.sex = String.valueOf(u.getSex());
		return null;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getLocalitate() {
		return localitate;
	}

	public void setLocalitate(String localitate) {
		this.localitate = localitate;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getSpatiuFolosit() {
		return spatiuFolosit;
	}

	public void setSpatiuFolosit(String spatiuFolosit) {
		this.spatiuFolosit = spatiuFolosit;
	}
}
