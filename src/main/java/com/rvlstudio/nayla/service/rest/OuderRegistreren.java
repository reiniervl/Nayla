package com.rvlstudio.nayla.service.rest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.rvlstudio.nayla.service.RegistreerOuder;

/**
 * RegistreerOuder
 */
@Path("registreer")
public class OuderRegistreren {
	@Inject
	private RegistreerOuder registreerOuder;

	@POST
	public void registreer(
		@FormParam("voornaam") String voornaam,
		@FormParam("achternaam") String achternaam,
		@FormParam("password") String password,
		@FormParam("username") String username,
		@FormParam("email") String email,
		@Context HttpServletRequest request,
		@Context HttpServletResponse response) {
			registreerOuder.registreer(voornaam, achternaam, password, username, email);
		}
}