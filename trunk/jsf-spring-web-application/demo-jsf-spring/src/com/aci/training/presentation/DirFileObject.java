package com.aci.training.presentation;

import javax.faces.event.ActionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

import com.aci.training.presentation.tabs.FisiereBean;
import com.aci.training.presentation.utils.JSFUtil;
import com.icesoft.faces.component.tree.IceUserObject;

public class DirFileObject extends IceUserObject {

	private DefaultMutableTreeNode directory;

	private String filePath;

	public void click(ActionEvent action) {
		FisiereBean f = (FisiereBean) JSFUtil.getBean("FisiereBean");
		f.setDirectorCurent(directory);
		if (this.isLeaf()){
			System.out.println(filePath);
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public DirFileObject(DefaultMutableTreeNode wrapper) {
		super(wrapper);
	}

	public DefaultMutableTreeNode getDirectory() {
		return directory;
	}

	public void setDirectory(DefaultMutableTreeNode directory) {
		this.directory = directory;
	}

}
