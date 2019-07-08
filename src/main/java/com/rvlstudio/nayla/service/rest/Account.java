package com.rvlstudio.nayla.service.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.io.IOException;

@Path("account")
public class Account {
	@POST
	@Path("inloggen")
	public void inloggen(
					@FormParam("username") String username,
					@FormParam("password") String password,
					@Context HttpServletRequest request,
					@Context HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("username", username);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	@GET
	@Path("uitloggen")
	public void uitloggen(
					@Context HttpServletRequest request,
					@Context HttpServletResponse response) throws IOException {
		String path = request.getContextPath();
		request.getSession().invalidate();
		response.sendRedirect(path);
	}
}
