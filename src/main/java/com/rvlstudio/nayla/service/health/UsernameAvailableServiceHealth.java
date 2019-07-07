package com.rvlstudio.nayla.service.health;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

/**
 * UsernameAvailableServiceHealth
 */
@Health
@ApplicationScoped
public class UsernameAvailableServiceHealth implements HealthCheck {
	private ServiceInfo getInfo() {
		ServiceInfo info = null;
		final String name = "username-available-service";
		try {
			URI uri = new URI("http://localhost:9080/nayla/UsernameAvailableService?wsdl");
      LocalDateTime start = LocalDateTime.now();
			Response response = ClientBuilder.newClient()
				.target(uri)
				.request(MediaType.TEXT_XML)
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
