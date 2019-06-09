package com.rvlstudio.nayla.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Ouder
 */
@Entity
@NamedQuery(name=Ouder.FindByName, query="SELECT o FROM Ouder o WHERE o.credentials.username=:username")
public class Ouder extends Persoon {
	private static final long serialVersionUID = 1L;
	public static final String FindByName = "Ouder_FindByName";

	@Embedded
	@NotNull
	@Column(name = "credentials")
	@AttributeOverrides({
		@AttributeOverride( name="username", column = @Column(name = "username")),
		@AttributeOverride( name="email", column = @Column(name = "email")),
		@AttributeOverride( name="password", column = @Column(name = "password"))
	})
	private Credentials credentials;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
// 	@OneToMany(cascade = CascadeType.ALL)
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
		return "Ouder [credentials=" + credentials + ", kinderen=" + kinderen + ", " + super.toString() + "]";
	}
}
