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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DeployCartridgeResponse.
 */
public class DeployCartridgeResponse extends GenericModel {

  protected Long code;
  protected List<ServiceError> artifactResponse;

  /**
   * Gets the code.
   *
   * @return the code
   */
  public Long getCode() {
    return code;
  }

  /**
   * Gets the artifactResponse.
   *
   * @return the artifactResponse
   */
  public List<ServiceError> getArtifactResponse() {
    return artifactResponse;
  }
}

