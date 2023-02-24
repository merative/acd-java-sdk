/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import static org.testng.Assert.assertNull;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.merative.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the ListStringWrapper model.
 */
public class ListStringWrapperTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListStringWrapper() throws Throwable {
    ListStringWrapper listStringWrapperModel = new ListStringWrapper();
    assertNull(listStringWrapperModel.getData());
  }
}
