/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.iml.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The getSearchMatches options.
 */
public class GetSearchMatchesOptions extends GenericModel {

//  public interface Types {
//    /** AcquiredAbnormality. */
//    String ACQUIREDABNORMALITY = "AcquiredAbnormality";
//    /** Activity. */
//    String ACTIVITY = "Activity";
//    /** AgeGroup. */
//    String AGEGROUP = "AgeGroup";
//    /** AminoAcidPeptideOrProtein. */
//    String AMINOACIDPEPTIDEORPROTEIN = "AminoAcidPeptideOrProtein";
//    /** AminoAcidSequence. */
//    String AMINOACIDSEQUENCE = "AminoAcidSequence";
//    /** Amphibian. */
//    String AMPHIBIAN = "Amphibian";
//    /** AnatomicalAbnormality. */
//    String ANATOMICALABNORMALITY = "AnatomicalAbnormality";
//    /** AnatomicalStructure. */
//    String ANATOMICALSTRUCTURE = "AnatomicalStructure";
//    /** Animal. */
//    String ANIMAL = "Animal";
//    /** Antibiotic. */
//    String ANTIBIOTIC = "Antibiotic";
//    /** Archaeon. */
//    String ARCHAEON = "Archaeon";
//    /** Bacterium. */
//    String BACTERIUM = "Bacterium";
//    /** Behavior. */
//    String BEHAVIOR = "Behavior";
//    /** BiologicFunction. */
//    String BIOLOGICFUNCTION = "BiologicFunction";
//    /** BiologicallyActiveSubstance. */
//    String BIOLOGICALLYACTIVESUBSTANCE = "BiologicallyActiveSubstance";
//    /** BiomedicalOccupationOrDiscipline. */
//    String BIOMEDICALOCCUPATIONORDISCIPLINE = "BiomedicalOccupationOrDiscipline";
//    /** BiomedicalOrDentalMaterial. */
//    String BIOMEDICALORDENTALMATERIAL = "BiomedicalOrDentalMaterial";
//    /** Bird. */
//    String BIRD = "Bird";
//    /** BodyLocationOrRegion. */
//    String BODYLOCATIONORREGION = "BodyLocationOrRegion";
//    /** BodyPartOrganOrOrganComponent. */
//    String BODYPARTORGANORORGANCOMPONENT = "BodyPartOrganOrOrganComponent";
//    /** BodySpaceOrJunction. */
//    String BODYSPACEORJUNCTION = "BodySpaceOrJunction";
//    /** BodySubstance. */
//    String BODYSUBSTANCE = "BodySubstance";
//    /** BodySystem. */
//    String BODYSYSTEM = "BodySystem";
//    /** CarbohydrateSequence. */
//    String CARBOHYDRATESEQUENCE = "CarbohydrateSequence";
//    /** Cell. */
//    String CELL = "Cell";
//    /** CellComponent. */
//    String CELLCOMPONENT = "CellComponent";
//    /** CellFunction. */
//    String CELLFUNCTION = "CellFunction";
//    /** CellOrMolecularDysfunction. */
//    String CELLORMOLECULARDYSFUNCTION = "CellOrMolecularDysfunction";
//    /** Chemical. */
//    String CHEMICAL = "Chemical";
//    /** ChemicalViewedFunctionally. */
//    String CHEMICALVIEWEDFUNCTIONALLY = "ChemicalViewedFunctionally";
//    /** ChemicalViewedStructurally. */
//    String CHEMICALVIEWEDSTRUCTURALLY = "ChemicalViewedStructurally";
//    /** Classification. */
//    String CLASSIFICATION = "Classification";
//    /** ClinicalAttribute. */
//    String CLINICALATTRIBUTE = "ClinicalAttribute";
//    /** ClinicalDrug. */
//    String CLINICALDRUG = "ClinicalDrug";
//    /** ConceptualEntity. */
//    String CONCEPTUALENTITY = "ConceptualEntity";
//    /** CongenitalAbnormality. */
//    String CONGENITALABNORMALITY = "CongenitalAbnormality";
//    /** DailyOrRecreationalActivity. */
//    String DAILYORRECREATIONALACTIVITY = "DailyOrRecreationalActivity";
//    /** DiagnosticProcedure. */
//    String DIAGNOSTICPROCEDURE = "DiagnosticProcedure";
//    /** DiseaseOrSyndrome. */
//    String DISEASEORSYNDROME = "DiseaseOrSyndrome";
//    /** DrugDeliveryDevice. */
//    String DRUGDELIVERYDEVICE = "DrugDeliveryDevice";
//    /** EducationalActivity. */
//    String EDUCATIONALACTIVITY = "EducationalActivity";
//    /** ElementIonOrIsotope. */
//    String ELEMENTIONORISOTOPE = "ElementIonOrIsotope";
//    /** EmbryonicStructure. */
//    String EMBRYONICSTRUCTURE = "EmbryonicStructure";
//    /** Entity. */
//    String ENTITY = "Entity";
//    /** EnvironmentalEffectOfHumans. */
//    String ENVIRONMENTALEFFECTOFHUMANS = "EnvironmentalEffectOfHumans";
//    /** Enzyme. */
//    String ENZYME = "Enzyme";
//    /** Eukaryote. */
//    String EUKARYOTE = "Eukaryote";
//    /** Event. */
//    String EVENT = "Event";
//    /** ExperimentalModelofDisease. */
//    String EXPERIMENTALMODELOFDISEASE = "ExperimentalModelofDisease";
//    /** FamilyGroup. */
//    String FAMILYGROUP = "FamilyGroup";
//    /** Finding. */
//    String FINDING = "Finding";
//    /** Fish. */
//    String FISH = "Fish";
//    /** Food. */
//    String FOOD = "Food";
//    /** FullyFormedAnatomicalStructure. */
//    String FULLYFORMEDANATOMICALSTRUCTURE = "FullyFormedAnatomicalStructure";
//    /** FunctionalConcept. */
//    String FUNCTIONALCONCEPT = "FunctionalConcept";
//    /** Fungus. */
//    String FUNGUS = "Fungus";
//    /** GeneOrGenome. */
//    String GENEORGENOME = "GeneOrGenome";
//    /** GeneticFunction. */
//    String GENETICFUNCTION = "GeneticFunction";
//    /** GeographicArea. */
//    String GEOGRAPHICAREA = "GeographicArea";
//    /** GovernmentalOrRegulatoryActivity. */
//    String GOVERNMENTALORREGULATORYACTIVITY = "GovernmentalOrRegulatoryActivity";
//    /** Group. */
//    String GROUP = "Group";
//    /** GroupAttribute. */
//    String GROUPATTRIBUTE = "GroupAttribute";
//    /** HazardousOrPoisonousSubstance. */
//    String HAZARDOUSORPOISONOUSSUBSTANCE = "HazardousOrPoisonousSubstance";
//    /** HealthCareActivity. */
//    String HEALTHCAREACTIVITY = "HealthCareActivity";
//    /** HealthCareRelatedOrganization. */
//    String HEALTHCARERELATEDORGANIZATION = "HealthCareRelatedOrganization";
//    /** Hormone. */
//    String HORMONE = "Hormone";
//    /** Human. */
//    String HUMAN = "Human";
//    /** HumancausedPhenomenonOrProcess. */
//    String HUMANCAUSEDPHENOMENONORPROCESS = "HumancausedPhenomenonOrProcess";
//    /** IdeaOrConcept. */
//    String IDEAORCONCEPT = "IdeaOrConcept";
//    /** ImmunologicFactor. */
//    String IMMUNOLOGICFACTOR = "ImmunologicFactor";
//    /** IndicatorReagentOrDiagnosticAid. */
//    String INDICATORREAGENTORDIAGNOSTICAID = "IndicatorReagentOrDiagnosticAid";
//    /** IndividualBehavior. */
//    String INDIVIDUALBEHAVIOR = "IndividualBehavior";
//    /** InjuryOrPoisoning. */
//    String INJURYORPOISONING = "InjuryOrPoisoning";
//    /** InorganicChemical. */
//    String INORGANICCHEMICAL = "InorganicChemical";
//    /** IntellectualProduct. */
//    String INTELLECTUALPRODUCT = "IntellectualProduct";
//    /** LaboratoryOrTestResult. */
//    String LABORATORYORTESTRESULT = "LaboratoryOrTestResult";
//    /** LaboratoryProcedure. */
//    String LABORATORYPROCEDURE = "LaboratoryProcedure";
//    /** Language. */
//    String LANGUAGE = "Language";
//    /** MachineActivity. */
//    String MACHINEACTIVITY = "MachineActivity";
//    /** Mammal. */
//    String MAMMAL = "Mammal";
//    /** ManufacturedObject. */
//    String MANUFACTUREDOBJECT = "ManufacturedObject";
//    /** MedicalDevice. */
//    String MEDICALDEVICE = "MedicalDevice";
//    /** MentalOrBehavioralDysfunction. */
//    String MENTALORBEHAVIORALDYSFUNCTION = "MentalOrBehavioralDysfunction";
//    /** MentalProcess. */
//    String MENTALPROCESS = "MentalProcess";
//    /** MolecularBiologyResearchTechnique. */
//    String MOLECULARBIOLOGYRESEARCHTECHNIQUE = "MolecularBiologyResearchTechnique";
//    /** MolecularFunction. */
//    String MOLECULARFUNCTION = "MolecularFunction";
//    /** MolecularSequence. */
//    String MOLECULARSEQUENCE = "MolecularSequence";
//    /** NaturalPhenomenonOrProcess. */
//    String NATURALPHENOMENONORPROCESS = "NaturalPhenomenonOrProcess";
//    /** NeoplasticProcess. */
//    String NEOPLASTICPROCESS = "NeoplasticProcess";
//    /** NucleicAcidNucleosideOrNucleotide. */
//    String NUCLEICACIDNUCLEOSIDEORNUCLEOTIDE = "NucleicAcidNucleosideOrNucleotide";
//    /** NucleotideSequence. */
//    String NUCLEOTIDESEQUENCE = "NucleotideSequence";
//    /** OccupationOrDiscipline. */
//    String OCCUPATIONORDISCIPLINE = "OccupationOrDiscipline";
//    /** OccupationalActivity. */
//    String OCCUPATIONALACTIVITY = "OccupationalActivity";
//    /** OrganOrTissueFunction. */
//    String ORGANORTISSUEFUNCTION = "OrganOrTissueFunction";
//    /** OrganicChemical. */
//    String ORGANICCHEMICAL = "OrganicChemical";
//    /** Organism. */
//    String ORGANISM = "Organism";
//    /** OrganismAttribute. */
//    String ORGANISMATTRIBUTE = "OrganismAttribute";
//    /** OrganismFunction. */
//    String ORGANISMFUNCTION = "OrganismFunction";
//    /** Organization. */
//    String ORGANIZATION = "Organization";
//    /** PathologicFunction. */
//    String PATHOLOGICFUNCTION = "PathologicFunction";
//    /** PatientOrDisabledGroup. */
//    String PATIENTORDISABLEDGROUP = "PatientOrDisabledGroup";
//    /** PharmacologicSubstance. */
//    String PHARMACOLOGICSUBSTANCE = "PharmacologicSubstance";
//    /** PhenomenonOrProcess. */
//    String PHENOMENONORPROCESS = "PhenomenonOrProcess";
//    /** PhysicalObject. */
//    String PHYSICALOBJECT = "PhysicalObject";
//    /** PhysiologicFunction. */
//    String PHYSIOLOGICFUNCTION = "PhysiologicFunction";
//    /** Plant. */
//    String PLANT = "Plant";
//    /** PopulationGroup. */
//    String POPULATIONGROUP = "PopulationGroup";
//    /** ProfessionalOrOccupationalGroup. */
//    String PROFESSIONALOROCCUPATIONALGROUP = "ProfessionalOrOccupationalGroup";
//    /** ProfessionalSociety. */
//    String PROFESSIONALSOCIETY = "ProfessionalSociety";
//    /** QualitativeConcept. */
//    String QUALITATIVECONCEPT = "QualitativeConcept";
//    /** QuantitativeConcept. */
//    String QUANTITATIVECONCEPT = "QuantitativeConcept";
//    /** Receptor. */
//    String RECEPTOR = "Receptor";
//    /** RegulationOrLaw. */
//    String REGULATIONORLAW = "RegulationOrLaw";
//    /** Reptile. */
//    String REPTILE = "Reptile";
//    /** ResearchActivity. */
//    String RESEARCHACTIVITY = "ResearchActivity";
//    /** ResearchDevice. */
//    String RESEARCHDEVICE = "ResearchDevice";
//    /** SelfhelpOrReliefOrganization. */
//    String SELFHELPORRELIEFORGANIZATION = "SelfhelpOrReliefOrganization";
//    /** SignOrSymptom. */
//    String SIGNORSYMPTOM = "SignOrSymptom";
//    /** SocialBehavior. */
//    String SOCIALBEHAVIOR = "SocialBehavior";
//    /** SpatialConcept. */
//    String SPATIALCONCEPT = "SpatialConcept";
//    /** Substance. */
//    String SUBSTANCE = "Substance";
//    /** TemporalConcept. */
//    String TEMPORALCONCEPT = "TemporalConcept";
//    /** TherapeuticOrPreventiveProcedure. */
//    String THERAPEUTICORPREVENTIVEPROCEDURE = "TherapeuticOrPreventiveProcedure";
//    /** Tissue. */
//    String TISSUE = "Tissue";
//    /** Vertebrate. */
//    String VERTEBRATE = "Vertebrate";
//    /** Virus. */
//    String VIRUS = "Virus";
//    /** Vitamin. */
//    String VITAMIN = "Vitamin";
//  }

