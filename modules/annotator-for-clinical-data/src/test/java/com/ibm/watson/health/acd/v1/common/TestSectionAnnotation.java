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
