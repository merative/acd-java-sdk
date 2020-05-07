package com.ibm.watson.health.acd.v1.model;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

public class Suggestion extends DynamicModel {

  private Type appliedType = new TypeToken<Boolean>() { } .getType();
  private Type confidenceType = new TypeToken<Double>() { } .getType();
  private Type semtypesType = new TypeToken<List<String>>() { } .getType();
  private Type textType = new TypeToken<String>() { } .getType();

  /**
   * Gets the applied field.
   *
   * @return the applied field
   */
  public Boolean getApplied() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("applied"), appliedType);
  }

  /**
   * Gets the confidence field.
   *
   * @return the confidence field
   */
  public Double getConfidence() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("confidence"), confidenceType);
  }

  /**
   * Gets the semtypes field.
   *
   * @return the semtypes field
   */
  public List<String> getSemtypes() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("semtypes"), semtypesType);
  }

  /**
   * Gets the text field.
   *
   * @return the text field
   */
  public String getText() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("text"), textType);
  }

//  /**
//   * Sets the applied field.
//   *
//   * @param applied the new applied field
//   */
//  public void setApplied(final Boolean applied) {
//    this.put("applied", applied);
//  }
//
//  /**
//   * Sets the confidence field.
//   *
//   * @param confidence the new confidence field
//   */
//  public void setConfidence(final Double confidence) {
//    this.put("confidence", confidence);
//  }
//
//  /**
//   * Sets the semtypes field.
//   *
//   * @param semtypes the new semtypes field
//   */
//  public void setSemtypes(final List<String> semtypes) {
//    this.put("semtypes", semtypes);
//  }
//
//  /**
//   * Sets the text field.
//   *
//   * @param text the new text field
//   */
//  public void setText(final String text) {
//    this.put("text", text);
//  }


}
