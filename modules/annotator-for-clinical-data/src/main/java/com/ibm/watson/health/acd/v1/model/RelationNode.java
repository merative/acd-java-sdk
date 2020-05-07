/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;


public class RelationNode extends GenericModel {

  private Reference entityType;

  /**
   * Gets the entity.
   *
   * @return the begin
   */
  public Reference getEntity() {
    return entityType;
  }

//  /**
//   * Sets the entity.
//   * @param begin the new begin
//   */
//  public void setEntity(final Reference begin) {
//    this.put("entity", begin);
//  }

}
