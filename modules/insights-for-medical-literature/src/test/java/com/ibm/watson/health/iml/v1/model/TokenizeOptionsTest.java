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
import com.ibm.watson.health.iml.v1.model.TokenizeOptions;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TokenizeOptions model.
 */
public class TokenizeOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTokenizeOptions() throws Throwable {
    TokenizeOptions tokenizeOptionsModel = new TokenizeOptions.Builder()
      .corpus("testString")
      .flow("testString")
      .body("testString")
      .ontologies(new ArrayList<String>(Arrays.asList("mesh")))
      .maxWords(Long.valueOf("26"))
      .build();
    assertEquals(tokenizeOptionsModel.corpus(), "testString");
    assertEquals(tokenizeOptionsModel.flow(), "testString");
    assertEquals(tokenizeOptionsModel.body(), "testString");
    assertEquals(tokenizeOptionsModel.ontologies(), new ArrayList<String>(Arrays.asList("mesh")));
    assertEquals(tokenizeOptionsModel.maxWords(), Long.valueOf("26"));
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTokenizeOptionsError() throws Throwable {
    new TokenizeOptions.Builder().build();
  }

}