/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
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
 * Unit test class for the InsightModelSubstanceAbuse model.
 */
public class InsightModelSubstanceAbuseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testInsightModelSubstanceAbuse() throws Throwable {
	  InsightModelSubstanceAbuse insightModelSubstanceAbuseModel = new InsightModelSubstanceAbuse();
	  assertNull(insightModelSubstanceAbuseModel.getNonPatientScore());
	  assertNull(insightModelSubstanceAbuseModel.getTreatmentScore());
	  assertNull(insightModelSubstanceAbuseModel.getTreatment());
  }
}
