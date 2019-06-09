package com.rvlstudio.nayla.service;

import javax.ejb.Local;

/**
 * UsernameExists
 */
@Local
public interface UsernameExists {
	boolean exists(String username);
}