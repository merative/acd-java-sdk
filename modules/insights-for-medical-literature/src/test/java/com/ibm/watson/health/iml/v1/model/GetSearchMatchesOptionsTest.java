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
import com.ibm.watson.health.iml.v1.model.GetSearchMatchesOptions;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetSearchMatchesOptions model.
 */
public class GetSearchMatchesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetSearchMatchesOptions() throws Throwable {
    GetSearchMatchesOptions getSearchMatchesOptionsModel = new GetSearchMatchesOptions.Builder()
      .corpus("testString")
      .documentId("testString")
      .minScore(Float.valueOf("36.0"))
      .cuis(new ArrayList<String>(Arrays.asList("testString")))
      .text(new ArrayList<String>(Arrays.asList("testString")))
      .types(new ArrayList<String>(Arrays.asList("testString")))
      .attributes(new ArrayList<String>(Arrays.asList("testString")))
      .values(new ArrayList<String>(Arrays.asList("testString")))
      .nluRelations(new ArrayList<String>(Arrays.asList("testString")))
      .limit(Long.valueOf("26"))
      .searchTagBegin("testString")
      .searchTagEnd("testString")
      .relatedTagBegin("testString")
      .relatedTagEnd("testString")
      .fields("testString")
      .build();
    assertEquals(getSearchMatchesOptionsModel.corpus(), "testString");
    assertEquals(getSearchMatchesOptionsModel.documentId(), "testString");
    assertEquals(getSearchMatchesOptionsModel.minScore(), Float.valueOf("36.0"));
    assertEquals(getSearchMatchesOptionsModel.cuis(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(getSearchMatchesOptionsModel.text(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(getSearchMatchesOptionsModel.types(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(getSearchMatchesOptionsModel.attributes(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(getSearchMatchesOptionsModel.values(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(getSearchMatchesOptionsModel.nluRelations(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(getSearchMatchesOptionsModel.limit(), Long.valueOf("26"));
    assertEquals(getSearchMatchesOptionsModel.searchTagBegin(), "testString");
    assertEquals(getSearchMatchesOptionsModel.searchTagEnd(), "testString");
    assertEquals(getSearchMatchesOptionsModel.relatedTagBegin(), "testString");
    assertEquals(getSearchMatchesOptionsModel.relatedTagEnd(), "testString");
    assertEquals(getSearchMatchesOptionsModel.fields(), "testString");
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSearchMatchesOptionsError() throws Throwable {
    new GetSearchMatchesOptions.Builder().build();
  }

}