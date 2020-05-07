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

import static com.ibm.watson.health.iml.v1.utils.ServiceUtilities.getProperty;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.AddArtifactOptions;
import com.ibm.watson.health.iml.v1.model.AttributeEntry;
import com.ibm.watson.health.iml.v1.model.DictonaryEntry;
import com.ibm.watson.health.iml.v1.model.PossibleValues;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

public class TestDefineCorpusConcept {
	private InsightsForMedicalLiteratureService imlService;

	public TestDefineCorpusConcept() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDefineCorpusConcept() {
		List<String> definitionStrings = new ArrayList<String>(1);
		definitionStrings.add(Constants.CUSTOM_CONCEPT_DEFINITION);
		List<String> types = new ArrayList<String>(1);
		types.add(Constants.CUSTOM_CONCEPT_TYPE);
		List<String> children = new ArrayList<String>(1);
		children.add(Constants.CUSTOM_CONCEPT_CHILD);
		List<String> parents = new ArrayList<String>(1);
		parents.add(Constants.CUSTOM_CONCEPT_PARENT);
		List<String> related = new ArrayList<String>(1);
		related.add(Constants.CUSTOM_CONCEPT_RELATED);
		List<String> siblings = new ArrayList<String>(1);
		siblings.add(Constants.CUSTOM_CONCEPT_SIBLING);
		List<String> surfaceForms = new ArrayList<String>(1);
		surfaceForms.add(Constants.CUSTOM_CONCEPT_SURFACE_FORM);
		List<String> variants = new ArrayList<String>(1);
		variants.add(Constants.CUSTOM_CONCEPT_VARIANT);

		DictonaryEntry entry = new DictonaryEntry.Builder()
			.cui(Constants.CUSTOM_CONCEPT_CUI)
			.preferredName(Constants.CUSTOM_CONCEPT_PERFERRRED_NAME)
			.definition(definitionStrings)
			.semtypes(types)
			.children(children)
			.parents(parents)
			.siblings(siblings)
			.related(related)
			.source(Constants.CUSTOM_CONCEPT_SOURCE)
			.sourceVersion(Constants.CUSTOM_CONCEPT_SOURCE_VERSION)
			.surfaceForms(surfaceForms)
			.variants(variants)
			.vocab(Constants.CUSTOM_CONCEPT_VOCAB)
			.build();

		AddArtifactOptions options = new AddArtifactOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.dictionaryEntry(entry).build();
		ServiceCall<Void> sc = imlService.addArtifact(options);
		try {
			Response<Void> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

	@Test
	public void testDefineCorpusAttribute() {
		List<String> fieldValues = new ArrayList<String>(1);
		fieldValues.add(Constants.CUSTOM_ATTR_VALUE);
		List<PossibleValues> possibleValues = new ArrayList<PossibleValues>(1);
		PossibleValues pv = new PossibleValues.Builder()
				.value(Constants.CUSTOM_ATTR_VALUE)
				.displayValue(Constants.CUSTOM_ATTR_VALUE)
				.build();

		AttributeEntry entry = new AttributeEntry.Builder()
			.attrName(Constants.CUSTOM_ATTR_NAME)
			.dataType(Constants.CUSTOM_ATTR_DATA_TYPE)
			.defaultValue(Constants.CUSTOM_ATTR_VALUE)
			.description(Constants.CUSTOM_CONCEPT_DEFINITION)
			.displayName(Constants.CUSTOM_ATTR_DISPLAY_NAME)
			.docId(Constants.CUSTOM_ATTR_ID)
			.fieldValues(fieldValues)
			.maximumValue(Constants.CUSTOM_ATTR_VALUE)
			.minimumValue(Constants.CUSTOM_ATTR_VALUE)
			.multiValue(false)
			.possibleValues(possibleValues)
			.units("")
			.valueType(Constants.CUSTOM_ATTR_DATA_TYPE)
			.build();

		AddArtifactOptions options = new AddArtifactOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.attributeEntry(entry).build();
		ServiceCall<Void> sc = imlService.addArtifact(options);
		try {
			Response<Void> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

}
