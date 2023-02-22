/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

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
			Assert.assertTrue(annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_PATIENT));
		}
		if (annotation.getSectionSurfaceForm() != null) {
			Assert.assertTrue(annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_PATIENT));
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
