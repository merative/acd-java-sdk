package com.ibm.watson.health.acd.v1.model;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

public class Relation extends DynamicModel {

  private Type typeType = new TypeToken<String>() { } .getType();
  private Type sourceType = new TypeToken<String>() { } .getType();
  private Type scoreType = new TypeToken<Double>() { } .getType();
  private Type nodeType = new TypeToken<List<RelationNode>>() { } .getType();

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("type"), typeType);
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("source"), sourceType);
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Double getScore() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("score"), scoreType);
  }

  /**
   * Gets the node.
   *
   * @return the node
   */
  public List<RelationNode> getNodes() {
//    List<Object> listObjects = GsonSerializationHelper.serializeDynamicModelProperty(this.get("nodes"), nodeType);
//    CustomCollection customCollection = new CustomCollection();
//    List<CustomCollection> listValues = customCollection.convertToCustomCollectionList(listObjects);
//    return listValues;
    List<RelationNode> relationNodes = GsonSerializationHelper.serializeDynamicModelProperty(this.get("nodes"), nodeType);
    return relationNodes;
  }

  /**
   * Gets the node.
   *
   * @return the node
   */
//  public CustomCollection getNode(int index) {
//    return getNodes().get(index);
//  }


//  /**
//   * Sets the type.
//   * @param type the new type
//   */
//  public void setType(final String type) {
//    this.put("type", type);
//  }
//
//  /**
//   * Sets the source.
//   *
//   * @param source the new source
//   */
//  public void setSource(final String source) {
//    this.put("source", source);
//  }
//
//  /**
//   * Sets the score.
//   *
//   * @param source the new score
//   */
//  public void setScore(final Double score) {
//    this.put("score", score);
//  }
//
//  /**
//     * Sets the node.
//     *
//     * @param node the relation nodes
//     */
//    public void setNodes(final List<RelationNode> node) {
//      this.put("nodes", node);
//    }

}
