/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2019, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.util.RequestUtils;

/**
 * The purpose of this class is to provide SDK-specific HTTP headers to be included in REST API requests made
 * by the SDK.
 */
public class SdkCommon {

    /**
     * SDK-specific "user agent" header value.
     */
    private static String userAgent;
    private static String projectName;
    private static String version;

    static {
        readBuildProperties();
    }

    private SdkCommon() {
    }

    public static String getVersion() {
        return version;
    }

    public static String getProjectName() {
        return projectName;
    }

    protected static void readBuildProperties() {
        final Properties buildProps = new Properties();
        try (InputStream is = SdkCommon.class.getResourceAsStream("/acd-sdk.properties")) {
            buildProps.load(is);
            version = buildProps.getProperty("version", "unknown");
            projectName = buildProps.getProperty("title", "unknown");
        } catch (final Throwable t) {
            version = "unknown";
            projectName = "unknown";
        }
    }

    /**
     * This function uses lazy initialization to build the SDK's "user agent" value.
     * This will consist of the SDK name and version, followed by a set of
     * properties provided by the Java Core's RequestUtils class.
     *
     * @return the SDK-specific user agent value
     */
    private static synchronized String getUserAgent() {
        if (userAgent == null) {
            String systemInfo = RequestUtils.getSystemInfo();
            systemInfo = systemInfo.replace("(", "(lang=java; ");
            userAgent = String.format("%s/%s %s", projectName, version, systemInfo);
        }
        return userAgent;
    }

    /**
     * This function is invoked by generated service methods (i.e. methods which
     * implement the REST API operations defined within the API definition). The
     * purpose of this function is to give the SDK implementor the opportunity to
     * provide SDK-specific HTTP headers that will be sent with an outgoing REST API
     * request.
     * <p>
     *
     * @param serviceName    the name of the service as defined in the API
     *                       definition (e.g. "MyService1")
     * @param serviceVersion the version of the service as defined in the API
     *                       definition (e.g. "V1")
     * @param operationId    the operationId as defined in the API definition (e.g.
     *                       getContext)
     * @return a Map which contains the set of headers to be included in the REST
     *         API request
     */
    public static Map<String, String> getSdkHeaders(final String serviceName, final String serviceVersion,
            final String operationId) {
        final Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.USER_AGENT, getUserAgent());
        return headers;
    }
}
