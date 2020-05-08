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
package com.ibm.watson.health.acd.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representing service runtime status.
 */
public class ServiceStatus extends GenericModel {

  /**
   * scurrent service state.
   */
  public interface ServiceState {
    /** OK. */
    String OK = "OK";
    /** WARNING. */
    String WARNING = "WARNING";
    /** ERROR. */
    String ERROR = "ERROR";
  }

  protected String serviceState;
  protected String stateDetails;

  /**
   * Gets the serviceState.
   *
   * scurrent service state.
   *
   * @return the serviceState
   */
  public String getServiceState() {
    return serviceState;
  }

  /**
   * Gets the stateDetails.
   *
   * service state details.
   *
   * @return the stateDetails
   */
  public String getStateDetails() {
    return stateDetails;
  }
}

