/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
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
 * MedicationAnnotation.
 */
public class MedicationAnnotation extends DynamicModel<Object> {
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
  @SerializedName("sectionNormalizedName")
  protected String sectionNormalizedName;
  @SerializedName("cui")
  protected String cui;
  @SerializedName("drug")
  protected List<Map> drug;
  @SerializedName("sectionSurfaceForm")
  protected String sectionSurfaceForm;
  @SerializedName("insightModelData")
  protected InsightModelData insightModelData;
  @SerializedName("temporal")
  protected List<Temporal> temporal;
  @SerializedName("disambiguationData")
  protected Disambiguation disambiguationData;

  public MedicationAnnotation() {
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
    return this.negated;
  }

  /**
   * Gets the hypothetical.
   *
   * @return the hypothetical
   */
  public Boolean isHypothetical() {
    return this.hypothetical;
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
   * Gets the cui.
   *
   * @return the cui
   */
  public String getCui() {
    return this.cui;
  }

  /**
   * Gets the drug.
   *
   * @return the drug
   */
  public List<CustomCollection> getDrug() {
    List<Object> listObjects = new ArrayList<Object>();
    for (Map map : this.drug) {
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
   * Gets the sectionSurfaceForm.
   *
   * @return the sectionSurfaceForm
   */
  public String getSectionSurfaceForm() {
    return this.sectionSurfaceForm;
  }

  /**
   * Gets the insightModelData.
   * @return the insightModelData
   */
  public InsightModelData getInsightModelData() {
    return this.insightModelData;
  }

  /**
   * Gets the temporal.
   *
   * @return the temporal
   */
  public List<Temporal> getTemporal() {
	  return this.temporal;
  }

  /**
   * Gets the disambiguationData.
   *
   * @return the disambiguationData
   */
  public Disambiguation getDisambiguationData() {
    return this.disambiguationData;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }

  /**
   * Sets the uid.
   *
   * @param uid the new uid
   */
  public void setUid(final Long uid) {
    this.uid = uid;
  }

  /**
   * Sets the begin.
   *
   * @param begin the new begin
   */
  public void setBegin(final Long begin) {
    this.begin = begin;
  }

  /**
   * Sets the end.
   *
   * @param end the new end
   */
  public void setEnd(final Long end) {
    this.end = end;
  }

  /**
   * Sets the coveredText.
   *
   * @param coveredText the new coveredText
   */
  public void setCoveredText(final String coveredText) {
    this.coveredText = coveredText;
  }

  /**
   * Sets the negated.
   *
   * @param negated the new negated
   */
  public void setNegated(final Boolean negated) {
    this.negated = negated;
  }

  /**
   * Sets the hypothetical.
   *
   * @param hypothetical the new hypothetical
   */
  public void setHypothetical(final Boolean hypothetical) {
    this.hypothetical = hypothetical;
  }

  /**
   * Sets the sectionNormalizedName.
   *
   * @param sectionNormalizedName the new sectionNormalizedName
   */
  public void setSectionNormalizedName(final String sectionNormalizedName) {
    this.sectionNormalizedName = sectionNormalizedName;
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
   * Sets the drug.
   *
   * @param drug the new drug
   */
  public void setDrug(final List<Map> drug) {
    this.drug = drug;
  }

  /**
   * Sets the sectionSurfaceForm.
   *
   * @param sectionSurfaceForm the new sectionSurfaceForm
   */
  public void setSectionSurfaceForm(final String sectionSurfaceForm) {
    this.sectionSurfaceForm = sectionSurfaceForm;
  }

  /**
   * Sets the insightModelData.
   *
   * @param insightModelData the new insightModelData
   */
  public void setInsightModelData(final InsightModelData insightModelData) {
      this.insightModelData = insightModelData;
  }

  /**
   * Sets the temporal.
   *
   * @param temporal the new temporal
   */
  public void setTemporal(final List<Temporal> temporal) {
    this.temporal = temporal;
  }

  /**
   * Sets the disambiguationData.
   *
   * @param disambiguationData the new disambiguationData
   */
  public void setDisambiguationData(final Disambiguation disambiguationData) {
      this.disambiguationData = disambiguationData;
  }

/*
 *
 * Manually Added code
 *
 * */
  public CustomCollection getDrug(int index) {
	List<Object> listObjects = new ArrayList<Object>();
    for (Map map : this.drug) {
    	Gson gson = new Gson();
    	JsonElement jsonElement = gson.toJsonTree(map);
    	Object mapObj = gson.fromJson(jsonElement, Object.class);
    	listObjects.add(mapObj);
    }
    CustomCollection customCollection = new CustomCollection();
    CustomCollection drug = customCollection.convertToCustomCollection(listObjects.get(index));
    return drug;
  }

  /**
   * Returns the value from MedicationAnnotation annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = MedicationAnnotation.class.getDeclaredField(key);
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
