/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import static org.testng.Assert.assertNull;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.merative.acd.v1.utils.TestUtilities;

/**
 * Unit test class for the ServiceStatus model.
 */
public class ServiceStatusTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testServiceStatus() throws Throwable {
    ServiceStatus serviceStatusModel = new ServiceStatus();
    assertNull(serviceStatusModel.getServiceState());
    assertNull(serviceStatusModel.getStateDetails());
  }
}
