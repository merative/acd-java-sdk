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
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

/**
 * ConceptValue.
 */
public class ConceptValue extends DynamicModel {
  private Type idType = new TypeToken<String>() { } .getType();
  private Type typeType = new TypeToken<String>() { } .getType();
  private Type uidType = new TypeToken<Long>() { } .getType();
  private Type beginType = new TypeToken<Long>() { } .getType();
  private Type endType = new TypeToken<Long>() { } .getType();
  private Type coveredTextType = new TypeToken<String>() { } .getType();
  private Type negatedType = new TypeToken<Boolean>() { } .getType();
  private Type hypotheticalType = new TypeToken<Boolean>() { } .getType();
  private Type cuiType = new TypeToken<String>() { } .getType();
  private Type dimensionType = new TypeToken<String>() { } .getType();
  private Type preferredNameType = new TypeToken<String>() { } .getType();
  private Type triggerType = new TypeToken<String>() { } .getType();
  private Type sourceType = new TypeToken<String>() { } .getType();
  private Type valueType = new TypeToken<String>() { } .getType();
  private Type sectionNormalizedNameType = new TypeToken<String>() { } .getType();
  private Type sectionSurfaceFormType = new TypeToken<String>() { } .getType();
  private Type ruleIdType = new TypeToken<String>() { } .getType();
  private Type derivedFromType = new TypeToken<List<Concept>>() { } .getType();
  private Type unitType = new TypeToken<String>() { } .getType();
  private Type valuesType = new TypeToken<List<Map>>() { } .getType();
  private Type rangeBeginType = new TypeToken<String>() { } .getType();
  private Type rangeEndType = new TypeToken<String>() { } .getType();

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("id"), idType);
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
   * Gets the uid.
   *
   * @return the uid
   */
  public Long getUid() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("uid"), uidType);
  }

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
   * Gets the negated.
   *
   * @return the negated
   */
  public Boolean isNegated() {
    Boolean negated = GsonSerializationHelper.serializeDynamicModelProperty(this.get("negated"), negatedType);
    if (negated == null) {
      negated = false;
    }
    return negated;
  }

  /**
   * Gets the hypothetical.
   *
   * @return the hypothetical
   */
  public Boolean isHypothetical() {
    Boolean hypothetical = GsonSerializationHelper.serializeDynamicModelProperty(this.get("hypothetical"), hypotheticalType);
    if (hypothetical == null) {
      hypothetical = false;
    }
    return hypothetical;
  }

  /**
   * Gets the cui.
   *
   * @return the cui
   */
  public String getCui() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("cui"), cuiType);
  }

  /**
   * Gets the dimension.
   *
   * @return the dimension
   */
  public String getDimension() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("dimension"), dimensionType);
  }

  /**
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("preferredName"), preferredNameType);
  }

  /**
   * Gets the trigger.
   *
   * @return the trigger
   */
  public String getTrigger() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("trigger"), triggerType);
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("source"), sourceType);
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("value"), valueType);
  }

  /**
   * Gets the sectionNormalizedName.
   *
   * @return the sectionNormalizedName
   */
  public String getSectionNormalizedName() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("sectionNormalizedName"), sectionNormalizedNameType);
  }

  /**
   * Gets the sectionSurfaceForm.
   *
   * @return the sectionSurfaceForm
   */
  public String getSectionSurfaceForm() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("sectionSurfaceForm"), sectionSurfaceFormType);
  }

  /**
   * Gets the ruleId.
   *
   * @return the ruleId
   */
  public String getRuleId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("ruleId"), ruleIdType);
  }

  /**
   * Gets the derivedFrom.
   *
   * @return the derivedFrom
   */
  public List<Concept> getDerivedFrom() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("derivedFrom"), derivedFromType);
  }

  /**
   * Gets the unit.
   *
   * @return the unit
   */
  public String getUnit() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("unit"), unitType);
  }

  /**
   * Gets the values.
   *
   * @return the values
   */
  public List<CustomCollection> getValues() {
    List<Object> listObjects = GsonSerializationHelper.serializeDynamicModelProperty(this.get("values"), valuesType);
    CustomCollection customCollection = new CustomCollection();
    List<CustomCollection> listValues = customCollection.convertToCustomCollectionList(listObjects);
    return listValues;
  }

  /**
   * Gets the rangeBegin.
   *
   * @return the rangeBegin
   */
  public String getRangeBegin() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("rangeBegin"), rangeBeginType);
  }

  /**
   * Gets the rangeEnd.
   *
   * @return the rangeEnd
   */
  public String getRangeEnd() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("rangeEnd"), rangeEndType);
  }

