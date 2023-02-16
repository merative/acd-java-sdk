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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.BearerTokenAuthenticator;
//import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.watson.health.acd.v1.model.AcdCartridges;
import com.ibm.watson.health.acd.v1.model.AcdCartridgesList;
import com.ibm.watson.health.acd.v1.model.AcdFlow;
import com.ibm.watson.health.acd.v1.model.Annotator.Name;
import com.ibm.watson.health.acd.v1.model.CartridgesGetIdOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesGetOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPostMultipartOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPutMultipartOptions;
import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.ContainerGroup;
import com.ibm.watson.health.acd.v1.model.DeployCartridgeResponse;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.GetFlowsByIdOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions;
import com.ibm.watson.health.acd.v1.model.GetHealthCheckStatusOptions;
import com.ibm.watson.health.acd.v1.model.ServiceStatus;
import com.ibm.watson.health.acd.v1.util.FlowUtil;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

/**
 * Sample ACD Java SDK Calls
 *
 * NOTE: To run this sample class, replace "ACD_TOKEN" below with your ACD bearer token,
 * and replace "ACD_URL" with the URL for the Annotator for Clinical Data (ACD) service endpoint.
 *
 * Optional: Update the "version" variable if you require a specific version of ACD.
 */
public class AnnotatorForClinicalDataExample {

  protected AnnotatorForClinicalDataExample() { }

  public static void main(String[] args) throws Exception {
    String authToken = "ACD_TOKEN";
    String url = "ACD_URL";
    String version = "2022-02-24";
    AnnotatorForClinicalData acd = null;

    BearerTokenAuthenticator authenticator = new BearerTokenAuthenticator(authToken);
    acd = new AnnotatorForClinicalData(
        version,
        AnnotatorForClinicalData.DEFAULT_SERVICE_NAME,
        authenticator);
    acd.setServiceUrl(url);
    // Uncomment the next 2 lines to disable SSL verification - not recommended
    //HttpConfigOptions options = new HttpConfigOptions.Builder().disableSslVerification(true).build();
    //acd.configureClient(options);



    /* Analyze */
    // analyze();
    // analyzeWithFlow();

    /* Cartridge deployment */
    // getCartridges();
    // getCartridge();
    // deployCartridge();
    // redeployCartridge();

    /* Annotator flow  */
    // getFlows();
    // getFlow();

    /* Misc */
    // getHealthCheck();


    /*
     * Annotator for Clinical Data
     */

    // Analyze
    try {
      System.out.println("\n Analyze =>");
      List<String> annotators = Arrays.asList(
          Name.CONCEPT_DETECTION,
          Name.NEGATION);
      Flow flow = new FlowUtil.Builder()
          .annotators(annotators).build();
      String text = "Patient has lung cancer, but did not smoke. She may consider chemotherapy as part of a treatment plan.";

      ContainerGroup response = acd.analyze(text, flow);
      List<Concept> concepts = response.getConcepts();
      for (Concept c : concepts) {
        System.out.println("Type: " + c.getType()
        + " Name: " + c.getPreferredName()
        + " | Negated (true/false): " + c.isNegated());
      }
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());

    }

