/*
 * Copyright 2018, 2022 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
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
		Map<String, Double> temporalTypeMap = (Map<String, Double>)annotation.getTemporalTypeMap();
		for (Map.Entry<String, Double> entry : temporalTypeMap.entrySet()) {
			Assert.assertTrue(entry.getKey() != null);
			Assert.assertTrue(entry.getValue() >= 0);
		}
		//Map<?, ?> temporalTypeMap = annotation.getTemporalTypeMap();
		//if (!temporalTypeMap.isEmpty()) {
		//	temporalTypeMap.forEach((k,v) -> Assert.assertTrue(k != null && v != null));
		//	temporalTypeMap.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
		//}
	}
}
