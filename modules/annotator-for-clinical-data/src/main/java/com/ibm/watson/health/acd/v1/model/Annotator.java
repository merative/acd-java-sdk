/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;



/**
 * Annotator.
 */
public class Annotator extends GenericModel {

    public interface Name {
      /** allergy. */
      String ALLERGY = "allergy";
      /** attribute_detection. */
      String ATTRIBUTE_DETECTION = "attribute_detection";
      /** bathing_assistance. */
      String BATHING_ASSISTANCE = "bathing_assistance";
      /** cancer. */
      String CANCER = "cancer";
      /** concept_detection. */
      String CONCEPT_DETECTION = "concept_detection";
      /** concept_value. */
      String CONCEPT_VALUE = "concept_value";
      /** disambiguation. */
      String DISAMBIGUATION = "disambiguation";
      /** dressing_assistance. */
      String DRESSING_ASSISTANCE = "dressing_assistance";
      /** eating_assistance. */
      String EATING_ASSISTANCE = "eating_assistance";
      /** ejection_fraction. */
      String EJECTION_FRACTION = "ejection_fraction";
      /** hypothetical. */
      String HYPOTHETICAL = "hypothetical";
      /** lab_value. */
      String LAB_VALUE = "lab_value";
      /** medication. */
      String MEDICATION = "medication";
      /** named_entities. */
      String NAMED_ENTITIES = "named_entities";
      /** negation. */
      String NEGATION = "negation";
      /** nlu. */
      String NLU = "nlu";
      /** procedure. */
      String PROCEDURE = "procedure";
      /** section. */
      String SECTION = "section";
      /** seeing_assistance. */
      String SEEING_ASSISTANCE = "seeing_assistance";
      /** smoking. */
      String SMOKING = "smoking";
      /** symptom_disease. */
      String SYMPTOM_DISEASE = "symptom_disease";
      /** toileting_assistance. */
      String TOILETING_ASSISTANCE = "toileting_assistance";
      /** walking_assistance. */
      String WALKING_ASSISTANCE = "walking_assistance";
      /** relation. */
      String RELATION = "relation";
      /** spell checker. */
      String SPELL_CHECKER = "spell_checker";
    }

    private Annotator annotator;
    private Flow flow;
    private String name;
    private String description;
    private Map parameters;
    private List<ConfigurationEntity> configurations;

    /**
     * Builder.
     */
    public static class Builder {
      private Annotator annotator;
      private Flow flow;
      private String name;
      private String description;
      private Map parameters;
      private List<ConfigurationEntity> configurations;

      private Builder(Annotator annotator) {
        annotator = annotator.annotator;
        flow = annotator.flow;
        name = annotator.name;
        description = annotator.description;
        parameters = annotator.parameters;
        configurations = annotator.configurations;
      }

      /**
       * Instantiates a new builder.
       */
      public Builder() {
      }

      /**
       * Instantiates a new builder with required properties.
       *
       * @param name the name
       */
      public Builder(String name) {
        this.name = name;
      }

      /**
       * Builds a Annotator.
       *
       * @return the annotator
       */
      public Annotator build() {
        return new Annotator(this);
      }

      /**
       * Adds an configurations to configurations.
       *
       * @param configurations the new configurations
       * @return the Annotator builder
       */
      public Builder addConfigurations(ConfigurationEntity configurations) {
        Validator.notNull(configurations, "configurations cannot be null");
        if (this.configurations == null) {
          this.configurations = new ArrayList<ConfigurationEntity>();
        }
        this.configurations.add(configurations);
        return this;
      }

      /**
       * Set the annotator.
       *
       * @param annotator the annotator
       * @return the Annotator builder
       */
      public Builder annotator(Annotator annotator) {
        this.annotator = annotator;
        return this;
      }

      /**
       * Set the flow.
       *
       * @param flow the flow
       * @return the Annotator builder
       */
      public Builder flow(Flow flow) {
        this.flow = flow;
        return this;
      }

      /**
       * Set the name.
       *
       * @param name the name
       * @return the Annotator builder
       */
      public Builder name(String name) {
        this.name = name;
        return this;
      }

      /**
       * Set the description.
       *
       * @param description the description
       * @return the Annotator builder
       */
      public Builder description(String description) {
        this.description = description;
        return this;
      }

      /**
       * Set the parameters.
       *
       * @param parameters the parameters
       * @return the Annotator builder
       */
      public Builder parameters(Map parameters) {
        this.parameters = parameters;
        return this;
      }

      /**
       * Set the configurations.
       * Existing configurations will be replaced.
       *
       * @param configurations the configurations
       * @return the Annotator builder
       */
      public Builder configurations(List<ConfigurationEntity> configurations) {
        this.configurations = configurations;
        return this;
      }
    }

    private Annotator(Builder builder) {
      Validator.notNull(builder.name, "name cannot be null");
      annotator = builder.annotator;
      flow = builder.flow;
      name = builder.name;
      description = builder.description;
      parameters = builder.parameters;
      configurations = builder.configurations;
    }

    /**
     * New builder.
     *
     * @return a Annotator builder
     */
    public Builder newBuilder() {
      return new Builder(this);
    }

    /**
     * Gets the annotator.
     *
     * @return the annotator
     */
    public Annotator annotator() {
      return annotator;
    }

    /**
     * Gets the flow.
     *
     * @return the flow
     */
    public Flow flow() {
      return flow;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String name() {
      return name;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String description() {
      return description;
    }

    /**
     * Gets the parameters.
     *
     * @return the parameters
     */
    public Map parameters() {
      return parameters;
    }

    /**
     * Gets the configurations.
     *
     * @return the configurations
     */
    public List<ConfigurationEntity> configurations() {
      return configurations;
    }
  }
