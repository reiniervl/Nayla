package com.rvlstudio.nayla.entity.data;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.rvlstudio.nayla.entity.Kind;

/**
 * Melk
 */
@Entity
public class Melk extends DataItem implements Comparable<Melk> {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Basic
	private int mililiter;

	public Melk() {	}

	public Melk(Melk melk) {
		super(melk);
		if(melk == null) {
			throw new IllegalArgumentException("melk mag niet null zijn");
		}
		this.mililiter = melk.mililiter;
	}

	public Melk(Kind kind, LocalDateTime tijd, Integer mililiter) {
		super(kind, tijd);
		if(mililiter == null) {
			throw new IllegalArgumentException("mililiter mag niet null zijn");
		}
		this.mililiter = mililiter;
	}

	public Integer getMililiter() {
		return mililiter;
	}

	public void setMililiter(Integer mililiter) {
		this.mililiter = mililiter;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o)
			&& o instanceof Melk
			&& this.mililiter == ((Melk)o).getMililiter();
	}

	@Override
	public int compareTo(Melk melk) {
		return melk == null ? 1 : this.mililiter - melk.mililiter;
	}
}