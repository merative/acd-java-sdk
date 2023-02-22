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

import com.ibm.watson.health.acd.v1.model.SectionAnnotation;
import com.ibm.watson.health.acd.v1.model.SectionTrigger;

public class TestSectionAnnotation {

	public static void testSectionAnnotation(SectionAnnotation annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNull(annotation.getCoveredText());
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		Assert.assertNull(annotation.getSectionType());
		SectionTrigger trigger = annotation.getTrigger();
		Assert.assertNotNull(trigger);
		Assert.assertNotNull(trigger.getBegin());
		Assert.assertNotNull(trigger.getCoveredText());
		Assert.assertNotNull(trigger.getEnd());
		if (trigger.getSectionNormalizedName() != null) {
			Assert.assertTrue(trigger.getSectionNormalizedName().equals(Constants.SECTION_NAME_HISTORY) ||
					trigger.getSectionNormalizedName().equals(Constants.SECTION_NAME_PATIENT));
		}
		Assert.assertNotNull(trigger.getSource());
		Assert.assertNotNull(trigger.getType());
		Assert.assertNotNull(annotation.getType());
	}
}
