package com.rvlstudio.nayla.service.health;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

/**
 * ServerHealth
 */
@Health
@ApplicationScoped
public class UsernameAvailableHealth implements HealthCheck {
	private ServiceInfo getInfo() {
		String name = "username-available";
		ServiceInfo info;
		try {
			URI uri = new URI("http://localhost:9080/nayla/app/available/test");
			LocalDateTime start = LocalDateTime.now();
			Response response = ClientBuilder.newClient()
				.target(uri)
				.request(MediaType.APPLICATION_JSON_TYPE)
				.get();
			LocalDateTime end = LocalDateTime.now();
			info = new ServiceInfo(name, response, Duration.between(start, end));
		} catch(URISyntaxException e) {
			info = new ServiceInfo(name);
			info.setUp(false);
			info.setMessage("URI syntax exception: " + e.getMessage());
		} catch(Exception e) {
			info = new ServiceInfo(name);
			info.setUp(false);
			info.setMessage("Exception occured: " + e.getMessage());
		}

		return info;
	}

	@Override
	public HealthCheckResponse call() {
		return getInfo().buildHealthCheckResponse();
	}
}