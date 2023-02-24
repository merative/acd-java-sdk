/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import java.lang.reflect.Field;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Spell corrected text.
 */
public class SpellCorrectedText extends DynamicModel<Object> {

  @SerializedName("correctedText")
  protected String correctedText;
  @SerializedName("debugText")
  protected String debugText;

  public SpellCorrectedText() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the correctedText.
   *
   * @return the correctedText
   */
  public String getCorrectedText() {
    return this.correctedText;
  }

  /**
   * Gets the debugText.
   *
   * @return the debugText
   */
  public String getDebugText() {
    return this.debugText;
  }

  /**
   * Returns the value from SpellCorrectedText annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = SpellCorrectedText.class.getDeclaredField(key);
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
