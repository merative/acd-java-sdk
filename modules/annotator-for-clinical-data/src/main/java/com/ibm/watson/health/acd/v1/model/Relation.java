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

public class Relation extends DynamicModel<Object> {

  @SerializedName("type")
  protected String type;
  @SerializedName("source")
  protected String source;
  @SerializedName("score")
  protected Double score;
  @SerializedName("nodes")
  protected List<RelationNode> node;

  public Relation() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return this.type;
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return this.source;
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Double getScore() {
    return this.score;
  }

  /**
   * Gets the node.
   *
   * @return the node list
   */
  public List<RelationNode> getNodes() {
    return this.node;
  }

  /**
   * Gets the node.
   *
   * @param index position to retrieve
   *
   * @return the node
   */
  public RelationNode getNode(int index) {
	  if (this.node != null) {
		  return getNodes().get(index);
	  }
	  return null;
  }

  /**
   * Returns the value from Relation annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  if (key.equals("nodes")) {
				  key = "node";
			  }
			  Field field = Relation.class.getDeclaredField(key);
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
