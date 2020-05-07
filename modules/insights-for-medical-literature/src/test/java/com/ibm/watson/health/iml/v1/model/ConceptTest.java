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
import com.ibm.watson.health.iml.v1.model.Concept;
import com.ibm.watson.health.iml.v1.model.Count;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Concept model.
 */
public class ConceptTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testConcept() throws Throwable {
    Concept conceptModel = new Concept();
    assertNull(conceptModel.getOntology());
    assertNull(conceptModel.getCui());
    assertNull(conceptModel.getPreferredName());
    assertNull(conceptModel.getAlternativeName());
    assertNull(conceptModel.getSemanticType());
    assertNull(conceptModel.getCount());
    assertNull(conceptModel.getHitCount());
    assertNull(conceptModel.getScore());
    assertNull(conceptModel.getParents());
    assertNull(conceptModel.getChildren());
    assertNull(conceptModel.getSiblings());
    assertNull(conceptModel.getRelated());
    assertNull(conceptModel.getDocumentIds());
    assertNull(conceptModel.getDataType());
    assertNull(conceptModel.getUnit());
    assertNull(conceptModel.getOperator());
    assertNull(conceptModel.getMinValue());
    assertNull(conceptModel.getMaxValue());
    assertNull(conceptModel.getVocab());
    assertNull(conceptModel.getXProperties());
  }
}