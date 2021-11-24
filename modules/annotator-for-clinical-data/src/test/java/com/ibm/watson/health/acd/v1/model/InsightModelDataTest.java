/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the InsightModelData model.
 */
public class InsightModelDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testInsightModelData() throws Throwable {

    InsightModelDataMedication insightModelDataMedicationModel = new InsightModelDataMedication();
    assertNull(insightModelDataMedicationModel.getUsage());
    assertNull(insightModelDataMedicationModel.getStarted());
    assertNull(insightModelDataMedicationModel.getStopped());
    assertNull(insightModelDataMedicationModel.getDoseChanged());
    assertNull(insightModelDataMedicationModel.getAdverse());

    InsightModelDataDiagnosis insightModelDataDiagnosisModel = new InsightModelDataDiagnosis();
    assertNull(insightModelDataDiagnosisModel.getUsage());
    assertNull(insightModelDataDiagnosisModel.getSuspectedScore());
    assertNull(insightModelDataDiagnosisModel.getSymptomScore());
    assertNull(insightModelDataDiagnosisModel.getTraumaScore());
    assertNull(insightModelDataDiagnosisModel.getFamilyHistoryScore());
    assertNull(insightModelDataDiagnosisModel.getModifiers());

    InsightModelDataProcedure insightModelDataProcedureModel = new InsightModelDataProcedure();
    assertNull(insightModelDataProcedureModel.getUsage());
    assertNull(insightModelDataProcedureModel.getTask());
    assertNull(insightModelDataProcedureModel.getType());
    assertNull(insightModelDataProcedureModel.getModifiers());

    InsightModelDataNormality insightModelDataNormalityModel = new InsightModelDataNormality();
    assertNull(insightModelDataNormalityModel.getUsage());
    assertNull(insightModelDataNormalityModel.getDirectlyAffectedScore());
    assertNull(insightModelDataNormalityModel.getEvidence());

    InsightModelData insightModelDataModel = new InsightModelData();
    assertNull(insightModelDataModel.getMedication());
    assertNull(insightModelDataModel.getDiagnosis());
    assertNull(insightModelDataModel.getProcedure());
    assertNull(insightModelDataModel.getNormality());
    assertNull(insightModelDataModel.getTobacco());
    assertNull(insightModelDataModel.getAlcohol());
    assertNull(insightModelDataModel.getIllicitDrug());
    assertNull(insightModelDataModel.getSubstance());
  }
}