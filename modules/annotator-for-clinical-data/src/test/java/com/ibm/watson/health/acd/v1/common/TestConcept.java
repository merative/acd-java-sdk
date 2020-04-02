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
package com.ibm.watson.health.acd.v1.common;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.Disambiguation;

public class TestConcept {

	public static void testConcept(Concept concept) {
		Assert.assertTrue(concept.getBegin() > -1);
		Assert.assertNotNull(concept.getCoveredText());
		String cptCode = concept.getCptCode();
		if (cptCode != null) {
			Assert.assertTrue(cptCode.length() > 0);
		}
		Assert.assertNotNull(concept.getCui());
		Disambiguation disambigData = concept.getDisambiguationData();
		if (disambigData != null) {
			Assert.assertNotNull(disambigData.getValidity());
		}
		Assert.assertTrue(concept.getEnd() > concept.getBegin());
		if (concept.getIcd10Code() != null) {
			Assert.assertTrue(concept.getIcd10Code().length() > 0);
		}
		if (concept.getIcd9Code() != null) {
			Assert.assertTrue(concept.getIcd9Code().length() > 0);
		}
		if (concept.getId() != null) {
			Assert.assertTrue(concept.getId().length() > 0);
		}
		if (concept.getLoincId() != null) {
			Assert.assertTrue(concept.getLoincId().length() > 0);
		}
		if (concept.getMeshId() != null) {
			Assert.assertTrue(concept.getMeshId().length() > 0);
		}
		if (concept.getNciCode() != null) {
			Assert.assertTrue(concept.getNciCode().length() > 0);
		}
		if (concept.getPreferredName() != null) {
			Assert.assertTrue(concept.getPreferredName().length() > 0);
		}
		if (concept.getRxNormId() != null) {
			Assert.assertTrue(concept.getRxNormId().length() > 0);
		}
		if (concept.getSectionNormalizedName() != null) {
			Assert.assertEquals(concept.getSectionNormalizedName(), Constants.SECTION_NAME);
			Assert.assertEquals(concept.getSectionSurfaceForm(), Constants.SECTION_NAME);
		}
		if (concept.getSnomedConceptId() != null) {
			Assert.assertTrue(concept.getSnomedConceptId().length() > 0);
		}
		if (concept.getSource() != null) {
			Assert.assertTrue(concept.getSource().length() > 0);
		}
		if (concept.getSourceVersion() != null) {
			Assert.assertTrue(concept.getSourceVersion().length() > 0);
		}
		if (concept.getType() != null) {
			Assert.assertTrue(concept.getType().length() > 0);
		}
		if (concept.getUid() != null) {
			Assert.assertTrue(concept.getUid() > 0);
		}
		String vocabs = concept.getVocabs();
		if (vocabs != null) {
			Assert.assertTrue(vocabs.length() > 0);
		}
		Assert.assertNotNull(concept.isHypothetical());
		Assert.assertNotNull(concept.isNegated());
		if (concept.getSemanticType() != null) {
			Assert.assertTrue(concept.getSemanticType().length() > 0);
		}
	}
}
