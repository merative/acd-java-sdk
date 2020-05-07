/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.iml.v1;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService.Builder;
import com.ibm.watson.health.iml.v1.common.Constants;

/**
 * Utility class to test the WHCS Java SDK.
 *
 * This was ported from the WDC Java SDK WatsonServiceTest class in GitHub.
 */
public abstract class WatsonServiceTest {

	private static final String DEFAULT_PROPERTIES = "config.properties";
	private static final String LOCAL_PROPERTIES = ".config.properties";

	/** The Constant PLACEHOLDER. */
	protected static final String PLACEHOLDER = "SERVICE_USERNAME";

	private static final Logger LOG = Logger.getLogger(WatsonServiceTest.class.getName());

	/** The Constant CONTENT_TYPE. */
	protected static final String CONTENT_TYPE = "Content-Type";

	/**
	 * Instantiates a new watson service test.
	 */
	public WatsonServiceTest() {
		if (properties == null) {
			loadProperties();
		}
		setupLogging();
	}

	/**
	 * Gets the default test headers.
	 *
	 * @return the default headers
	 */
	protected Map<String, String> getDefaultHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put(HttpHeaders.CONTENT_TYPE, "application/json");
		headers.put(HttpHeaders.ACCEPT, "application/json");
		return headers;
	}

	/**
	 * Gets the string from input stream.
	 *
	 * @param is
	 *            the input stream
	 * @return the string from input stream
	 */
	public static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		final StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

	/** The prop. */
	private static Properties properties = null;

	/**
	 * Gets the valid property.
	 *
	 * @param property
	 *            the property
	 * @return the valid property
	 */
	public String getProperty(String property) {
		return properties.getProperty(property);
	}

	private void loadProperties() {
		properties = new Properties();

		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(LOCAL_PROPERTIES);
		if (input == null) {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_PROPERTIES);
		} else {
			LOG.info("Using " + LOCAL_PROPERTIES);
		}
		if (input == null) {
			LOG.warning(DEFAULT_PROPERTIES + " was not found.");
			return;
		}
		// load a properties file from class path, inside static method
		try {
			properties.load(input);
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Error loading the config.properties");
		}

	}

	/**
	 * Setup logging.
	 */
	private void setupLogging() {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream configFile = classLoader.getResourceAsStream("logging.properties");
			LogManager.getLogManager().readConfiguration(configFile);
		} catch (IOException ex) {
			System.out.println("WARNING: Could not open configuration file");
			System.out.println("WARNING: Logging not configured (console output only)");
		}
	}

	/**
	 * Write input stream to file.
	 *
	 * @param inputStream
	 *            the input stream
	 * @param file
	 *            the file
	 */
	public static void writeInputStreamToFile(InputStream inputStream, File file) {
		OutputStream outStream = null;
		try {
			outStream = new FileOutputStream(file);

			byte[] buffer = new byte[8 * 1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
		} catch (Exception e) {
			fail();
		} finally {
			try {
				inputStream.close();
				outStream.close();
			} catch (Exception e) {
				fail();
			}
		}
	}

	/**
	 * Loads fixture.
	 *
	 * @param <T>
	 *            the return type
	 * @param filename
	 *            the file name
	 * @param returnType
	 *            the return type
	 * @return the t
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static <T> T loadFixture(String filename, Class<T> returnType) throws FileNotFoundException {
		String jsonString = getStringFromInputStream(new FileInputStream(filename));
		return GsonSingleton.getGsonWithoutPrettyPrinting().fromJson(jsonString, returnType);
	}

	private static InsightsForMedicalLiteratureService imlService;
	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void setUp() throws Exception {
		HttpConfigOptions options = new HttpConfigOptions.Builder()
				.disableSslVerification(Boolean.valueOf(getProperty(Constants.DISABLE_SSL))).build();
		Builder builder = new InsightsForMedicalLiteratureService.Builder().versionDate(getProperty(Constants.VERSION))
			.url(getProperty(Constants.URL));
		if (getProperty(Constants.APIKEY) != null && getProperty(Constants.APIKEY).trim().length() > 0) {
			builder.apikey(getProperty(Constants.APIKEY)).httpConfigOptions(options);
		}
		if (getProperty(Constants.IAM_URL) != null && getProperty(Constants.IAM_URL).trim().length() > 0)	{
			builder.iamUrl(getProperty(Constants.IAM_URL)).httpConfigOptions(options);
		}
		imlService = builder.build();

	}

	/**
	 * Returns the service instance.
	 * @return service instance
	 */
	public InsightsForMedicalLiteratureService getServiceInstance() {
		return imlService;
	}

}
