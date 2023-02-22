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
 * CancerDiagnosis.
 */
public class CancerDiagnosis extends DynamicModel<Object> {
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
  @SerializedName("cui")
  protected Long cui;
  @SerializedName("negated")
  protected Boolean negated;
  @SerializedName("hypohetical")
  protected Boolean hypothetical;
  @SerializedName("sectionNormalizedName")
  protected String sectionNormalizedName;
  @SerializedName("modality")
  protected String modality;
  @SerializedName("sectionSurfaceForm")
  protected String sectionSurfaceForm;
  @SerializedName("disambiguationData")
  protected Disambiguation disambiguationData;
  @SerializedName("cancer")
  protected List<Map> cancer;


  public CancerDiagnosis() {
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
   * Gets the cui.
   *
   * @return the cui
   */
  public Long getCui() {
    return this.cui;
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
   * Gets the sectionNormalizedName.
   *
   * @return the sectionNormalizedName
   */
  public String getSectionNormalizedName() {
    return this.sectionNormalizedName;
  }

  /**
   * Gets the modality.
   *
   * @return the modality
   */
  public String getModality() {
    return this.modality;
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
   * Gets the disambiguationData.
   *
   * @return the disambiguationData
   */
  public Disambiguation getDisambiguationData() {
    return this.disambiguationData;
  }

  /**
   * Gets the cancer.
   *
   * @return the cancer
   */
  public List<CustomCollection> getCancer() {
    List<Object> listCancer = new ArrayList<Object>();
    for (Map map : this.cancer) {
    	Gson gson = new Gson();
    	JsonElement jsonElement = gson.toJsonTree(map);
    	Object mapObj = gson.fromJson(jsonElement, Object.class);
    	listCancer.add(mapObj);
    }
    CustomCollection customCollection = new CustomCollection();
    return customCollection.convertToCustomCollectionList(listCancer);
  }

  public CustomCollection getCancer(int index) {
    List<Object> listCancer = new ArrayList<Object>();
    for (Map map : this.cancer) {
    	Gson gson = new Gson();
    	JsonElement jsonElement = gson.toJsonTree(map);
    	Object mapObj = gson.fromJson(jsonElement, Object.class);
    	listCancer.add(mapObj);
    }
    CustomCollection customCollection = new CustomCollection();
    return customCollection.convertToCustomCollection(listCancer.get(index));
  }

  /**
   * Returns the value from CancerDiagnosis annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = CancerDiagnosis.class.getDeclaredField(key);
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
