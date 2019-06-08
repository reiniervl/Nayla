package com.rvlstudio.nayla.persistence.jpa;

import com.rvlstudio.nayla.entity.AbstractEntity;
import com.rvlstudio.nayla.persistence.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

public abstract class AbstractJpaDAO<T extends AbstractEntity> implements DAO<T> {
	private Class<T> entityClass;

	@PersistenceContext
	protected EntityManager em;


	@SuppressWarnings({"unchecked", "unused"})
	private AbstractJpaDAO() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
						.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public AbstractJpaDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public Optional<T> findById(Integer id) {
		return Optional.ofNullable(em.find(entityClass, id));
	}

	@Override
	public void add(T entity) {
		em.persist(entity);
	}

	@Override
	public Optional<T> update(T entity) {
		return Optional.ofNullable(em.merge(entity));
	}

	@Override
	public void delete(T entity) {
		if(entity.getId() != null) em.remove(entity);
	}
}
