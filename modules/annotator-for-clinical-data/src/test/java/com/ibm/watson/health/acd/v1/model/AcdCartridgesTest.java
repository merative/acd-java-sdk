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

import static org.testng.Assert.assertNull;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the AcdCartridges model.
 */
public class AcdCartridgesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAcdCartridges() throws Throwable {
    AcdCartridges acdCartridgesModel = new AcdCartridges();
    assertNull(acdCartridgesModel.getId());
    assertNull(acdCartridgesModel.getName());
    assertNull(acdCartridgesModel.getStatus());
    assertNull(acdCartridgesModel.getStatusCode());
    assertNull(acdCartridgesModel.getStatusLocation());
    assertNull(acdCartridgesModel.getStartTime());
    assertNull(acdCartridgesModel.getEndTime());
    assertNull(acdCartridgesModel.getDuration());
    assertNull(acdCartridgesModel.getCorrelationId());
    assertNull(acdCartridgesModel.getArtifactResponseCode());
    assertNull(acdCartridgesModel.getArtifactResponse());
  }
}
