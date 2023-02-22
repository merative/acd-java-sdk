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
