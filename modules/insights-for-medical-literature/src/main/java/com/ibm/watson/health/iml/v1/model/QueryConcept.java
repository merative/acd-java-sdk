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

public class QueryConcept {
	private String boolOperand;
	private String ontology;
	private String cui;
	private String rank;
	private String text;
	private String semanticType;
	private List<String> includeRelated;
	private List<String> sections;
	private boolean negated = false;

	/**
	 * Object representing a search criteria.
	 */
	public QueryConcept() {

	}

	/**
	 * Get the search phrase.
	 * @return
	 */
	public String getBool() {
		return boolOperand;
	}

	/**
	 * Get the search criterion ontology.
	 * @return
	 */
	public String getOntology() {
		return ontology;
	}

	/**
	 * Get the search criterion identifier.
	 * @return
	 */
	public String getId() {
		return cui;
	}

	/**
	 * Get the search criterion rank.
	 * @return
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Get the search criterion target section.
	 * @return
	 */
	public List<String> getSections() {
		return sections;
	}

	/**
	 * Get the search text keyword or null.
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * Get the search criterion semantic type.
	 * @return
	 */
	public String getType() {
		return semanticType;
	}

	/**
	 * Get the related criteria.
	 * @return
	 */
	public List<String> getIncludeRelated() {
		return includeRelated;
	}

	/**
	 * Whether search criterion is negated.
	 * @return
	 */
	public boolean getNegated() {
		return negated;
	}

	/**
	 * Set the search phrase.
	 * @param value
	 */
	public void setBool(String value) {
		boolOperand = value;
	}

	/**
	 * Set the search criterion ontology.
	 * @param source
	 */
	public void setOntology(String source) {
		ontology = source;
	}

	/**
	 * Set the search criterion identifier.
	 * @param artifactId
	 */
	public void setId(String artifactId) {
		cui = artifactId;
	}

	/**
	 * Set the search criterion rank.
	 * @param artifiactRank
	 */
	public void setRank(String artifiactRank) {
		rank = artifiactRank;
	}

	/**
	 * Set the search criterion target sections(s).
	 * @param textFields
	 */
	public void setSections(List<String> textFields) {
		sections = textFields;
	}

	/**
	 * Set the search criterion text keyword.
	 * @param token
	 */
	public void setText(String token) {
		text = token;
	}

	/**
	 * Set the search criterion semantic type.
	 * @param artifactType
	 */
	public void setType(String artifactType) {
		semanticType = artifactType;
	}

	/**
	 * Set the related search criterion.
	 * @param artifactRelations
	 */
	public void setIncludeRelated(List<String> artifactRelations) {
		includeRelated = artifactRelations;
	}

	/**
	 * Set whether the search criterion is negated.
	 * @param negateArtifact
	 */
	public void setNegated(boolean negateArtifact) {
		negated = negateArtifact;
	}
}

