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
package com.ibm.watson.health.iml.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * PossbileValues.
 */
public class PossibleValues extends GenericModel {

  protected String displayValue;
  protected String value;

  /**
   * Builder.
   */
  public static class Builder {
    private String displayValue;
    private String value;

    private Builder(PossibleValues possbileValues) {
      this.displayValue = possbileValues.displayValue;
      this.value = possbileValues.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PossbileValues.
     *
     * @return the new PossbileValues instance
     */
    public PossibleValues build() {
      return new PossibleValues(this);
    }

    /**
     * Set the displayValue.
     *
     * @param displayValue the displayValue
     * @return the PossbileValues builder
     */
    public Builder displayValue(String displayValue) {
      this.displayValue = displayValue;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the PossbileValues builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected PossibleValues(Builder builder) {
    displayValue = builder.displayValue;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a PossbileValues builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the displayValue.
   *
   * @return the displayValue
   */
  public String displayValue() {
    return displayValue;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}

