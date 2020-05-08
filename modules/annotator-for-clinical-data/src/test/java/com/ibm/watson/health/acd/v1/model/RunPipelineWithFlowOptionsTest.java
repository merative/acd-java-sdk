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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the RunPipelineWithFlowOptions model.
 */
public class RunPipelineWithFlowOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRunPipelineWithFlowOptions() throws Throwable {
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
//      .globalConfigurations(new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)))
//      .uid(Long.valueOf("26"))
      .build();
    assertEquals(annotatorFlowModel.profile(), "testString");
    assertEquals(annotatorFlowModel.flow(), flowModel);
//    assertEquals(annotatorFlowModel.id(), "testString");
//    assertEquals(annotatorFlowModel.type(), "testString");
//    assertEquals(annotatorFlowModel.data(), new java.util.HashMap<String,List<Entity>>(){{put("foo", new ArrayList<Entity>(Arrays.asList(entityModel))); }});
//    assertEquals(annotatorFlowModel.metadata(), new java.util.HashMap<String,Object>(){{put("foo", "testString"); }});
//    assertEquals(annotatorFlowModel.globalConfigurations(), new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)));
//    assertEquals(annotatorFlowModel.uid(), Long.valueOf("26"));

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

    AnalyticFlowBeanInput analyticFlowBeanInputModel = new AnalyticFlowBeanInput.Builder()
      .unstructured(new ArrayList<UnstructuredContainer>(Arrays.asList(unstructuredContainerModel)))
      .annotatorFlows(new ArrayList<AnnotatorFlow>(Arrays.asList(annotatorFlowModel)))
      .build();
    assertEquals(analyticFlowBeanInputModel.unstructured(), new ArrayList<UnstructuredContainer>(Arrays.asList(unstructuredContainerModel)));
    assertEquals(analyticFlowBeanInputModel.annotatorFlows(), new ArrayList<AnnotatorFlow>(Arrays.asList(annotatorFlowModel)));

    RunPipelineWithFlowOptions runPipelineWithFlowOptionsModel = new RunPipelineWithFlowOptions.Builder()
      .flowId("testString")
      .returnAnalyzedText(true)
      .analyticFlowBeanInput(analyticFlowBeanInputModel)
      .debugTextRestore(true)
      .build();
    assertEquals(runPipelineWithFlowOptionsModel.flowId(), "testString");
    assertEquals(runPipelineWithFlowOptionsModel.returnAnalyzedText(), Boolean.valueOf(true));
    assertEquals(runPipelineWithFlowOptionsModel.analyticFlowBeanInput(), analyticFlowBeanInputModel);
    assertEquals(runPipelineWithFlowOptionsModel.debugTextRestore(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRunPipelineWithFlowOptionsError() throws Throwable {
    new RunPipelineWithFlowOptions.Builder().build();
  }

}