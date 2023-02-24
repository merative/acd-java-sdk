/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.merative.acd.v1.acd.TestAnalyze;
import com.merative.acd.v1.acd.TestAnalyzeFlowId;
import com.merative.acd.v1.acd.TestGetAnnotators;
import com.merative.acd.v1.acd.TestGetAnnotatorsAnnotatorId;
import com.merative.acd.v1.flows.TestCreateFlows;
import com.merative.acd.v1.flows.TestDeleteFlows;
import com.merative.acd.v1.flows.TestGetFlows;
import com.merative.acd.v1.flows.TestGetFlowsFlowId;
import com.merative.acd.v1.flows.TestUpdateFlows;
import com.merative.acd.v1.profiles.TestCreateProfiles;
import com.merative.acd.v1.profiles.TestDeleteProfiles;
import com.merative.acd.v1.profiles.TestGetProfiles;
import com.merative.acd.v1.profiles.TestGetProfilesProfileId;
import com.merative.acd.v1.profiles.TestUpdateProfiles;
import com.merative.acd.v1.cartridges.TestCreateCartridges;
import com.merative.acd.v1.cartridges.TestDeployCartridge;
import com.merative.acd.v1.cartridges.TestGetCartridges;
import com.merative.acd.v1.cartridges.TestGetCartridgesCartridgeId;
import com.merative.acd.v1.cartridges.TestUpdateCartridges;
import com.merative.acd.v1.status.TestGetHealthCheckStatus;
import com.merative.acd.v1.unit.AnnotatorForClinicalDataAcdTest;



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
