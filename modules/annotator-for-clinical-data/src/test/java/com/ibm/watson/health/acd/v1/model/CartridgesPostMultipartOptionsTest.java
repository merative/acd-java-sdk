/*
 * (C) Copyright IBM Corp. 2020.
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

package com.ibm.watson.health.acd.v1.model;

import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

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
    assertEquals(IOUtils.toString(cartridgesPostMultipartOptionsModel.archiveFile()), IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(cartridgesPostMultipartOptionsModel.archiveFileContentType(), "testString");
  }
}