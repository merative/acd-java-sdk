/*
 * Copyright 2018, 2021 IBM Corp. All Rights Reserved.
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

import java.util.List;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.CancerDiagnosis;
import com.ibm.watson.health.acd.v1.model.Disambiguation;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

public class TestCancerAnnotation {

	public static void testCancerAnnotation(CancerDiagnosis annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		List<CustomCollection> customCollections = annotation.getCancer();
		if (customCollections != null && !customCollections.isEmpty()) {
			for (CustomCollection collection : customCollections) {
				TestCustomCollection.testCustomCollection(collection);
			}
		}
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertNull(annotation.getCui());
		Disambiguation disambigData = annotation.getDisambiguationData();
		if (disambigData != null) {
			Assert.assertNotNull(disambigData.getValidity());
		}
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		if (annotation.getId() != null) {
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		if (annotation.getModality() != null) {
			Assert.assertTrue(annotation.getModality().length() > 0);
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
		if (annotation.getUid() != null) {
			Assert.assertTrue(annotation.getUid() > 0);
		}
		Assert.assertNotNull(annotation.isHypothetical());
		Assert.assertNotNull(annotation.isNegated());
	}
}
