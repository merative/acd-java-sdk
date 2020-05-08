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
 * Object representing a document sentence.
 */
public class SentenceModel extends GenericModel {

  protected String documentSection;
  protected StringBuilder text;
  protected Long begin;
  protected Long end;
  protected Long timestamp;

  /**
   * Builder.
   */
  public static class Builder {
    private String documentSection;
    private StringBuilder text;
    private Long begin;
    private Long end;
    private Long timestamp;

    private Builder(SentenceModel sentenceModel) {
      this.documentSection = sentenceModel.documentSection;
      this.text = sentenceModel.text;
      this.begin = sentenceModel.begin;
      this.end = sentenceModel.end;
      this.timestamp = sentenceModel.timestamp;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SentenceModel.
     *
     * @return the new SentenceModel instance
     */
    public SentenceModel build() {
      return new SentenceModel(this);
    }

    /**
     * Set the documentSection.
     *
     * @param documentSection the documentSection
     * @return the SentenceModel builder
     */
    public Builder documentSection(String documentSection) {
      this.documentSection = documentSection;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the SentenceModel builder
     */
    public Builder text(StringBuilder text) {
      this.text = text;
      return this;
    }

    /**
     * Set the begin.
     *
     * @param begin the begin
     * @return the SentenceModel builder
     */
    public Builder begin(long begin) {
      this.begin = begin;
      return this;
    }

    /**
     * Set the end.
     *
     * @param end the end
     * @return the SentenceModel builder
     */
    public Builder end(long end) {
      this.end = end;
      return this;
    }

    /**
     * Set the timestamp.
     *
     * @param timestamp the timestamp
     * @return the SentenceModel builder
     */
    public Builder timestamp(long timestamp) {
      this.timestamp = timestamp;
      return this;
    }
  }

  protected SentenceModel(Builder builder) {
    documentSection = builder.documentSection;
    text = builder.text;
    begin = builder.begin;
    end = builder.end;
    timestamp = builder.timestamp;
  }

  /**
   * New builder.
   *
   * @return a SentenceModel builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the documentSection.
   *
   * Document section for sentence.
   *
   * @return the documentSection
   */
  public String documentSection() {
    return documentSection;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public StringBuilder text() {
    return text;
  }

  /**
   * Gets the begin.
   *
   * Starting sentence offset.
   *
   * @return the begin
   */
  public Long begin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * Ending sentence offset.
   *
   * @return the end
   */
  public Long end() {
    return end;
  }

  /**
   * Gets the timestamp.
   *
   * Timestamp of sentence in video transcript.
   *
   * @return the timestamp
   */
  public Long timestamp() {
    return timestamp;
  }
}

