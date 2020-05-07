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
package com.ibm.watson.health.iml.v1.concepts;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.WatsonServiceTest;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.AddArtifactOptions;
import com.ibm.watson.health.iml.v1.model.AddArtifactOptions.Builder;
import com.ibm.watson.health.iml.v1.model.AttributeEntry;
import com.ibm.watson.health.iml.v1.model.DictonaryEntry;
import com.ibm.watson.health.iml.v1.model.PossibleValues;

public class TestDefineCorpusConcept extends WatsonServiceTest {
	private InsightsForMedicalLiteratureService imlService;

	public TestDefineCorpusConcept() {
		super();
		try {
			this.setUp();
			imlService = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDefineCorpusConcept() {
		AddArtifactOptions options = new AddArtifactOptions.Builder().corpus(getProperty(Constants.CORPUS)).build();
		DictonaryEntry entry = new DictonaryEntry();
		if (entry.getCui() == null) {
			entry.setCui(Constants.CUSTOM_CONCEPT_CUI);
		}
		if (entry.getPreferredName() == null) {
			entry.setPreferredName(Constants.CUSTOM_CONCEPT_PERFERRRED_NAME);
		}
		if (entry.getSemtypes() == null) {
			List<String> types = new ArrayList<String>(1);
			types.add(Constants.CUSTOM_CONCEPT_TYPE);
			entry.setSemtypes(types);
		}
		if (entry.getDefinition() == null) {
			List<String> definitionStrings = new ArrayList<String>(1);
			definitionStrings.add(Constants.CUSTOM_CONCEPT_DEFINITION);
			entry.setDefinition(definitionStrings);
		}
		if (entry.getChildren() == null) {
			List<String> children = new ArrayList<String>(1);
			children.add(Constants.CUSTOM_CONCEPT_CHILD);
			entry.setChildren(children);
		}
		if (entry.getParents() == null) {
			List<String> parents = new ArrayList<String>(1);
			parents.add(Constants.CUSTOM_CONCEPT_PARENT);
			entry.setParents(parents);
		}
		if (entry.getRelated() == null) {
			List<String> related = new ArrayList<String>(1);
			related.add(Constants.CUSTOM_CONCEPT_RELATED);
			entry.setRelated(related);
		}
		if (entry.getSiblings() == null) {
			List<String> siblings = new ArrayList<String>(1);
			siblings.add(Constants.CUSTOM_CONCEPT_SIBLING);
			entry.setSiblings(siblings);
		}
		if (entry.getSource() == null) {
			entry.setSource(Constants.CUSTOM_CONCEPT_SOURCE);
		}
		if (entry.getSourceVersion() == null) {
			entry.setSourceVersion(Constants.CUSTOM_CONCEPT_SOURCE_VERSION);
		}
		if (entry.getSurfaceForms() == null) {
			List<String> surfaceForms = new ArrayList<String>(1);
			surfaceForms.add(Constants.CUSTOM_CONCEPT_SURFACE_FORM);
			entry.setSurfaceForms(surfaceForms);
		}
		if (entry.getVariants() == null) {
			List<String> variants = new ArrayList<String>(1);
			variants.add(Constants.CUSTOM_CONCEPT_VARIANT);
			entry.setVariants(variants);
		}
		if (entry.getVocab() == null) {
			entry.setVocab(Constants.CUSTOM_CONCEPT_VOCAB);
		}

		ServiceCall<Void> sc = imlService.addArtifact(options);
		try {
			Response<Void> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

	@Test
	public void testDefineCorpusAttribute() {
		AddArtifactOptions options = new AddArtifactOptions.Builder().corpus(getProperty(Constants.CORPUS)).build();
		AttributeEntry entry = new AttributeEntry();
		if (entry.getAttrName() == null) {
			entry.setAttrName(Constants.CUSTOM_ATTR_NAME);
		}
		if (entry.getDataType() == null) {
			entry.setDataType(Constants.CUSTOM_ATTR_DATA_TYPE);
		}
		if (entry.getDefaultValue() == null) {
			entry.setDefaultValue(Constants.CUSTOM_ATTR_VALUE);
		}
		if (entry.getDescription() == null) {
			entry.setDescription(Constants.CUSTOM_CONCEPT_DEFINITION);
		}
		if (entry.getDisplayName() == null) {
			entry.setDisplayName(Constants.CUSTOM_ATTR_DISPLAY_NAME);
		}
		if (entry.getDocId() == null) {
			entry.setDocId(Constants.CUSTOM_ATTR_ID);
		}
		if (entry.getFieldValues() == null) {
			List<String> fieldValues = new ArrayList<String>(1);
			fieldValues.add(Constants.CUSTOM_ATTR_VALUE);
			entry.setFieldValues(fieldValues);
		}
		if (entry.getMaximumValue() == null) {
			entry.setMaximumValue(Constants.CUSTOM_ATTR_VALUE);
		}
		if (entry.getMinimumValue() == null) {
			entry.setMinimumValue(Constants.CUSTOM_ATTR_VALUE);
		}
		if (entry.isMultiValue() == null) {
			entry.setMultiValue(false);
		}
		if (entry.getPossibleValues() == null) {
			List<PossibleValues> possibleValues = new ArrayList<PossibleValues>(1);
			PossibleValues pv = new PossibleValues();
			if (pv.getValue() == null) {
				pv.setValue(Constants.CUSTOM_ATTR_VALUE);
			}
			if (pv.getDisplayValue() == null) {
				pv.setDisplayValue(Constants.CUSTOM_ATTR_VALUE);
			}
			entry.setPossibleValues(possibleValues);
		}
		if (entry.getUnits() == null) {
			entry.setUnits("");
		}
		if (entry.getValueType() == null) {
			entry.setValueType(Constants.CUSTOM_ATTR_DATA_TYPE);
		}
		ServiceCall<Void> sc = imlService.addArtifact(options);
		try {
			Response<Void> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

	@Test
	public void testDefineCorpusBuilder() {
		Builder builder = new AddArtifactOptions.Builder(getProperty(Constants.CORPUS));
		AttributeEntry entry = new AttributeEntry();
		entry.setAttrName(Constants.CUSTOM_ATTR_NAME);
		entry.setDataType(Constants.CUSTOM_ATTR_DATA_TYPE);
		entry.setDefaultValue(Constants.CUSTOM_ATTR_VALUE);
		entry.setDescription(Constants.CUSTOM_CONCEPT_DEFINITION);
		entry.setDisplayName(Constants.CUSTOM_ATTR_DISPLAY_NAME);
		entry.setDocId(Constants.CUSTOM_ATTR_ID);
		List<String> fieldValues = new ArrayList<String>(1);
		fieldValues.add(Constants.CUSTOM_ATTR_VALUE);
		entry.setFieldValues(fieldValues);
		entry.setMaximumValue(Constants.CUSTOM_ATTR_VALUE);
		entry.setMinimumValue(Constants.CUSTOM_ATTR_VALUE);
		entry.setMultiValue(false);
		List<PossibleValues> possibleValues = new ArrayList<PossibleValues>(1);
		PossibleValues pv = new PossibleValues();
		pv.setValue(Constants.CUSTOM_ATTR_VALUE);
		entry.setPossibleValues(possibleValues);
		entry.setUnits("");
		entry.setValueType(Constants.CUSTOM_ATTR_DATA_TYPE);

		ServiceCall<Void> sc = imlService.addArtifact(builder.build());
		try {
			Response<Void> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

	@Test
	public void testBuilderFromOptions() {
		AddArtifactOptions options = new AddArtifactOptions.Builder().corpus(getProperty(Constants.CORPUS)).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
