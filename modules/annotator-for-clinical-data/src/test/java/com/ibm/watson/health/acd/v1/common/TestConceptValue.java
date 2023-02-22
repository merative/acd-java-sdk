/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.common;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.ConceptValue;

public class TestConceptValue {

	public static void testConceptValue(ConceptValue annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertNotNull(annotation.getCui());
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		Assert.assertNotNull(annotation.getPreferredName());
		if (annotation.getSectionNormalizedName() != null) {
			Assert.assertTrue(annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_PATIENT));
		}
		if (annotation.getSectionSurfaceForm() != null) {
			Assert.assertTrue(annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_PATIENT));
		}
		Assert.assertNotNull(annotation.getType());
		Assert.assertNotNull(annotation.getValue());
	}
}
