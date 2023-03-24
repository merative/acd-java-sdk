/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.BearerTokenAuthenticator;
//import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.merative.acd.v1.model.AcdCartridges;
import com.merative.acd.v1.model.AcdCartridgesList;
import com.merative.acd.v1.model.AcdFlow;
import com.merative.acd.v1.model.Annotator.Name;
import com.merative.acd.v1.model.CartridgesGetIdOptions;
import com.merative.acd.v1.model.CartridgesGetOptions;
import com.merative.acd.v1.model.CartridgesPostMultipartOptions;
import com.merative.acd.v1.model.CartridgesPutMultipartOptions;
import com.merative.acd.v1.model.Concept;
import com.merative.acd.v1.model.ContainerGroup;
import com.merative.acd.v1.model.DeployCartridgeResponse;
import com.merative.acd.v1.model.Flow;
import com.merative.acd.v1.model.GetFlowsByIdOptions;
import com.merative.acd.v1.model.GetFlowsOptions;
import com.merative.acd.v1.model.GetHealthCheckStatusOptions;
import com.merative.acd.v1.model.ServiceStatus;
import com.merative.acd.v1.util.FlowUtil;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

/**
 * Sample ACD Java SDK Calls
 *
 * NOTE: To run this sample class, replace "ACD_TOKEN" below with your ACD bearer token,
 * and replace "ACD_URL" with the URL for the Annotator for Clinical Data (ACD) service endpoint.
 *
 * Optional: Update the "version" variable if you require a specific version of the ACD REST APIs.
 */
public class AnnotatorForClinicalDataExample {

  protected AnnotatorForClinicalDataExample() { }

  public static void main(String[] args) throws Exception {
    String authToken = "ACD_TOKEN";
    String url = "ACD_URL";
    String version = "2023-02-24";
    AnnotatorForClinicalData acd = null;

    // In the analyzeWithFlow and getFlowsById examples, they require a flow ID parameter.  Replace
    // "PERSISTED_FLOW_ID" on the next line with the ID of a flow that is persisted within your ACD instance.
    String persistedFlowId = "PERSISTED_FLOW_ID";

    // In the cartridgesGetId example, it requires a cartridge ID parameter.  Replace
    // "DEPLOYED_CARTRIDGE_ID" on the next line with the ID of a cartridge that is deployed within your ACD instance.
    String deployedCartridgeId = "DEPLOYED_CARTRIDGE_ID";

    // In the deploy and redeploy cartridge examples, they require a cartridge zip file name.  Replace
    // "NAME_OF_EXPORTED_CARTRIDGE_ZIP_FILE" on the next line with the name of your exported cartridge zip file.
    File cartridgeZip = new File("NAME_OF_EXPORTED_CARTRIDGE_ZIP_FILE");

    BearerTokenAuthenticator authenticator = new BearerTokenAuthenticator(authToken);
    acd = new AnnotatorForClinicalData(
        version,
        AnnotatorForClinicalData.DEFAULT_SERVICE_NAME,
        authenticator);
    acd.setServiceUrl(url);

    // Uncomment the next 2 lines to disable SSL verification - not recommended
    // HttpConfigOptions options = new HttpConfigOptions.Builder().disableSslVerification(true).build();
    // acd.configureClient(options);


    /** Examples of the following methods are provided: **/
    // analyze();
    // analyzeWithFlow();

    // getCartridges();
    // cartridgesGetId();
    // cartridgesPostMultipart();
    // cartridgesPutMultipart();

    // getFlows();
    // getFlowsById();

    // getHealthCheckStatus();


    /*
     * Annotator for Clinical Data
     */

    // Analyze your text with a dynamic annotator flow
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

    // Analyze your text with a persisted annotator flow
    try {
      System.out.println("\n Analyze with Flow =>");
      String flowId = persistedFlowId;
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

    // Get the list of deployed cartridges
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

    // Get details of a deployed cartridge
    try {
      System.out.println("\n Get Cartridge by ID =>");
      CartridgesGetIdOptions opts = new CartridgesGetIdOptions.Builder()
        .id(deployedCartridgeId).build();
      ServiceCall<AcdCartridges> getCartridgeCall = acd.cartridgesGetId(opts);

      Response<AcdCartridges> resp = getCartridgeCall.execute();
      AcdCartridges cart = resp.getResult();

      System.out.println("Cartridge: " + cart.getId() + " Status: " + cart.getStatus());
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

    // Deploy a new cartridge asynchronously
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

    // Redeploy a cartridge asynchronously
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

    // Get the list of persisted annotator flows
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

    // Get details of a persisted annotator flow
    try {
      System.out.println("\n Get Flows by ID =>");
      GetFlowsByIdOptions options = new GetFlowsByIdOptions.Builder()
          .id(persistedFlowId)
          .build();

      ServiceCall<AcdFlow> getFlowIdCall = acd.getFlowsById(options);
      Response<AcdFlow> resp = getFlowIdCall.execute();

      AcdFlow flow = resp.getResult();
      System.out.println("Id: " + flow.id() + " | Name: " + flow.name() + " | Description: " + flow.description());
    } catch (ServiceResponseException e) {
      System.out.println("Service returned status code: Error details: " + e.getStatusCode() + " " + e.getMessage() + " " + e.getDebuggingInfo().toString());
    }

    // Get ACD service health check
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
