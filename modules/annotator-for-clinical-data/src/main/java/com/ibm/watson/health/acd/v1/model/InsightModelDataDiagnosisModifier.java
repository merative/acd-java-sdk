/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
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
 * InsightModelData Diagnosis Modifier .
 */
public class InsightModelDataDiagnosisModifier extends DynamicModel<Object> {

  @SerializedName("associatedProcedures")
  protected List<InsightModelDataEvidence> associatedProcedures;
  @SerializedName("sites")
  protected List<InsightModelDataSite> sites;

  public InsightModelDataDiagnosisModifier() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the associatedProcedures.
   *
   * @return the associatedProcedures
   */
  public List<InsightModelDataEvidence> getAssociatedProcedures() {
	  return this.associatedProcedures;
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
   * Returns the value from InsightModelDataDiagnosisModifier annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataDiagnosisModifier.class.getDeclaredField(key);
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
