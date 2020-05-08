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

import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the AcdFlow model.
 */
public class AcdFlowTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAcdFlow() throws Throwable {
    FlowEntry flowEntryModel = new FlowEntry.Builder().build();

    ConfigurationEntity configurationEntityModel = new ConfigurationEntity.Builder()
      .id("testString")
      .type("testString")
      .uid(Long.valueOf("26"))
      .mergeid(Long.valueOf("26"))
      .build();
    assertEquals(configurationEntityModel.id(), "testString");
    assertEquals(configurationEntityModel.type(), "testString");
    assertEquals(configurationEntityModel.uid(), Long.valueOf("26"));
    assertEquals(configurationEntityModel.mergeid(), Long.valueOf("26"));

    Flow flowModel = new Flow.Builder()
      .elements(new ArrayList<FlowEntry>(Arrays.asList(flowEntryModel)))
      .async(true)
      .build();
    assertEquals(flowModel.elements(), new ArrayList<FlowEntry>(Arrays.asList(flowEntryModel)));
    assertEquals(flowModel.async(), Boolean.valueOf(true));

    AnnotatorFlow annotatorFlowModel = new AnnotatorFlow.Builder()
      .profile("testString")
      .flow(flowModel)
//      .id("testString")
//      .type("testString")
//      .data(new java.util.HashMap<String,List<Entity>>(){{put("foo", new ArrayList<Entity>(Arrays.asList(entityModel))); }})
//      .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
 //     .globalConfigurations(new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)))
 //     .uid(Long.valueOf("26"))
      .build();
    assertEquals(annotatorFlowModel.profile(), "testString");
    assertEquals(annotatorFlowModel.flow(), flowModel);
//    assertEquals(annotatorFlowModel.id(), "testString");
//    assertEquals(annotatorFlowModel.type(), "testString");
//    assertEquals(annotatorFlowModel.data(), new java.util.HashMap<String,List<Entity>>(){{put("foo", new ArrayList<Entity>(Arrays.asList(entityModel))); }});
//    assertEquals(annotatorFlowModel.metadata(), new java.util.HashMap<String,Object>(){{put("foo", "testString"); }});
//    assertEquals(annotatorFlowModel.globalConfigurations(), new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)));
//    assertEquals(annotatorFlowModel.uid(), Long.valueOf("26"));

    AcdFlow acdFlowModel = new AcdFlow.Builder()
      .id("testString")
      .name("testString")
      .description("testString")
      .publishedDate("testString")
      .publish(true)
      .version("testString")
      .cartridgeId("testString")
      .annotatorFlows(new ArrayList<AnnotatorFlow>(Arrays.asList(annotatorFlowModel)))
      .build();
    assertEquals(acdFlowModel.id(), "testString");
    assertEquals(acdFlowModel.name(), "testString");
    assertEquals(acdFlowModel.description(), "testString");
    assertEquals(acdFlowModel.publishedDate(), "testString");
    assertEquals(acdFlowModel.publish(), Boolean.valueOf(true));
    assertEquals(acdFlowModel.version(), "testString");
    assertEquals(acdFlowModel.cartridgeId(), "testString");
    assertEquals(acdFlowModel.annotatorFlows(), new ArrayList<AnnotatorFlow>(Arrays.asList(annotatorFlowModel)));

    String json = TestUtilities.serialize(acdFlowModel);

    AcdFlow acdFlowModelNew = TestUtilities.deserialize(json, AcdFlow.class);
    assertTrue(acdFlowModelNew instanceof AcdFlow);
    assertEquals(acdFlowModelNew.id(), "testString");
    assertEquals(acdFlowModelNew.name(), "testString");
    assertEquals(acdFlowModelNew.description(), "testString");
    assertEquals(acdFlowModelNew.publishedDate(), "testString");
    assertEquals(acdFlowModelNew.publish(), Boolean.valueOf(true));
    assertEquals(acdFlowModelNew.version(), "testString");
    assertEquals(acdFlowModelNew.cartridgeId(), "testString");
  }
}