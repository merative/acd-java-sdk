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
import com.ibm.watson.health.iml.v1.model.ConceptModel;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ConceptModel model.
 */
public class ConceptModelTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testConceptModel() throws Throwable {
    ConceptModel conceptModelModel = new ConceptModel();
    assertNull(conceptModelModel.getUniqueId());
    assertNull(conceptModelModel.getStickyIds());
    assertNull(conceptModelModel.getSection());
    assertNull(conceptModelModel.getType());
    assertNull(conceptModelModel.getBegin());
    assertNull(conceptModelModel.getEnd());
    assertNull(conceptModelModel.getCoveredText());
    assertNull(conceptModelModel.getCui());
    assertNull(conceptModelModel.getPreferredName());
    assertNull(conceptModelModel.getSource());
    assertNull(conceptModelModel.isNegated());
    assertNull(conceptModelModel.isHypothetical());
    assertNull(conceptModelModel.getTimestamp());
    assertNull(conceptModelModel.getAttributeId());
    assertNull(conceptModelModel.getQualifiers());
    assertNull(conceptModelModel.getUnit());
    assertNull(conceptModelModel.getMinValue());
    assertNull(conceptModelModel.getMaxValue());
    assertNull(conceptModelModel.getOperator());
    assertNull(conceptModelModel.getFeatures());
    assertNull(conceptModelModel.getNluEntityIndex());
    assertNull(conceptModelModel.getNluMentionIndex());
    assertNull(conceptModelModel.getNluRelationId());
    assertNull(conceptModelModel.getNluSide());
    assertNull(conceptModelModel.getNluSourceType());
    assertNull(conceptModelModel.getNluRelation());
    assertNull(conceptModelModel.getNluTargetType());
    assertNull(conceptModelModel.getHits());
  }
}