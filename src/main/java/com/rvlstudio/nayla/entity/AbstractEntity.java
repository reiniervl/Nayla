package com.rvlstudio.nayla.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractEntity
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	public AbstractEntity() {}

	public AbstractEntity(AbstractEntity abstractEntity) {
		if(abstractEntity == null) {
			throw new IllegalArgumentException("Entity mag niet null zijn");
		}
		this.id = abstractEntity.id;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof AbstractEntity
			&& this.id.equals(((AbstractEntity)o).getId());
	}
}