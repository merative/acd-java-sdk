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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ibm.watson.health.acd.v1.exception.IllegalMethodException;
import com.ibm.watson.health.acd.v1.exception.IndexNotAvailableException;
import com.ibm.watson.health.acd.v1.exception.ParameterNotAvailableException;

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
	 * @return
	 */
	public JsonElement getObject() {
		return object;
	}

	/**
	 * Sets element within collection.
	 * @param tempobj
	 */
	public void setObject(JsonElement tempobj) {
		this.object = tempobj;
	}

	/** @param key
	 *
	 * @return the {@link CustomCollection}
	 */

	public CustomCollection get(String key) throws ParameterNotAvailableException {
		CustomCollection cd = new CustomCollection();
		if (this.object instanceof JsonObject) {
			// System.out.println("Object");
			try {
				JsonObject jsobj = this.getObject().getAsJsonObject();
				cd.setObject(jsobj.get(key));
			} catch (RuntimeException ex) {
				throw new ParameterNotAvailableException(key + " is not available or it is empty.");
			}
		}

		return cd;

	}

	/** @param key
	 *
	 * @return the {@link CustomCollection}
	 */

	public CustomCollection get(int key) throws IndexNotAvailableException {
		CustomCollection cd = new CustomCollection();
		if (this.object instanceof JsonArray) {
			// System.out.println("Array");
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

	/** @param key
	 *
	 * @return the {@link List<CustomCollection>}
	 */

	public List<CustomCollection> getList(String key) throws ParameterNotAvailableException, IllegalMethodException {
		List<CustomCollection> listCustomCollections = new ArrayList<CustomCollection>();
		CustomCollection cd = new CustomCollection();
		if (this.object instanceof JsonObject) {
			// System.out.println("Array");
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
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			for (int i = 0; i < length; i++) {
				CustomDeserializer customDeserializer = new CustomDeserializer();
				CustomCollection customCollection = customDeserializer.convertObject(gson.toJson(array.get(i)));
				listCustomCollections.add(customCollection);
			}
		}

		return listCustomCollections;

	}

	/** @param key
	 *
	 * @return the {@link String}
	 */

	public String getValue(String key) throws ParameterNotAvailableException {
		// System.out.println(this.getTempobj().toString());
		try {
			JsonObject tempJsonObject = this.getObject().getAsJsonObject();
			return tempJsonObject.get(key).toString();
		} catch (RuntimeException ex) {
			throw new ParameterNotAvailableException(key + " is not available.");
		}
		/*
		 * if(tempJsonObject.get(key) instanceof JsonElement)
		 * System.out.println("String"); else System.out.println("No");
		 */

	}

	/** @param annotation
	 *
	 * @return the {@link List<CustomCollection>}
	 */

	public List<CustomCollection> convertToCustomCollectionList(List<Object> listAnnotation) {

		List<CustomCollection> lisCustomCollections = new ArrayList<CustomCollection>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		for (Object annotation : listAnnotation) {
			CustomCollection customCollection = new CustomCollection();
			CustomDeserializer customDeserializer = new CustomDeserializer();
			customCollection = customDeserializer.convertObject(gson.toJson(annotation));
			lisCustomCollections.add(customCollection);

		}

		return lisCustomCollections;
	}

	/** @param annotation
	 *
	 * @return the {@link CustomCollection}
	 */

	public CustomCollection convertToCustomCollection(Object annotation) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		CustomCollection customCollection = new CustomCollection();
		CustomDeserializer customDeserializer = new CustomDeserializer();
		customCollection = customDeserializer.convertObject(gson.toJson(annotation));

		return customCollection;
	}

}
