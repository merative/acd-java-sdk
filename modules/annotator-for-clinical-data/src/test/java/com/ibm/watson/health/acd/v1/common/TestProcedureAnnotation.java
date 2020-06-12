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
import com.ibm.watson.health.acd.v1.model.InsightModelData;
import com.ibm.watson.health.acd.v1.model.InsightModelDataProcedure;
import com.ibm.watson.health.acd.v1.model.InsightModelDataTask;
import com.ibm.watson.health.acd.v1.model.Procedure;

public class TestProcedureAnnotation {

	public static void testProcedureAnnotation(Procedure annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertNotNull(annotation.getCui());
		Assert.assertNotNull(annotation.getDateInMilliseconds());
		Disambiguation disambigData = annotation.getDisambiguationData();
		if (disambigData != null) {
			Assert.assertNotNull(disambigData.getValidity());
		}
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		Assert.assertNotNull(annotation.getType());
		if (annotation.getId() != null) {
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		if (annotation.getProcedureNormalizedName() != null) {
			Assert.assertTrue(annotation.getProcedureNormalizedName().length() > 0);
		}
		if (annotation.getProcedureSurfaceForm() != null) {
			Assert.assertTrue(annotation.getProcedureSurfaceForm().length() > 0);
		}
		if (annotation.getSectionNormalizedName() != null) {
			Assert.assertEquals(annotation.getSectionNormalizedName(), Constants.SECTION_NAME);
			Assert.assertEquals(annotation.getSectionSurfaceForm(), Constants.SECTION_NAME);
		}
		if (annotation.getSnomedConceptId() != null) {
			Assert.assertTrue(annotation.getSnomedConceptId().length() > 0);
		}
		if (annotation.getUid() != null) {
			Assert.assertTrue(annotation.getUid() > 0);
		}
		Assert.assertNotNull(annotation.isHypothetical());
		Assert.assertNotNull(annotation.isNegated());
		if (annotation.getInsightModelData() != null) {
			Assert.assertTrue(!annotation.getInsightModelData().isEmpty());
			InsightModelData imd = annotation.getInsightModelData();
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
		}
	}
}
