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
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.merative.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the CartridgesPutMultipartOptions model.
 */
public class CartridgesPutMultipartOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCartridgesPutMultipartOptions() throws Throwable {
    CartridgesPutMultipartOptions cartridgesPutMultipartOptionsModel = new CartridgesPutMultipartOptions.Builder()
      .archiveFile(TestUtilities.createMockStream("This is a mock file."))
      .archiveFileContentType("testString")
      .build();
    assertEquals(IOUtils.toString(cartridgesPutMultipartOptionsModel.archiveFile(), StandardCharsets.UTF_8), IOUtils.toString(TestUtilities.createMockStream("This is a mock file."), StandardCharsets.UTF_8));
    assertEquals(cartridgesPutMultipartOptionsModel.archiveFileContentType(), "testString");
  }
}
