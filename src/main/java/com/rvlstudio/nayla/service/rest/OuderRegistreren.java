package com.rvlstudio.nayla.service.rest;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.rvlstudio.nayla.service.RegistreerOuder;
import com.rvlstudio.nayla.service.transferrable.RegistreerResultTO;
import com.rvlstudio.nayla.service.transferrable.RegistreerTO;

/**
 * RegistreerOuder
 */
@Path("registreer")
public class OuderRegistreren {
	@Inject
	private RegistreerOuder registreerOuder;

	@POST
	public void registreer (
		@FormParam("voornaam") String voornaam,
		@FormParam("achternaam") String achternaam,
		@FormParam("password") String password,
		@FormParam("username") String username,
		@FormParam("email") String email,
		@Context HttpServletRequest request,
		@Context HttpServletResponse response) {
			RegistreerTO registreerTO = new RegistreerTO(
				voornaam,
				achternaam,
				password,
				username,
				email);
			
			RegistreerResultTO result = registreerOuder.registreer(registreerTO);

			String contextPath;
			if(result.isSuccessFul()) {
				contextPath = request.getContextPath() + "/inloggen.jsp";
			} else {
				contextPath = request.getContextPath() + "/index.html";
			}
			try {
				response.sendRedirect(contextPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}