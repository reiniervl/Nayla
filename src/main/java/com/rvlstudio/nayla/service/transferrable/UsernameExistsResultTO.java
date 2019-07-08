package com.rvlstudio.nayla.service.transferrable;

/**
 * UsernameExistsResultTO
 */
public class UsernameExistsResultTO extends ResultTO<Boolean> {
	public UsernameExistsResultTO(boolean exists) {
		super(exists);
	}

	public UsernameExistsResultTO() {
		super(Result.UsernameAvailableOpvragenMislukt);
	}
}