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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

/**
 * Temporal.
 */
public class Temporal extends DynamicModel<Object> {
  @SerializedName("begin")
  protected Long begin;
  @SerializedName("end")
  protected Long end;
  @SerializedName("coveredText")
  protected String coveredText;
  @SerializedName("temporalType")
  protected Map temporalType;
  @SerializedName("relationTypes")
  protected Map relationTypes;

  public Temporal() {
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
   * Gets the coveredText.
   *
   * @return the coveredText
   */
  public String getCoveredText() {
    return this.coveredText;
  }

  /**
   * Gets the temporal type.
   *
   * @return the temporal type
   */
  public CustomCollection getTemporalType() {
    Object temporalTypeObject = this.temporalType;
    CustomCollection customCollection = new CustomCollection();
    return customCollection.convertToCustomCollection(temporalTypeObject);
  }

  /**
   * Gets the temporal type map.
   *
   * @return the temporal type map
   */
  public Map getTemporalTypeMap() {
    return this.temporalType;
  }

  /**
   * Gets the relation types.
   *
   * @return the relation types
   */
  public CustomCollection getRelationTypes() {
    Object relationTypesObject = this.relationTypes;
    CustomCollection customCollection = new CustomCollection();
    return customCollection.convertToCustomCollection(relationTypesObject);
  }

  /**
   * Gets the relation types map.
   *
   * @return the relation types map
   */
  public Map getRelationTypesMap() {
    return this.relationTypes;
  }

}
