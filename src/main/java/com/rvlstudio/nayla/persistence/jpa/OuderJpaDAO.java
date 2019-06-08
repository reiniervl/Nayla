package com.rvlstudio.nayla.persistence.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

import com.rvlstudio.nayla.entity.Ouder;
import com.rvlstudio.nayla.persistence.OuderDAO;

/**
 * OuderJpaDAO
 */
@Default
@ApplicationScoped
public class OuderJpaDAO extends AbstractJpaDAO<Ouder> implements OuderDAO {
	public OuderJpaDAO() {
		super(Ouder.class);
	}
}