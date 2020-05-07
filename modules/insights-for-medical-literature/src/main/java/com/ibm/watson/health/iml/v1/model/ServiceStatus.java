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

  protected String version;
  protected String upTime;
  protected String serviceState;
  protected String stateDetails;
  protected String hostName;
  protected Long requestCount;
  protected Long maxMemoryMb;
  protected Long commitedMemoryMb;
  protected Long inUseMemoryMb;
  protected Long availableProcessors;
  protected Long concurrentRequests;
  protected Long maxConcurrentRequests;
  protected Long totalRejectedRequests;
  protected Long totalBlockedRequests;

  /**
   * Gets the version.
   *
   * version of the service.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the upTime.
   *
   * service uptime since last restart.
   *
   * @return the upTime
   */
  public String getUpTime() {
    return upTime;
  }

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

  /**
   * Gets the hostName.
   *
   * service uptime since last restart.
   *
   * @return the hostName
   */
  public String getHostName() {
    return hostName;
  }

  /**
   * Gets the requestCount.
   *
   * total number of requests during uptime.
   *
   * @return the requestCount
   */
  public Long getRequestCount() {
    return requestCount;
  }

  /**
   * Gets the maxMemoryMb.
   *
   * Maximum memory used during uptime.
   *
   * @return the maxMemoryMb
   */
  public Long getMaxMemoryMb() {
    return maxMemoryMb;
  }

  /**
   * Gets the commitedMemoryMb.
   *
   * Megabytes of committed memory.
   *
   * @return the commitedMemoryMb
   */
  public Long getCommitedMemoryMb() {
    return commitedMemoryMb;
  }

  /**
   * Gets the inUseMemoryMb.
   *
   * Megabytes of memory used.
   *
   * @return the inUseMemoryMb
   */
  public Long getInUseMemoryMb() {
    return inUseMemoryMb;
  }

  /**
   * Gets the availableProcessors.
   *
   * number of available processors.
   *
   * @return the availableProcessors
   */
  public Long getAvailableProcessors() {
    return availableProcessors;
  }

  /**
   * Gets the concurrentRequests.
   *
   * number of concurrent requests.
   *
   * @return the concurrentRequests
   */
  public Long getConcurrentRequests() {
    return concurrentRequests;
  }

  /**
   * Gets the maxConcurrentRequests.
   *
   * configured maximum concurrent request limit.
   *
   * @return the maxConcurrentRequests
   */
  public Long getMaxConcurrentRequests() {
    return maxConcurrentRequests;
  }

  /**
   * Gets the totalRejectedRequests.
   *
   * number of rejected requests.
   *
   * @return the totalRejectedRequests
   */
  public Long getTotalRejectedRequests() {
    return totalRejectedRequests;
  }

  /**
   * Gets the totalBlockedRequests.
   *
   * number of blocked requests.
   *
   * @return the totalBlockedRequests
   */
  public Long getTotalBlockedRequests() {
    return totalBlockedRequests;
  }
}

