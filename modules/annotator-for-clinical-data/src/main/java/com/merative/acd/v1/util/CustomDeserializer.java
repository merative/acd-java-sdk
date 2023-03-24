/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.util.GsonSingleton;


/**
 * CustomDeserializer
 *
 * To deserialize the response.
 *
 * This class is manually written and not generated from swagger codegen.
 * */


public class CustomDeserializer {

  /** @param response api response
   *
   * @return the {@link JsonObject}
   */

  public JsonObject convertJsonObject(String response) {
    Gson gson = GsonSingleton.getGson();
    JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
    return jsonObject;

  }

  /** @param response api response
   *
   * @return the {@link CustomCollection}
   */

  public CustomCollection convertObject(String response) {
    CustomCollection cd = new CustomCollection();
    JsonElement jsonObject = GsonSingleton.getGson().fromJson(response, JsonElement.class);
    cd.setObject(jsonObject);
    return cd;
  }

}
