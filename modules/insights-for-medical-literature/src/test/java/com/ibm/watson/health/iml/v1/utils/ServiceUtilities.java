/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.iml.v1.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;

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
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException ioe){
					System.out.println("failed to close input stream.");
				}
			}
		}

	}

	private static InsightsForMedicalLiteratureService imlService;
	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void setUp() throws Exception {
		if ((getProperty(Constants.APIKEY) == null) || getProperty(Constants.APIKEY).trim().length() == 0) {
			imlService = new InsightsForMedicalLiteratureService(getProperty(Constants.VERSION),
				"InsightsForMedicalLiterature", new NoAuthAuthenticator());
			imlService.setServiceUrl(getProperty(Constants.URL));
			HttpConfigOptions options = new HttpConfigOptions.Builder().disableSslVerification(true).build();
			imlService.configureClient(options);
		} else {
			imlService = new InsightsForMedicalLiteratureService(getProperty(Constants.VERSION),
			"InsightsForMedicalLiterature", new IamAuthenticator(getProperty(Constants.APIKEY),
			getProperty(Constants.IAM_URL), null, null, Boolean.parseBoolean(Constants.DISABLE_SSL), null));
			imlService.setServiceUrl(getProperty(Constants.URL));
		}
	}

	/**
	 * Returns the service instance.
	 * @return service instance
	 * @throws Exception
	 */
	public static InsightsForMedicalLiteratureService getServiceInstance() throws Exception {
		loadProperties();
		setUp();
		return imlService;
	}
}
