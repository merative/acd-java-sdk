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

package com.ibm.watson.health.iml.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.iml.v1.model.AddCorpusDocumentOptions;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AddCorpusDocumentOptions model.
 */
public class AddCorpusDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddCorpusDocumentOptions() throws Throwable {
    AddCorpusDocumentOptions addCorpusDocumentOptionsModel = new AddCorpusDocumentOptions.Builder()
      .corpus("testString")
      .document(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
      .acdUrl("testString")
      .apiKey("testString")
      .flowId("testString")
      .accessToken("testString")
      .otherAnnotators(new ArrayList<Object>(Arrays.asList("testString")))
      .build();
    assertEquals(addCorpusDocumentOptionsModel.corpus(), "testString");
    assertEquals(addCorpusDocumentOptionsModel.document(), new java.util.HashMap<String,Object>(){{put("foo", "testString"); }});
    assertEquals(addCorpusDocumentOptionsModel.acdUrl(), "testString");
    assertEquals(addCorpusDocumentOptionsModel.apiKey(), "testString");
    assertEquals(addCorpusDocumentOptionsModel.flowId(), "testString");
    assertEquals(addCorpusDocumentOptionsModel.accessToken(), "testString");
    assertEquals(addCorpusDocumentOptionsModel.otherAnnotators(), new ArrayList<Object>(Arrays.asList("testString")));
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddCorpusDocumentOptionsError() throws Throwable {
    new AddCorpusDocumentOptions.Builder().build();
  }

}