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

import com.ibm.watson.health.acd.v1.model.EjectionFractionAnnotation;

public class TestEjectionFractionAnnotation {

	public static void testEjectionFractionAnnotation(EjectionFractionAnnotation annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		Assert.assertNotNull(annotation.getType());

		if (annotation.getEfAlphabeticValueNormalizedName() != null) {
			Assert.assertNotNull(annotation.getEfAlphabeticValueNormalizedName().length() > 0);
		}
		if (annotation.getEfAlphabeticValueSurfaceForm() != null) {
			Assert.assertNotNull(annotation.getEfAlphabeticValueSurfaceForm().length() > 0);
		}
		if (annotation.getEfSuffixNormalizedName() != null) {
			Assert.assertNotNull(annotation.getEfSuffixNormalizedName().length() > 0);
		}
		if (annotation.getEfSuffixSurfaceForm() != null) {
			Assert.assertNotNull(annotation.getEfSuffixSurfaceForm().length() > 0);
		}
		if (annotation.getEfTermNormalizedName() != null) {
			Assert.assertNotNull(annotation.getEfTermNormalizedName().length() > 0);
		}
		if (annotation.getEfTermSurfaceForm() != null) {
			Assert.assertNotNull(annotation.getEfTermSurfaceForm().length() > 0);
		}
		if (annotation.getFirstValue() != null) {
			Assert.assertNotNull(annotation.getFirstValue().length() > 0);
		}
		if (annotation.getId() != null) {
			Assert.assertNotNull(annotation.getId().length() > 0);
		}
		if (annotation.getIsRange() != null) {
			Assert.assertNotNull(annotation.getIsRange().length() > 0);
		}
		if (annotation.getSecondValue() != null) {
			Assert.assertNotNull(annotation.getSecondValue().length() > 0);
		}
		if (annotation.getSectionNormalizedName() != null) {
			Assert.assertTrue(annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_PATIENT));
		}
		if (annotation.getSectionSurfaceForm() != null) {
			Assert.assertTrue(annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_PATIENT));

		}
		if (annotation.getUid() != null) {
			Assert.assertTrue(annotation.getUid() > 0);
		}
	}
}
