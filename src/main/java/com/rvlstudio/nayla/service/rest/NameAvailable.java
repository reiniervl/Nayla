package com.rvlstudio.nayla.service.rest;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rvlstudio.nayla.service.UsernameExists;

/**
 * NameInUse
 */
@Path("available")
public class NameAvailable {
	@Inject
	private UsernameExists usernameExists;

	@GET
	@Path("{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response inUse(@PathParam("username") String username) {
		JsonObject jo = Json.createObjectBuilder()
			.add("success", "true")
			.add("available", !usernameExists.exists(username))
			.build();
		return Response.ok(jo).build();
	}
}