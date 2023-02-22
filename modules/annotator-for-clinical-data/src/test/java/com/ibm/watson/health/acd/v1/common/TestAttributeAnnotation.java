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

import com.ibm.watson.health.acd.v1.model.AttributeValueAnnotation;
import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.Disambiguation;
import com.ibm.watson.health.acd.v1.model.Reference;
import com.ibm.watson.health.acd.v1.model.Temporal;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

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
			Assert.assertTrue(annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_PATIENT));
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
		if (annotation.getInsightModelData() != null) {
			TestInsightModelData.testInsightModelData(annotation.getInsightModelData());
		}
		if (annotation.getCcsCode() != null) {
			Assert.assertTrue(annotation.getCcsCode().length() > 0);
		}
		if (annotation.getHccCode() != null) {
			Assert.assertTrue(annotation.getHccCode().length() > 0);
		}
		if (annotation.getRuleId() != null) {
			Assert.assertTrue(annotation.getRuleId().length() > 0);
		}
		if (annotation.getDerivedFrom() != null) {
			Assert.assertTrue(annotation.getDerivedFrom().size() > 0);
			List<Concept> derivedFroms = annotation.getDerivedFrom();
			if (derivedFroms != null) {
				for (Concept derivedFrom : derivedFroms) {
					Assert.assertTrue(derivedFrom.getUid() > -1);
					if (derivedFrom.getValueIndex() != null) {
						Assert.assertTrue(derivedFrom.getValueIndex() >= 0);
					}
				}
			}
		}
		List<CustomCollection> customCollections = annotation.getValues();
		if (customCollections != null && !customCollections.isEmpty()) {
			Assert.assertTrue(annotation.getValues().size() > 0);
			Assert.assertTrue(annotation.getValues(0) != null);
			for (CustomCollection collection : customCollections) {
				TestCustomCollection.testCustomCollectionByName(collection, "value");
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
		List<Reference> evidenceSpans = annotation.getEvidenceSpans();
		if (evidenceSpans != null) {
			Assert.assertTrue(evidenceSpans.size() > 0);
			for (Reference evidenceSpan : evidenceSpans) {
				Long evSpanUid = evidenceSpan.getUid();
				if (evSpanUid != null) {
					Assert.assertTrue(evSpanUid > 0);
				}
			}
		}
	}
}
