package com.rvlstudio.nayla.service.health;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rvlstudio.nayla.service.UsernameExists;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

/**
 * ServerHealth
 */
@Health
@ApplicationScoped
public class ServerHealth implements HealthCheck {
	private Response checkUsernameAvailable() {
		return ClientBuilder.newClient()
			.target("http://localhost:9080/nayla/app/available/test")
			.request(MediaType.APPLICATION_JSON_TYPE)
			.get();
	}
	@Override
	public HealthCheckResponse call() {
		String msg = "unavailable";
		boolean isUp = false;
		Response response = checkUsernameAvailable();
		if(response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE) &&
				checkUsernameAvailable().readEntity(JsonObject.class).getString("success").equals("true")) {
			msg = "available";
			isUp = true;
		}
		return HealthCheckResponse.named(UsernameExists.class.getSimpleName()).withData("service", msg).state(isUp).build();
	}
}