    // Analyze with Flow
    try {
      System.out.println("\n Analyze with Flow =>");
      String flowId = "wh_acd.ibm_clinical_insights_v1.0_standard_flow";
      String text = "Patient has lung cancer, but did not smoke. She may consider chemotherapy as part of a treatment plan.";

      ContainerGroup response = acd.analyzeWithFlow(flowId, text);
      List<Concept> concepts = response.getConcepts();

      for (Concept c : concepts) {
        System.out.println("Type: " + c.getType()
        + " Name: " + c.getPreferredName()
        + " | CUI: " + c.getCui());
      }
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

    // Get Cartridges
    try {
      System.out.println("\n Get Cartridges =>");
      CartridgesGetOptions opts = new CartridgesGetOptions();
      ServiceCall<AcdCartridgesList> getCartridgesCall = acd.cartridgesGet(opts);

      Response<AcdCartridgesList> resp = getCartridgesCall.execute();
      AcdCartridgesList cartridges = resp.getResult();

      for (AcdCartridges cartridge : cartridges.getCartridges()) {
        System.out.println("Cartridge: " + cartridge.getId() + " Status: " + cartridge.getStatus());
      }
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

    // Get Cartridge by ID
    try {
      System.out.println("\n Get Cartridge by ID =>");
      CartridgesGetIdOptions opts = new CartridgesGetIdOptions.Builder()
        .id("wh_acd.ibm_clinical_insights_v1.0").build();
      ServiceCall<AcdCartridges> getCartridgeCall = acd.cartridgesGetId(opts);

      Response<AcdCartridges> resp = getCartridgeCall.execute();
      AcdCartridges cart = resp.getResult();

      System.out.println("Cartridge: " + cart.getId() + " Status: " + cart.getStatus());
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

    // Deploy Cartridge Asynchronously
    File cartridgeZip = new File("name_of_exported cartridge_zip_file.zip");
    try {
      System.out.println("\n Deploy Cartridge =>");
      CartridgesPostMultipartOptions opts = new CartridgesPostMultipartOptions.Builder()
          .archiveFile(cartridgeZip)
          .build();

      ServiceCall<DeployCartridgeResponse> deployCartridgeCall = acd.cartridgesPostMultipart(opts);
      Response<DeployCartridgeResponse> resp = deployCartridgeCall.execute();

      System.out.println(resp.getStatusCode());
    } catch (FileNotFoundException e) {
      System.out.println("File " + cartridgeZip + " not found for cartridge deployment: " + e.getMessage());
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

    // Redeploy Existing Cartridge
    try {
      System.out.println("\n Redeploy Cartridge =>");
      CartridgesPutMultipartOptions opts = new CartridgesPutMultipartOptions.Builder()
          .archiveFile(cartridgeZip)
          .build();

      ServiceCall<DeployCartridgeResponse> redeployCartridgeCall = acd.cartridgesPutMultipart(opts);
      Response<DeployCartridgeResponse> resp = redeployCartridgeCall.execute();

      System.out.println(resp.getStatusCode());
    } catch (FileNotFoundException e) {
      System.out.println("File " + cartridgeZip + " not found for cartridge redeployment: " + e.getMessage());
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

    // Get Flows
    try {
      System.out.println("\n Get Flows =>");
      GetFlowsOptions options = new GetFlowsOptions.Builder().build();

      ServiceCall<Map<String, AcdFlow>> getFlowsCall = acd.getFlows(options);
      Response<Map<String, AcdFlow>> resp = getFlowsCall.execute();

      Map<String, AcdFlow> mapAcdFlow = resp.getResult();
      for (String id : mapAcdFlow.keySet()) {
        System.out.println("Flow: " + id);
      }
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

    // Get Flow by ID
    try {
      System.out.println("\n Get Flows by ID =>");
      GetFlowsByIdOptions options = new GetFlowsByIdOptions.Builder()
          .id("wh_acd.ibm_clinical_insights_v1.0_standard_flow")
          .build();

      ServiceCall<AcdFlow> getFlowIdCall = acd.getFlowsById(options);
      Response<AcdFlow> resp = getFlowIdCall.execute();

      AcdFlow flow = resp.getResult();
      System.out.println("Id: " + flow.id() + " | Name: " + flow.name() + " | Description: " + flow.description());
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

    // Get ACD Service Health Check
    try {
      System.out.println("\n Get ACD Health Check =>");
      GetHealthCheckStatusOptions options = new GetHealthCheckStatusOptions.Builder().build();

      ServiceCall<ServiceStatus> getHealthCheckCall = acd.getHealthCheckStatus(options);
      Response<ServiceStatus> resp = getHealthCheckCall.execute();

      System.out.println("Service Status: " + resp.getResult().getServiceState());
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

  }
}
