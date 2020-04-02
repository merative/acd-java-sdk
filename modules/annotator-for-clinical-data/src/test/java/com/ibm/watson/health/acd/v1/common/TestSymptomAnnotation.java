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

import com.ibm.watson.health.acd.v1.model.Disambiguation;
import com.ibm.watson.health.acd.v1.model.SymptomDisease;

public class TestSymptomAnnotation {

	public static void testSymptomAnnotation(SymptomDisease annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		if (annotation.getCcsCode() != null){
			Assert.assertTrue(annotation.getCcsCode().length() > 0);
		}
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertNotNull(annotation.getCui());
		Assert.assertNotNull(annotation.getDateInMilliseconds());
		Disambiguation disambigData = annotation.getDisambiguationData();
		if (disambigData != null) {
			Assert.assertNotNull(disambigData.getValidity());
		}
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		if (annotation.getHccCode() != null) {
			Assert.assertTrue(annotation.getHccCode().length() > 0);
		}
		if (annotation.getIcd10Code() != null){
			Assert.assertTrue(annotation.getIcd10Code().length() >  0);
		}
		if (annotation.getIcd9Code() != null) {
			Assert.assertTrue(annotation.getIcd9Code().length() > 0);
		}
		if (annotation.getId() != null) {
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		if (annotation.getModality() != null){
			Assert.assertTrue(annotation.getModality().length() > 0);
		}
		if (annotation.getSectionNormalizedName() != null) {
			Assert.assertEquals(annotation.getSectionNormalizedName(), Constants.SECTION_NAME);
			Assert.assertEquals(annotation.getSectionSurfaceForm(), Constants.SECTION_NAME);
		}
		if (annotation.getSnomedConceptId() != null){
			Assert.assertTrue(annotation.getSnomedConceptId().length() > 0);
		}
		if (annotation.getSymptomDiseaseNormalizedName() != null){
			Assert.assertTrue(annotation.getSymptomDiseaseNormalizedName().length() > 0);
		}
		if (annotation.getSymptomDiseaseSurfaceForm() != null){
			Assert.assertTrue(annotation.getSymptomDiseaseSurfaceForm().length() > 0);
		}
		Assert.assertNotNull(annotation.getType());
		if (annotation.getUid() != null) {
			Assert.assertTrue(annotation.getUid() > 0);
		}
		Assert.assertNotNull(annotation.isHypothetical());
		Assert.assertNotNull(annotation.isNegated());
	}
}
