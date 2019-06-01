package com.rvlstudio.nayla.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.rvlstudio.nayla.entity.data.DataView;

/**
 * Kind
 */
@Entity
public class Kind extends Persoon {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private LocalDate geboorteDatum;
	
	@NotNull
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Ouder> ouders = new ArrayList<Ouder>();

	@NotNull
	@OneToOne
	private DataView data;

	public Kind() {}

	@SuppressWarnings("unchecked")
	public Kind(Kind kind) {
		if(kind == null) {
			 throw new IllegalArgumentException("kind mag niet null zijn");
		}
		this.geboorteDatum = kind.geboorteDatum;
		this.ouders = (List<Ouder>) ((ArrayList<Ouder>)kind.ouders).clone();
	}

	public Kind(LocalDate geboorteDatum, List<Ouder> ouders, DataView data) {
		if(geboorteDatum == null) {
			 throw new IllegalArgumentException("geboorteDatum mag niet null zijn");
		}
		if(ouders == null) {
			 throw new IllegalArgumentException("ouders mag niet null zijn");
		}
		if(data == null) {
			 throw new IllegalArgumentException("data mag niet null zijn");
		}
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(LocalDate geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public DataView getData() {
		return data;
	}

	public void setData(DataView data) {
		this.data = data;
	}
	
	public boolean addOuder(Ouder ouder) {
		return this.ouders.add(ouder);
	}

	public boolean removeOuder(Ouder ouder) {
		return this.ouders.remove(ouder);
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o)
			&& o instanceof Kind
			&& this.geboorteDatum.equals(((Kind)o).getGeboorteDatum())
			&& this.ouders.equals(((Kind)o).ouders)
			&& this.data.equals(((Kind)o).getData());
	}

	@Override
	public String toString() {
		return super.toString() + "Kind [data=" + data + ", geboorteDatum=" + geboorteDatum + ", ouders=" + ouders + "]";
	}
}