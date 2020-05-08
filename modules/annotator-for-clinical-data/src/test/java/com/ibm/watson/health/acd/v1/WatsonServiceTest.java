package com.ibm.watson.health.acd.v1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.health.acd.v1.common.Constants;

/**
 * Utility class to test the ACD Java SDK.
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
		headers.put(HttpHeaders.X_WATSON_LEARNING_OPT_OUT, String.valueOf(true));
		headers.put(HttpHeaders.X_WATSON_TEST, String.valueOf(true));
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

	private static AnnotatorForClinicalData service;
	/**
	 * Sets up the service connections.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void setUp() throws Exception {
//		HttpConfigOptions options = new HttpConfigOptions.Builder()
//				.disableSslVerification(Boolean.valueOf(getProperty(Constants.DISABLE_SSL))).build();

//		Builder builder = new AnnotatorForClinicalData.Builder()
//				.url(getProperty(Constants.URL)).versionDate(getProperty(Constants.VERSION));
//		if (getProperty(Constants.APIKEY) != null && getProperty(Constants.APIKEY).trim().length() > 0) {
//			builder.apikey(getProperty(Constants.APIKEY)).httpConfigOptions(options);
//		}
//		if (getProperty(Constants.IAM_URL) != null && getProperty(Constants.IAM_URL).trim().length() > 0)	{
//			builder.iamUrl(getProperty(Constants.IAM_URL)).httpConfigOptions(options);
//		}
//		service = builder.build();
		if ((getProperty(Constants.APIKEY) == null) || getProperty(Constants.APIKEY).trim().length() == 0) {
			service = new AnnotatorForClinicalData(getProperty(Constants.VERSION),
				"InsightsForMedicalLiterature", new NoAuthAuthenticator());
			service.setServiceUrl(getProperty(Constants.URL));
			HttpConfigOptions options = new HttpConfigOptions.Builder().disableSslVerification(true).build();
			service.configureClient(options);
		} else {
			service = new AnnotatorForClinicalData(getProperty(Constants.VERSION),
			"InsightsForMedicalLiterature", new IamAuthenticator(getProperty(Constants.APIKEY),
			getProperty(Constants.IAM_URL), null, null, Boolean.parseBoolean(Constants.DISABLE_SSL), null));
			service.setServiceUrl(getProperty(Constants.URL));
		}
	}

	/**
	 * Retrieves service instance.
	 * @return the service
	 */
	public AnnotatorForClinicalData getServiceInstance() {
		return service;
	}

}
