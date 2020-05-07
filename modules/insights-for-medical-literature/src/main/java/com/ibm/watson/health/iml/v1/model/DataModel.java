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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 *
 * DataModel.
 *
 */
public class DataModel extends GenericModel {

	private List<AnnotationModel> concepts;
	private List<AnnotationModel> attributeValues;
	private List<String> negatedSpans;
	private List<String> hypotheticalSpans;

	/**
	 * Gets the concept annotations.
	 *
	 * @return concept annotations
	 */
	public List<AnnotationModel> getConcepts() {
		return concepts;
	}

	/**
	 * Gets the attribute annotations.
	 *
	 * @return attribute annotations
	 */
	public List<AnnotationModel> getAttributeValues() {
		return attributeValues;
	}

	/**
	 * Gets the negated spans for negated annotations.
	 * @return negated annotation spans
	 */
	public List<String> getNegatedSpans() {
		return negatedSpans;
	}

	/**
	 * Gets the hypothetical spans for hypothetical annotations.
	 * @return hypothetical annotation spans
	 */
	public List<String> getHypotheticalSpans() {
		return hypotheticalSpans;
	}
}