  private String corpus;
  private String documentId;
  private List<String> cuis;
  private List<String> text;
  private List<String> types;
  private List<String> attributes;
  private List<String> values;
  private Long limit;
  private String searchTagBegin;
  private String searchTagEnd;
  private String relatedTagBegin;
  private String relatedTagEnd;
  private Float minScore;
  private String fields;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String documentId;
    private List<String> cuis;
    private List<String> text;
    private List<String> types;
    private List<String> attributes;
    private List<String> values;
    private Long limit;
    private String searchTagBegin;
    private String searchTagEnd;
    private String relatedTagBegin;
    private String relatedTagEnd;
    private Float minScore;
    private String fields;

    private Builder(GetSearchMatchesOptions getSearchMatchesOptions) {
      corpus = getSearchMatchesOptions.corpus;
      documentId = getSearchMatchesOptions.documentId;
      cuis = getSearchMatchesOptions.cuis;
      text = getSearchMatchesOptions.text;
      types = getSearchMatchesOptions.types;
      attributes = getSearchMatchesOptions.attributes;
      values = getSearchMatchesOptions.values;
      limit = getSearchMatchesOptions.limit;
      searchTagBegin = getSearchMatchesOptions.searchTagBegin;
      searchTagEnd = getSearchMatchesOptions.searchTagEnd;
      relatedTagBegin = getSearchMatchesOptions.relatedTagBegin;
      relatedTagEnd = getSearchMatchesOptions.relatedTagEnd;
      minScore = getSearchMatchesOptions.minScore;
      fields = getSearchMatchesOptions.fields;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param corpus the corpus
     * @param documentId the documentId
     * @param minScore the minScore
     */
    public Builder(String corpus, String documentId, Float minScore) {
      this.corpus = corpus;
      this.documentId = documentId;
      this.minScore = minScore;
    }

    /**
     * Builds a GetSearchMatchesOptions.
     *
     * @return the getSearchMatchesOptions
     */
    public GetSearchMatchesOptions build() {
      return new GetSearchMatchesOptions(this);
    }

    /**
     * Adds an cuis to cuis.
     *
     * @param cuis the new cuis
     * @return the GetSearchMatchesOptions builder
     */
    public Builder addCuis(String cuis) {
      Validator.notNull(cuis, "cuis cannot be null");
      if (this.cuis == null) {
        this.cuis = new ArrayList<String>();
      }
      this.cuis.add(cuis);
      return this;
    }

    /**
     * Adds an text to text.
     *
     * @param text the new text
     * @return the GetSearchMatchesOptions builder
     */
    public Builder addText(String text) {
      Validator.notNull(text, "text cannot be null");
      if (this.text == null) {
        this.text = new ArrayList<String>();
      }
      this.text.add(text);
      return this;
    }

    /**
     * Adds an types to types.
     *
     * @param types the new types
     * @return the GetSearchMatchesOptions builder
     */
    public Builder addTypes(String types) {
      Validator.notNull(types, "types cannot be null");
      if (this.types == null) {
        this.types = new ArrayList<String>();
      }
      this.types.add(types);
      return this;
    }

    /**
     * Adds an attributes to attributes.
     *
     * @param attributes the new attributes
     * @return the GetSearchMatchesOptions builder
     */
    public Builder addAttributes(String attributes) {
      Validator.notNull(attributes, "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<String>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Adds an values to values.
     *
     * @param values the new values
     * @return the GetSearchMatchesOptions builder
     */
    public Builder addValues(String values) {
      Validator.notNull(values, "values cannot be null");
      if (this.values == null) {
        this.values = new ArrayList<String>();
      }
      this.values.add(values);
      return this;
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetSearchMatchesOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the GetSearchMatchesOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the cuis.
     * Existing cuis will be replaced.
     *
     * @param cuis the cuis
     * @return the GetSearchMatchesOptions builder
     */
    public Builder cuis(List<String> cuis) {
      this.cuis = cuis;
      return this;
    }

    /**
     * Set the text.
     * Existing text will be replaced.
     *
     * @param text the text
     * @return the GetSearchMatchesOptions builder
     */
    public Builder text(List<String> text) {
      this.text = text;
      return this;
    }

    /**
     * Set the types.
     * Existing types will be replaced.
     *
     * @param types the types
     * @return the GetSearchMatchesOptions builder
     */
    public Builder types(List<String> types) {
      this.types = types;
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the GetSearchMatchesOptions builder
     */
    public Builder attributes(List<String> attributes) {
      this.attributes = attributes;
      return this;
    }

    /**
     * Set the values.
     * Existing values will be replaced.
     *
     * @param values the values
     * @return the GetSearchMatchesOptions builder
     */
    public Builder values(List<String> values) {
      this.values = values;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetSearchMatchesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the searchTagBegin.
     *
     * @param searchTagBegin the searchTagBegin
     * @return the GetSearchMatchesOptions builder
     */
    public Builder searchTagBegin(String searchTagBegin) {
      this.searchTagBegin = searchTagBegin;
      return this;
    }

    /**
     * Set the searchTagEnd.
     *
     * @param searchTagEnd the searchTagEnd
     * @return the GetSearchMatchesOptions builder
     */
    public Builder searchTagEnd(String searchTagEnd) {
      this.searchTagEnd = searchTagEnd;
      return this;
    }

    /**
     * Set the relatedTagBegin.
     *
     * @param relatedTagBegin the relatedTagBegin
     * @return the GetSearchMatchesOptions builder
     */
    public Builder relatedTagBegin(String relatedTagBegin) {
      this.relatedTagBegin = relatedTagBegin;
      return this;
    }

    /**
     * Set the relatedTagEnd.
     *
     * @param relatedTagEnd the relatedTagEnd
     * @return the GetSearchMatchesOptions builder
     */
    public Builder relatedTagEnd(String relatedTagEnd) {
      this.relatedTagEnd = relatedTagEnd;
      return this;
    }

    /**
     * Set the minScore.
     *
     * @param minScore the minScore
     * @return the GetSearchMatchesOptions builder
     */
    public Builder minScore(Float minScore) {
      this.minScore = minScore;
      return this;
    }

    /**
     * Set the fields.
     *
     * @param fields the fields
     * @return the GetSearchMatchesOptions builder
     */
    public Builder fields(String fields) {
      this.fields = fields;
      return this;
    }
  }

  private GetSearchMatchesOptions(Builder builder) {
    Validator.notEmpty(builder.corpus, "corpus cannot be empty");
    Validator.notEmpty(builder.documentId, "documentId cannot be empty");
    Validator.notNull(builder.minScore, "minScore cannot be null");
    corpus = builder.corpus;
    documentId = builder.documentId;
    cuis = builder.cuis;
    text = builder.text;
    types = builder.types;
    attributes = builder.attributes;
    values = builder.values;
    limit = builder.limit;
    searchTagBegin = builder.searchTagBegin;
    searchTagEnd = builder.searchTagEnd;
    relatedTagBegin = builder.relatedTagBegin;
    relatedTagEnd = builder.relatedTagEnd;
    minScore = builder.minScore;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a GetSearchMatchesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the corpus.
   *
   * Corpus name.
   *
   * @return the corpus
   */
  public String corpus() {
    return corpus;
  }

  /**
   * Gets the documentId.
   *
   * Document ID (e.g, 7014026).
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the cuis.
   *
   * cui[,rank,[type]] - Example: "C0030567,10". The rank is an optional value from 0 to 10 (defalut is 10). Special
   * rank values: 0=omit, 10=require. Related concepts can also be included by appending, '-PAR' (parents), '-CHD'
   * (children), '-SIB' (siblings), or '-RQ' (related) to the CUI (eg., to include all children of C0030567:
   * 'C0030567-CHD')).  The type may explicitly select a semanic type for a concept.  If no type is specified, a default
   * type is selected.
   *
   * @return the cuis
   */
  public List<String> cuis() {
    return cuis;
  }

  /**
   * Gets the text.
   *
   * Case insensitive text searches.
   *
   * @return the text
   */
  public List<String> text() {
    return text;
  }

  /**
   * Gets the types.
   *
   * Highlight all text spans matching these semantic types.
   *
   * @return the types
   */
  public List<String> types() {
    return types;
  }

  /**
   * Gets the attributes.
   *
   * Highlight all text spans matching these attributes.  An attribute may also specify a range value (e.g.,
   * age:years:65-100) or  a string value (e.g., gender:female).
   *
   * @return the attributes
   */
  public List<String> attributes() {
    return attributes;
  }

  /**
   * Gets the values.
   *
   * Highlight all text spans matching these values.  e.g., age:years:within:65-100 or gender:female  a string value
   * (e.g., gender:female).
   *
   * @return the values
   */
  public List<String> values() {
    return values;
  }

  /**
   * Gets the limit.
   *
   * Limit the number of matching passages per search concept/search term (1 to 250).  Default is 50.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the searchTagBegin.
   *
   * HTML tag used to highlight search concepts found in the text.  Default is '&ltb&gt'.
   *
   * @return the searchTagBegin
   */
  public String searchTagBegin() {
    return searchTagBegin;
  }

  /**
   * Gets the searchTagEnd.
   *
   * HTML tag used to highlight search concepts found in the text.  Default is '&lt/b&gt'.
   *
   * @return the searchTagEnd
   */
  public String searchTagEnd() {
    return searchTagEnd;
  }

  /**
   * Gets the relatedTagBegin.
   *
   * HTML tag used to highlight related concepts found in the text.  Default is '&ltu&gt'.
   *
   * @return the relatedTagBegin
   */
  public String relatedTagBegin() {
    return relatedTagBegin;
  }

  /**
   * Gets the relatedTagEnd.
   *
   * HTML tag used to highlight related concepts found in the text.  Default is '&lt/u&gt'.
   *
   * @return the relatedTagEnd
   */
  public String relatedTagEnd() {
    return relatedTagEnd;
  }

  /**
   * Gets the minScore.
   *
   * Minimum score .0 to 1.0.
   *
   * @return the minScore
   */
  public Float minScore() {
    return minScore;
  }

  /**
   * Gets the fields.
   *
   * Comma separated list of fields to return:  passages, annotations, highlightedTitle, highlightedAbstract,
   * highlightedBody.
   *
   * @return the fields
   */
  public String fields() {
    return fields;
  }
}

