/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The analyzeWithFlow options.
 */
public class AnalyzeWithFlowOptions extends GenericModel {

  /**
   * The type of the input: text/plain or application/json. A character encoding can be specified by including a `charset` parameter. For example, 'text/plain;charset=utf-8'.
   */
  public interface ContentType {
    /** text/plain. */
    String TEXT_PLAIN = "text/plain";
    /** application/json. */
    String APPLICATION_JSON = "application/json";
  }

  private String flowId;
  private RequestContainer request;
  private String body;
  private String contentType;
  private boolean returnAnalyzedText;

  /**
   * Builder.
   */
  public static class Builder {
      private String flowId;
      private RequestContainer request;
      private String body;
      private String contentType;
      private boolean returnAnalyzedText = false;

      private Builder(AnalyzeWithFlowOptions analyzeWithFlowOptions) {
          flowId = analyzeWithFlowOptions.flowId;
          request = analyzeWithFlowOptions.request;
          body = analyzeWithFlowOptions.body;
          contentType = analyzeWithFlowOptions.contentType;
          returnAnalyzedText = analyzeWithFlowOptions.returnAnalyzedText;
      }

      /**
       * Instantiates a new builder.
       */
      public Builder() {
      }

      /**
       * Instantiates a new builder with required properties.
       *
       * @param flowId the flowId
       */
      public Builder(String flowId) {
          this.flowId = flowId;
      }

      /**
       * Builds a AnalyzeWithFlowOptions.
       *
       * @return the analyzeWithFlowOptions
       */
      public AnalyzeWithFlowOptions build() {
          return new AnalyzeWithFlowOptions(this);
      }

      /**
       * Set the flowId.
       *
       * @param contentType the content type for request
       * @return the AnalyzeWithFlowOptions builder
       */
      public Builder contentType(String contentType) {
          this.contentType = contentType;
          return this;
      }

      /**
       * Set the flowId.
       *
       * @param flowId the flowId
       * @return the AnalyzeWithFlowOptions builder
       */
      public Builder flowId(String flowId) {
          this.flowId = flowId;
          return this;
      }

      /**
       * Set the text.
       *
       * @param text the text
       * @return the AnalyzeWithFlowOptions builder
       */
      public Builder text(String text) {
          this.body = text;
          this.contentType = AnalyzeWithFlowOptions.ContentType.TEXT_PLAIN;
          return this;
      }

      /**
       * Set the request.
       *
       * @param request the request
       * @return the AnalyzeWithFlowOptions builder
       */
      public Builder request(RequestContainer request) {
          this.request = request;
          this.contentType = AnalyzeWithFlowOptions.ContentType.APPLICATION_JSON;
          return this;
      }

      /**
       * Set the returnAnalyzedText.
       *
       * @param returnAnalyzedText whether to return the submitted text
       * @return the AnalyzeWithFlowOptions builder
       */
      public Builder returnAnalyzedText(boolean returnAnalyzedText) {
          this.returnAnalyzedText = returnAnalyzedText;
          return this;
      }
  }


  private AnalyzeWithFlowOptions(Builder builder) {
    Validator.notEmpty(builder.flowId, "flowId cannot be empty");
    Validator.isTrue(builder.contentType != null, "contentType cannot be null");
    flowId = builder.flowId;
    request = builder.request;
    body = builder.body;
    contentType = builder.contentType;
    returnAnalyzedText = builder.returnAnalyzedText;
  }

  /**
   * New builder.
   *
   * @return a AnalyzeWithFlowOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the flowId.
   *
   * flow identifier .
   *
   * @return the flowId
   */
  public String flowId() {
    return flowId;
  }

  /**
   * Gets the request.
   *
   * Input request data in TEXT or JSON format .
   *
   * @return the request
   */
  public RequestContainer request() {
    return request;
  }

  /**
   * Gets the body.
   *
   * Input request data in TEXT or JSON format .
   *
   * @return the body
   */
  public String body() {
    return body;
  }

  /**
   * Gets the contentType.
   *
   * The type of the input: text/plain or application/json. A character encoding can be specified by including a `charset` parameter. For example, 'text/plain;charset=utf-8'.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the returnAnalyzedText.
   *
   * true or false
   *
   * @return the returnAnalyzedText
   */
  public boolean returnAnalyzedText() {
    return returnAnalyzedText;
  }
}
