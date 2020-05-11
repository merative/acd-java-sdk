/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.health.acd.v1.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ServiceApiBean {

	private String id;
	private URL url;
	private List<URL> urls = new ArrayList<URL>();
	private Boolean publish = false;
	Integer receiveTimeout;
	Integer connectTimeout;

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
}
