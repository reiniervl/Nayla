package com.rvlstudio.nayla.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * UsernameAvailablePortType
 */
@WebService(
	targetNamespace = "http://rvlstudio.com/nayla/service/ws",
	name = "UsernameAvailableServicePortType")
@XmlSeeAlso({com.rvlstudio.nayla.service.ws.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface UsernameAvailablePortType {
	@WebMethod(action = "http://rvlstudio.com/nayla/service/ws/check", operationName = "check")
	@WebResult(name = "available", partName = "body", targetNamespace = "http://rvlstudio.com/nayla/user")
	Boolean check(
		@WebParam(name = "username", partName = "body", targetNamespace = "http://rvlstudio.com/nayla/user")
		String username
	);
	
}