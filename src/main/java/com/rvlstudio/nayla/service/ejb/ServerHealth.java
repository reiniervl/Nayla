package com.rvlstudio.nayla.service.ejb;

import javax.enterprise.context.ApplicationScoped;

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
	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse.named(UsernameExists.class.getSimpleName()).withData("service", "available").up().build();
	}
}