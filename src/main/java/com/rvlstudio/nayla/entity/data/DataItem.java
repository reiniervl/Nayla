package com.rvlstudio.nayla.entity.data;

import java.time.LocalDateTime;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.rvlstudio.nayla.entity.AbstractEntity;
import com.rvlstudio.nayla.entity.Kind;

/**
 * DataItem
 */
@MappedSuperclass
public abstract class DataItem extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	private LocalDateTime tijd;

	@NotNull
	@ManyToOne
	private Kind kind;

	public DataItem() {}

	public DataItem(DataItem dataItem) {
		super(dataItem);
		this.kind = dataItem.kind;
		this.tijd = dataItem.tijd;
	}
	
	public DataItem(Kind kind, LocalDateTime tijd) {
		if(kind == null) {
			throw new IllegalArgumentException("kind mag niet null zijn");
		}
		if(tijd == null) {
			throw new IllegalArgumentException("tijd mag niet null zijn");
		}
		this.kind = kind;
		this.tijd = tijd;
	}

	@Override
	public String toString() {
		return "DataItem [tijd=" + tijd + ", " + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return tijd.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o)
			&& o instanceof DataItem
			&& this.kind.equals(((DataItem)o).getKind())
			&& this.tijd.equals(((DataItem)o).getTijd());
	}

	public LocalDateTime getTijd() {
		return tijd;
	}

	public void setTijd(LocalDateTime tijd) {
		this.tijd = tijd;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}
	
}