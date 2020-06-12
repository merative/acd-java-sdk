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
import com.ibm.watson.health.acd.v1.model.InsightModelData;
import com.ibm.watson.health.acd.v1.model.InsightModelDataDiagnosis;
import com.ibm.watson.health.acd.v1.model.InsightModelDataMedication;
import com.ibm.watson.health.acd.v1.model.InsightModelDataProcedure;
import com.ibm.watson.health.acd.v1.model.InsightModelDataTask;
import com.ibm.watson.health.acd.v1.model.InsightModelDataUsage;

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
		if (concept.getInsightModelData() != null) {
			Assert.assertTrue(!concept.getInsightModelData().isEmpty());
			InsightModelData imd = concept.getInsightModelData();
			if (imd.getMedication() != null) {
				Assert.assertTrue(!imd.getMedication().isEmpty());
				InsightModelDataMedication imdMed = imd.getMedication();
				if (imdMed.getUsage() != null) {
					Assert.assertTrue(!imdMed.getUsage().isEmpty());
					InsightModelDataUsage imdMedUsage = imdMed.getUsage();
					Float explicitScore = imdMedUsage.getExplicitScore();
					if (explicitScore != null) {
						Assert.assertTrue(explicitScore >= 0);
					}
				}
			}
			if (imd.getProcedure() != null) {
				Assert.assertTrue(!imd.getProcedure().isEmpty());
				InsightModelDataProcedure imdProc = imd.getProcedure();
				if (imdProc.getTask() != null) {
					Assert.assertTrue(!imdProc.getTask().isEmpty());
					InsightModelDataTask imdProcTask = imdProc.getTask();
					Float clinicalAssessScore = imdProcTask.getClinicalAssessmentScore();
					if (clinicalAssessScore != null) {
						Assert.assertTrue(clinicalAssessScore >= 0);
					}
				}
			}
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
			}
		}
		if (concept.getRuleId() != null) {
			Assert.assertTrue(concept.getRuleId().length() > 0);
		}
		if (concept.getDerivedFrom() != null) {
			Assert.assertTrue(concept.getDerivedFrom().size() > 0);
		}
	}
}
