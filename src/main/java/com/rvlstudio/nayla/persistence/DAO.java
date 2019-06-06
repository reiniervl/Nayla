package com.rvlstudio.nayla.persistence;

import com.rvlstudio.nayla.entity.AbstractEntity;

import java.util.Optional;

public interface DAO<T extends AbstractEntity> {
	Optional<T> findById(Integer id);
	void add(T entity);
	Optional<T> update(T entity);
	void delete(T entity);
}
