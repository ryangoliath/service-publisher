package net.iqbusiness.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AppProperties {
	
	private static final String RESOURCE_APP_PROPERTIES = "/app.properties";
	
	private static final Logger logger = Logger.getLogger(AppProperties.class);
	
	private static Properties properties;
	
	static {
		loadProperties();
	} 

	public static void loadProperties() {

		properties = loadExternalProperties();

		// Check whether external properties was found. Revert to default properties if not present
		if(properties == null) {
			properties = loadDefaultProperties();
		}
		
	}
	
	public static String getProperty(String property) {
		String value;
		
		if(property.contains(":")) {
			String [] propValAndDefault = property.split(":");
			if(properties.getProperty(propValAndDefault[0]) != null) {
				value =  properties.getProperty(propValAndDefault[0]);
			} else {
				value = propValAndDefault[1];
			}
		} else {
			value = properties.getProperty(property);
		}
		
		return value;
	}

	private static Properties loadDefaultProperties() {
		
		Properties props = null;
		InputStream is;
		
		try {
			
			is = AppProperties.class.getResourceAsStream(RESOURCE_APP_PROPERTIES);
			
			props = new Properties();
			props.load(is);
			logger.info("[Default] Properties loaded");
			
		} catch (Exception e) {
			logger.error("Error reading properties file. Exiting...", e);
			System.exit(0);
		}

		return props;
	}

	private static Properties loadExternalProperties() {
		Properties props;
		File jarPath;
		String propertiesPath;
		
		try {
			
			jarPath = new File(AppProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			propertiesPath = jarPath.getParent();
			
			StringBuilder pathBuilder = new StringBuilder(propertiesPath);
			pathBuilder.append(RESOURCE_APP_PROPERTIES);
			
			props = new Properties();
			props.load(new FileInputStream(pathBuilder.toString()));
			
			logger.info("[External] Properties loaded");
			
		} catch (Exception e) {
			props = null;
			logger.warn("No external properties provided. Defaulting to app defaults.");
		}

		return props;
	}

}
