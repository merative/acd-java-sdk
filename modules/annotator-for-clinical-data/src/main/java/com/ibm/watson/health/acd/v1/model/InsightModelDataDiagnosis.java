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
 * InsightModelData Diagnosis.
 */
public class InsightModelDataDiagnosis extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelDataUsage usage;
  @SerializedName("suspectedScore")
  protected Float suspectedScore;
  @SerializedName("symptomScore")
  protected Float symptomScore;
  @SerializedName("traumaScore")
  protected Float traumaScore;
  @SerializedName("familyHistoryScore")
  protected Float familyHistoryScore;
  @SerializedName("modifiers")
  protected InsightModelDataDiagnosisModifier modifiers;

  public InsightModelDataDiagnosis() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataUsage getUsage() {
    return this.usage;
  }

  /**
   * Gets the suspectedScore.
   *
   * @return the suspectedScore
   */
  public Float getSuspectedScore() {
	  return this.suspectedScore;
  }

  /**
   * Gets the symptomScore.
   *
   * @return the symptomScore
   */
  public Float getSymptomScore() {
	  return this.symptomScore;
  }

  /**
   * Gets the traumaScore.
   *
   * @return the traumaScore
   */
  public Float getTraumaScore() {
	  return this.traumaScore;
  }

  /**
   * Gets the familyHistoryScore.
   *
   * @return the familyHistoryScore
   */
  public Float getFamilyHistoryScore() {
	  return this.familyHistoryScore;
  }

  /**
   * Gets the modifiers.
   *
   * @return the modifiers
   */
  public InsightModelDataDiagnosisModifier getModifiers() {
    return this.modifiers;
  }

  /**
   * Returns the value from InsightModelDataDiagnosis annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataDiagnosis.class.getDeclaredField(key);
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
