/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.common;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.LabValueAnnotation;

public class TestLabValueAnnotation {

	public static void testLabValueAnnotation(LabValueAnnotation annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		if (annotation.getId() != null){
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		Assert.assertNotNull(annotation.getLabTypeNormalizedName());

		Assert.assertNotNull(annotation.getLabTypeSurfaceForm());
		Assert.assertNotNull(annotation.getLabValue());
		Assert.assertNotNull(annotation.getLoincId());
		if (annotation.getLowValue() != null){
			Assert.assertTrue(annotation.getLowValue().length() > 0);
		}
		if (annotation.getLowValue() != null){
			Assert.assertTrue(annotation.getSectionNormalizedName().length() > 0);
		}
		if (annotation.getLowValue() != null){
			Assert.assertTrue(annotation.getSectionSurfaceForm().length() > 0);
		}
		Assert.assertNotNull(annotation.getType());
		if (annotation.getUid() != null){
			Assert.assertTrue(annotation.getUid() > 0);
		}
	}
}
