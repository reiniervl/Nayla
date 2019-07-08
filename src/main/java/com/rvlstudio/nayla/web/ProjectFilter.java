package com.rvlstudio.nayla.web;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import org.apache.wicket.protocol.http.WicketFilter;

/**
 * ProjectFilter
 */
@WebFilter(urlPatterns = "/page/*", initParams = {
	@WebInitParam(name = "applicationClassName", value = "com.rvlstudio.nayla.web.WicketApplication"),
	@WebInitParam(name = "filterMappingUrlPattern", value = "/*")
})
public class ProjectFilter extends WicketFilter {	
}