/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

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
