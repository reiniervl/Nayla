package com.rvlstudio.nayla.service;

import javax.ejb.Local;
import com.rvlstudio.nayla.service.transferrable.UsernameExistsResultTO;
import com.rvlstudio.nayla.service.transferrable.UsernameExistsTO;

/**
 * UsernameExists
 */
@Local
public interface UsernameExists {
	// TODO: return ResultTO
	UsernameExistsResultTO exists(UsernameExistsTO usernameExistsTO);
}