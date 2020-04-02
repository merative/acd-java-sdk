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

import java.util.List;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.Reference;
import com.ibm.watson.health.acd.v1.model.Relation;
import com.ibm.watson.health.acd.v1.model.RelationNode;

public class TestRelationAnnotation {

	public static void testRelationAnnotation(Relation annotation) {
		List<RelationNode> relationNodes = annotation.getNodes();
		if (relationNodes != null && !relationNodes.isEmpty()) {
			for (RelationNode node : relationNodes) {
				Reference reference = node.getEntity();
				Assert.assertNotNull(reference.getUid());
			}
		}
		Assert.assertTrue(annotation.getScore() > 0);
		Assert.assertNotNull(annotation.getSource());
		Assert.assertNotNull(annotation.getType());
	}
}
