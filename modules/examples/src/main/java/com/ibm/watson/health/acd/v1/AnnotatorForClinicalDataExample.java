/*
 * (C) Copyright IBM Corp. 2020, 2022.
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

package com.ibm.watson.health.acd.v1;

import java.util.Arrays;
import java.util.List;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.watson.health.acd.v1.model.Annotator.Name;
import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.ContainerGroup;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.util.FlowUtil;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

/**
 * Sample ACD Java SDK Calls
 *
 * Note: to run this sample class, replace "YOUR_APIKEY" below with your apikey
 * for the Annotator for Clinical Data (ACD) service. Make sure the "url" var reflects
 * the ACD region you're using. Update the "version" var as well if you require a
 * specific version of ACD.
 */
public class AnnotatorForClinicalDataExample {

        protected AnnotatorForClinicalDataExample() { }

        public static void main(String[] args) throws Exception {
	  String apikey = "YOUR_APIKEY";
	  String url = "https://us-east.wh-acd.cloud.ibm.com/wh-acd/api";
	  //String url = "https://us-south.wh-acd.cloud.ibm.com/wh-acd/api";
	  String version = "2022-02-24";
	  AnnotatorForClinicalData acd = null;

          Authenticator authenticator = new BasicAuthenticator("apikey", apikey);
          acd = new AnnotatorForClinicalData(
                       version,
                       AnnotatorForClinicalData.DEFAULT_SERVICE_NAME,
                       authenticator);
          acd.setServiceUrl(url);

		/* Analyze */
		// analyze();
		// analyzeWithFlow();

		/* Cartridge deployment */
		// getCartridges();
		// getCartridge();
		// deployCartridge();
		// redeployCartridge();
		// legacyDeploy();

		/* Profile crud operations */
		// createProfile();
		// getProfiles();
		// getProfile();
		// updateProfile();
		// deleteProfile();

		/* Annotator flow crud operations */
		// createFlow();
		// getFlows();
		// getFlow();
		// updateFlow();
		// deleteFlow();

		/* Misc */
		// deleteTenantData();
		// getHealthCheck();
		// getAnnotators();
		//getAnnotator();


	/*
	 * Annotator for Clinical Data Text Analysis Calls
	 */

	// POST /analyze
        try {

		List<String> annotators = Arrays.asList(
				Name.CONCEPT_DETECTION,
				Name.NEGATION);

		Flow flow = new FlowUtil.Builder()
				.annotators(annotators).build();

		String text = "Patient has lung cancer, but did not smoke. She may consider chemotherapy as part of a treatment plan.";

		ContainerGroup response = acd.analyze(text, flow);

		List<Concept> concepts = response.getConcepts();

		for (Concept c : concepts)
			System.out.println("Type: " + c.getType()
				+ " Name: " + c.getPreferredName()
				+ " | Negated (t/f): " + c.get("negated"));
        } catch (ServiceResponseException e) {
                System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());

	}
   }
}
