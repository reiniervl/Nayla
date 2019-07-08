package com.rvlstudio.nayla.web;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * WicketApplication
 */
public class WicketApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	public void init() {
		super.init();
		mountPage("/page", HomePage.class);
		mountPage("/page/account/inloggen", LoginPage.class);
	}
}