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
package com.ibm.watson.health.iml.v1.corpora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.WatsonServiceTest;
import com.ibm.watson.health.iml.v1.model.CorporaConfigModel;
import com.ibm.watson.health.iml.v1.model.EnrichmentTarget;
import com.ibm.watson.health.iml.v1.model.MetadataField;
import com.ibm.watson.health.iml.v1.model.SetCorpusSchemaOptions;
import com.ibm.watson.health.iml.v1.model.SetCorpusSchemaOptions.Builder;

public class TestCreateCorpusSchema extends WatsonServiceTest {
	private InsightsForMedicalLiteratureService imlService;

	public TestCreateCorpusSchema() {
		super();
		try {
			this.setUp();
			imlService = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateCorpusSchema() {
		EnrichmentTarget et1 = new EnrichmentTarget("abstract", "abstract");
		EnrichmentTarget et2 = new EnrichmentTarget();
		if (et2.getContentField() == null) {
			et2.setContentField("text");
		}
		if (et2.getEnrichmentField() == null) {
			et2.setEnrichmentField("body");
		}
		List<EnrichmentTarget> enrichmentTargets = new ArrayList<EnrichmentTarget>();
		enrichmentTargets.add(et1);
		enrichmentTargets.add(et2);
		MetadataField mf1 = new MetadataField("publicationName", "keyword");
		MetadataField mf2 = new MetadataField();
		if (mf2.getFieldName() == null) {
			mf2.setFieldName("references");
		}
		if (mf2.getFieldType() == null) {
			mf2.setFieldType("object");
		}
		List<MetadataField> metadataFields = new ArrayList<MetadataField>();
		metadataFields.add(mf1);
		metadataFields.add(mf2);
		Map<String, String> referenceIndices = new HashMap<String, String>();
		referenceIndices.put("concepts", "my_dictionaries");
		referenceIndices.put("attributes", "my_attributes");

		SetCorpusSchemaOptions schemaOptions = new SetCorpusSchemaOptions.Builder().corpusName("sdk_test").userName("elastic").password("imliml")
				.corpusURI("watsonvmwrk27.rch.stglabs.ibm.com:9200").enrichmentTargets(enrichmentTargets).metadataFields(metadataFields).references(referenceIndices).build();
		ServiceCall<CorporaConfigModel> sc = imlService.setCorpusSchema(schemaOptions);
		try {
			Response<CorporaConfigModel> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

	@Test
	public void testCreateCorpusSchemaAddingArrayElements() {
		EnrichmentTarget et1 = new EnrichmentTarget("abstract", "abstract");
		EnrichmentTarget et2 = new EnrichmentTarget("text", "body");
		List<EnrichmentTarget> enrichmentTargets = new ArrayList<EnrichmentTarget>();
		enrichmentTargets.add(et1);
		enrichmentTargets.add(et2);
		MetadataField mf1 = new MetadataField("publicationName", "keyword");
		MetadataField mf2 = new MetadataField("references", "object");
		List<MetadataField> metadataFields = new ArrayList<MetadataField>();
		metadataFields.add(mf1);
		metadataFields.add(mf2);
		Map<String, String> referenceIndices = new HashMap<String, String>();
		referenceIndices.put("concepts", "my_dictionaries");
		referenceIndices.put("attributes", "my_attributes");

		SetCorpusSchemaOptions schemaOptions = new SetCorpusSchemaOptions.Builder().corpusName("sdk_test").userName("elastic").password("imliml")
				.corpusURI("watsonvmwrk27.rch.stglabs.ibm.com:9200").addEnrichmentTargets(enrichmentTargets).addMetadataFields(metadataFields).references(referenceIndices).build();
		ServiceCall<CorporaConfigModel> sc = imlService.setCorpusSchema(schemaOptions);
		try {
			Response<CorporaConfigModel> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		EnrichmentTarget et1 = new EnrichmentTarget("abstract", "abstract");
		EnrichmentTarget et2 = new EnrichmentTarget("text", "body");
		List<EnrichmentTarget> enrichmentTargets = new ArrayList<EnrichmentTarget>();
		enrichmentTargets.add(et1);
		enrichmentTargets.add(et2);
		MetadataField mf1 = new MetadataField("publicationName", "keyword");
		MetadataField mf2 = new MetadataField("references", "object");
		List<MetadataField> metadataFields = new ArrayList<MetadataField>();
		metadataFields.add(mf1);
		metadataFields.add(mf2);
		Map<String, String> referenceIndices = new HashMap<String, String>();
		referenceIndices.put("concepts", "my_dictionaries");
		referenceIndices.put("attributes", "my_attributes");

		SetCorpusSchemaOptions schemaOptions = new SetCorpusSchemaOptions.Builder().corpusName("sdk_test").userName("elastic").password("imliml")
				.corpusURI("watsonvmwrk27.rch.stglabs.ibm.com:9200").addEnrichmentTargets(enrichmentTargets).addMetadataFields(metadataFields).references(referenceIndices).build();
		Builder builder = schemaOptions.newBuilder();
		Assert.assertNotNull(builder);
	}
}
