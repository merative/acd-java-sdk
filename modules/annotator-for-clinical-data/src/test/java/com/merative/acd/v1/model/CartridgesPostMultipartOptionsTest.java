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
 * Unit test class for the CartridgesPostMultipartOptions model.
 */
public class CartridgesPostMultipartOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCartridgesPostMultipartOptions() throws Throwable {
    CartridgesPostMultipartOptions cartridgesPostMultipartOptionsModel = new CartridgesPostMultipartOptions.Builder()
      .archiveFile(TestUtilities.createMockStream("This is a mock file."))
      .archiveFileContentType("testString")
      .build();
    assertEquals(IOUtils.toString(cartridgesPostMultipartOptionsModel.archiveFile(), StandardCharsets.UTF_8), IOUtils.toString(TestUtilities.createMockStream("This is a mock file."), StandardCharsets.UTF_8));
    assertEquals(cartridgesPostMultipartOptionsModel.archiveFileContentType(), "testString");
  }
}
