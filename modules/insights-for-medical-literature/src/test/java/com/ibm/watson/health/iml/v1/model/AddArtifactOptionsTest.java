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
import com.ibm.watson.health.iml.v1.model.AddArtifactOptions;
import com.ibm.watson.health.iml.v1.model.AttributeEntry;
import com.ibm.watson.health.iml.v1.model.DictonaryEntry;
import com.ibm.watson.health.iml.v1.model.PossibleValues;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AddArtifactOptions model.
 */
public class AddArtifactOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddArtifactOptions() throws Throwable {
    PossibleValues possbileValuesModel = new PossibleValues.Builder()
      .displayValue("testString")
      .value("testString")
      .build();
    assertEquals(possbileValuesModel.displayValue(), "testString");
    assertEquals(possbileValuesModel.value(), "testString");

    AttributeEntry attributeEntryModel = new AttributeEntry.Builder()
      .attrName("testString")
      .dataType("testString")
      .defaultValue("testString")
      .description("testString")
      .displayName("testString")
      .docId("testString")
      .fieldValues(new ArrayList<String>(Arrays.asList("testString")))
      .maximumValue("testString")
      .minimumValue("testString")
      .multiValue(true)
      .units("testString")
      .valueType("testString")
      .possibleValues(new ArrayList<PossibleValues>(Arrays.asList(possbileValuesModel)))
      .build();
    assertEquals(attributeEntryModel.attrName(), "testString");
    assertEquals(attributeEntryModel.dataType(), "testString");
    assertEquals(attributeEntryModel.defaultValue(), "testString");
    assertEquals(attributeEntryModel.description(), "testString");
    assertEquals(attributeEntryModel.displayName(), "testString");
    assertEquals(attributeEntryModel.docId(), "testString");
    assertEquals(attributeEntryModel.fieldValues(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(attributeEntryModel.maximumValue(), "testString");
    assertEquals(attributeEntryModel.minimumValue(), "testString");
    assertEquals(attributeEntryModel.multiValue(), Boolean.valueOf(true));
    assertEquals(attributeEntryModel.units(), "testString");
    assertEquals(attributeEntryModel.valueType(), "testString");
    assertEquals(attributeEntryModel.possibleValues(), new ArrayList<PossibleValues>(Arrays.asList(possbileValuesModel)));

    DictonaryEntry dictonaryEntryModel = new DictonaryEntry.Builder()
      .children(new ArrayList<String>(Arrays.asList("testString")))
      .cui("testString")
      .definition(new ArrayList<String>(Arrays.asList("testString")))
      .parents(new ArrayList<String>(Arrays.asList("testString")))
      .preferredName("testString")
      .semtypes(new ArrayList<String>(Arrays.asList("testString")))
      .siblings(new ArrayList<String>(Arrays.asList("testString")))
      .surfaceForms(new ArrayList<String>(Arrays.asList("testString")))
      .variants(new ArrayList<String>(Arrays.asList("testString")))
      .vocab("testString")
      .related(new ArrayList<String>(Arrays.asList("testString")))
      .source("testString")
      .sourceVersion("testString")
      .build();
    assertEquals(dictonaryEntryModel.children(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(dictonaryEntryModel.cui(), "testString");
    assertEquals(dictonaryEntryModel.definition(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(dictonaryEntryModel.parents(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(dictonaryEntryModel.preferredName(), "testString");
    assertEquals(dictonaryEntryModel.semtypes(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(dictonaryEntryModel.siblings(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(dictonaryEntryModel.surfaceForms(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(dictonaryEntryModel.variants(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(dictonaryEntryModel.vocab(), "testString");
    assertEquals(dictonaryEntryModel.related(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(dictonaryEntryModel.source(), "testString");
    assertEquals(dictonaryEntryModel.sourceVersion(), "testString");

    AddArtifactOptions addArtifactOptionsModel = new AddArtifactOptions.Builder()
      .corpus("testString")
      .dictionaryEntry(dictonaryEntryModel)
      .attributeEntry(attributeEntryModel)
      .build();
    assertEquals(addArtifactOptionsModel.corpus(), "testString");
    assertEquals(addArtifactOptionsModel.dictionaryEntry(), dictonaryEntryModel);
    assertEquals(addArtifactOptionsModel.attributeEntry(), attributeEntryModel);
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddArtifactOptionsError() throws Throwable {
    new AddArtifactOptions.Builder().build();
  }

}