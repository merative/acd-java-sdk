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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.model.AcdCartridges;
import com.ibm.watson.health.acd.v1.model.AcdCartridgesList;
import com.ibm.watson.health.acd.v1.model.AcdFlow;
import com.ibm.watson.health.acd.v1.model.AcdProfile;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.Annotator.Name;
import com.ibm.watson.health.acd.v1.model.AnnotatorFlow;
import com.ibm.watson.health.acd.v1.model.CartridgesGetIdOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesGetOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPostMultipartOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPutMultipartOptions;
import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.ContainerGroup;
import com.ibm.watson.health.acd.v1.model.CreateFlowsOptions;
import com.ibm.watson.health.acd.v1.model.CreateProfileOptions;
import com.ibm.watson.health.acd.v1.model.CreateProfileOptions.Builder;
import com.ibm.watson.health.acd.v1.model.DeleteFlowsOptions;
import com.ibm.watson.health.acd.v1.model.DeleteProfileOptions;
import com.ibm.watson.health.acd.v1.model.DeleteUserSpecificArtifactsOptions;
import com.ibm.watson.health.acd.v1.model.DeployCartridgeOptions;
import com.ibm.watson.health.acd.v1.model.DeployCartridgeResponse;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.FlowEntry;
import com.ibm.watson.health.acd.v1.model.GetAnnotatorsByIdOptions;
import com.ibm.watson.health.acd.v1.model.GetAnnotatorsOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsByIdOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions;
import com.ibm.watson.health.acd.v1.model.GetProfileOptions;
import com.ibm.watson.health.acd.v1.model.GetProfilesOptions;
import com.ibm.watson.health.acd.v1.model.ListStringWrapper;
import com.ibm.watson.health.acd.v1.model.ServiceApiBean;
import com.ibm.watson.health.acd.v1.model.ServiceStatus;
import com.ibm.watson.health.acd.v1.model.UpdateFlowsOptions;
import com.ibm.watson.health.acd.v1.model.UpdateProfileOptions;
import com.ibm.watson.health.acd.v1.util.FlowUtil;

/**
 * Sample ACD Java SDK Calls
 *
 * Note: to run this sample class, replace "<YOUR_APIKEY>" below with your apikey
 * for the Annotator for Clinical Data (ACD) service. Make sure the ACD_URL var reflects
 * the ACD region you're using. Update the version var as well if you require a
 * specific version of ACD.
 */
public class AnnotatorForClinicalDataExample {

	public static final String ACD_APIKEY="<YOUR_APIKEY>";
	public static final String ACD_URL="https://us-east.wh-acd.cloud.ibm.com/wh-acd/api";
	//public static String ACD_URL="https://us-south.wh-acd.cloud.ibm.com/wh-acd/api";
	public static String version = "2020-06-01";
	public static AnnotatorForClinicalData acd = null;

	static {

		Authenticator authenticator = new BasicAuthenticator("apikey", ACD_APIKEY);
		acd = new AnnotatorForClinicalData(
				version,
				AnnotatorForClinicalData.DEFAULT_SERVICE_NAME,
				authenticator);
		acd.setServiceUrl(ACD_URL);

	}

	public static void main(String[] args) {

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

	}

	/*
	 * Annotator for Clinical Data Text Analysis Calls
	 */

	// POST /analyze
	public static void analyze() {

		List<String> annotators = Arrays.asList(
				Name.CONCEPT_DETECTION,
				Name.NEGATION);

		Flow flow = new FlowUtil.Builder()
				.annotators(annotators).build();

		String text = "Patient has lung cancer, but did not smoke. She may consider chemotherapy as part of a treatment plan.";

		ContainerGroup response = acd.analyze(text, flow);

		List<Concept> concepts = response.getConcepts();

		for (Concept c: concepts)
			System.out.println("Type: " + c.getType()
				+ " Name: " + c.getPreferredName()
				+ " | Negated (t/f): " + c.get("negated"));


	}

