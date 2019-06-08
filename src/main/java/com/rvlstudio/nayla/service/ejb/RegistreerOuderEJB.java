package com.rvlstudio.nayla.service.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.rvlstudio.nayla.entity.Credentials;
import com.rvlstudio.nayla.entity.Ouder;
import com.rvlstudio.nayla.persistence.jpa.OuderJpaDAO;
import com.rvlstudio.nayla.service.RegistreerOuder;

/**
 * RegistreerOuderEJB
 */
@Stateless
@Default
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RegistreerOuderEJB implements RegistreerOuder {
	@Inject
	private OuderJpaDAO ouderDAO;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registreer(String voornaam, String achternaam, String password, String username, String email) {
		Ouder ouder = new Ouder(voornaam, achternaam, new Credentials(username, password, email));
		try {
			ouderDAO.add(ouder);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}