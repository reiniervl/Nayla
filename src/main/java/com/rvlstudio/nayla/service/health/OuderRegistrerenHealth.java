package com.rvlstudio.nayla.service.health;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

/**
 * OuderRegistrerenHealth
 */
@Health
@ApplicationScoped
public class OuderRegistrerenHealth implements HealthCheck {
	private ServiceInfo getInfo() {
		String name = "ouder-registreren";
		ServiceInfo info;
		try {
			URI uri = new URI("http://localhost:9080/nayla/app/registreer");
			LocalDateTime start = LocalDateTime.now();
			Form form = new Form();
			form.param("voornaam", "test");
			form.param("achternaam", "test");
			form.param("username", "test");
			form.param("password", "test");
			form.param("email", "test@rvlstudio.com");
			
			Response response = ClientBuilder.newClient()
				.target(uri)
				.request()
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
			LocalDateTime end = LocalDateTime.now();
			info = new ServiceInfo(name, response, Duration.between(start, end));
			if(response.getStatus() == 302) {
				info.setUp(true);
				info.setMessage(response.getLocation().getPath());
			}
		} catch(URISyntaxException e) {
			info = new ServiceInfo(name);
			info.setUp(false);
			info.setMessage("URI syntax exception: " + e.getMessage());
		} catch(Exception e) {
			info = new ServiceInfo(name);
			info.setUp(false);
			info.setMessage("Exception occured: " + e.getMessage());
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public HealthCheckResponse call() {
		return getInfo().buildHealthCheckResponse();
	}

}