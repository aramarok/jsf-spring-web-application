package demo.jsf_spring_app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import demo.jsf_spring_app.model.File;
import demo.jsf_spring_app.model.User;
import demo.jsf_spring_app.model.UserAndFile;

public class DAOUtil {

	public static RowMapper getUserRowMapper() {
		return new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserName(rs.getString(UsersTable.USER_NAME.getName()));
				user.setPassword(rs.getString(UsersTable.PASSWORD.getName()));
				user.setLastName(rs.getString(UsersTable.LAST_NAME.getName()));
				user.setFirstName(rs.getString(UsersTable.FIRST_NAME.getName()));
				user.setCity(rs.getString(UsersTable.CITY.getName()));
				user.setAge(Integer.parseInt(rs.getString(UsersTable.AGE.getName())));
				user.setSex(Integer.parseInt(rs.getString(UsersTable.SEX.getName())));
				return user;
			}
		};
	}

	public static RowMapper getFileRowMapper() {
		return new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				File file = new File();
				file.setFileName(rs.getString(FilesTable.FILE_NAME.getName()));
				file.setUserName(rs.getString(FilesTable.USER_NAME.getName()));
				file.setSize(Long.parseLong(rs.getString(FilesTable.SIZE.getName())));
				file.setFilePath(rs.getString(FilesTable.FILE_PATH.getName()));
				file.setContent(rs.getBytes(FilesTable.CONTENT.getName()));
				return file;
			}
		};
	}
	
	public static RowMapper getUserAndFileRowMapper() {
		return new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserAndFile userAndFile = new UserAndFile();
				userAndFile.setCity(rs.getString(UsersTable.CITY.getName()));
				userAndFile.setFileName(rs.getString(FilesTable.FILE_NAME.getName()));
				userAndFile.setFirstName(rs.getString(UsersTable.FIRST_NAME.getName()));
				userAndFile.setLastName(rs.getString(UsersTable.LAST_NAME.getName()));
				userAndFile.setSize(rs.getLong(FilesTable.SIZE.getName()));
				userAndFile.setFilePath(rs.getString(FilesTable.FILE_PATH.getName()));
				userAndFile.setFileContent(rs.getBytes(FilesTable.CONTENT.getName()));
				return userAndFile;
			}
		};
	}

}