package demo.jsf_spring_app.presentation.tabs;

import java.util.List;

import demo.jsf_spring_app.model.UserAndFile;
import demo.jsf_spring_app.presentation.utils.SpringUtil;

public class CautareBean {
	private String nume;
	private String prenume;
	private String localitate;

	private String numeFisier;
	private String minDim;
	private String maxDim;

	private List<UserAndFile> searchResults;

	public String cauta() {
		System.out.println("cautare");

		UserAndFile filter = new UserAndFile();
		filter.setLastName(nume);
		filter.setFirstName(prenume);
		filter.setCity(localitate);
		filter.setFileName(numeFisier);
		try {
			filter.setMinFileDimension(Long.parseLong(minDim));
		} catch (NumberFormatException e) {

		}
		try {
			filter.setMaxFileDimension(Long.parseLong(maxDim));
		} catch (NumberFormatException e) {

		}

		searchResults = SpringUtil.getServices().searchUsersAndFiles(filter);

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

	public String getNumeFisier() {
		return numeFisier;
	}

	public void setNumeFisier(String numeFisier) {
		this.numeFisier = numeFisier;
	}

	public String getMinDim() {
		return minDim;
	}

	public void setMinDim(String minDim) {
		this.minDim = minDim;
	}

	public String getMaxDim() {
		return maxDim;
	}

	public void setMaxDim(String maxDim) {
		this.maxDim = maxDim;
	}

	public void setSearchResults(List<UserAndFile> searchResults) {
		this.searchResults = searchResults;
	}

	public List<UserAndFile> getSearchResults() {
		return searchResults;
	}
}
