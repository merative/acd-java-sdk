/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.common;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.Smoking;

public class TestSmokingAnnotation {

	public static void testSmokingAnnotation(Smoking annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertNotNull(annotation.getCurrent());
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		if (annotation.getId() != null) {
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		if (annotation.getModality() != null) {
			Assert.assertTrue(annotation.getModality().length() > 0);
		}
		if (annotation.getParticipation() != null) {
			Assert.assertTrue(annotation.getParticipation().length() > 0);
		}
		if (annotation.getSectionNormalizedName() != null) {
			Assert.assertTrue(annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_PATIENT));
		}
		if (annotation.getSectionSurfaceForm() != null) {
			Assert.assertTrue(annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_PATIENT));
		}
		if (annotation.getSmokeTermNormalizedName() != null) {
			Assert.assertTrue(annotation.getSmokeTermNormalizedName().length() > 0);
		}
		if (annotation.getSmokeTermSurfaceForm() != null) {
			Assert.assertTrue(annotation.getSmokeTermSurfaceForm().length() > 0);
		}
		Assert.assertNotNull(annotation.getType());
		if (annotation.getUid() != null) {
			Assert.assertTrue(annotation.getUid() > 0);
		}
		Assert.assertNotNull(annotation.isHypothetical());
		Assert.assertNotNull(annotation.isNegated());
		if (annotation.getIllicitDrugNormalizedName() != null) {
			Assert.assertTrue(annotation.getIllicitDrugNormalizedName().length() > 0);
		}
		if (annotation.getIllicitDrugSurfaceForm() != null) {
			Assert.assertTrue(annotation.getIllicitDrugSurfaceForm().length() > 0);
		}
		if (annotation.getDuration() != null) {
			Assert.assertTrue(annotation.getDuration().length() > 0);
		}
	}
}