	// POST /analyze/{flowId}
	public static void analyzeWithFlow() {

		String flowId = "wh_acd.ibm_clinical_insights_v1.0_standard_flow";
		String text = "Patient has lung cancer, but did not smoke. She may consider chemotherapy as part of a treatment plan.";

		ContainerGroup response = acd.analyzeWithFlow(flowId, text);

		List<Concept> concepts = response.getConcepts();

		for (Concept c: concepts)
			System.out.println("Type: " + c.getType()
				+ " Name: " + c.getPreferredName());

	}

	/*
	 * Profile Crud Operations
	 */

	// GET /profiles
	public static void getProfiles() {

		GetProfilesOptions options = new GetProfilesOptions.Builder().build();
		ServiceCall<Map<String, AcdProfile>> sc = acd.getProfiles(options);
		Response<Map<String, AcdProfile>> resp = sc.execute();
		Map<String, AcdProfile> profileMap = resp.getResult();

		for (String id:profileMap.keySet())
			System.out.println("Profile Id: " + id + " Desc:" + profileMap.get(id).description());

	}

	// GET /profiles/{id}
	public static void getProfile() {

		GetProfileOptions options = new GetProfileOptions.Builder()
				.id("wh_acd.ibm_clinical_insights_v1.0_profile").build();
		ServiceCall<AcdProfile> sc = acd.getProfile(options);
		Response<AcdProfile> response = sc.execute();
		AcdProfile profile = response.getResult();
		System.out.println(profile);

		System.out.println("Id: " + profile.id());
		System.out.println("Name: " + profile.name());
		System.out.println("Annotators:");
		List<Annotator> annos = profile.annotators();
		for (Annotator anno:annos)
			System.out.println('\t' + anno.name());
                        Map<String, List<String>> annoParmMap = (Map<String, List<String>>)anno.parameters();
                        System.out.println("Profile Config Parms:");
                        for (Map.Entry<String, List<String>> mapEntry : annoParmMap.entrySet()) {
                                for (String profileParmEntry : mapEntry.getValue()) {
                                        System.out.println("Name: " + mapEntry.getKey() + " Value: " + profileParmEntry);
                                }
                        }
                }
	}

	// POST /profiles
	public static void createProfile() {

		Map<String, Set<String>> conceptDetectionParams
			= new HashMap<String,Set<String>>(){{put("libraries",
				new HashSet<String>() {{ add("umls.latest"); }} ); }};

		Annotator conceptDetection = new Annotator.Builder()
				.name(Annotator.Name.CONCEPT_DETECTION)
				.parameters(new java.util.HashMap<String,List<String>>(){{put("libraries", Arrays.asList("umls.latest")); }})
				.build();

		Builder bldr = new CreateProfileOptions.Builder();
		bldr.id("my_profile");
		bldr.name("My profile");
		bldr.description("My profile desc");
		bldr.addAnnotators(conceptDetection);

		ServiceCall<Void> call = acd.createProfile(bldr.build());
		Response<Void> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode()); // should be 201

	}

	// PUT /profiles
	public static void updateProfile() {

		Map<String, Set<String>> conceptDetectionParams
			= new HashMap<String,Set<String>>(){{put("libraries",
			   new HashSet<String>() {{ add("umls.2019AA"); }} ); }};

		Annotator conceptDetection = new Annotator.Builder()
				.name(Annotator.Name.CONCEPT_DETECTION)
				.parameters(conceptDetectionParams)
				.build();

		UpdateProfileOptions.Builder bldr
			= new UpdateProfileOptions.Builder();

		bldr.id("my_profile");
		bldr.newId("my_profile");
		bldr.newName("My profile - updated");
		bldr.newDescription("My profile desc - updated");
		bldr.newAnnotators(Arrays.asList(new Annotator[] {conceptDetection}));

		ServiceCall<Void> call = acd.updateProfile(bldr.build());
		Response<Void> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode()); // should be 200

	}

	// DELETE /profiles/{id}
	public static void deleteProfile() {

		DeleteProfileOptions options = new DeleteProfileOptions
				.Builder()
				.id("my_profile")
				.build();

		ServiceCall<Void> call = acd.deleteProfile(options);
		Response<Void> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode()); // should be 200

	}

	/*
	 * Annotator Flow Crud Operations
	 */

	// GET /flows
	public static void getFlows() {

		GetFlowsOptions options = new GetFlowsOptions.Builder().build();
		ServiceCall<Map<String, AcdFlow>> call = acd.getFlows(options);
		Response<Map<String, AcdFlow>> resp = call.execute();
		Map<String, AcdFlow> mapStrAcdFlow = resp.getResult();
		for( String id:mapStrAcdFlow.keySet() )
			System.out.println("Flow: " + id + " Desc: " + mapStrAcdFlow.get(id).description());


	}

	// GET /flows/{id}
	public static void getFlow() {

		GetFlowsByIdOptions options = new GetFlowsByIdOptions.Builder()
				.id("wh_acd.ibm_clinical_insights_v1.0_standard_flow")
				.build();
		ServiceCall<AcdFlow> sc = acd.getFlowsById(options);
		Response<AcdFlow> resp = sc.execute();
		AcdFlow flow = resp.getResult();

		System.out.println("Id: " + flow.id());
		System.out.println("Name: " + flow.name());
		System.out.println("Description: " + flow.description());

		System.out.println("Annotators:");
		List<AnnotatorFlow> annotatorFlowList = flow.annotatorFlows();
		for ( AnnotatorFlow annotatorFlow : annotatorFlowList ) {
			Flow annotatorFlowFlow = annotatorFlow.flow();
			List<FlowEntry> flowEntryList = annotatorFlowFlow.elements();
			for( FlowEntry flowEntry : flowEntryList ) {
				Annotator annotator =  flowEntry.annotator();
				System.out.println('\t' + annotator.name());
			}
		}

	}

	// POST /flows
	public static void createFlow() {

		Annotator conceptDetection = new Annotator.Builder()
			.name(Annotator.Name.CONCEPT_DETECTION).build();

		Annotator negation = new Annotator.Builder()
			.name(Annotator.Name.NEGATION).build();

		FlowEntry cdFlowEntry = new FlowEntry
			.Builder().annotator(conceptDetection).build();

		FlowEntry negFlowEntry = new FlowEntry
			.Builder().annotator(negation).build();

		Flow flow = new Flow.Builder()
			.elements(Arrays.asList(cdFlowEntry, negFlowEntry))
			.async(true)
			.build();

		AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder()
			.flow(flow)
			.build();

		AcdFlow acdFlow = new AcdFlow.Builder()
				.id("my_flow")
				.name("My flow name")
				.description("My flow desc")
				.annotatorFlows(Arrays.asList(annotatorFlow))
				.build();

		CreateFlowsOptions options = new CreateFlowsOptions
			.Builder()
			.acdFlow(acdFlow)
			.build();

		ServiceCall<Void> call = acd.createFlows(options);
		Response<Void> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode()); // should be 201

	}

	// PUT /flows
	public static void updateFlow() {

		Annotator conceptDetection = new Annotator.Builder()
			.name(Annotator.Name.CONCEPT_DETECTION).build();

		Annotator hypothetical = new Annotator.Builder()
			.name(Annotator.Name.HYPOTHETICAL).build();

		FlowEntry cdFlowEntry = new FlowEntry
			.Builder().annotator(conceptDetection).build();

		FlowEntry hypoFlowEntry = new FlowEntry
			.Builder().annotator(hypothetical).build();

		Flow flow = new Flow.Builder()
			.elements(Arrays.asList(cdFlowEntry, hypoFlowEntry))
			.async(true)
			.build();

		AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder()
			.flow(flow)
			.build();

		AcdFlow acdFlow = new AcdFlow.Builder()
			.id("my_flow")
			.name("My flow name - updated")
			.description("My flow desc - updated")
			.annotatorFlows(Arrays.asList(annotatorFlow))
			.build();

		UpdateFlowsOptions opts = new UpdateFlowsOptions.Builder()
			.id("my_flow")
			.acdFlow(acdFlow)
			.build();

		ServiceCall<Void> call = acd.updateFlows(opts);
		Response<Void> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode()); // should be 200


	}

	// DELETE /flows/{id}
	public static void deleteFlow() {

		DeleteFlowsOptions opts = new DeleteFlowsOptions
			.Builder()
			.id("my_flow")
			.build();

		ServiceCall<Void> call = acd.deleteFlows(opts);
		Response<Void> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode()); // should be 200

	}

	// DELETE /user_data
	public static void deleteTenantData() {

		DeleteUserSpecificArtifactsOptions opts = new DeleteUserSpecificArtifactsOptions();
		ServiceCall<Void> call = acd.deleteUserSpecificArtifacts(opts);
		Response<Void> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode());

	}

	// GET /status/health_check
	public static void getHealthCheck() {

		ServiceCall<ServiceStatus> call = acd.getHealthCheckStatus();
		Response<ServiceStatus> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode() + " Status: " + resp.getStatusMessage());

	}

	// GET /cartridges
	public static void getCartridges() {

		CartridgesGetOptions opts = new CartridgesGetOptions();
		ServiceCall<AcdCartridgesList> call = acd.cartridgesGet(opts);
		Response<AcdCartridgesList> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode());
		AcdCartridgesList cartridges = resp.getResult();
		for (AcdCartridges cartridge:cartridges.getCartridges())
			System.out.println("Cartridge: " + cartridge.getId() + " Status: " + cartridge.getStatus());

	}

	// GET /cartridges/{id}
	public static void getCartridge() {

		CartridgesGetIdOptions opts = new CartridgesGetIdOptions.Builder()
				.id("wh_acd.ibm_clinical_insights_v1.0").build();

		ServiceCall<AcdCartridges> call = acd.cartridgesGetId(opts);
		Response<AcdCartridges> resp = call.execute();
		System.out.println("Status code: " + resp.getStatusCode());
		AcdCartridges cart = resp.getResult();
		System.out.println("Cartridge: " + cart.getId() + " Status: " + cart.getStatus());

	}

	// POST /cartridges
	public static void deployCartridge() {

		File cartridgeZip = new File("/tmp/my_cartridge_v2.0.zip");

		CartridgesPostMultipartOptions opts;

		try {
			opts = new CartridgesPostMultipartOptions.Builder()
					.archiveFile(cartridgeZip)
					.build();

			ServiceCall<DeployCartridgeResponse> call = acd.cartridgesPostMultipart(opts);
			Response<DeployCartridgeResponse> resp = call.execute();
			System.out.println(resp.getStatusCode());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// PUT /cartridges
	public static void redeployCartridge() {

		File cartridgeZip = new File("/tmp/my_cartridge_v2.0.zip");

		CartridgesPutMultipartOptions opts;

		try {
			opts = new CartridgesPutMultipartOptions.Builder()
					.archiveFile(cartridgeZip)
					.build();

			ServiceCall<DeployCartridgeResponse> call = acd.cartridgesPutMultipart(opts);
			Response<DeployCartridgeResponse> resp = call.execute();
			System.out.println(resp.getStatusCode());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// POST /deploy
	public static void legacyDeploy() {

		File cartridgeZip = new File("/tmp/my_cartridge_v2.0.zip");
		DeployCartridgeOptions opts;
		try {
			opts = new DeployCartridgeOptions.Builder()
					.archiveFile(cartridgeZip)
					.archiveFileContentType("application/octet-stream")
					.update(true).build();
			ServiceCall<DeployCartridgeResponse> call = acd.deployCartridge(opts);
			Response<DeployCartridgeResponse> resp = call.execute();
			System.out.println("Response code: " + resp.getStatusCode());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// GET /annotators
	public static void getAnnotators() {

		GetAnnotatorsOptions opts = new GetAnnotatorsOptions();
		ServiceCall<Map<String, ServiceApiBean>> call = acd.getAnnotators(opts);
		Response<Map<String, ServiceApiBean>> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode());
		Map<String, ServiceApiBean> annotators = resp.getResult();
		for (String id:annotators.keySet())
			System.out.println(id);

	}

	// GET /annotators/{id}
	public static void getAnnotator() {

		GetAnnotatorsByIdOptions opts = new GetAnnotatorsByIdOptions.Builder().id("negation").build();
		ServiceCall<Annotator> call = acd.getAnnotatorsById(opts);
		Response<Annotator> resp = call.execute();
		System.out.println("Response code: " + resp.getStatusCode());
		System.out.println(resp.getResult().description());

	}

}
