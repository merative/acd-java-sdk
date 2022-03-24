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
 * InsightModelData Alcohol Usage.
 */
public class InsightModelAlcoholUsage extends DynamicModel<Object> {

  @SerializedName("useScore")
  protected Float useScore;
  @SerializedName("noneScore")
  protected Float noneScore;
  @SerializedName("unknownScore")
  protected Float unknownScore;
  @SerializedName("discussedScore")
  protected Float discussedScore;

  public InsightModelAlcoholUsage() {
	 super(new TypeToken<Object>() { });
  }

  /**
   * Gets the useScore.
   *
   * @return the useScore
   */
  public Float getUseScore() {
	  return this.useScore;
  }

  /**
   * Gets the noneScore.
   *
   * @return the noneScore
   */
  public Float getNoneScore() {
	  return this.noneScore;
  }

  /**
   * Gets the unknownScore.
   *
   * @return the unknownScore
   */
  public Float getUnknownScore() {
	  return this.unknownScore;
  }

  /**
   * Gets the discussedScore.
   *
   * @return the discussedScore
   */
  public Float getDiscussedScore() {
	  return this.discussedScore;
  }

  /**
   * Returns the value from InsightModelAlcoholUsage annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelAlcoholUsage.class.getDeclaredField(key);
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
