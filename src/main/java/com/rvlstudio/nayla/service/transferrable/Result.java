package com.rvlstudio.nayla.service.transferrable;

/**
 * Result
 */
public enum Result {
	Success(0, "Success"),
	RegistratieMislukt(100, "Registreren is mislukt");

	private int code;
	private String description;

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	Result(int code, String description) {
		this.code = code;
		this.description = description;
	}
}