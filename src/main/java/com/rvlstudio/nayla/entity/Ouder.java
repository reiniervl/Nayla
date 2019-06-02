package com.rvlstudio.nayla.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 * Ouder
 */
@Entity
public class Ouder extends Persoon {
	private static final long serialVersionUID = 1L;

	@Embedded
	@NotNull
	private Credentials credentials;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Kind> kinderen = new ArrayList<>();

	public Ouder() {}

	@SuppressWarnings("unchecked")
	public Ouder(Ouder ouder) {
		super(ouder);
		
		this.credentials = (Credentials) ouder.credentials.clone();
		this.kinderen = (List<Kind>) ((ArrayList<Kind>)ouder.kinderen).clone();
	}

	public Ouder(String voorNaam, String achterNaam, Credentials credentials) {
		super(voorNaam, achterNaam);
		if(credentials == null) {
			throw new IllegalArgumentException("credentials mag niet null zijn");
		}

		this.credentials = credentials;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public List<Kind> getKinderen() {
		return kinderen;
	}

	public void setKinderen(List<Kind> kinderen) {
		this.kinderen = kinderen;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Ouder
			&& this.credentials.equals(((Ouder)o).getCredentials())
			&& this.getVoorNaam().equals(((Ouder)o).getVoorNaam())
			&& this.getAchterNaam().equals(((Ouder)o).getAchterNaam())
			&& this.kinderen.equals(((Ouder)o).getKinderen());
	}

	@Override
	public int hashCode() {
		return this.credentials.hashCode();
	}

	@Override
	public String toString() {
		return super.toString() + "Ouder [credentials=" + credentials + ", kinderen=" + kinderen + "]";
	}
}