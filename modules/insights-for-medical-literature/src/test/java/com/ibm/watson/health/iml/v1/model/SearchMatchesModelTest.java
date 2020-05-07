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
import com.ibm.watson.health.iml.v1.model.SearchMatchesModel;
import com.ibm.watson.health.iml.v1.model.StringBuilder;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SearchMatchesModel model.
 */
public class SearchMatchesModelTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSearchMatchesModel() throws Throwable {
    SearchMatchesModel searchMatchesModelModel = new SearchMatchesModel();
    assertNull(searchMatchesModelModel.getExternalId());
    assertNull(searchMatchesModelModel.getDocumentId());
    assertNull(searchMatchesModelModel.getParentDocumentId());
    assertNull(searchMatchesModelModel.getPublicationName());
    assertNull(searchMatchesModelModel.getPublicationDate());
    assertNull(searchMatchesModelModel.getPublicationUrl());
    assertNull(searchMatchesModelModel.getAuthors());
    assertNull(searchMatchesModelModel.getTitle());
    assertNull(searchMatchesModelModel.getMedlineLicense());
    assertNull(searchMatchesModelModel.getHrefPubMed());
    assertNull(searchMatchesModelModel.getHrefPmc());
    assertNull(searchMatchesModelModel.getHrefDoi());
    assertNull(searchMatchesModelModel.getPdfUrl());
    assertNull(searchMatchesModelModel.getReferenceUrl());
    assertNull(searchMatchesModelModel.getHighlightedTitle());
    assertNull(searchMatchesModelModel.getHighlightedAbstract());
    assertNull(searchMatchesModelModel.getHighlightedBody());
    assertNull(searchMatchesModelModel.getHighlightedSections());
    assertNull(searchMatchesModelModel.getPassages());
    assertNull(searchMatchesModelModel.getAnnotations());
  }
}