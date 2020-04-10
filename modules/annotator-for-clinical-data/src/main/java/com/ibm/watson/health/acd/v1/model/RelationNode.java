package com.ibm.watson.health.acd.v1.model;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

public class RelationNode extends DynamicModel {

  private Type entityType = new TypeToken<Reference>() { } .getType();

  /**
   * Gets the entity.
   *
   * @return the begin
   */
  public Reference getEntity() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("entity"), entityType);
  }

//  /**
//   * Sets the entity.
//   * @param begin the new begin
//   */
//  public void setEntity(final Reference begin) {
//    this.put("entity", begin);
//  }

}
