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

import java.util.Map;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.Temporal;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

public class TestTemporal {

	public static void testTemporal(Temporal annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		CustomCollection temporalType = annotation.getTemporalType();
		TestCustomCollection.testCustomCollectionByName(temporalType, "dateScore");
		@SuppressWarnings("unchecked")
		Map<String, ?> temporalTypeMap = (Map<String, ?>)annotation.getTemporalTypeMap();
		for (Map.Entry<String, ?> entry : temporalTypeMap.entrySet()) {
			Assert.assertTrue(entry.getKey() != null);
		}
		//Map<?, ?> temporalTypeMap = annotation.getTemporalTypeMap();
		//if (!temporalTypeMap.isEmpty()) {
		//	temporalTypeMap.forEach((k,v) -> Assert.assertTrue(k != null && v != null));
		//	temporalTypeMap.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
		//}
	}
}
