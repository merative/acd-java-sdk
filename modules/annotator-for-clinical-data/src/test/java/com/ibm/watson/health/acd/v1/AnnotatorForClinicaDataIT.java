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
import com.ibm.watson.health.acd.v1.unit.AnnotatorForClinicalDataAcdTest;;



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


public class AnnotatorForClinicaDataIT {

}
