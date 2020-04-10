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
package com.ibm.watson.health.acd.v1.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * CustomDeserializer
 *
 * To deserialize the response.
 *
 * This class is manually written and not generated from swagger codegen.
 * */


public class CustomDeserializer {

  /** @param response
   *
   * @return the {@link JsonObject}
   */

  public JsonObject convertJsonObject(String response) {
    CustomDeserializer cd = new CustomDeserializer();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
    return jsonObject;

  }

  /** @param response
   *
   * @return the {@link CustomCollection}
   */

  public CustomCollection convertObject(String response) {
    CustomCollection cd = new CustomCollection();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonElement jsonObject = gson.fromJson(response, JsonElement.class);
    cd.setObject(jsonObject);
    return cd;
  }





}
