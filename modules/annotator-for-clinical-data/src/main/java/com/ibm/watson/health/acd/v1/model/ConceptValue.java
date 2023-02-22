/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

/**
 * ConceptValue.
 */
public class ConceptValue extends DynamicModel<Object> {
  @SerializedName("id")
  protected String id;
  @SerializedName("type")
  protected String type;
  @SerializedName("uid")
  protected Long uid;
  @SerializedName("begin")
  protected Long begin;
  @SerializedName("end")
  protected Long end;
  @SerializedName("coveredText")
  protected String coveredText;
  @SerializedName("negated")
  protected Boolean negated;
  @SerializedName("hypothetical")
  protected Boolean hypothetical;
  @SerializedName("cui")
  protected String cui;
  @SerializedName("dimension")
  protected String dimension;
  @SerializedName("preferredName")
  protected String preferredName;
  @SerializedName("trigger")
  protected String trigger;
  @SerializedName("source")
  protected String source;
  @SerializedName("value")
  protected String value;
  @SerializedName("sectionNormalizedName")
  protected String sectionNormalizedName;
  @SerializedName("sectionSurfaceForm")
  protected String sectionSurfaceForm;
  @SerializedName("ruleId")
  protected String ruleId;
  @SerializedName("derivedFrom")
  protected List<Concept> derivedFrom;
  @SerializedName("unit")
  protected String unit;
  @SerializedName("values")
  protected List<Map> values;
  @SerializedName("rangeBegin")
  protected String rangeBegin;
  @SerializedName("rangeEnd")
  protected String rangeEnd;

  public ConceptValue() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return this.id;
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
   * Gets the uid.
   *
   * @return the uid
   */
  public Long getUid() {
    return this.uid;
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
   * Gets the negated.
   *
   * @return the negated
   */
  public Boolean isNegated() {
    Boolean negated = this.negated;
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
    Boolean hypothetical = this.hypothetical;
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
    return this.cui;
  }

  /**
   * Gets the dimension.
   *
   * @return the dimension
   */
  public String getDimension() {
    return this.dimension;
  }

  /**
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return this.preferredName;
  }

  /**
   * Gets the trigger.
   *
   * @return the trigger
   */
  public String getTrigger() {
    return this.trigger;
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return this.source;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return this.value;
  }

  /**
   * Gets the sectionNormalizedName.
   *
   * @return the sectionNormalizedName
   */
  public String getSectionNormalizedName() {
    return this.sectionNormalizedName;
  }

  /**
   * Gets the sectionSurfaceForm.
   *
   * @return the sectionSurfaceForm
   */
  public String getSectionSurfaceForm() {
    return this.sectionSurfaceForm;
  }

  /**
   * Gets the ruleId.
   *
   * @return the ruleId
   */
  public String getRuleId() {
    return this.ruleId;
  }

  /**
   * Gets the derivedFrom.
   *
   * @return the derivedFrom
   */
  public List<Concept> getDerivedFrom() {
	  return this.derivedFrom;
  }

  /**
   * Gets the unit.
   *
   * @return the unit
   */
  public String getUnit() {
    return this.unit;
  }

  /**
   * Gets the values.
   *
   * @return the values
   */
  public List<CustomCollection> getValues() {
    List<Object> listObjects = new ArrayList<Object>();
    for (Map map : this.values) {
    	Gson gson = new Gson();
    	JsonElement jsonElement = gson.toJsonTree(map);
    	Object mapObj = gson.fromJson(jsonElement, Object.class);
    	listObjects.add(mapObj);
    }
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
    return this.rangeBegin;
  }

  /**
   * Gets the rangeEnd.
   *
   * @return the rangeEnd
   */
  public String getRangeEnd() {
    return this.rangeEnd;
  }

  /**
   * Returns the value from ConceptValue annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = ConceptValue.class.getDeclaredField(key);
			  value = field.get(this);
		  } catch (NoSuchFieldException e) {
			  return null;
		  } catch (Exception e1) {
			  e1.printStackTrace();
		  }
	  }
	  return value;
  }

}
