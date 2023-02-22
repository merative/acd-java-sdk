/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deployCartridge options.
 */
public class DeployCartridgeOptions extends GenericModel {

  protected InputStream archiveFile;
  protected String archiveFileContentType;
  protected Boolean update;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream archiveFile;
    private String archiveFileContentType;
    private Boolean update;

    private Builder(DeployCartridgeOptions deployCartridgeOptions) {
      this.archiveFile = deployCartridgeOptions.archiveFile;
      this.archiveFileContentType = deployCartridgeOptions.archiveFileContentType;
      this.update = deployCartridgeOptions.update;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DeployCartridgeOptions.
     *
     * @return the new DeployCartridgeOptions instance
     */
    public DeployCartridgeOptions build() {
      return new DeployCartridgeOptions(this);
    }

    /**
     * Set the archiveFile.
     *
     * @param archiveFile the archiveFile
     * @return the DeployCartridgeOptions builder
     */
    public Builder archiveFile(InputStream archiveFile) {
      this.archiveFile = archiveFile;
      return this;
    }

    /**
     * Set the archiveFileContentType.
     *
     * @param archiveFileContentType the archiveFileContentType
     * @return the DeployCartridgeOptions builder
     */
    public Builder archiveFileContentType(String archiveFileContentType) {
      this.archiveFileContentType = archiveFileContentType;
      return this;
    }

    /**
     * Set the update.
     *
     * @param update the update
     * @return the DeployCartridgeOptions builder
     */
    public Builder update(Boolean update) {
      this.update = update;
      return this;
    }

    /**
     * Set the archiveFile.
     *
     * @param archiveFile the archiveFile
     * @return the DeployCartridgeOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder archiveFile(File archiveFile) throws FileNotFoundException {
      this.archiveFile = new FileInputStream(archiveFile);
      return this;
    }
  }

  protected DeployCartridgeOptions(Builder builder) {
    archiveFile = builder.archiveFile;
    archiveFileContentType = builder.archiveFileContentType;
    update = builder.update;
  }

  /**
   * New builder.
   *
   * @return a DeployCartridgeOptions builder
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

  /**
   * Gets the update.
   *
   * Update resources if they already exist.
   *
   * @return the update
   */
  public Boolean update() {
    return update;
  }
}

