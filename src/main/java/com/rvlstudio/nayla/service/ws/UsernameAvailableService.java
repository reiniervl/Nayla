package com.rvlstudio.nayla.service.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * UsernameAvailableService
 */
@WebServiceClient(
	name = "UsernameAvailableService",
	wsdlLocation = "file:/home/reinier/Projects/java/Nayla/src/main/webapp/WEB-INF/wsdl/usernameavailble.wsdl",
	targetNamespace = "http://rvlstudio.com/nayla/service/ws")
public class UsernameAvailableService extends Service {
	private static final URL wsdlLocation;
	private static final QName serviceName = new QName("http://rvlstudio.com/nayla/service/ws", "UsernameAvailableService");
	private static final QName servicePort = new QName("http://rvlstudio.com/nayla/service/ws", "UsernameAvailableServicePort");
	static {
		URL url = null;
		try {
			url = new URL("file:/home/reinier/Projects/java/Nayla/src/main/webapp/WEB-INF/wsdl/usernameavailble.wsdl");
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}
		wsdlLocation = url;
	}

	public UsernameAvailableService() {
		super(wsdlLocation, serviceName);
	}

	public UsernameAvailableService(URL wsdlDocumentLocation) {
		super(wsdlDocumentLocation, serviceName);
	}

	public UsernameAvailableService(WebServiceFeature...features) {
		super(wsdlLocation, serviceName, features);
	}

	public UsernameAvailableService(URL wsdlDocumentLocation, WebServiceFeature...features) {
		super(wsdlDocumentLocation, serviceName, features);
	}

	public UsernameAvailableService(URL wsdlDocumentLocation, QName serviceName) {
		super(wsdlDocumentLocation, serviceName);
	}

	public UsernameAvailableService(URL wsdlDocumentLocation, QName serviceName, WebServiceFeature... features) {
		super(wsdlDocumentLocation, serviceName, features);
	}

	@WebEndpoint(name = "UsernameAvailableServicePort")
	public UsernameAvailablePortType gUsernameAvailableServicePort() {
		return super.getPort(servicePort, UsernameAvailablePortType.class);
	}

	@WebEndpoint(name = "UsernameAvailableServicePort")
	public UsernameAvailablePortType gUsernameAvailableServicePort(WebServiceFeature ...features) {
		return super.getPort(servicePort, UsernameAvailablePortType.class, features);
	}
}