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

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representing repository message.
 */
public class Message extends GenericModel {

  /**
   * Message semantic type.
   */
  public interface MessageType {
    /** expanded_request. */
    String EXPANDED_REQUEST = "expanded_request";
    /** elastic_search. */
    String ELASTIC_SEARCH = "elastic_search";
  }

  protected String messageType;
  protected String url;
  protected Map<String, Object> request;
  protected List<String> headers;
  protected Long status;
  protected Map<String, Object> response;

  /**
   * Gets the messageType.
   *
   * Message semantic type.
   *
   * @return the messageType
   */
  public String getMessageType() {
    return messageType;
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

