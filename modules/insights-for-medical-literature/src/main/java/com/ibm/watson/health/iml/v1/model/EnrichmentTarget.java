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
package com.ibm.watson.health.iml.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

public class EnrichmentTarget extends GenericModel {

	private String contentField;
	private String enrichmentField;

	/**
	 * COnstructor.
	 */
	public EnrichmentTarget() {

	}

	/**
	 * Constructor.
	 * @param sourceField - field name for source content.
	 * @param targetField - field name for enrichment output
	 */
	public EnrichmentTarget(String sourceField, String targetField) {
		contentField = sourceField;
		enrichmentField = targetField;
	}

	/**
	 * Retrieves name of source content field.
	 * @return content field name
	 */
	public String getContentField() {
		return contentField;
	}

	/**
	 * Sets name of source content field.
	 * @param source content field name
	 */
	public void setContentField(String source) {
		contentField = source;
	}

	/**
	 * Retrieves field name of enrichment target.
	 * @return field name
	 */
	public String getEnrichmentField() {
		return enrichmentField;
	}

	/**
	 * Sets field name of enrichment target.
	 * @param target field name
	 */
	public void setEnrichmentField(String target) {
		enrichmentField = target;
	}
}
