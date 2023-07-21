package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ReadConfig {

	 Properties prop;

	public void readConfigFille() {

		File src = new File("./Configuration/config.properties");
		try {

			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * private Properties prop;
	 * 
	 * public ReadConfig() { 
	 * readConfig(); 
	 * }
	 * 
	 * public void readConfig() { File src = new
	 * File("./Configuration/config.properties"); try { FileInputStream fis = new
	 * FileInputStream(src); prop = new Properties(); prop.load(fis); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 */
	public  String getBaseUrl() {

		String url = prop.getProperty("baseurl");
		if (url != null)
		{
			return url;
		}
		else
			throw new RuntimeException("url not specified in config file");
	}

	public  String getUsername() {

		String username = prop.getProperty("username");
		if (username != null)
		{
			return username;
		}
		else
			throw new RuntimeException("url not specified in config file");
	}

	public String getPassword() {

		String password = prop.getProperty("password");
		if (password != null)
		{
			return password;
		}
		else
			throw new RuntimeException("url not specified in config file");
	}

}
