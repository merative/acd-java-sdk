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

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;


/**
 * The analyze options.
 */
public class AnalyzeOptions extends GenericModel {

  private List<UnstructuredContainer> unstructured;
  private List<AnnotatorFlow> annotatorFlows;
  private boolean returnAnalyzedText;


  /**
   * Builder.
   */
  public static class Builder {
      private List<UnstructuredContainer> unstructured;
      private List<AnnotatorFlow> annotatorFlows;
      private boolean returnAnalyzedText;


      private Builder(AnalyzeOptions analyzeOptions) {
          unstructured = analyzeOptions.unstructured;
          annotatorFlows = analyzeOptions.annotatorFlows;
          returnAnalyzedText = analyzeOptions.returnAnalyzedText;
      }

      /**
       * Instantiates a new builder.
       */
      public Builder() {
      }

      /**
       * Builds a AnalyzeOptions.
       *
       * @return the analyzeOptions
       */
      public AnalyzeOptions build() {
          return new AnalyzeOptions(this);
      }

      /**
       * Adds an unstructured to unstructured.
       *
       * @param unstructured the new unstructured
       * @return the AnalyzeOptions builder
       */
      public Builder addUnstructured(UnstructuredContainer unstructured) {
          Validator.notNull(unstructured, "unstructured cannot be null");
          if (this.unstructured == null) {
              this.unstructured = new ArrayList<UnstructuredContainer>();
          }
          this.unstructured.add(unstructured);
          return this;
      }

      /**
       * Adds an annotatorFlows to annotatorFlows.
       *
       * @param annotatorFlows the new annotatorFlows
       * @return the AnalyzeOptions builder
       */
      public Builder addAnnotatorFlows(AnnotatorFlow annotatorFlows) {
          Validator.notNull(annotatorFlows, "annotatorFlows cannot be null");
          if (this.annotatorFlows == null) {
              this.annotatorFlows = new ArrayList<AnnotatorFlow>();
          }
          this.annotatorFlows.add(annotatorFlows);
          return this;
      }

      /**
       * Set the unstructured.
       * Existing unstructured will be replaced.
       *
       * @param unstructured the unstructured
       * @return the AnalyzeOptions builder
       */
      public Builder unstructured(List<UnstructuredContainer> unstructured) {
          this.unstructured = unstructured;
          return this;
      }

      /**
       * Set the annotatorFlows.
       * Existing annotatorFlows will be replaced.
       *
       * @param annotatorFlows the annotatorFlows
       * @return the AnalyzeOptions builder
       */
      public Builder annotatorFlows(List<AnnotatorFlow> annotatorFlows) {
          this.annotatorFlows = annotatorFlows;
          return this;
      }

      /**
       * Set the returnAnalyzedText.
       *
       * @param returnAnalyzedText whether to return the submitted text
       * @return the AnalyzeOptionsbuilder
       */
      public Builder returnAnalyzedText(boolean returnAnalyzedText) {
          this.returnAnalyzedText = returnAnalyzedText;
          return this;
      }
}

  private AnalyzeOptions(Builder builder) {
    unstructured = builder.unstructured;
    annotatorFlows = builder.annotatorFlows;
    returnAnalyzedText = builder.returnAnalyzedText;
  }

  /**
   * New builder.
   *
   * @return a AnalyzeOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the unstructured.
   *
   * @return the unstructured
   */
  public List<UnstructuredContainer> unstructured() {
    return unstructured;
  }

  /**
   * Gets the annotatorFlows.
   *
   * @return the annotatorFlows
   */
  public List<AnnotatorFlow> annotatorFlows() {
    return annotatorFlows;
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
