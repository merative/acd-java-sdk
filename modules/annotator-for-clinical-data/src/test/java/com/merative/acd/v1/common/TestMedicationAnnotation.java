/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.common;

import java.util.List;
import org.junit.Assert;
import com.merative.acd.v1.model.InsightModelData;
import com.merative.acd.v1.model.InsightModelDataEvent;
import com.merative.acd.v1.model.InsightModelDataMedication;
import com.merative.acd.v1.model.InsightModelDataNormality;
import com.merative.acd.v1.model.InsightModelDataNormalityUsage;
import com.merative.acd.v1.model.InsightModelDataUsage;
import com.merative.acd.v1.model.MedicationAnnotation;
import com.merative.acd.v1.model.Temporal;
import com.merative.acd.v1.util.CustomCollection;

public class TestMedicationAnnotation {

	public static void testMedicationAnnotation(MedicationAnnotation annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		List<CustomCollection> customCollections = annotation.getDrug();
		if (customCollections != null && !customCollections.isEmpty()) {
			for (CustomCollection collection : customCollections) {
				TestCustomCollection.testCustomCollectionByName(collection, "type");
			}
		}
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		Assert.assertNull(annotation.getId());
		if (annotation.getSectionNormalizedName() != null) {
			Assert.assertTrue(annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_PATIENT));
		}
		if (annotation.getSectionSurfaceForm() != null) {
			Assert.assertTrue(annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_PATIENT));
		}
		Assert.assertNotNull(annotation.getType());
		if (annotation.getUid() != null) {
			Assert.assertTrue(annotation.getUid() > 0);
		}
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
