package com.rvlstudio.nayla.persistence.jpa;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.TypedQuery;

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

	@Override
	public Optional<Ouder> findByUsername(String username) {
		TypedQuery<Ouder> query = em.createNamedQuery(Ouder.FindByName, Ouder.class);
		query.setParameter("username", username);
		return query.getResultList().stream().findFirst();
	}
}