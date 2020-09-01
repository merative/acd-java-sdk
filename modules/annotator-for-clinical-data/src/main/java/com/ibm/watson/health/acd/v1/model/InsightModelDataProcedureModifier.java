/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * InsightModelData Modifier.
 */
public class InsightModelDataProcedureModifier extends DynamicModel {

  private Type associatedDiagnosesType = new TypeToken<List<InsightModelDataEvidence>>() { } .getType();
  private Type sitesType = new TypeToken<List<InsightModelDataSite>>() { } .getType();

  /**
   * Gets the associatedDiagnoses.
   *
   * @return the associatedDiagnoses
   */
  public List<InsightModelDataEvidence> getAssociatedDiagnoses() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("associatedDiagnoses"), associatedDiagnosesType);
  }

  /**
   * Gets the sites.
   *
   * @return the sites
   */
  public List<InsightModelDataSite> getSites() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("sites"), sitesType);
  }

//  /**
//   * Sets the associatedDiagnoses.
//   *
//   * @param associatedDiagnoses the new associatedDiagnoses
//   */
//  public void setAssociatedDiagnoses(final List<InsightModelDataEvidence> associatedDiagnoses) {
//    this.put("associatedDiagnoses", associatedDiagnoses);
//  }
//
//  /**
//   * Sets the sites.
//   *
//   * @param sites the new sites
//   */
//  public void setSites(final List<InsightModelDataSite> sites) {
//    this.put("sites", sites);
//  }

}
