/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.watson.health.acd.v1.acd.TestAnalyze;
import com.ibm.watson.health.acd.v1.acd.TestAnalyzeFlowId;
import com.ibm.watson.health.acd.v1.acd.TestGetAnnotators;
import com.ibm.watson.health.acd.v1.acd.TestGetAnnotatorsAnnotatorId;
import com.ibm.watson.health.acd.v1.flows.TestCreateFlows;
import com.ibm.watson.health.acd.v1.flows.TestDeleteFlows;
import com.ibm.watson.health.acd.v1.flows.TestGetFlows;
import com.ibm.watson.health.acd.v1.flows.TestGetFlowsFlowId;
import com.ibm.watson.health.acd.v1.flows.TestUpdateFlows;
import com.ibm.watson.health.acd.v1.profiles.TestCreateProfiles;
import com.ibm.watson.health.acd.v1.profiles.TestDeleteProfiles;
import com.ibm.watson.health.acd.v1.profiles.TestGetProfiles;
import com.ibm.watson.health.acd.v1.profiles.TestGetProfilesProfileId;
import com.ibm.watson.health.acd.v1.profiles.TestUpdateProfiles;
import com.ibm.watson.health.acd.v1.cartridges.TestCreateCartridges;
import com.ibm.watson.health.acd.v1.cartridges.TestDeployCartridge;
import com.ibm.watson.health.acd.v1.cartridges.TestGetCartridges;
import com.ibm.watson.health.acd.v1.cartridges.TestGetCartridgesCartridgeId;
import com.ibm.watson.health.acd.v1.cartridges.TestUpdateCartridges;
import com.ibm.watson.health.acd.v1.status.TestGetHealthCheckStatus;
import com.ibm.watson.health.acd.v1.unit.AnnotatorForClinicalDataAcdTest;



@RunWith(Suite.class)
@SuiteClasses({
	AnnotatorForClinicalDataAcdTest.class,
	TestAnalyze.class,
	TestAnalyzeFlowId.class,
	TestGetAnnotators.class,
	TestGetAnnotatorsAnnotatorId.class,
	TestGetFlows.class,
	TestGetFlowsFlowId.class,
	TestCreateFlows.class,
	TestUpdateFlows.class,
	TestDeleteFlows.class,
	TestGetProfiles.class,
	TestGetProfilesProfileId.class,
	TestCreateProfiles.class,
	TestUpdateProfiles.class,
	TestDeleteProfiles.class,
	TestGetCartridges.class,
	TestGetCartridgesCartridgeId.class,
	TestCreateCartridges.class,
	TestUpdateCartridges.class,
	//TestDeployCartridge.class,  legacy deployment is deprecated
	TestGetHealthCheckStatus.class
})


public class AnnotatorForClinicalDataIT {

}
