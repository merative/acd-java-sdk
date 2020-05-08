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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representing a passage.
 */
public class EntryModel extends GenericModel {

  protected String id;
  protected Boolean negated;
  protected List<SentenceModel> sentences;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private Boolean negated;
    private List<SentenceModel> sentences;

    private Builder(EntryModel entryModel) {
      this.id = entryModel.id;
      this.negated = entryModel.negated;
      this.sentences = entryModel.sentences;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a EntryModel.
     *
     * @return the new EntryModel instance
     */
    public EntryModel build() {
      return new EntryModel(this);
    }

    /**
     * Adds an sentences to sentences.
     *
     * @param sentences the new sentences
     * @return the EntryModel builder
     */
    public Builder addSentences(SentenceModel sentences) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(sentences,
        "sentences cannot be null");
      if (this.sentences == null) {
        this.sentences = new ArrayList<SentenceModel>();
      }
      this.sentences.add(sentences);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the EntryModel builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the negated.
     *
     * @param negated the negated
     * @return the EntryModel builder
     */
    public Builder negated(Boolean negated) {
      this.negated = negated;
      return this;
    }

    /**
     * Set the sentences.
     * Existing sentences will be replaced.
     *
     * @param sentences the sentences
     * @return the EntryModel builder
     */
    public Builder sentences(List<SentenceModel> sentences) {
      this.sentences = sentences;
      return this;
    }
  }

  protected EntryModel(Builder builder) {
    id = builder.id;
    negated = builder.negated;
    sentences = builder.sentences;
  }

  /**
   * New builder.
   *
   * @return a EntryModel builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Unique identifier of passage.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the negated.
   *
   * Whether passage is a negated span.
   *
   * @return the negated
   */
  public Boolean negated() {
    return negated;
  }

  /**
   * Gets the sentences.
   *
   * List of sentences within passage.
   *
   * @return the sentences
   */
  public List<SentenceModel> sentences() {
    return sentences;
  }
}

