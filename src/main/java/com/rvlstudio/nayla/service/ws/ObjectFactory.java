package com.rvlstudio.nayla.service.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * ObjectFactory
 */
@XmlRegistry
public class ObjectFactory {
	private static final QName username_q = new QName("http://rvlstudio.com/nayla/user", "username");
	private static final QName available_q = new QName("http://rvlstudio.com/nayla/user", "available");

	@XmlElementDecl(namespace = "http://rvlstudio.com/nayla/user", name = "username")
	public JAXBElement<String> createUsername(String username) {
		System.out.println("!! username called");
		return new JAXBElement<String>(username_q, String.class, null, username);
	}

	@XmlElementDecl(namespace = "http://rvlstudio.com/nayla/user", name = "available")
	public JAXBElement<Boolean> createAvailable(boolean available) {
		return new JAXBElement<Boolean>(available_q, Boolean.class, null, available);
	}
}