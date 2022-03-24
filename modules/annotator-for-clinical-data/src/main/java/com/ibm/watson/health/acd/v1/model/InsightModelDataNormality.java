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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * InsightModelData Normality.
 */
public class InsightModelDataNormality extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelDataNormalityUsage usage;
  @SerializedName("evidence")
  protected List<InsightModelDataEvidence> evidence;
  @SerializedName("directlyAffectedScore")
  protected Float directlyAffectedScore;

  public InsightModelDataNormality() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataNormalityUsage getUsage() {
    return this.usage;
  }

  /**
   * Gets the evidence.
   *
   * @return the evidence
   */
  public List<InsightModelDataEvidence> getEvidence() {
    return this.evidence;
  }

  /**
   * Gets the directlyAffectedScore.
   *
   * @return the directlyAffectedScore
   */
  public Float getDirectlyAffectedScore() {
	  return this.directlyAffectedScore;
  }

  /**
   * Returns the value from InsightModelDataNormality annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataNormality.class.getDeclaredField(key);
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
