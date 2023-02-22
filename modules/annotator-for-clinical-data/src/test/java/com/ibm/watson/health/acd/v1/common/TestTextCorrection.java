/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.common;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.SpellCorrectedText;

public class TestTextCorrection {

	public static void testTextCorrection(SpellCorrectedText annotation) {
		Assert.assertNotNull(annotation.getCorrectedText());
		if (annotation.getDebugText() != null){
			Assert.assertTrue(annotation.getDebugText().length() > 0);
		}
	}
}
