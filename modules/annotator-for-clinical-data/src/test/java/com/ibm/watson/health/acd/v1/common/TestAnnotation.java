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

import com.ibm.watson.health.acd.v1.model.Annotation;

public class TestAnnotation {

	public static void testAnnotation(Annotation annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		if (annotation.getCoveredText() != null && !annotation.getCoveredText().isEmpty()) {
			Assert.assertTrue(annotation.getCoveredText().length() > 0);
		}
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		if (annotation.getId() != null){
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		if (annotation.getType() != null && !annotation.getType().isEmpty()) {
			Assert.assertTrue(annotation.getType().length() > 0);
		}
		if (annotation.getUid() != null){
			Assert.assertTrue(annotation.getUid() > 0);
		}
	}
}
