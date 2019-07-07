package com.rvlstudio.nayla.service.ws;

import javax.inject.Inject;
import javax.jws.WebService;

import com.rvlstudio.nayla.service.UsernameExists;

/**
 * UsernameAvailablePort
 */
@WebService(
	serviceName = "UsernameAvailableService",
	portName = "UsernameAvailableServicePort",
	wsdlLocation = "file:apps/expanded/Nayla-0.0.1.war/WEB-INF/wsdl/usernameavailable.wsdl",
	targetNamespace = "http://rvlstudio.com/nayla/service/ws",
	endpointInterface = "com.rvlstudio.nayla.service.ws.UsernameAvailablePortType")
public class UsernameAvailablePort implements UsernameAvailablePortType {

	@Inject
	private UsernameExists usernameExists;

	@Override
	public Boolean check(String username) {
		return !usernameExists.exists(username);
	}
}