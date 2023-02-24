/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.common;

import org.junit.Assert;

import com.merative.acd.v1.model.NegatedSpan;
import com.merative.acd.v1.util.CustomCollection;

public class TestNegatedSpan {

	public static void testNegatedSpan(NegatedSpan annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		CustomCollection trigger = annotation.getTrigger();
		TestCustomCollection.testCustomCollectionByName(trigger, "coveredText");
		Assert.assertNotNull(annotation.getType());
	}
}
