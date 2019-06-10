package com.rvlstudio.nayla.service;

import javax.ejb.Local;

/**
 * UsernameExists
 */
@Local
public interface UsernameExists {
	// TODO: return ResultTO
	boolean exists(String username);
}