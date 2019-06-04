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
		this.graden = temperatuur.graden;
	}

	public Temperatuur(Kind kind, LocalDateTime tijd, double graden) {
		super(kind, tijd);
		this.graden = graden;
	}

	public double getGraden() {
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