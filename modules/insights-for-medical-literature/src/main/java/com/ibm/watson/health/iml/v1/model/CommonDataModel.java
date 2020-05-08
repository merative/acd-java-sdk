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
 * Model representing common data across annotations.
 */
public class CommonDataModel extends GenericModel {

  protected List<UnstructuredModel> unstructured;

  /**
   * Gets the unstructured.
   *
   * Object of all ontology artifacts found in the document.
   *
   * @return the unstructured
   */
  public List<UnstructuredModel> getUnstructured() {
    return unstructured;
  }
}

