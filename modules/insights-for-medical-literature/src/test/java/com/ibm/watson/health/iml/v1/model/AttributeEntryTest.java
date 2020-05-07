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
import com.ibm.watson.health.iml.v1.model.AttributeEntry;
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
 * Unit test class for the AttributeEntry model.
 */
public class AttributeEntryTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAttributeEntry() throws Throwable {
    PossibleValues possibleValuesModel = new PossibleValues.Builder()
      .displayValue("testString")
      .value("testString")
      .build();
    assertEquals(possibleValuesModel.displayValue(), "testString");
    assertEquals(possibleValuesModel.value(), "testString");

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
      .possibleValues(new ArrayList<PossibleValues>(Arrays.asList(possibleValuesModel)))
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
    assertEquals(attributeEntryModel.possibleValues(), new ArrayList<PossibleValues>(Arrays.asList(possibleValuesModel)));

    String json = TestUtilities.serialize(attributeEntryModel);

    AttributeEntry attributeEntryModelNew = TestUtilities.deserialize(json, AttributeEntry.class);
    assertTrue(attributeEntryModelNew instanceof AttributeEntry);
    assertEquals(attributeEntryModelNew.attrName(), "testString");
    assertEquals(attributeEntryModelNew.dataType(), "testString");
    assertEquals(attributeEntryModelNew.defaultValue(), "testString");
    assertEquals(attributeEntryModelNew.description(), "testString");
    assertEquals(attributeEntryModelNew.displayName(), "testString");
    assertEquals(attributeEntryModelNew.docId(), "testString");
    assertEquals(attributeEntryModelNew.maximumValue(), "testString");
    assertEquals(attributeEntryModelNew.minimumValue(), "testString");
    assertEquals(attributeEntryModelNew.multiValue(), Boolean.valueOf(true));
    assertEquals(attributeEntryModelNew.units(), "testString");
    assertEquals(attributeEntryModelNew.valueType(), "testString");
  }
}