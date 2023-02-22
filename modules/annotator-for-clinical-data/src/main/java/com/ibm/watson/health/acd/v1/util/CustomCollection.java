/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ibm.watson.health.acd.v1.exception.IllegalMethodException;
import com.ibm.watson.health.acd.v1.exception.IndexNotAvailableException;
import com.ibm.watson.health.acd.v1.exception.ParameterNotAvailableException;

import com.ibm.cloud.sdk.core.util.GsonSingleton;

/**
 * CustomCollection
 *
 * To deserialize the response.
 *
 * This class is manually written and not generated from swagger codegen.
 * */


public class CustomCollection extends CustomDeserializer {

  private JsonElement object;

  /**
   * Retrieves element within collection.
   * @return json object
   */
  public JsonElement getObject() {
    return object;
  }

  /**
   * Sets element within collection.
   * @param tempobj object to add to collection
   */
  public void setObject(JsonElement tempobj) {
    this.object = tempobj;
  }

  /**
   * Retrieves collection by key.
   * @param key object key to retrieve
   *
   * @return the {@link CustomCollection}
   */

  public CustomCollection get(String key) throws ParameterNotAvailableException {
    CustomCollection cd = new CustomCollection();
    if (this.object instanceof JsonObject) {
      try {
        JsonObject jsobj = this.getObject().getAsJsonObject();
        cd.setObject(jsobj.get(key));
      } catch (RuntimeException ex) {
        throw new ParameterNotAvailableException(key + " is not available or it is empty.");
      }
    }

    return cd;

  }

  /**
   * Retrieves collection by position.
   * @param key object position to retrieve
   *
   * @return the {@link CustomCollection}
   */

  public CustomCollection get(int key) throws IndexNotAvailableException {
    CustomCollection cd = new CustomCollection();
    if (this.object instanceof JsonArray) {
      int size = 0;
      try {
        JsonArray jsarr = this.getObject().getAsJsonArray();
        size = jsarr.size();
        cd.setObject(jsarr.get(key));
      } catch (RuntimeException ex) {
        throw new IndexNotAvailableException("Index: " + key + ", " + " Size: " + size);
      }
    }

    return cd;

  }

  /**
   * Retrieve list of collections by key.
   * @param key key for retrieval
   *
   * @return the {@link CustomCollection} list
   */

  public List<CustomCollection> getList(String key) throws ParameterNotAvailableException, IllegalMethodException {
    List<CustomCollection> listCustomCollections = new ArrayList<CustomCollection>();
    CustomCollection cd = new CustomCollection();
    if (this.object instanceof JsonObject) {
      try {
        JsonObject jsarr = this.getObject().getAsJsonObject();
        cd.setObject(jsarr.get(key).getAsJsonArray());
      } catch (NullPointerException e) {
        throw new ParameterNotAvailableException(key + " is not available or it is an empty list.");
      } catch (IllegalStateException e) {
        throw new IllegalMethodException(key + " is not a list.");
      }

      JsonArray array = cd.getObject().getAsJsonArray();
      int length = array.size();
      Gson gson = GsonSingleton.getGson();
      for (int i = 0; i < length; i++) {
        CustomDeserializer customDeserializer = new CustomDeserializer();
        CustomCollection customCollection = customDeserializer.convertObject(gson.toJson(array.get(i)));
        listCustomCollections.add(customCollection);
      }
    }

    return listCustomCollections;

  }

  /**
   * Retrieves value for key.
   * @param key value key
   *
   * @return the {@link String}
   */

  public String getValue(String key) throws ParameterNotAvailableException {
    try {
      JsonObject tempJsonObject = this.getObject().getAsJsonObject();
      return tempJsonObject.get(key).toString();
    } catch (RuntimeException ex) {
      throw new ParameterNotAvailableException(key + " is not available.");
    }

  }

  /**
   * Retrieves collection list for annotation list.
   * @param listAnnotation annotation list for retrieval
   *
   * @return the {@link CustomCollection} list
   */

  public List<CustomCollection> convertToCustomCollectionList(List<Object> listAnnotation) {

    List<CustomCollection> lisCustomCollections = new ArrayList<CustomCollection>();
    Gson gson = GsonSingleton.getGson();
    for (Object annotation : listAnnotation) {
      CustomCollection customCollection = new CustomCollection();
      CustomDeserializer customDeserializer = new CustomDeserializer();
      customCollection = customDeserializer.convertObject(gson.toJson(annotation));
      lisCustomCollections.add(customCollection);

    }

    return lisCustomCollections;
  }

  /**
   * Converts annotation to collection.
   * @param annotation annotation to convert
   *
   * @return the {@link CustomCollection}
   */

  public CustomCollection convertToCustomCollection(Object annotation) {

    Gson gson = GsonSingleton.getGson();
    CustomCollection customCollection = new CustomCollection();
    CustomDeserializer customDeserializer = new CustomDeserializer();
    customCollection = customDeserializer.convertObject(gson.toJson(annotation));

    return customCollection;
  }

}
