package com.rvlstudio.nayla.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Credentials
 */
@Embeddable
public class Credentials implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(unique = true, name = "username")
	@Size(min = 2, max = 24)
	private String username;

	@NotNull
	@Size(min = 4)
	private String password;

	@NotNull
	private String email;

	public Credentials() {}

	public Credentials(Credentials credentials) {
		if(credentials == null) {
			throw new IllegalArgumentException("credentials mag niet null zijn");
		}
		this.username = credentials.getUsername();
		this.password = credentials.getPassword();
		this.email = credentials.getEmail();
	}

	public Credentials(String username, String password, String email) {
		if(username == null) {
			throw new IllegalArgumentException("username mag niet null zijn");
		}
		if(password == null) {
			throw new IllegalArgumentException("password mag niet null zijn");
		}
		if(email == null) {
			throw new IllegalArgumentException("email mag niet null zijn");
		}
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Credentials
			&& this.username.equals(((Credentials)o).getUsername())
			&& this.password.equals(((Credentials)o).getPassword())
			&& this.email.equals(((Credentials)o).getEmail());
	}
	
	@Override
	public int hashCode() {
		return username.hashCode();
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Credentials kan niet gecloned worden");
		}
	}

	@Override
	public String toString() {
		return "Credentials [email=" + email + ", password=" + password + ", username=" + username + "]";
	}
}