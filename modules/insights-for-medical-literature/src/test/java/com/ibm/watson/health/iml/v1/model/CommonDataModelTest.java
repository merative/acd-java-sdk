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
import com.ibm.watson.health.iml.v1.model.CommonDataModel;
import com.ibm.watson.health.iml.v1.model.ConceptModel;
import com.ibm.watson.health.iml.v1.model.DataModel;
import com.ibm.watson.health.iml.v1.model.RelationModel;
import com.ibm.watson.health.iml.v1.model.TextSpan;
import com.ibm.watson.health.iml.v1.model.UnstructuredModel;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CommonDataModel model.
 */
public class CommonDataModelTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCommonDataModel() throws Throwable {
    CommonDataModel commonDataModelModel = new CommonDataModel();
    assertNull(commonDataModelModel.getUnstructured());
  }
}