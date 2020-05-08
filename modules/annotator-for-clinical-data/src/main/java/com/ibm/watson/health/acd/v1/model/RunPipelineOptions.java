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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The runPipeline options.
 */
public class RunPipelineOptions extends GenericModel {

  protected List<UnstructuredContainer> unstructured;
  protected List<AnnotatorFlow> annotatorFlows;
  protected Boolean debugTextRestore;
  protected Boolean returnAnalyzedText;

  /**
   * Builder.
   */
  public static class Builder {
    private List<UnstructuredContainer> unstructured;
    private List<AnnotatorFlow> annotatorFlows;
    private Boolean debugTextRestore;
    private Boolean returnAnalyzedText;

    private Builder(RunPipelineOptions runPipelineOptions) {
      this.unstructured = runPipelineOptions.unstructured;
      this.annotatorFlows = runPipelineOptions.annotatorFlows;
      this.debugTextRestore = runPipelineOptions.debugTextRestore;
      this.returnAnalyzedText = runPipelineOptions.returnAnalyzedText;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RunPipelineOptions.
     *
     * @return the new RunPipelineOptions instance
     */
    public RunPipelineOptions build() {
      return new RunPipelineOptions(this);
    }

    /**
     * Adds an unstructured to unstructured.
     *
     * @param unstructured the new unstructured
     * @return the RunPipelineOptions builder
     */
    public Builder addUnstructured(UnstructuredContainer unstructured) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(unstructured,
        "unstructured cannot be null");
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
     * @return the RunPipelineOptions builder
     */
    public Builder addAnnotatorFlows(AnnotatorFlow annotatorFlows) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(annotatorFlows,
        "annotatorFlows cannot be null");
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
     * @return the RunPipelineOptions builder
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
     * @return the RunPipelineOptions builder
     */
    public Builder annotatorFlows(List<AnnotatorFlow> annotatorFlows) {
      this.annotatorFlows = annotatorFlows;
      return this;
    }

    /**
     * Set the debugTextRestore.
     *
     * @param debugTextRestore the debugTextRestore
     * @return the RunPipelineOptions builder
     */
    public Builder debugTextRestore(Boolean debugTextRestore) {
      this.debugTextRestore = debugTextRestore;
      return this;
    }

    /**
     * Set the returnAnalyzedText.
     *
     * @param returnAnalyzedText the returnAnalyzedText
     * @return the RunPipelineOptions builder
     */
    public Builder returnAnalyzedText(Boolean returnAnalyzedText) {
      this.returnAnalyzedText = returnAnalyzedText;
      return this;
    }
  }

  protected RunPipelineOptions(Builder builder) {
    unstructured = builder.unstructured;
    annotatorFlows = builder.annotatorFlows;
    debugTextRestore = builder.debugTextRestore;
    returnAnalyzedText = builder.returnAnalyzedText;
  }

  /**
   * New builder.
   *
   * @return a RunPipelineOptions builder
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
   * Gets the debugTextRestore.
   *
   * If true, any ReplaceTextChange annotations will be left in the container and the modified text before restoring to
   * original form will stored in the metadata that is returned.  Otherwise, these annotations and modified text will be
   * removed from the container.
   *
   * @return the debugTextRestore
   */
  public Boolean debugTextRestore() {
    return debugTextRestore;
  }

  /**
   * Gets the returnAnalyzedText.
   *
   * Set this to true to show the analyzed text in the response.
   *
   * @return the returnAnalyzedText
   */
  public Boolean returnAnalyzedText() {
    return returnAnalyzedText;
  }
}

