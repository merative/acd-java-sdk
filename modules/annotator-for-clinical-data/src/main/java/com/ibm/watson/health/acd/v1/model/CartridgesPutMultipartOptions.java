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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The cartridgesPutMultipart options.
 */
public class CartridgesPutMultipartOptions extends GenericModel {

  protected InputStream archiveFile;
  protected String archiveFileContentType;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream archiveFile;
    private String archiveFileContentType;

    private Builder(CartridgesPutMultipartOptions cartridgesPutMultipartOptions) {
      this.archiveFile = cartridgesPutMultipartOptions.archiveFile;
      this.archiveFileContentType = cartridgesPutMultipartOptions.archiveFileContentType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CartridgesPutMultipartOptions.
     *
     * @return the new CartridgesPutMultipartOptions instance
     */
    public CartridgesPutMultipartOptions build() {
      return new CartridgesPutMultipartOptions(this);
    }

    /**
     * Set the archiveFile.
     *
     * @param archiveFile the archiveFile
     * @return the CartridgesPutMultipartOptions builder
     */
    public Builder archiveFile(InputStream archiveFile) {
      this.archiveFile = archiveFile;
      return this;
    }

    /**
     * Set the archiveFileContentType.
     *
     * @param archiveFileContentType the archiveFileContentType
     * @return the CartridgesPutMultipartOptions builder
     */
    public Builder archiveFileContentType(String archiveFileContentType) {
      this.archiveFileContentType = archiveFileContentType;
      return this;
    }

    /**
     * Set the archiveFile.
     *
     * @param archiveFile the archiveFile
     * @return the CartridgesPutMultipartOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder archiveFile(File archiveFile) throws FileNotFoundException {
      this.archiveFile = new FileInputStream(archiveFile);
      return this;
    }
  }

  protected CartridgesPutMultipartOptions(Builder builder) {
    archiveFile = builder.archiveFile;
    archiveFileContentType = builder.archiveFileContentType;
  }

  /**
   * New builder.
   *
   * @return a CartridgesPutMultipartOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the archiveFile.
   *
   * Cartridge archive file.
   *
   * @return the archiveFile
   */
  public InputStream archiveFile() {
    return archiveFile;
  }

  /**
   * Gets the archiveFileContentType.
   *
   * The content type of archiveFile. Values for this parameter can be obtained from the HttpMediaType class.
   *
   * @return the archiveFileContentType
   */
  public String archiveFileContentType() {
    return archiveFileContentType;
  }
}