//  /**
//   * Sets the id.
//   *
//   * @param id the new id
//   */
//  public void setId(final String id) {
//    this.put("id", id);
//  }
//
//  /**
//   * Sets the type.
//   *
//   * @param type the new type
//   */
//  public void setType(final String type) {
//    this.put("type", type);
//  }
//
//  /**
//   * Sets the uid.
//   *
//   * @param uid the new uid
//   */
//  public void setUid(final Long uid) {
//    this.put("uid", uid);
//  }
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
//   * Sets the negated.
//   *
//   * @param negated the new negated
//   */
//  public void setNegated(final Boolean negated) {
//    this.put("negated", negated);
//  }
//
//  /**
//   * Sets the hypothetical.
//   *
//   * @param hypothetical the new hypothetical
//   */
//  public void setHypothetical(final Boolean hypothetical) {
//    this.put("hypothetical", hypothetical);
//  }
//
//  /**
//   * Sets the cui.
//   *
//   * @param cui the new cui
//   */
//  public void setCui(final String cui) {
//    this.put("cui", cui);
//  }
//
//  /**
//   * Sets the dimension.
//   *
//   * @param dimension the new dimension
//   */
//  public void setDimension(final String dimension) {
//    this.put("dimension", dimension);
//  }
//
//  /**
//   * Sets the preferredName.
//   *
//   * @param preferredName the new preferredName
//   */
//  public void setPreferredName(final String preferredName) {
//    this.put("preferredName", preferredName);
//  }
//
//  /**
//   * Sets the trigger.
//   *
//   * @param trigger the new trigger
//   */
//  public void setTrigger(final String trigger) {
//    this.put("trigger", trigger);
//  }
//
//  /**
//   * Sets the source.
//   *
//   * @param source the new source
//   */
//  public void setSource(final String source) {
//    this.put("source", source);
//  }
//
//  /**
//   * Sets the value.
//   *
//   * @param value the new value
//   */
//  public void setValue(final String value) {
//    this.put("value", value);
//  }
//
//  /**
//   * Sets the sectionSurfaceForm.
//   *
//   * @param sectionSurfaceForm the new sectionSurfaceForm
//   */
//  public void setSectionSurfaceForm(final String sectionSurfaceForm) {
//    this.put("sectionSurfaceForm", sectionSurfaceForm);
//  }
//
//  /**
//   * Sets the sectionNormalizedName.
//   *
//   * @param sectionNormalizedName the new sectionNormalizedName
//   */
//  public void setSectionNormalizedName(final String sectionNormalizedName) {
//    this.put("sectionNormalizedName", sectionNormalizedName);
//  }
//
//  /**
//   * Sets the ruleId.
//   *
//   * @param ruleId the new ruleId
//   */
//  public void setRuleId(final String ruleId) {
//    this.put("ruleId", ruleId);
//  }
//
//  /**
//   * Sets the derivedFrom.
//   *
//   * @param derivedFrom the new derivedFrom
//   */
//  public void setDerivedFrom(final List<Concept> derivedFrom) {
//    this.put("derivedFrom", derivedFrom);
//  }
//
//  /**
//   * Sets the unit.
//   *
//   * @param unit the new unit
//   */
//  public void setUnit(final String unit) {
//    this.put("unit", unit);
//  }
//
//  /**
//   * Sets the values.
//   *
//   * @param values the new values
//   */
//  public void setValues(final List<Map> values) {
//    this.put("values", values);
//  }
//
//  /**
//   * Sets the rangeBegin.
//   *
//   * @param rangeBegin the new rangeBegin
//   */
//  public void setRangeBegin(final String rangeBegin) {
//    this.put("rangeBegin", rangeBegin);
//  }
//
//  /**
//   * Sets the rangeEnd.
//   *
//   * @param rangeEnd the new rangeEnd
//   */
//  public void setRangeEnd(final String rangeEnd) {
//    this.put("rangeEnd", rangeEnd);
//  }

}
