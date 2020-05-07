/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.iml.v1.model;

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representing repository message.
 */
public class Message extends GenericModel {

  private String type;
  private String url;
  private Map<String, Object> request;
  private List<String> headers;
  private Long status;
  private Map<String, Object> response;

  /**
   * Gets the type.
   *
   * Message type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the url.
   *
   * Message link.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the request.
   *
   * Message request.
   *
   * @return the request
   */
  public Map<String, Object> getRequest() {
    return request;
  }

  /**
   * Gets the headers.
   *
   * Request headers.
   *
   * @return the headers
   */
  public List<String> getHeaders() {
    return headers;
  }

  /**
   * Gets the status.
   *
   * Message status.
   *
   * @return the status
   */
  public Long getStatus() {
    return status;
  }

  /**
   * Gets the response.
   *
   * Message response.
   *
   * @return the response
   */
  public Map<String, Object> getResponse() {
    return response;
  }
}

