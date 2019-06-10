package com.rvlstudio.nayla.service.health;

import java.time.Duration;

import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

/**
 * ServiceInfo
 */
public class ServiceInfo {
	private final String name;
	private int responseCode = -1;
	private boolean up;
	private MediaType mediaType;
	private Duration responseTime;
	private String message;

	public ServiceInfo(String name) {
		this.name = name;
	}

	public ServiceInfo(String name, Response response, Duration responseTime) {
		this.name = name;
		this.responseCode = response.getStatus();
		this.mediaType = response.getMediaType();
		this.responseTime = responseTime;
		if(mediaType != null && mediaType.isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
			JsonObject jo = response.readEntity(JsonObject.class);
			try {
				this.up = jo.getBoolean("success");
			} catch (NullPointerException e) {
				this.up = false;
				this.message = "Key 'success' missing from JSON response";
			}
		} else {
			this.up = true;
		}
	}

	public ServiceInfo(String name, Response response) {
		this(name, response, null);
	}

	public ServiceInfo(String name, int responseCode, boolean up, MediaType mediaType, Duration responseTime) {
		this.name = name;
		this.responseCode = responseCode;
		this.up = up;
		this.mediaType = mediaType;
		this.responseTime = responseTime;
	}

	public HealthCheckResponse buildHealthCheckResponse() {
		HealthCheckResponseBuilder response = HealthCheckResponse.named(this.name)
			.state(this.up);

			if(hasResponseCode()) response.withData("response-code", Integer.toString(this.responseCode));
			if(hasMediaType()) response.withData("media-type", this.mediaType.toString());
			if(hasResponseTime()) response.withData("time", this.responseTime.toString());
			if(hasMessage()) response.withData("message", this.message);

			return response.build();
	}

	public boolean hasResponseCode() {
		return this.responseCode != -1;
	}

	public boolean isUp() {
		return this.up;
	}

	public boolean hasMediaType() {
		return this.mediaType != null;
	}

	public boolean hasResponseTime() {
		return this.responseTime != null;
	}

	public boolean hasMessage() {
		return this.message != null;
	}

	public String getName() {
		return name;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public Duration getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Duration responseTime) {
		this.responseTime = responseTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}