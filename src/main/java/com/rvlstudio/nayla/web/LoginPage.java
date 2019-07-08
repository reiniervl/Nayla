package com.rvlstudio.nayla.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

/**
 * LoginPage
 */
public class LoginPage extends WebPage {
	public LoginPage() {
		add(new Link<Void>("home") {
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
	}	
}