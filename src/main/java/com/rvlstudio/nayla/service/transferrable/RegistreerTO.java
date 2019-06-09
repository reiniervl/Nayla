package com.rvlstudio.nayla.service.transferrable;

import java.io.Serializable;

/**
 * RegistreerTO
 */
public class RegistreerTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String voornaam;
	private final String achternaam;
	private final String password;
	private final String username;
	private final String email;

	public RegistreerTO(
		final String voornaam,
		final String achternaam,
		final String password,
		final String username,
		final String email) {
			this.voornaam = voornaam;
			this.achternaam = achternaam;
			this.password = password;
			this.username = username;
			this.email = email;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
}