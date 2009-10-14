package com.aci.training.bl;

import java.util.List;

import com.aci.training.dao.FileDAO;
import com.aci.training.dao.UserDAO;
import com.aci.training.model.File;
import com.aci.training.model.User;
import com.aci.training.model.UserAndFile;

public class Services {

	private UserDAO userDAO;
	private FileDAO fileDAO;

	public User login(String userName, String password) {
		User user = userDAO.getUser(userName);
		if (user!=null && user.getPassword().compareTo(password) == 0) {
			return user;
		} else {
			return null;
		}
	}

	public User getUser(String userName) {
		return userDAO.getUser(userName);
	}

	public long getFilesBytesForUser(String userName) {
		File fileFilter = new File();
		fileFilter.setUserName(userName);
		List<File> filesOfUser = fileDAO.findFiles(fileFilter);

		long fileBytes = 0L;
		for (File f : filesOfUser) {
			fileBytes += f.getSize();
		}

		return fileBytes;
	}

	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}

	public File addFileToUser(String userName, File file) {
		if (userDAO.getUser(userName) != null) {
			file.setUserName(userName);
			return fileDAO.addFile(file);
		} else {
			return null;
		}
	}
	
	public List<UserAndFile> searchUsersAndFiles(UserAndFile filter) {
		return fileDAO.findFiles(filter);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setFileDAO(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}

	public FileDAO getFileDAO() {
		return fileDAO;
	}

}