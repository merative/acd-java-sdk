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

import com.ibm.watson.health.acd.v1.model.AttributeValueAnnotation;
import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.Disambiguation;

public class TestAttributeAnnotation {

	public static void testAttributeValue(AttributeValueAnnotation annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Concept concept = annotation.getConcept();
		if (concept != null) {
			Assert.assertNotNull(concept.getUid());
		}
		Assert.assertNotNull(annotation.getCoveredText());

		Disambiguation disambigData = annotation.getDisambiguationData();
		if (disambigData != null) {
			Assert.assertNotNull(disambigData.getValidity());
		}
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		if (annotation.getCptCode() != null) {
			Assert.assertTrue(annotation.getCptCode().length() > 0);
		}
		if (annotation.getIcd10Code() != null) {
			Assert.assertTrue(annotation.getIcd10Code().length() > 0);
		}
		if (annotation.getIcd9Code() != null) {
			Assert.assertTrue(annotation.getIcd9Code().length() > 0);
		}
		if (annotation.getId() != null) {
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		if (annotation.getLoincId() != null) {
			Assert.assertTrue(annotation.getLoincId().length() > 0);
		}
		if (annotation.getMeshId() != null) {
			Assert.assertTrue(annotation.getMeshId().length() > 0);
		}
		if (annotation.getName() != null) {
			Assert.assertTrue(annotation.getName().length() > 0);
		}
		if (annotation.getNciCode() != null) {
			Assert.assertTrue(annotation.getNciCode().length() > 0);
		}
		if (annotation.getPreferredName() != null) {
			Assert.assertTrue(annotation.getPreferredName().length() > 0);
		}
		if (annotation.getRxNormId() != null) {
			Assert.assertTrue(annotation.getRxNormId().length() > 0);
		}
		if (annotation.getSectionNormalizedName() != null) {
			Assert.assertEquals(annotation.getSectionNormalizedName(), Constants.SECTION_NAME);
		}
		if (annotation.getSnomedConceptId() != null) {
			Assert.assertTrue(annotation.getSnomedConceptId().length() > 0);
		}
		if (annotation.getSource() != null) {
			Assert.assertTrue(annotation.getSource().length() > 0);
		}
		if (annotation.getSourceVersion() != null) {
			Assert.assertTrue(annotation.getSourceVersion().length() > 0);
		}
		Assert.assertNull(annotation.getType());
		Long uid = annotation.getUid();
		if (uid != null) {
			Assert.assertTrue(uid > 0);
		}
	}
}
