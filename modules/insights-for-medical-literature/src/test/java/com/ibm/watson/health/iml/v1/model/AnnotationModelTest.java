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
import com.ibm.watson.health.iml.v1.model.AnnotationModel;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AnnotationModel model.
 */
public class AnnotationModelTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAnnotationModel() throws Throwable {
    AnnotationModel annotationModelModel = new AnnotationModel.Builder()
      .uniqueId(Long.valueOf("26"))
      .stickyIds(new ArrayList<Long>(Arrays.asList(Long.valueOf("26"))))
      .ontology("testString")
      .section("testString")
      .preferredName("testString")
      .cui("testString")
      .attributeId("testString")
      .qualifiers(new ArrayList<String>(Arrays.asList("testString")))
      .type("testString")
      .negated(true)
      .hypothetical(true)
      .unit("testString")
      .minValue("testString")
      .maxValue("testString")
      .operator("testString")
      .nluSourceType("testString")
      .nluRelation("testString")
      .nluTargetType("testString")
      .nluEntityIndex("testString")
      .nluMentionIndex("testString")
      .nluRelationId("testString")
      .nluSide("testString")
      .begin(Long.valueOf("26"))
      .end(Long.valueOf("26"))
      .score(Float.valueOf("36.0"))
      .timestamp(Long.valueOf("26"))
      .features(new java.util.HashMap<String,String>(){{put("foo", "testString"); }})
      .hits(Long.valueOf("26"))
      .build();
    assertEquals(annotationModelModel.uniqueId(), Long.valueOf("26"));
    assertEquals(annotationModelModel.stickyIds(), new ArrayList<Long>(Arrays.asList(Long.valueOf("26"))));
    assertEquals(annotationModelModel.ontology(), "testString");
    assertEquals(annotationModelModel.section(), "testString");
    assertEquals(annotationModelModel.preferredName(), "testString");
    assertEquals(annotationModelModel.cui(), "testString");
    assertEquals(annotationModelModel.attributeId(), "testString");
    assertEquals(annotationModelModel.qualifiers(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(annotationModelModel.type(), "testString");
    assertEquals(annotationModelModel.negated(), Boolean.valueOf(true));
    assertEquals(annotationModelModel.hypothetical(), Boolean.valueOf(true));
    assertEquals(annotationModelModel.unit(), "testString");
    assertEquals(annotationModelModel.minValue(), "testString");
    assertEquals(annotationModelModel.maxValue(), "testString");
    assertEquals(annotationModelModel.operator(), "testString");
    assertEquals(annotationModelModel.nluSourceType(), "testString");
    assertEquals(annotationModelModel.nluRelation(), "testString");
    assertEquals(annotationModelModel.nluTargetType(), "testString");
    assertEquals(annotationModelModel.nluEntityIndex(), "testString");
    assertEquals(annotationModelModel.nluMentionIndex(), "testString");
    assertEquals(annotationModelModel.nluRelationId(), "testString");
    assertEquals(annotationModelModel.nluSide(), "testString");
    assertEquals(annotationModelModel.begin(), Long.valueOf("26"));
    assertEquals(annotationModelModel.end(), Long.valueOf("26"));
    assertEquals(annotationModelModel.score(), Float.valueOf("36.0"));
    assertEquals(annotationModelModel.timestamp(), Long.valueOf("26"));
    assertEquals(annotationModelModel.features(), new java.util.HashMap<String,String>(){{put("foo", "testString"); }});
    assertEquals(annotationModelModel.hits(), Long.valueOf("26"));

    String json = TestUtilities.serialize(annotationModelModel);

    AnnotationModel annotationModelModelNew = TestUtilities.deserialize(json, AnnotationModel.class);
    assertTrue(annotationModelModelNew instanceof AnnotationModel);
    assertEquals(annotationModelModelNew.uniqueId(), Long.valueOf("26"));
    assertEquals(annotationModelModelNew.ontology(), "testString");
    assertEquals(annotationModelModelNew.section(), "testString");
    assertEquals(annotationModelModelNew.preferredName(), "testString");
    assertEquals(annotationModelModelNew.cui(), "testString");
    assertEquals(annotationModelModelNew.attributeId(), "testString");
    assertEquals(annotationModelModelNew.type(), "testString");
    assertEquals(annotationModelModelNew.negated(), Boolean.valueOf(true));
    assertEquals(annotationModelModelNew.hypothetical(), Boolean.valueOf(true));
    assertEquals(annotationModelModelNew.unit(), "testString");
    assertEquals(annotationModelModelNew.minValue(), "testString");
    assertEquals(annotationModelModelNew.maxValue(), "testString");
    assertEquals(annotationModelModelNew.operator(), "testString");
    assertEquals(annotationModelModelNew.nluSourceType(), "testString");
    assertEquals(annotationModelModelNew.nluRelation(), "testString");
    assertEquals(annotationModelModelNew.nluTargetType(), "testString");
    assertEquals(annotationModelModelNew.nluEntityIndex(), "testString");
    assertEquals(annotationModelModelNew.nluMentionIndex(), "testString");
    assertEquals(annotationModelModelNew.nluRelationId(), "testString");
    assertEquals(annotationModelModelNew.nluSide(), "testString");
    assertEquals(annotationModelModelNew.begin(), Long.valueOf("26"));
    assertEquals(annotationModelModelNew.end(), Long.valueOf("26"));
    assertEquals(annotationModelModelNew.score(), Float.valueOf("36.0"));
    assertEquals(annotationModelModelNew.timestamp(), Long.valueOf("26"));
    assertEquals(annotationModelModelNew.hits(), Long.valueOf("26"));
  }
}