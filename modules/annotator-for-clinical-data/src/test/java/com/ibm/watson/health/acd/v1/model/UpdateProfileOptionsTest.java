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

import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the UpdateProfileOptions model.
 */
public class UpdateProfileOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateProfileOptions() throws Throwable {
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

    Annotator annotatorModel = new Annotator.Builder()
      .name("testString")
      .parameters(new java.util.HashMap<String,List<String>>(){{put("foo", new ArrayList<String>(Arrays.asList("testString"))); }})
      .configurations(new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)))
      .build();
    assertEquals(annotatorModel.name(), "testString");
    assertEquals(annotatorModel.parameters(), new java.util.HashMap<String,List<String>>(){{put("foo", new ArrayList<String>(Arrays.asList("testString"))); }});
    assertEquals(annotatorModel.configurations(), new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)));

    UpdateProfileOptions updateProfileOptionsModel = new UpdateProfileOptions.Builder()
      .id("testString")
      .newId("testString")
      .newName("testString")
      .newDescription("testString")
      .newPublishedDate("testString")
      .newPublish(true)
      .newVersion("testString")
      .newCartridgeId("testString")
      .newAnnotators(new ArrayList<Annotator>(Arrays.asList(annotatorModel)))
      .build();
    assertEquals(updateProfileOptionsModel.id(), "testString");
    assertEquals(updateProfileOptionsModel.newId(), "testString");
    assertEquals(updateProfileOptionsModel.newName(), "testString");
    assertEquals(updateProfileOptionsModel.newDescription(), "testString");
    assertEquals(updateProfileOptionsModel.newPublishedDate(), "testString");
    assertEquals(updateProfileOptionsModel.newPublish(), Boolean.valueOf(true));
    assertEquals(updateProfileOptionsModel.newVersion(), "testString");
    assertEquals(updateProfileOptionsModel.newCartridgeId(), "testString");
    assertEquals(updateProfileOptionsModel.newAnnotators(), new ArrayList<Annotator>(Arrays.asList(annotatorModel)));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateProfileOptionsError() throws Throwable {
    new UpdateProfileOptions.Builder().build();
  }

}