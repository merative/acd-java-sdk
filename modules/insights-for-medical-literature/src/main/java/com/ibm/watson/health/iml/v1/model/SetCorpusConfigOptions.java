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
 * The setCorpusConfig options.
 */
public class SetCorpusConfigOptions extends GenericModel {

  protected String userName;
  protected String password;
  protected String corpusUri;

  /**
   * Builder.
   */
  public static class Builder {
    private String userName;
    private String password;
    private String corpusUri;

    private Builder(SetCorpusConfigOptions setCorpusConfigOptions) {
      this.userName = setCorpusConfigOptions.userName;
      this.password = setCorpusConfigOptions.password;
      this.corpusUri = setCorpusConfigOptions.corpusUri;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SetCorpusConfigOptions.
     *
     * @return the new SetCorpusConfigOptions instance
     */
    public SetCorpusConfigOptions build() {
      return new SetCorpusConfigOptions(this);
    }

    /**
     * Set the userName.
     *
     * @param userName the userName
     * @return the SetCorpusConfigOptions builder
     */
    public Builder userName(String userName) {
      this.userName = userName;
      return this;
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the SetCorpusConfigOptions builder
     */
    public Builder password(String password) {
      this.password = password;
      return this;
    }

    /**
     * Set the corpusUri.
     *
     * @param corpusUri the corpusUri
     * @return the SetCorpusConfigOptions builder
     */
    public Builder corpusUri(String corpusUri) {
      this.corpusUri = corpusUri;
      return this;
    }
  }

  protected SetCorpusConfigOptions(Builder builder) {
    userName = builder.userName;
    password = builder.password;
    corpusUri = builder.corpusUri;
  }

  /**
   * New builder.
   *
   * @return a SetCorpusConfigOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the userName.
   *
   * Repository connection userid.
   *
   * @return the userName
   */
  public String userName() {
    return userName;
  }

  /**
   * Gets the password.
   *
   * Repository connection password.
   *
   * @return the password
   */
  public String password() {
    return password;
  }

  /**
   * Gets the corpusUri.
   *
   * Repository connection URI.
   *
   * @return the corpusUri
   */
  public String corpusUri() {
    return corpusUri;
  }
}

