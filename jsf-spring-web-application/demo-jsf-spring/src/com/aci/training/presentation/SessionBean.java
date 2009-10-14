package com.aci.training.presentation;

import javax.faces.event.AbortProcessingException;

import com.aci.training.model.User;
import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.component.paneltabset.TabChangeListener;

public class SessionBean implements TabChangeListener{
	
	private User loggedInUser;

	private int selectedIndex = 0;
	
	private boolean profilVisible = true;
	private boolean fisiereVisible = true;
	private boolean cautareVisible = true;

	
	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	
	public boolean isProfilVisible() {
		return profilVisible;
	}

	public void setProfilVisible(boolean profilVisible) {
		this.profilVisible = profilVisible;
	}

	public boolean isFisiereVisible() {
		return fisiereVisible;
	}

	public void setFisiereVisible(boolean fisiereVisible) {
		this.fisiereVisible = fisiereVisible;
	}

	public boolean isCautareVisible() {
		return cautareVisible;
	}

	public void setCautareVisible(boolean cautareVisible) {
		this.cautareVisible = cautareVisible;
	}
	
	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public void processTabChange(TabChangeEvent arg0)
			throws AbortProcessingException {
		// TODO Auto-generated method stub
	}

}