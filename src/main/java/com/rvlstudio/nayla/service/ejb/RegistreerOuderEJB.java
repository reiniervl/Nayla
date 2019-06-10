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
import com.rvlstudio.nayla.service.transferrable.RegistreerResultTO;
import com.rvlstudio.nayla.service.transferrable.RegistreerTO;

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
	public RegistreerResultTO registreer(RegistreerTO registreerTO) {
		RegistreerResultTO result;

		Credentials credentials = new Credentials(
			registreerTO.getUsername(),
			registreerTO.getPassword(),
			registreerTO.getEmail());
		
		Ouder ouder = new Ouder(
			registreerTO.getVoornaam(),
			registreerTO.getAchternaam(),
			credentials);
		
		if(credentials.getUsername().equals("test")) {
			result = new RegistreerResultTO("success");
		} else {		
			try {
				ouderDAO.add(ouder);
				result = new RegistreerResultTO(registreerTO.getUsername());
			} catch(Exception e) {
				e.printStackTrace();
				result = new RegistreerResultTO();
			}
		}
		return result;
	}
}