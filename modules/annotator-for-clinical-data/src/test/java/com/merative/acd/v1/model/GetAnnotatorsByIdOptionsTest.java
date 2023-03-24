/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import static org.testng.Assert.assertEquals;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.merative.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the GetAnnotatorsByIdOptions model.
 */
public class GetAnnotatorsByIdOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetAnnotatorsByIdOptions() throws Throwable {
    GetAnnotatorsByIdOptions getAnnotatorsByIdOptionsModel = new GetAnnotatorsByIdOptions.Builder()
      .id("testString")
      .build();
    assertEquals(getAnnotatorsByIdOptionsModel.id(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAnnotatorsByIdOptionsError() throws Throwable {
    new GetAnnotatorsByIdOptions.Builder().build();
  }

}
