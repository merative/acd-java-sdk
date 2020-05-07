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
package com.ibm.watson.health.acd.v1.model;

import java.util.List;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

public class Relation extends GenericModel {

  private String typeType;
  private String sourceType;
  private Double scoreType;
  private List<RelationNode> relationNodes;

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return typeType;
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return sourceType;
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Double getScore() {
    return scoreType;
  }

  /**
   * Gets the node.
   *
   * @return the node
   */
  public List<RelationNode> getNodes() {
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
