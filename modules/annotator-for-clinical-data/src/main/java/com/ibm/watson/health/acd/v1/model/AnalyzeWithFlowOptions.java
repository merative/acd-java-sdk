/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

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
  private boolean debug;

  /**
   * Builder.
   */
  public static class Builder {
      private String flowId;
      private RequestContainer request;
      private String body;
      private String contentType;
      private boolean returnAnalyzedText = false;
      private boolean debug = false;

      private Builder(AnalyzeWithFlowOptions analyzeWithFlowOptions) {
          flowId = analyzeWithFlowOptions.flowId;
          request = analyzeWithFlowOptions.request;
          body = analyzeWithFlowOptions.body;
          contentType = analyzeWithFlowOptions.contentType;
          returnAnalyzedText = analyzeWithFlowOptions.returnAnalyzedText;
          debug =  analyzeWithFlowOptions.debug;
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

      /**
       * Set the debug.
       *
       * @param debug enable analyze debug flag
       * @return the AnalyzeWithFlowOptions builder
       */
      public Builder debug(boolean debug) {
          this.debug = debug;
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
    debug = builder.debug;
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

  /**
   * Gets the debug flag.
   *
   * true or false
   *
   * @return the debug flag
   */
  public boolean debug() {
    return debug;
  }
}
