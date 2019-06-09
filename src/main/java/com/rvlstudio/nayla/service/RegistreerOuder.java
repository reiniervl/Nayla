package com.rvlstudio.nayla.service;

import javax.ejb.Local;

import com.rvlstudio.nayla.service.transferrable.RegistreerResultTO;
import com.rvlstudio.nayla.service.transferrable.RegistreerTO;

/**
 * RegistreerOuder
 */
@Local
public interface RegistreerOuder {
	RegistreerResultTO registreer(RegistreerTO registreerTO);
}