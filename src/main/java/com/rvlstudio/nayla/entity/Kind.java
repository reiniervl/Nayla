package com.rvlstudio.nayla.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

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

	public Kind() {}

	@SuppressWarnings("unchecked")
	public Kind(Kind kind) {
		super(kind);
		if(kind == null) {
			 throw new IllegalArgumentException("kind mag niet null zijn");
		}
		this.geboorteDatum = kind.geboorteDatum;
		this.ouders = (List<Ouder>) ((ArrayList<Ouder>)kind.ouders).clone();
	}

	public Kind(String voorNaam, String achterNaam, LocalDate geboorteDatum, Ouder ouder) {
		super(voorNaam, achterNaam);
		if(geboorteDatum == null) {
			 throw new IllegalArgumentException("geboorteDatum mag niet null zijn");
		}
		if(ouder == null) {
			 throw new IllegalArgumentException("ouder mag niet null zijn");
		}
		this.geboorteDatum = geboorteDatum;
		this.ouders.add(ouder);
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(LocalDate geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
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
			&& this.ouders.equals(((Kind)o).ouders);
	}

	@Override
	public String toString() {
		return super.toString() + "Kind [geboorteDatum=" + geboorteDatum + ", ouders=" + ouders + "]";
	}
}