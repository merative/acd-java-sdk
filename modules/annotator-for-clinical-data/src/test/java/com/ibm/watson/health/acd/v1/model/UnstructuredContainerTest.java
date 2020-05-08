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
import static org.testng.Assert.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the UnstructuredContainer model.
 */
public class UnstructuredContainerTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUnstructuredContainer() throws Throwable {
    UnstructuredContainer unstructuredContainerModel = new UnstructuredContainer.Builder()
      .text("testString")
      .id("testString")
      .type("testString")
      .data(new ContainerAnnotation())
      .metadata(new java.util.HashMap<String,Map>(){{put("foo", new HashMap()); }})
      .uid(Long.valueOf("26"))
      .build();
    assertEquals(unstructuredContainerModel.text(), "testString");
    assertEquals(unstructuredContainerModel.id(), "testString");
    assertEquals(unstructuredContainerModel.type(), "testString");
    assertEquals(unstructuredContainerModel.data(), new ContainerAnnotation());
    assertEquals(unstructuredContainerModel.metadata(), new java.util.HashMap<String,Map>(){{put("foo", new HashMap()); }});
    assertEquals(unstructuredContainerModel.uid(), Long.valueOf("26"));

    String json = TestUtilities.serialize(unstructuredContainerModel);

    UnstructuredContainer unstructuredContainerModelNew = TestUtilities.deserialize(json, UnstructuredContainer.class);
    assertTrue(unstructuredContainerModelNew instanceof UnstructuredContainer);
    assertEquals(unstructuredContainerModelNew.text(), "testString");
    assertEquals(unstructuredContainerModelNew.id(), "testString");
    assertEquals(unstructuredContainerModelNew.type(), "testString");
    assertEquals(unstructuredContainerModelNew.uid(), Long.valueOf("26"));
  }
}