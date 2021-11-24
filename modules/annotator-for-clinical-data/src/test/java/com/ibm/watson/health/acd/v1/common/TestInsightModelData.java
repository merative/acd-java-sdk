/*
 * Copyright 2018, 2021 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.health.acd.v1.common;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.InsightModelData;
import com.ibm.watson.health.acd.v1.model.InsightModelAlcohol;
import com.ibm.watson.health.acd.v1.model.InsightModelAlcoholUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelAlcoholUseStatus;
import com.ibm.watson.health.acd.v1.model.InsightModelDataDiagnosis;
import com.ibm.watson.health.acd.v1.model.InsightModelDataDiagnosisModifier;
import com.ibm.watson.health.acd.v1.model.InsightModelDataEvent;
import com.ibm.watson.health.acd.v1.model.InsightModelDataEvidence;
import com.ibm.watson.health.acd.v1.model.InsightModelIllicitDrug;
import com.ibm.watson.health.acd.v1.model.InsightModelIllicitDrugUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelIllicitDrugUseStatus;
import com.ibm.watson.health.acd.v1.model.InsightModelDataMedication;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormality;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormalityUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelDataProcedure;
import com.ibm.watson.health.acd.v1.model.InsightModelDataProcedureModifier;
import com.ibm.watson.health.acd.v1.model.InsightModelDataSite;
import com.ibm.watson.health.acd.v1.model.InsightModelSubstanceAbuse;
import com.ibm.watson.health.acd.v1.model.InsightModelDataTask;
import com.ibm.watson.health.acd.v1.model.InsightModelTobacco;
import com.ibm.watson.health.acd.v1.model.InsightModelTobaccoUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelTobaccoUseStatus;
import com.ibm.watson.health.acd.v1.model.InsightModelSubstanceAbuseTreatment;
import com.ibm.watson.health.acd.v1.model.InsightModelDataUsage;

public class TestInsightModelData {

	public static void testInsightModelData(InsightModelData insightModelData) {
		Assert.assertTrue(!insightModelData.isEmpty());
		if (insightModelData.getMedication() != null) {
			Assert.assertTrue(!insightModelData.getMedication().isEmpty());
			InsightModelDataMedication imdMed = insightModelData.getMedication();
			if (imdMed.getUsage() != null) {
				Assert.assertTrue(!imdMed.getUsage().isEmpty());
				InsightModelDataUsage imdMedUsage = imdMed.getUsage();
				Float explicitScore = imdMedUsage.getExplicitScore();
				if (explicitScore != null) {
					Assert.assertTrue(explicitScore >= 0);
				}
			}
			if (imdMed.getStarted() != null) {
				Assert.assertTrue(!imdMed.getStarted().isEmpty());
				InsightModelDataEvent imdMedStarted = imdMed.getStarted();
				Float startedScore = imdMedStarted.getScore();
				if (startedScore != null) {
					Assert.assertTrue(startedScore >= 0);
				}
				if (imdMedStarted.getUsage() != null) {
					Assert.assertTrue(!imdMedStarted.getUsage().isEmpty());
					InsightModelDataUsage imdMedStartedUsage = imdMedStarted.getUsage();
					Float explicitScore = imdMedStartedUsage.getExplicitScore();
					if (explicitScore != null) {
						Assert.assertTrue(explicitScore >= 0);
					}
				}
			}
		}
		if (insightModelData.getProcedure() != null) {
			Assert.assertTrue(!insightModelData.getProcedure().isEmpty());
			InsightModelDataProcedure imdProc = insightModelData.getProcedure();
			if (imdProc.getTask() != null) {
				Assert.assertTrue(!imdProc.getTask().isEmpty());
				InsightModelDataTask imdProcTask = imdProc.getTask();
				Float clinicalAssessScore = imdProcTask.getClinicalAssessmentScore();
				if (clinicalAssessScore != null) {
					Assert.assertTrue(clinicalAssessScore >= 0);
				}
			}
			if (imdProc.getModifiers() != null) {
				Assert.assertTrue(!imdProc.getModifiers().isEmpty());
				InsightModelDataProcedureModifier imdProcModif = imdProc.getModifiers();
				if (imdProcModif.getSites() != null) {
					for (InsightModelDataSite imdSite : imdProcModif.getSites()) {
						Assert.assertNotNull(imdSite.getCoveredText());
						Assert.assertTrue(imdSite.getEnd() > imdSite.getBegin());
					}
				}
				if (imdProcModif.getAssociatedDiagnoses() != null) {
					for (InsightModelDataEvidence imdAssociatedDiag : imdProcModif.getAssociatedDiagnoses()) {
						Assert.assertNotNull(imdAssociatedDiag.getCoveredText());
						Assert.assertTrue(imdAssociatedDiag.getEnd() > imdAssociatedDiag.getBegin());
					}
				}
			}
		}
		if (insightModelData.getDiagnosis() != null) {
			Assert.assertTrue(!insightModelData.getDiagnosis().isEmpty());
			InsightModelDataDiagnosis imdDiag = insightModelData.getDiagnosis();
			if (imdDiag.getUsage() != null) {
				Assert.assertTrue(!imdDiag.getUsage().isEmpty());
				InsightModelDataUsage imdDiagUsage = imdDiag.getUsage();
				Float explicitScore = imdDiagUsage.getExplicitScore();
				if (explicitScore != null) {
					Assert.assertTrue(explicitScore >= 0);
				}
			}
			if (imdDiag.getModifiers() != null) {
				Assert.assertTrue(!imdDiag.getModifiers().isEmpty());
				InsightModelDataDiagnosisModifier imdDiagModif = imdDiag.getModifiers();
				if (imdDiagModif.getSites() != null) {
					for (InsightModelDataSite imdSite : imdDiagModif.getSites()) {
						Assert.assertNotNull(imdSite.getCoveredText());
						Assert.assertTrue(imdSite.getEnd() > imdSite.getBegin());
					}
				}
				if (imdDiagModif.getAssociatedProcedures() != null) {
					for (InsightModelDataEvidence imdAssociatedProc : imdDiagModif.getAssociatedProcedures()) {
						Assert.assertNotNull(imdAssociatedProc.getCoveredText());
						Assert.assertTrue(imdAssociatedProc.getEnd() > imdAssociatedProc.getBegin());
					}
				}
			}
		}
		if (insightModelData.getNormality() != null) {
			Assert.assertTrue(!insightModelData.getNormality().isEmpty());
			InsightModelDataNormality imdNorm = insightModelData.getNormality();
			if (imdNorm.getUsage() != null) {
				Assert.assertTrue(!imdNorm.getUsage().isEmpty());
				InsightModelDataNormalityUsage imdNormUsage = imdNorm.getUsage();
				Float normalScore = imdNormUsage.getNormalScore();
				if (normalScore != null) {
					Assert.assertTrue(normalScore >= 0);
				}
			}
			if (imdNorm.getEvidence() != null) {
				Assert.assertTrue(imdNorm.getEvidence().size() > 0);
				for (InsightModelDataEvidence evidence : imdNorm.getEvidence()) {
					Assert.assertTrue(evidence.getBegin() > -1);
					Assert.assertTrue(evidence.getEnd() > evidence.getBegin());
					Assert.assertNotNull(evidence.getCoveredText());
				}
			}
		}
		if (insightModelData.getTobacco() != null) {
			Assert.assertTrue(!insightModelData.getTobacco().isEmpty());
			InsightModelTobacco imdTobacco = insightModelData.getTobacco();
			if (imdTobacco.getUsage() != null) {
				Assert.assertTrue(!imdTobacco.getUsage().isEmpty());
				InsightModelTobaccoUsage imdSubstUsage = imdTobacco.getUsage();
				Float useScore = imdSubstUsage.getUseScore();
				if (useScore != null) {
					Assert.assertTrue(useScore >= 0);
				}
			}
			if (imdTobacco.getUseStatus() != null) {
				Assert.assertTrue(!imdTobacco.getUseStatus().isEmpty());
				InsightModelTobaccoUseStatus imdUseStatus = imdTobacco.getUseStatus();
				Float currentScore = imdUseStatus.getCurrentScore();
				if (currentScore != null) {
					Assert.assertTrue(currentScore >= 0);
				}
			}
		}
		if (insightModelData.getAlcohol() != null) {
			Assert.assertTrue(!insightModelData.getAlcohol().isEmpty());
			InsightModelAlcohol imdAlcohol = insightModelData.getAlcohol();
			if (imdAlcohol.getUsage() != null) {
				Assert.assertTrue(!imdAlcohol.getUsage().isEmpty());
				InsightModelAlcoholUsage imdSubstUsage = imdAlcohol.getUsage();
				Float useScore = imdSubstUsage.getUseScore();
				if (useScore != null) {
					Assert.assertTrue(useScore >= 0);
				}
			}
			if (imdAlcohol.getUseStatus() != null) {
				Assert.assertTrue(!imdAlcohol.getUseStatus().isEmpty());
				InsightModelAlcoholUseStatus imdUseStatus = imdAlcohol.getUseStatus();
				Float stoppedScore = imdUseStatus.getStoppedScore();
				if (stoppedScore != null) {
					Assert.assertTrue(stoppedScore >= 0);
				}
			}
		}
		if (insightModelData.getIllicitDrug() != null) {
			Assert.assertTrue(!insightModelData.getIllicitDrug().isEmpty());
			InsightModelIllicitDrug imdIllicitDrug = insightModelData.getIllicitDrug();
			if (imdIllicitDrug.getUsage() != null) {
				Assert.assertTrue(!imdIllicitDrug.getUsage().isEmpty());
				InsightModelIllicitDrugUsage imdSubstUsage = imdIllicitDrug.getUsage();
				Float useScore = imdSubstUsage.getUseScore();
				if (useScore != null) {
					Assert.assertTrue(useScore >= 0);
				}
			}
			if (imdIllicitDrug.getUseStatus() != null) {
				Assert.assertTrue(!imdIllicitDrug.getUseStatus().isEmpty());
				InsightModelIllicitDrugUseStatus imdUseStatus = imdIllicitDrug.getUseStatus();
				Float stoppedScore = imdUseStatus.getStoppedScore();
				if (stoppedScore != null) {
					Assert.assertTrue(stoppedScore >= 0);
				}
			}
		}
		if (insightModelData.getSubstance() != null) {
			Assert.assertTrue(!insightModelData.getSubstance().isEmpty());
			InsightModelSubstanceAbuse imdSubstance = insightModelData.getSubstance();
			Float treatmentScore = imdSubstance.getTreatmentScore();
			if (treatmentScore != null) {
				Assert.assertTrue(treatmentScore >= 0);
			}
			Float nonPatientScore = imdSubstance.getNonPatientScore();
			if (nonPatientScore != null) {
				Assert.assertTrue(nonPatientScore >= 0);
			}
			if (imdSubstance.getTreatment() != null) {
				Assert.assertTrue(!imdSubstance.getTreatment().isEmpty());
				InsightModelSubstanceAbuseTreatment imdTreatment = imdSubstance.getTreatment();
				Float treatmentDiscussedScore = imdTreatment.getDiscussedScore();
				if (treatmentDiscussedScore != null) {
					Assert.assertTrue(treatmentDiscussedScore >= 0);
				}
				Float treatmentComplianceScore = imdTreatment.getComplianceScore();
				if (treatmentComplianceScore != null) {
					Assert.assertTrue(treatmentComplianceScore >= 0);
				}
			}
		}

	}
}
