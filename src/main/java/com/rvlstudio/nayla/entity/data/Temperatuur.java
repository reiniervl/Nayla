package com.rvlstudio.nayla.entity.data;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.rvlstudio.nayla.entity.Kind;

/**
 * Temperatuur
 */
@Entity
public class Temperatuur extends DataItem implements Comparable<Temperatuur> {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Basic
	private double graden;

	public Temperatuur() { }
	
	public Temperatuur(Temperatuur temperatuur) {
		super(temperatuur);
		if(temperatuur == null) {
			throw new IllegalArgumentException("melk mag niet null zijn");
		}
		this.graden = temperatuur.graden;
	}

	public Temperatuur(Kind kind, LocalDateTime tijd, Double graden) {
		super(kind, tijd);
		if(graden == null) {
			throw new IllegalArgumentException("graden mag niet null zijn");
		}
		this.graden = graden;
	}

	public Double getGraden() {
		return graden;
	}

	public void setGraden(Double graden) {
		this.graden = graden;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o)
			&& o instanceof Temperatuur
			&& this.graden == ((Temperatuur)o).getGraden();
	}

	@Override
	public int compareTo(Temperatuur temperatuur) {
		return (int) (temperatuur == null ? 1 : this.graden - temperatuur.getGraden());
	}
}