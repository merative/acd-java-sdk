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

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;


/**
 * SectionAnnotation.
 */
public class SectionAnnotation extends DynamicModel {


  private Type beginType = new TypeToken<Long>() { } .getType();
  private Type endType = new TypeToken<Long>() { } .getType();
  private Type typeType = new TypeToken<String>() { } .getType();
  private Type coveredTextType = new TypeToken<String>() { } .getType();
  private Type sectionType = new TypeToken<String>() { } .getType();
  private Type sectionTriggerType = new TypeToken<SectionTrigger>() { } .getType();










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
   * Gets the sectionTrigger.
   * @return the sectionTrigger
   */
  public SectionTrigger getTrigger() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("trigger"), sectionTriggerType);
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
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("type"), typeType);
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getSectionType() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("sectionType"), typeType);
  }



//  /**
//   * Sets the begin.
//   * @param begin the new begin
//   */
//  public void setBegin(final Long begin) {
//    this.put("begin", begin);
//  }
//
//  /**
//   * Sets the end.
//   * @param end the new end
//   */
//  public void setEnd(final Long end) {
//    this.put("end", end);
//  }
//
//  /**
//   * Sets the type.
//   * @param type the new type
//   */
//  public void setType(final String type) {
//    this.put("type", type);
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
//
//  public void setTrigger(final SectionTrigger sectionTrigger) {
//      this.put("trigger", sectionTrigger);
//  }
//
//  /**
//   * Sets the type.
//   * @param type the new type
//   */
//  public void setSectionType(final String sectionType) {
//    this.put("sectionType", sectionType);
//  }

}
