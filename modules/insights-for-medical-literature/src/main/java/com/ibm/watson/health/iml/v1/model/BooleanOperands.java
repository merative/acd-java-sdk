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
package com.ibm.watson.health.iml.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representingn boolean operands search criteria.
 */
public class BooleanOperands extends GenericModel {

  protected String boolExpression;
  protected List<BoolOperand> boolOperands;

  /**
   * Gets the boolExpression.
   *
   * Boolean search condition.
   *
   * @return the boolExpression
   */
  public String getBoolExpression() {
    return boolExpression;
  }

  /**
   * Gets the boolOperands.
   *
   * Ontology artifacts supporing boolean search condition.
   *
   * @return the boolOperands
   */
  public List<BoolOperand> getBoolOperands() {
    return boolOperands;
  }
}

