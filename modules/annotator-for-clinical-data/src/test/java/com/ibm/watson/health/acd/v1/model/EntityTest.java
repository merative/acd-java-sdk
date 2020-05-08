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
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the Entity model.
 */
public class EntityTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testEntity() throws Throwable {
    Entity entityModel = new Entity.Builder()
      .id("testString")
      .type("testString")
      .uid(Long.valueOf("26"))
      .mergeid(Long.valueOf("26"))
      .build();
    assertEquals(entityModel.id(), "testString");
    assertEquals(entityModel.type(), "testString");
    assertEquals(entityModel.uid(), Long.valueOf("26"));
    assertEquals(entityModel.mergeid(), Long.valueOf("26"));

    String json = TestUtilities.serialize(entityModel);

    Entity entityModelNew = TestUtilities.deserialize(json, Entity.class);
    assertTrue(entityModelNew instanceof Entity);
    assertEquals(entityModelNew.id(), "testString");
    assertEquals(entityModelNew.type(), "testString");
    assertEquals(entityModelNew.uid(), Long.valueOf("26"));
    assertEquals(entityModelNew.mergeid(), Long.valueOf("26"));
  }
}