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
import com.ibm.watson.health.iml.v1.model.CategoriesModel;
import com.ibm.watson.health.iml.v1.model.EntryModel;
import com.ibm.watson.health.iml.v1.model.StringBuilder;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CategoriesModel model.
 */
public class CategoriesModelTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCategoriesModel() throws Throwable {
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

    StringBuilder stringBuilderModel = new StringBuilder();

    CategoriesModel categoriesModelModel = new CategoriesModel.Builder()
      .modelLicense("testString")
      .highlightedTitle("testString")
      .highlightedAbstract("testString")
      .highlightedBody("testString")
      .highlightedSections(new java.util.HashMap<String,String>(){{put("foo", "testString"); }})
      .passages(new java.util.HashMap<String, PassagesModel>(){{put("foo", new PassagesModel(){{put("foo", new PassagesModel()); }}); }})
      .annotations(new java.util.HashMap<String,AnnotationModel>(){{put("foo", annotationModelModel); }})
      .build();
    assertEquals(categoriesModelModel.modelLicense(), "testString");
    assertEquals(categoriesModelModel.highlightedTitle(), "testString");
    assertEquals(categoriesModelModel.highlightedAbstract(), "testString");
    assertEquals(categoriesModelModel.highlightedBody(), "testString");
    assertEquals(categoriesModelModel.highlightedSections(), new java.util.HashMap<String,String>(){{put("foo", "testString"); }});
    //assertEquals(categoriesModelModel.passages(), (new java.util.HashMap<String, PassagesModel>(){{put("foo", new PassagesModel(){{put("foo", new PassagesModel()); }}); }}));
    assertEquals(categoriesModelModel.annotations(), new java.util.HashMap<String,AnnotationModel>(){{put("foo", annotationModelModel); }});

    String json = TestUtilities.serialize(categoriesModelModel);

    CategoriesModel categoriesModelModelNew = TestUtilities.deserialize(json, CategoriesModel.class);
    assertTrue(categoriesModelModelNew instanceof CategoriesModel);
    assertEquals(categoriesModelModelNew.modelLicense(), "testString");
    assertEquals(categoriesModelModelNew.highlightedTitle().toString(), "testString");
    assertEquals(categoriesModelModelNew.highlightedAbstract().toString(), "testString");
    assertEquals(categoriesModelModelNew.highlightedBody().toString(), "testString");
  }
}