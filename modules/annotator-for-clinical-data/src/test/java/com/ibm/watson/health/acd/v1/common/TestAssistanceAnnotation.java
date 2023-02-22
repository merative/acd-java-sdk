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

import com.ibm.watson.health.acd.v1.model.AssistanceAnnotation;

public class TestAssistanceAnnotation {

	public static void testAssistanceAnnotation(AssistanceAnnotation annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		if (annotation.getId() != null) {
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		if (annotation.getModality() != null){
			Assert.assertTrue(annotation.getModality().length() > 0);
		}
		if (annotation.getPrimaryActionNormalizedName() != null){
			Assert.assertTrue(annotation.getPrimaryActionNormalizedName().length() > 0);
		}
		if (annotation.getPrimaryActionSurfaceForm() != null){
			Assert.assertTrue(annotation.getPrimaryActionSurfaceForm().length() > 0);
		}
		if (annotation.getSectionNormalizedName() != null) {
			Assert.assertTrue(annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionNormalizedName().equals(Constants.SECTION_NAME_PATIENT));
		}
		if (annotation.getSectionSurfaceForm() != null) {
			Assert.assertTrue(annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_HISTORY) ||
					annotation.getSectionSurfaceForm().equals(Constants.SECTION_NAME_PATIENT));
		}
		Assert.assertNotNull(annotation.getType());
		if (annotation.getUid() != null){
			Assert.assertTrue(annotation.getUid() > 0);
		}
		Assert.assertNotNull(annotation.isHypothetical());
		Assert.assertNotNull(annotation.isNegated());
	}
}
