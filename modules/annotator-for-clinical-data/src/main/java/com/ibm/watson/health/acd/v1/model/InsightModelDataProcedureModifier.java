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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * InsightModelData Modifier.
 */
public class InsightModelDataProcedureModifier extends DynamicModel<Object> {

  @SerializedName("associatedDiagnoses")
  protected List<InsightModelDataEvidence> associatedDiagnoses;
  @SerializedName("sites")
  protected List<InsightModelDataSite> sites;

  public InsightModelDataProcedureModifier() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the associatedDiagnoses.
   *
   * @return the associatedDiagnoses
   */
  public List<InsightModelDataEvidence> getAssociatedDiagnoses() {
	  return this.associatedDiagnoses;
  }

  /**
   * Gets the sites.
   *
   * @return the sites
   */
  public List<InsightModelDataSite> getSites() {
	  return this.sites;
  }

  /**
   * Returns the value from InsightModelDataProcedureModifier annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataProcedureModifier.class.getDeclaredField(key);
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
