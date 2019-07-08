package com.rvlstudio.nayla.web;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * HeaderPanel
 */
public class HeaderPanel extends Panel {

	public HeaderPanel(String id) {
		super(id);
		this.add(new Link<Void>("inloggen") {
			@Override
			public void onClick() {
				LoginPage loginPage = new LoginPage();
				setResponsePage(loginPage);
			}
		});
	}
}