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
	 * @return operand
	 */
	public String getBool() {
		return boolOperand;
	}

	/**
	 * Get the search criterion ontology.
	 * @return ontology
	 */
	public String getOntology() {
		return ontology;
	}

	/**
	 * Get the search criterion identifier.
	 * @return identifier
	 */
	public String getId() {
		return cui;
	}

	/**
	 * Get the search criterion rank.
	 * @return rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Get the search criterion target section.
	 * @return section names
	 */
	public List<String> getSections() {
		return sections;
	}

	/**
	 * Get the search text keyword or null.
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Get the search criterion semantic type.
	 * @return semantic type
	 */
	public String getType() {
		return semanticType;
	}

	/**
	 * Get the related criteria.
	 * @return related criteria
	 */
	public List<String> getIncludeRelated() {
		return includeRelated;
	}

	/**
	 * Whether search criterion is negated.
	 * @return negated flag
	 */
	public boolean getNegated() {
		return negated;
	}

	/**
	 * Set the search phrase.
	 * @param value search value
	 */
	public void setBool(String value) {
		boolOperand = value;
	}

	/**
	 * Set the search criterion ontology.
	 * @param source ontology
	 */
	public void setOntology(String source) {
		ontology = source;
	}

	/**
	 * Set the search criterion identifier.
	 * @param artifactId identifier
	 */
	public void setId(String artifactId) {
		cui = artifactId;
	}

	/**
	 * Set the search criterion rank.
	 * @param artifiactRank ranking
	 */
	public void setRank(String artifiactRank) {
		rank = artifiactRank;
	}

	/**
	 * Set the search criterion target sections(s).
	 * @param textFields section names
	 */
	public void setSections(List<String> textFields) {
		sections = textFields;
	}

	/**
	 * Set the search criterion text keyword.
	 * @param token text token
	 */
	public void setText(String token) {
		text = token;
	}

	/**
	 * Set the search criterion semantic type.
	 * @param artifactType semantic type
	 */
	public void setType(String artifactType) {
		semanticType = artifactType;
	}

	/**
	 * Set the related search criterion.
	 * @param artifactRelations relation criteria
	 */
	public void setIncludeRelated(List<String> artifactRelations) {
		includeRelated = artifactRelations;
	}

	/**
	 * Set whether the search criterion is negated.
	 * @param negateArtifact negated flag
	 */
	public void setNegated(boolean negateArtifact) {
		negated = negateArtifact;
	}
}

