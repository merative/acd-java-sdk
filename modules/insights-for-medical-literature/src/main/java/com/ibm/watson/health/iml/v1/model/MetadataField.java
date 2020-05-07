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

/**
 * Class representing a metadata field definition.
 *
 */
public class MetadataField extends GenericModel {
	private String fieldName;
	private String fieldType;

	/**
	 * Constructor.
	 */
	public MetadataField() {

	}

	/**
	 * Constructor.
	 * @param field - name of field
	 * @param type - data model type (text, boolean, date, keyword, object)
	 */
	public MetadataField(String field, String type) {
		fieldName = field;
		fieldType = type;
	}

	/**
	 * Retrieves name of the field.
	 * @return field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Sets nmae of the field.
	 * @param name - field name
	 */
	public void setFieldName(String name) {
		fieldName = name;
	}

	/**
	 * Retrieves field data type.
	 * @return field type
	 */
	public String getFieldType() {
		return fieldType;
	}

	/**
	 * Sets field data type (text, boolean, date, keyword, object).
	 * @param type data type
	 */
	public void setFieldType(String type) {
		fieldType = type;
	}
}
