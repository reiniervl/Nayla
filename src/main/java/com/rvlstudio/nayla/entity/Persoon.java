package com.rvlstudio.nayla.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Persoon
 */
@MappedSuperclass
public abstract class Persoon extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 2, max = 36)
	private String voorNaam;

	@NotNull
	@Size(min = 2, max = 48)
	private String achterNaam;

	public Persoon() {}

	public Persoon(Persoon persoon) {
		if(persoon == null) {
			throw new IllegalArgumentException("persoon mag niet null zijn");
		}

		this.voorNaam = persoon.voorNaam;
		this.achterNaam = persoon.achterNaam;
	}

	public Persoon(String voorNaam, String achterNaam) {
		if(voorNaam == null) {
			throw new IllegalArgumentException("voorNaam mag niet null zijn");
		}
		if(achterNaam == null) {
			throw new IllegalArgumentException("achterNaam mag niet null zijn");
		}

		this.voorNaam = voorNaam;
		this.achterNaam = achterNaam;
	}

	public String getVoorNaam() {
		return voorNaam;
	}

	public void setVoorNaam(String voorNaam) {
		this.voorNaam = voorNaam;
	}

	public String getAchterNaam() {
		return achterNaam;
	}

	public void setAchterNaam(String achterNaam) {
		this.achterNaam = achterNaam;
	}

	@Override
	public int hashCode() {
		return this.voorNaam.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Persoon 
			&& this.voorNaam.equals(((Persoon)o).getVoorNaam())
			&& this.achterNaam.equals(((Persoon)o).getAchterNaam());
	}

	@Override
	public String toString() {
		return super.toString() + "Persoon [achterNaam=" + achterNaam + ", voorNaam=" + voorNaam + "]";
	}
}