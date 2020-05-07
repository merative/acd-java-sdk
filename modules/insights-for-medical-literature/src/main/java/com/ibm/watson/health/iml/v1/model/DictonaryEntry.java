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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DictonaryEntry.
 */
public class DictonaryEntry extends GenericModel {

  private List<String> children;
  private String cui;
  private List<String> definition;
  private List<String> parents;
  private String preferredName;
  private List<String> semtypes;
  private List<String> siblings;
  private List<String> surfaceForms;
  private List<String> variants;
  private String vocab;
  private List<String> related;
  private String source;
  @SerializedName("source_version")
  private String sourceVersion;

  /**
   * Gets the children.
   *
   * @return the children
   */
  public List<String> getChildren() {
    return children;
  }

  /**
   * Gets the cui.
   *
   * @return the cui
   */
  public String getCui() {
    return cui;
  }

  /**
   * Gets the definition.
   *
   * @return the definition
   */
  public List<String> getDefinition() {
    return definition;
  }

  /**
   * Gets the parents.
   *
   * @return the parents
   */
  public List<String> getParents() {
    return parents;
  }

  /**
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return preferredName;
  }

  /**
   * Gets the semtypes.
   *
   * @return the semtypes
   */
  public List<String> getSemtypes() {
    return semtypes;
  }

  /**
   * Gets the siblings.
   *
   * @return the siblings
   */
  public List<String> getSiblings() {
    return siblings;
  }

  /**
   * Gets the surfaceForms.
   *
   * @return the surfaceForms
   */
  public List<String> getSurfaceForms() {
    return surfaceForms;
  }

  /**
   * Gets the variants.
   *
   * @return the variants
   */
  public List<String> getVariants() {
    return variants;
  }

  /**
   * Gets the vocab.
   *
   * @return the vocab
   */
  public String getVocab() {
    return vocab;
  }

  /**
   * Gets the related.
   *
   * @return the related
   */
  public List<String> getRelated() {
    return related;
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the sourceVersion.
   *
   * @return the sourceVersion
   */
  public String getSourceVersion() {
    return sourceVersion;
  }

  /**
   * Sets the children.
   *
   * @param children the new children
   */
  public void setChildren(final List<String> children) {
    this.children = children;
  }

  /**
   * Sets the cui.
   *
   * @param cui the new cui
   */
  public void setCui(final String cui) {
    this.cui = cui;
  }

  /**
   * Sets the definition.
   *
   * @param definition the new definition
   */
  public void setDefinition(final List<String> definition) {
    this.definition = definition;
  }

  /**
   * Sets the parents.
   *
   * @param parents the new parents
   */
  public void setParents(final List<String> parents) {
    this.parents = parents;
  }

  /**
   * Sets the preferredName.
   *
   * @param preferredName the new preferredName
   */
  public void setPreferredName(final String preferredName) {
    this.preferredName = preferredName;
  }

  /**
   * Sets the semtypes.
   *
   * @param semtypes the new semtypes
   */
  public void setSemtypes(final List<String> semtypes) {
    this.semtypes = semtypes;
  }

  /**
   * Sets the siblings.
   *
   * @param siblings the new siblings
   */
  public void setSiblings(final List<String> siblings) {
    this.siblings = siblings;
  }

  /**
   * Sets the surfaceForms.
   *
   * @param surfaceForms the new surfaceForms
   */
  public void setSurfaceForms(final List<String> surfaceForms) {
    this.surfaceForms = surfaceForms;
  }

  /**
   * Sets the variants.
   *
   * @param variants the new variants
   */
  public void setVariants(final List<String> variants) {
    this.variants = variants;
  }

  /**
   * Sets the vocab.
   *
   * @param vocab the new vocab
   */
  public void setVocab(final String vocab) {
    this.vocab = vocab;
  }

  /**
   * Sets the related.
   *
   * @param related the new related
   */
  public void setRelated(final List<String> related) {
    this.related = related;
  }

  /**
   * Sets the source.
   *
   * @param source the new source
   */
  public void setSource(final String source) {
    this.source = source;
  }

  /**
   * Sets the sourceVersion.
   *
   * @param sourceVersion the new sourceVersion
   */
  public void setSourceVersion(final String sourceVersion) {
    this.sourceVersion = sourceVersion;
  }
}

