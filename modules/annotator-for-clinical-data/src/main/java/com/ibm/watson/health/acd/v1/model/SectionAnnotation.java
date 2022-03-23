/*
 * Copyright 2018, 2022 IBM Corp. All Rights Reserved.
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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * SectionAnnotation.
 */
public class SectionAnnotation extends DynamicModel<Object> {

  @SerializedName("begin")
  protected Long begin;
  @SerializedName("end")
  protected Long end;
  @SerializedName("type")
  protected String type;
  @SerializedName("coveredText")
  protected String coveredText;
  @SerializedName("sectionType")
  protected String sectionType;
  @SerializedName("trigger")
  protected SectionTrigger sectionTrigger;

  public SectionAnnotation() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the begin.
   *
   * @return the begin
   */
  public Long getBegin() {
    return this.begin;
  }

  /**
   * Gets the end.
   *
   * @return the end
   */
  public Long getEnd() {
    return this.end;
  }


  /**
   * Gets the sectionTrigger.
   * @return the sectionTrigger
   */
  public SectionTrigger getTrigger() {
    return this.sectionTrigger;
  }


  /**
   * Gets the coveredText.
   *
   * @return the coveredText
   */
  public String getCoveredText() {
    return this.coveredText;
  }


  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return this.type;
  }

  /**
   * Gets the section type.
   *
   * @return the section type
   */
  public String getSectionType() {
    return this.sectionType;
  }

}
