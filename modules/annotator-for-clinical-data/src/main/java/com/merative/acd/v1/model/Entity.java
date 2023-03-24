/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Entity.
 */
public class Entity extends GenericModel {

  protected String id;
  protected String type;
  protected Long uid;
  protected Long mergeid;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String type;
    private Long uid;
    private Long mergeid;

    private Builder(Entity entity) {
      this.id = entity.id;
      this.type = entity.type;
      this.uid = entity.uid;
      this.mergeid = entity.mergeid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Entity.
     *
     * @return the new Entity instance
     */
    public Entity build() {
      return new Entity(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Entity builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the Entity builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the uid.
     *
     * @param uid the uid
     * @return the Entity builder
     */
    public Builder uid(long uid) {
      this.uid = uid;
      return this;
    }

    /**
     * Set the mergeid.
     *
     * @param mergeid the mergeid
     * @return the Entity builder
     */
    public Builder mergeid(long mergeid) {
      this.mergeid = mergeid;
      return this;
    }
  }

  protected Entity(Builder builder) {
    id = builder.id;
    type = builder.type;
    uid = builder.uid;
    mergeid = builder.mergeid;
  }

  /**
   * New builder.
   *
   * @return a Entity builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the uid.
   *
   * @return the uid
   */
  public Long uid() {
    return uid;
  }

  /**
   * Gets the mergeid.
   *
   * @return the mergeid
   */
  public Long mergeid() {
    return mergeid;
  }
}

