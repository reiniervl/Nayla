package com.rvlstudio.nayla.service.transferrable;

/**
 * UsernameExistsTO
 */
public class UsernameExistsTO {
	private final String username;

	public UsernameExistsTO(final String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}