/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
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

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

/**
 * Temporal.
 */
public class Temporal extends DynamicModel {
  private Type beginType = new TypeToken<Long>() { } .getType();
  private Type endType = new TypeToken<Long>() { } .getType();
  private Type coveredTextType = new TypeToken<String>() { } .getType();
  private Type temporalTypeType = new TypeToken<Map>() { } .getType();
  private Type relationTypesType = new TypeToken<Map>() { } .getType();


  /**
   * Gets the begin.
   *
   * @return the begin
   */
  public Long getBegin() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("begin"), beginType);
  }

  /**
   * Gets the end.
   *
   * @return the end
   */
  public Long getEnd() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("end"), endType);
  }

  /**
   * Gets the coveredText.
   *
   * @return the coveredText
   */
  public String getCoveredText() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("coveredText"), coveredTextType);
  }

  /**
   * Gets the temporal type.
   *
   * @return the temporal type
   */
  public CustomCollection getTemporalType() {
    Object temporalTypeObject = GsonSerializationHelper.serializeDynamicModelProperty(this.get("temporalType"), temporalTypeType);
    CustomCollection customCollection = new CustomCollection();
    return customCollection.convertToCustomCollection(temporalTypeObject);
  }

  /**
   * Gets the relation types.
   *
   * @return the relation types
   */
  public CustomCollection getRelationTypes() {
    Object relationTypesObject = GsonSerializationHelper.serializeDynamicModelProperty(this.get("relationTypes"), relationTypesType);
    CustomCollection customCollection = new CustomCollection();
    return customCollection.convertToCustomCollection(relationTypesObject);
  }

//
//  /**
//   * Sets the begin.
//   *
//   * @param begin the new begin
//   */
//  public void setBegin(final Long begin) {
//    this.put("begin", begin);
//  }
//
//  /**
//   * Sets the end.
//   *
//   * @param end the new end
//   */
//  public void setEnd(final Long end) {
//    this.put("end", end);
//  }
//
//  /**
//   * Sets the coveredText.
//   *
//   * @param coveredText the new coveredText
//   */
//  public void setCoveredText(final String coveredText) {
//    this.put("coveredText", coveredText);
//  }
//
//  /**
//   * Sets the temporalType.
//   *
//   * @param temporalType the new temporalType
//   */
//  public void setTemporalType(final Map temporalType) {
//    this.put("temporalType", temporalType);
//  }
//
//  /**
//   * Sets the relationTypes.
//   *
//   * @param relationTypes the new relationTypes
//   */
//  public void setRelationTypes(final Map relationTypes) {
//    this.put("relationTypes", relationTypes);
//  }
//
}
