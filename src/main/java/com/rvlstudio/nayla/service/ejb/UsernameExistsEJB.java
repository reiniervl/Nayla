package com.rvlstudio.nayla.service.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.rvlstudio.nayla.persistence.jpa.OuderJpaDAO;
import com.rvlstudio.nayla.service.UsernameExists;

/**
 * UsernameExistsEJB
 */
@Stateless
public class UsernameExistsEJB implements UsernameExists {
	@Inject
	private OuderJpaDAO ouderDAO;

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public boolean exists(String username) {
		return ouderDAO.findByUsername(username).isPresent();
	}
}