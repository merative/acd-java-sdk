/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the Flow model.
 */
public class FlowTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testFlow() throws Throwable {
    FlowEntry flowEntryModel = new FlowEntry.Builder().build();

    Flow flowModel = new Flow.Builder()
      .elements(new ArrayList<FlowEntry>(Arrays.asList(flowEntryModel)))
      .async(true)
      .build();
    assertEquals(flowModel.elements(), new ArrayList<FlowEntry>(Arrays.asList(flowEntryModel)));
    assertEquals(flowModel.async(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(flowModel);

    Flow flowModelNew = TestUtilities.deserialize(json, Flow.class);
    assertTrue(flowModelNew instanceof Flow);
    assertEquals(flowModelNew.async(), Boolean.valueOf(true));
  }
}
