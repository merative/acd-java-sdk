/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the DeployCartridgeOptions model.
 */
public class DeployCartridgeOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeployCartridgeOptions() throws Throwable {
    DeployCartridgeOptions deployCartridgeOptionsModel = new DeployCartridgeOptions.Builder()
      .archiveFile(TestUtilities.createMockStream("This is a mock file."))
      .archiveFileContentType("testString")
      .update(true)
      .build();
    assertEquals(IOUtils.toString(deployCartridgeOptionsModel.archiveFile(), StandardCharsets.UTF_8), IOUtils.toString(TestUtilities.createMockStream("This is a mock file."), StandardCharsets.UTF_8));
    assertEquals(deployCartridgeOptionsModel.archiveFileContentType(), "testString");
    assertEquals(deployCartridgeOptionsModel.update(), Boolean.valueOf(true));
  }
}
