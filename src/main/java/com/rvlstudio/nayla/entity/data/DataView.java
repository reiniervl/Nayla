package com.rvlstudio.nayla.entity.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.rvlstudio.nayla.entity.AbstractEntity;
import com.rvlstudio.nayla.entity.Kind;

/**
 * DataView
 */
@Entity
public class DataView extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@OneToOne
	private Kind kind;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Melk> melk = new ArrayList<>();

	public DataView() {}

	@SuppressWarnings("unchecked")
	public DataView(DataView dataView) {
		if(dataView == null) {
			throw new IllegalArgumentException("dataView mag niet null zijn");
		}
		this.kind = dataView.kind;
		this.melk = (List<Melk>) ((ArrayList<Melk>)dataView.melk).clone();
	}

	public DataView(Kind kind) {
		if(kind == null) {
			throw new IllegalArgumentException("kind mag niet null zijn");
		}
		this.kind = kind;
	}

	public boolean hasMelk() {
		return melk != null && melk.size() > 0;
	}

	public boolean addMelk(Melk melk) {
		return this.melk.add(melk);
	}

	public boolean removeMelk(Melk melk) {
		return this.melk.remove(melk);
	}
}