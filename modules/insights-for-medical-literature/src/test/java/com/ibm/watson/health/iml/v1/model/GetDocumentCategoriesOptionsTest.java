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
import com.ibm.watson.health.iml.v1.model.GetDocumentCategoriesOptions;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetDocumentCategoriesOptions model.
 */
public class GetDocumentCategoriesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetDocumentCategoriesOptions() throws Throwable {
    GetDocumentCategoriesOptions getDocumentCategoriesOptionsModel = new GetDocumentCategoriesOptions.Builder()
      .corpus("testString")
      .documentId("testString")
      .highlightTagBegin("testString")
      .highlightTagEnd("testString")
      .types(new ArrayList<String>(Arrays.asList("testString")))
      .category("disorders")
      .onlyNegatedConcepts(true)
      .fields("testString")
      .limit(Long.valueOf("26"))
      .build();
    assertEquals(getDocumentCategoriesOptionsModel.corpus(), "testString");
    assertEquals(getDocumentCategoriesOptionsModel.documentId(), "testString");
    assertEquals(getDocumentCategoriesOptionsModel.highlightTagBegin(), "testString");
    assertEquals(getDocumentCategoriesOptionsModel.highlightTagEnd(), "testString");
    assertEquals(getDocumentCategoriesOptionsModel.types(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(getDocumentCategoriesOptionsModel.category(), "disorders");
    assertEquals(getDocumentCategoriesOptionsModel.onlyNegatedConcepts(), Boolean.valueOf(true));
    assertEquals(getDocumentCategoriesOptionsModel.fields(), "testString");
    assertEquals(getDocumentCategoriesOptionsModel.limit(), Long.valueOf("26"));
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentCategoriesOptionsError() throws Throwable {
    new GetDocumentCategoriesOptions.Builder().build();
  }

}