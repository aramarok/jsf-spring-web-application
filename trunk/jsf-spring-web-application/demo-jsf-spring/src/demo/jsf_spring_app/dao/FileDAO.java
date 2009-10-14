package demo.jsf_spring_app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import demo.jsf_spring_app.model.File;
import demo.jsf_spring_app.model.UserAndFile;

public class FileDAO {

	private JdbcTemplate jdbcTemplate;

	public File addFile(File file) {
		int rows = jdbcTemplate
				.update(
						"INSERT INTO files(file_name, file_path, size, user_name, content) VALUES(?, ?, ?, ?, ?)",
						new Object[] { file.getFileName(), file.getFilePath(),
								file.getSize(), file.getUserName(),
								file.getContent() });

		if (rows != 1) {
			return null;
		}
		return file;

	}

	public File updateFile(File file) {
		return new File();
	}

	public boolean deleteFile(File file) {
		return true;
	}

	public File getFile(long fileId) {
		return new File();
	}

	public List<File> findFiles(File fileFilter) {
		return new ArrayList<File>();
	}

	public List<UserAndFile> findFiles(UserAndFile userAndFileFilter) {
		StringBuffer query = new StringBuffer(
				"SELECT last_name, first_name, city, age, sex, file_name, file_path, size, content FROM users, files where users.user_name=files.user_name ");

		if (userAndFileFilter != null) {

			String and = " AND ";
			String where = " WHERE ";

			boolean whereAdded = true;
			boolean andNeeded = true;

			if (userAndFileFilter.getLastName() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" last_name LIKE \"%"
						+ userAndFileFilter.getLastName() + "%\"");
				andNeeded = true;
			}

			if (userAndFileFilter.getFirstName() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" first_name LIKE \"%"
						+ userAndFileFilter.getFirstName() + "%\"");
				andNeeded = true;
			}

			if (userAndFileFilter.getCity() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" city LIKE \"%" + userAndFileFilter.getCity()
						+ "%\"");
				andNeeded = true;
			}

			if (userAndFileFilter.getSex() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" sex = " + userAndFileFilter.getSex());
				andNeeded = true;
			}

			if (userAndFileFilter.getAge() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" age = " + userAndFileFilter.getAge());
				andNeeded = true;
			}

			if (userAndFileFilter.getFileName() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" file_name LIKE \"%"
						+ userAndFileFilter.getFileName() + "%\"");
				andNeeded = true;
			}

			if (userAndFileFilter.getMinFileDimension() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" size >= "
						+ userAndFileFilter.getMinFileDimension());
				andNeeded = true;
			}

			if (userAndFileFilter.getMaxFileDimension() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" size <= "
						+ userAndFileFilter.getMaxFileDimension());
				andNeeded = true;
			}
		}

		@SuppressWarnings("unchecked")
		List<UserAndFile> results = (List<UserAndFile>) jdbcTemplate.query(
				query.toString(), DAOUtil.getUserAndFileRowMapper());
		
		return results;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}