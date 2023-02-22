/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.common;

import java.util.List;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.Disambiguation;
import com.ibm.watson.health.acd.v1.model.InsightModelData;
import com.ibm.watson.health.acd.v1.model.InsightModelDataEvidence;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormality;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormalityUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelDataProcedure;
import com.ibm.watson.health.acd.v1.model.InsightModelDataProcedureModifier;
import com.ibm.watson.health.acd.v1.model.InsightModelDataSite;
import com.ibm.watson.health.acd.v1.model.InsightModelDataTask;
import com.ibm.watson.health.acd.v1.model.Procedure;
import com.ibm.watson.health.acd.v1.model.Temporal;

public class TestProcedureAnnotation {

	public static void testProcedureAnnotation(Procedure annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertNotNull(annotation.getCui());
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
			Assert.assertTrue(annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_PATIENT));
		}
		if (annotation.getSectionSurfaceForm() != null) {
			Assert.assertTrue(annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_PATIENT));
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
			TestInsightModelData.testInsightModelData(annotation.getInsightModelData());
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
