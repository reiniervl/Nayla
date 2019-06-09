package com.rvlstudio.nayla.service.transferrable;

/**
 * RegistreerResultTO
 */
public class RegistreerResultTO extends ResultTO<String> {
	public RegistreerResultTO(String username) {
		super(username);
	}

	public RegistreerResultTO() {
		super(Result.RegistratieMislukt);
	}
}