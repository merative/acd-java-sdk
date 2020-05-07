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
import com.ibm.watson.health.iml.v1.model.SentenceModel;
import com.ibm.watson.health.iml.v1.model.StringBuilder;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SentenceModel model.
 */
public class SentenceModelTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSentenceModel() throws Throwable {
    StringBuilder stringBuilderModel = new StringBuilder();

    SentenceModel sentenceModelModel = new SentenceModel.Builder()
      .documentSection("testString")
      .text(stringBuilderModel)
      .begin(Long.valueOf("26"))
      .end(Long.valueOf("26"))
      .timestamp(Long.valueOf("26"))
      .build();
    assertEquals(sentenceModelModel.documentSection(), "testString");
    assertEquals(sentenceModelModel.text(), stringBuilderModel);
    assertEquals(sentenceModelModel.begin(), Long.valueOf("26"));
    assertEquals(sentenceModelModel.end(), Long.valueOf("26"));
    assertEquals(sentenceModelModel.timestamp(), Long.valueOf("26"));

    String json = TestUtilities.serialize(sentenceModelModel);

    SentenceModel sentenceModelModelNew = TestUtilities.deserialize(json, SentenceModel.class);
    assertTrue(sentenceModelModelNew instanceof SentenceModel);
    assertEquals(sentenceModelModelNew.documentSection(), "testString");
    assertEquals(sentenceModelModelNew.text().toString(), stringBuilderModel.toString());
    assertEquals(sentenceModelModelNew.begin(), Long.valueOf("26"));
    assertEquals(sentenceModelModelNew.end(), Long.valueOf("26"));
    assertEquals(sentenceModelModelNew.timestamp(), Long.valueOf("26"));
  }
}