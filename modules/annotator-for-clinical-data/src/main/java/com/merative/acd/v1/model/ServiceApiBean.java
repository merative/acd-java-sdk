/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * ServiceApiBean contains annotator details.
 */
public class ServiceApiBean {

	private String id;
	private URL url;
	private List<URL> urls = new ArrayList<URL>();
	private String description;
	private Boolean publish = false;
	Integer receiveTimeout;
	Integer connectTimeout;
	private String version;

	/**
	 * Gets the identifier.
	 *
	 * @return identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the URL.
	 *
	 * @return url
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * Gets the urls.
	 *
	 * @return the urls
	 */
	public List<URL> getUrls() {
		return urls;
	}

	/**
	 * Gets the publish status.
	 *
	 * @return publish status
	 */
	public Boolean getPublish() {
		return publish;
	}

	/**
	 * Gets the description.
	 *
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets receive timeout.
	 *
	 * @return the receive timeout
	 */
	public Integer getReceiveTimeout() {
		return receiveTimeout;
	}

	/**
	 * Gets connect timeout.
	 *
	 * @return the connect timeout
	 */
	public Integer getConnectTimeout() {
		return connectTimeout;
	}

	/**
	 * Gets the version.
	 *
	 * @return version
	 */
	public String getVersion() {
		return version;
	}
}
