package com.rvlstudio.nayla.persistence.it;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

/**
 * OuderDAOTest
 */
public class OuderDAOIT {
	@Test
	public void testConstructor() {
		try {
			URL url = new URL("http://localhost:9080/nayla/app/available/test");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			assertTrue(con.getContent().toString(), con.getResponseCode() == 200);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}