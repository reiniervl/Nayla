package com.rvlstudio.nayla.service;

import javax.ejb.Local;

/**
 * RegistreerOuder
 */
@Local
public interface RegistreerOuder {
	void registreer(String voornaam, String achternaam, String password, String username, String email);
}