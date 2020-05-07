/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.health.iml.v1.search;
import static com.ibm.watson.health.iml.v1.utils.ServiceUtilities.getProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.FieldOptions;
import com.ibm.watson.health.iml.v1.model.GetFieldsOptions;
import com.ibm.watson.health.iml.v1.model.GetFieldsOptions.Builder;
import com.ibm.watson.health.iml.v1.model.MetadataModel;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 *
 * Class for testing /v1/corpora/{corpus}/search/metadata.
 *
 */
public class TestGetSearchMetatdata {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetSearchMetatdata() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getMetadata() {
		GetFieldsOptions options = new GetFieldsOptions.Builder().corpus(getProperty(Constants.CORPUS)).build();

		ServiceCall<MetadataModel> sc = imlService.getFields(options);
		Response<MetadataModel> response = sc.execute();
		MetadataModel model = response.getResult();

		Map<String, FieldOptions> fieldMap = model.getFields();
		Set<String> keys = fieldMap.keySet();
		for (String key : keys) {
			List<String> supportsList = fieldMap.get(key).getSupports();
			for (String support : supportsList) {
				Assert.assertNotNull(support);
			}
		}

	}

	@Test
	public void getMetadataBuilder() {
		Builder builder = new GetFieldsOptions.Builder(getProperty(Constants.CORPUS));

		ServiceCall<MetadataModel> sc = imlService.getFields(builder.build());
		Response<MetadataModel> response = sc.execute();
		MetadataModel model = response.getResult();

		Map<String, FieldOptions> fieldMap = model.getFields();
		Set<String> keys = fieldMap.keySet();
		for (String key : keys) {
			List<String> supportsList = fieldMap.get(key).getSupports();
			for (String support : supportsList) {
				Assert.assertNotNull(support);
			}
		}

	}

	@Test
	public void getBuilderFromOptions() {
		GetFieldsOptions options = new GetFieldsOptions.Builder().corpus(getProperty(Constants.CORPUS)).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}

}
