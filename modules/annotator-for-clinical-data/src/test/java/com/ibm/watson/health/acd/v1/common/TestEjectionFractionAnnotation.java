/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
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
			Assert.assertEquals(annotation.getSectionNormalizedName(), Constants.SECTION_NAME);
			Assert.assertEquals(annotation.getSectionSurfaceForm(), Constants.SECTION_NAME);
		}
		if (annotation.getUid() != null) {
			Assert.assertTrue(annotation.getUid() > 0);
		}
	}
}
