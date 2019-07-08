package com.rvlstudio.nayla.web;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * HomePage
 */
public class HomePage extends WebPage {
	private Component headerPanel;
	public HomePage() {
		this.add(headerPanel = new HeaderPanel("headerPanel"));
		this.add(new Label("hello", "World"));
	}
}