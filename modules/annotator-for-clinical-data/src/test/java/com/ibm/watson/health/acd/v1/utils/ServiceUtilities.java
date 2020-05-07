package com.ibm.watson.health.acd.v1.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.common.Constants;

public class ServiceUtilities {

	/** The prop. */
	private static Properties properties = null;
	private static final String DEFAULT_PROPERTIES = "config.properties";
	private static final String LOCAL_PROPERTIES = ".config.properties";

	/**
	 * Gets the valid property.
	 *
	 * @param property
	 *            the property
	 * @return the valid property
	 */
	public static String getProperty(String property) {
		return properties.getProperty(property);
	}

	private static void loadProperties() {
		properties = new Properties();

		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(LOCAL_PROPERTIES);
		if (input == null) {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_PROPERTIES);
		} else {
			System.out.println("Using " + LOCAL_PROPERTIES);
		}
		if (input == null) {
			System.out.println(DEFAULT_PROPERTIES + " was not found.");
			return;
		}
		// load a properties file from class path, inside static method
		try {
			properties.load(input);
		} catch (IOException e) {
			System.out.println("Error loading the config.properties");
		}

	}

	private static AnnotatorForClinicalData acdService;
	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void setUp() throws Exception {
		acdService = new AnnotatorForClinicalData(getProperty(Constants.VERSION),
				"InsightsForMedicalLiterature", new NoAuthAuthenticator());
		acdService.setServiceUrl(getProperty(Constants.URL));
		HttpConfigOptions options = new HttpConfigOptions.Builder().disableSslVerification(true).build();
		acdService.configureClient(options);

	}

	/**
	 * Returns the service instance.
	 * @return service instance
	 * @throws Exception
	 */
	public static AnnotatorForClinicalData getServiceInstance() throws Exception {
		loadProperties();
		setUp();
		return acdService;
	}
}
