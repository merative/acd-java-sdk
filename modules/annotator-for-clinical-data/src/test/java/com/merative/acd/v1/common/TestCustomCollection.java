/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.common;

import org.junit.Assert;
import com.merative.acd.v1.util.CustomCollection;

public class TestCustomCollection {

	public static void testCustomCollection(CustomCollection collection) {
		Assert.assertNotNull(collection.get("cancer"));
		Assert.assertNotNull(collection.get(0));
	}
	
	public static void testCustomCollectionByName(CustomCollection collection, String key) {
		//System.out.println("CustomCollection key: " + key + " value: " + collection.get(key).getObject());
		Assert.assertNotNull(collection.get(key));
	}
}
