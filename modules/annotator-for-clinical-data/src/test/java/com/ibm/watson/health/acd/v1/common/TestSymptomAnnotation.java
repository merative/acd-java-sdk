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

import java.util.List;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.Disambiguation;
import com.ibm.watson.health.acd.v1.model.InsightModelData;
import com.ibm.watson.health.acd.v1.model.InsightModelDataDiagnosis;
import com.ibm.watson.health.acd.v1.model.InsightModelDataDiagnosisModifier;
import com.ibm.watson.health.acd.v1.model.InsightModelDataEvidence;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormality;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormalityUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelDataSite;
import com.ibm.watson.health.acd.v1.model.InsightModelDataUsage;
import com.ibm.watson.health.acd.v1.model.SymptomDisease;
import com.ibm.watson.health.acd.v1.model.Temporal;

public class TestSymptomAnnotation {

	public static void testSymptomAnnotation(SymptomDisease annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		if (annotation.getCcsCode() != null){
			Assert.assertTrue(annotation.getCcsCode().length() > 0);
		}
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertNotNull(annotation.getCui());
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
		if (annotation.getInsightModelData() != null) {
			Assert.assertTrue(!annotation.getInsightModelData().isEmpty());
			InsightModelData imd = annotation.getInsightModelData();
			if (imd.getDiagnosis() != null) {
				Assert.assertTrue(!imd.getDiagnosis().isEmpty());
				InsightModelDataDiagnosis imdDiag = imd.getDiagnosis();
				if (imdDiag.getUsage() != null) {
					Assert.assertTrue(!imdDiag.getUsage().isEmpty());
					InsightModelDataUsage imdDiagUsage = imdDiag.getUsage();
					Float explicitScore = imdDiagUsage.getExplicitScore();
					if (explicitScore != null) {
						Assert.assertTrue(explicitScore >= 0);
					}
				}
				if (imdDiag.getModifiers() != null) {
					Assert.assertTrue(!imdDiag.getModifiers().isEmpty());
					InsightModelDataDiagnosisModifier imdDiagModif = imdDiag.getModifiers();
					if (imdDiagModif.getSites() != null) {
						for (InsightModelDataSite imdSite : imdDiagModif.getSites()) {
							Assert.assertNotNull(imdSite.getCoveredText());
							Assert.assertTrue(imdSite.getEnd() > imdSite.getBegin());
						}
					}
					if (imdDiagModif.getAssociatedProcedures() != null) {
						for (InsightModelDataEvidence imdAssociatedProc : imdDiagModif.getAssociatedProcedures()) {
							Assert.assertNotNull(imdAssociatedProc.getCoveredText());
							Assert.assertTrue(imdAssociatedProc.getEnd() > imdAssociatedProc.getBegin());
						}
					}
				}
			}
			if (imd.getNormality() != null) {
				Assert.assertTrue(!imd.getNormality().isEmpty());
				InsightModelDataNormality imdNorm = imd.getNormality();
				if (imdNorm.getUsage() != null) {
					Assert.assertTrue(!imdNorm.getUsage().isEmpty());
					InsightModelDataNormalityUsage imdNormUsage = imdNorm.getUsage();
					Float normalScore = imdNormUsage.getNormalScore();
					if (normalScore != null) {
						Assert.assertTrue(normalScore >= 0);
					}
				}
			}
		}
		List<Temporal> temporals = annotation.getTemporal();
		if (temporals != null) {
			Assert.assertTrue(temporals.size() > 0);
			for (Temporal temporal : temporals) {
				Assert.assertTrue(temporal.getBegin() > -1);
				Assert.assertTrue(temporal.getEnd() > temporal.getBegin());
				Assert.assertNotNull(temporal.getCoveredText());
			}
		}
	}
}
