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

import java.lang.reflect.Field;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Smoking.
 */
public class Smoking extends DynamicModel<Object> {
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
  @SerializedName("participation")
  protected String participation;
  @SerializedName("sectionNormalizedName")
  protected String sectionNormalizedName;
  @SerializedName("modality")
  protected String modality;
  @SerializedName("current")
  protected String current;
  @SerializedName("smokeTermSurfaceForm")
  protected String smokeTermSurfaceForm;
  @SerializedName("smokeTermNormalizedName")
  protected String smokeTermNormalizedName;
  @SerializedName("sectionSurfaceForm")
  protected String sectionSurfaceForm;
  @SerializedName("illicitDrugNormalizedName")
  protected String illicitDrugNormalizedName;
  @SerializedName("illicitDrugSurfaceForm")
  protected String illicitDrugSurfaceForm;
  @SerializedName("smokeSubstanceNormalizedName")
  protected String smokeSubstanceNormalizedName;
  @SerializedName("smokeSubstanceSurfaceForm")
  protected String smokeSubstanceSurfaceForm;
  @SerializedName("duration")
  protected String duration;

  public Smoking() {
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
   * Gets the participation.
   *
   * @return the participation
   */
  public String getParticipation() {
    return this.participation;
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
   * Gets the current.
   *
   * @return the current
   */
  public String getCurrent() {
    return this.current;
  }

  /**
   * Gets the smokeTermSurfaceForm.
   *
   * @return the smokeTermSurfaceForm
   */
  public String getSmokeTermSurfaceForm() {
    return this.smokeTermSurfaceForm;
  }

  /**
   * Gets the smokeTermNormalizedName.
   *
   * @return the smokeTermNormalizedName
   */
  public String getSmokeTermNormalizedName() {
    return this.smokeTermNormalizedName;
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
   * Gets the illicitDrugNormalizedName.
   *
   * @return the illicitDrugNormalizedName
   */
  public String getIllicitDrugNormalizedName() {
    return this.illicitDrugNormalizedName;
  }

  /**
   * Gets the illicitDrugSurfaceForm.
   *
   * @return the illicitDrugSurfaceForm
   */
  public String getIllicitDrugSurfaceForm() {
    return this.illicitDrugSurfaceForm;
  }

  /**
   * Gets the smokeSubstanceNormalizedName.
   *
   * @return the smokeSubstanceNormalizedName
   */
  public String getSmokeSubstanceNormalizedName() {
    return this.smokeSubstanceNormalizedName;
  }

  /**
   * Gets the smokeSubstanceSurfaceForm.
   *
   * @return the smokeSubstanceSurfaceForm
   */
  public String getSmokeSubstanceSurfaceForm() {
    return this.smokeSubstanceSurfaceForm;
  }

  /**
   * Gets the duration.
   *
   * @return the duration
   */
  public String getDuration() {
    return this.duration;
  }

  /**
   * Returns the value from Smoking annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = Smoking.class.getDeclaredField(key);
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
