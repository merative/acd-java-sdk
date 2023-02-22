/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.common;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.InsightModelData;
import com.ibm.watson.health.acd.v1.model.InsightModelAlcohol;
import com.ibm.watson.health.acd.v1.model.InsightModelAlcoholUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelAlcoholUseQualifier;
import com.ibm.watson.health.acd.v1.model.InsightModelAlcoholUseStatus;
import com.ibm.watson.health.acd.v1.model.InsightModelDataDiagnosis;
import com.ibm.watson.health.acd.v1.model.InsightModelDataDiagnosisModifier;
import com.ibm.watson.health.acd.v1.model.InsightModelDataEvent;
import com.ibm.watson.health.acd.v1.model.InsightModelDataEvidence;
import com.ibm.watson.health.acd.v1.model.InsightModelIllicitDrug;
import com.ibm.watson.health.acd.v1.model.InsightModelIllicitDrugUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelIllicitDrugUseDimension;
import com.ibm.watson.health.acd.v1.model.InsightModelIllicitDrugUseQualifier;
import com.ibm.watson.health.acd.v1.model.InsightModelIllicitDrugUseStatus;
import com.ibm.watson.health.acd.v1.model.InsightModelDataMedication;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormality;
import com.ibm.watson.health.acd.v1.model.InsightModelDataNormalityUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelDataProcedure;
import com.ibm.watson.health.acd.v1.model.InsightModelDataProcedureModifier;
import com.ibm.watson.health.acd.v1.model.InsightModelDataSite;
import com.ibm.watson.health.acd.v1.model.InsightModelSubstanceAbuse;
import com.ibm.watson.health.acd.v1.model.InsightModelDataTask;
import com.ibm.watson.health.acd.v1.model.InsightModelDataType;
import com.ibm.watson.health.acd.v1.model.InsightModelTobacco;
import com.ibm.watson.health.acd.v1.model.InsightModelTobaccoUsage;
import com.ibm.watson.health.acd.v1.model.InsightModelTobaccoUseStatus;
import com.ibm.watson.health.acd.v1.model.InsightModelSubstanceAbuseTreatment;
import com.ibm.watson.health.acd.v1.model.InsightModelDataUsage;

public class TestInsightModelData {

	public static void testInsightModelData(InsightModelData insightModelData) {
		if (insightModelData.getMedication() != null) {
			InsightModelDataMedication imdMed = insightModelData.getMedication();
			if (imdMed.getUsage() != null) {
				InsightModelDataUsage imdMedUsage = imdMed.getUsage();
				Float explicitScore = imdMedUsage.getExplicitScore();
				if (explicitScore != null) {
					Assert.assertTrue(explicitScore >= 0);
				}
			}
			if (imdMed.getStarted() != null) {
				InsightModelDataEvent imdMedStarted = imdMed.getStarted();
				Float startedScore = imdMedStarted.getScore();
				if (startedScore != null) {
					Assert.assertTrue(startedScore >= 0);
				}
				if (imdMedStarted.getUsage() != null) {
					InsightModelDataUsage imdMedStartedUsage = imdMedStarted.getUsage();
					Float explicitScore = imdMedStartedUsage.getExplicitScore();
					if (explicitScore != null) {
						Assert.assertTrue(explicitScore >= 0);
					}
				}
			}
		}
		if (insightModelData.getProcedure() != null) {
			InsightModelDataProcedure imdProc = insightModelData.getProcedure();
			if (imdProc.getTask() != null) {
				InsightModelDataTask imdProcTask = imdProc.getTask();
				Float clinicalAssessScore = imdProcTask.getClinicalAssessmentScore();
				if (clinicalAssessScore != null) {
					Assert.assertTrue(clinicalAssessScore >= 0);
				}
			}
			if (imdProc.getModifiers() != null) {
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
			if (imdProc.getType() != null) {
				InsightModelDataType imdProcType = imdProc.getType();
				Float deviceScore = imdProcType.getDeviceScore();
				if (deviceScore != null) {
					Assert.assertTrue(deviceScore >= 0);
				}
			}
		}
		if (insightModelData.getDiagnosis() != null) {
			InsightModelDataDiagnosis imdDiag = insightModelData.getDiagnosis();
			if (imdDiag.getUsage() != null) {
				InsightModelDataUsage imdDiagUsage = imdDiag.getUsage();
				Float explicitScore = imdDiagUsage.getExplicitScore();
				if (explicitScore != null) {
					Assert.assertTrue(explicitScore >= 0);
				}
			}
			if (imdDiag.getModifiers() != null) {
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
			InsightModelDataNormality imdNorm = insightModelData.getNormality();
			if (imdNorm.getUsage() != null) {
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
			InsightModelTobacco imdTobacco = insightModelData.getTobacco();
			if (imdTobacco.getUsage() != null) {
				InsightModelTobaccoUsage imdSubstUsage = imdTobacco.getUsage();
				Float useScore = imdSubstUsage.getUseScore();
				if (useScore != null) {
					Assert.assertTrue(useScore >= 0);
				}
			}
			if (imdTobacco.getUseStatus() != null) {
				InsightModelTobaccoUseStatus imdUseStatus = imdTobacco.getUseStatus();
				Float currentScore = imdUseStatus.getCurrentScore();
				if (currentScore != null) {
					Assert.assertTrue(currentScore >= 0);
				}
			}
		}
		if (insightModelData.getAlcohol() != null) {
			InsightModelAlcohol imdAlcohol = insightModelData.getAlcohol();
			if (imdAlcohol.getUsage() != null) {
				InsightModelAlcoholUsage imdSubstUsage = imdAlcohol.getUsage();
				Float useScore = imdSubstUsage.getUseScore();
				if (useScore != null) {
					Assert.assertTrue(useScore >= 0);
				}
			}
			if (imdAlcohol.getUseStatus() != null) {
				InsightModelAlcoholUseStatus imdUseStatus = imdAlcohol.getUseStatus();
				Float stoppedScore = imdUseStatus.getStoppedScore();
				if (stoppedScore != null) {
					Assert.assertTrue(stoppedScore >= 0);
				}
			}
			if (imdAlcohol.getUseQualifier() != null) {
				InsightModelAlcoholUseQualifier imdUseQual = imdAlcohol.getUseQualifier();
				Float lightScore = imdUseQual.getLightScore();
				if (lightScore != null) {
					Assert.assertTrue(lightScore >= 0);
				}
			}
		}
		if (insightModelData.getIllicitDrug() != null) {
			InsightModelIllicitDrug imdIllicitDrug = insightModelData.getIllicitDrug();
			if (imdIllicitDrug.getUsage() != null) {
				InsightModelIllicitDrugUsage imdSubstUsage = imdIllicitDrug.getUsage();
				Float useScore = imdSubstUsage.getUseScore();
				if (useScore != null) {
					Assert.assertTrue(useScore >= 0);
				}
			}
			if (imdIllicitDrug.getUseStatus() != null) {
				InsightModelIllicitDrugUseStatus imdUseStatus = imdIllicitDrug.getUseStatus();
				Float stoppedScore = imdUseStatus.getStoppedScore();
				if (stoppedScore != null) {
					Assert.assertTrue(stoppedScore >= 0);
				}
			}
			if (imdIllicitDrug.getUseDimension() != null) {
				InsightModelIllicitDrugUseDimension imdUseDimension = imdIllicitDrug.getUseDimension();
				Float abuseScore = imdUseDimension.getAbuseScore();
				if (abuseScore != null) {
					Assert.assertTrue(abuseScore >= 0);
				}
			}
			if (imdIllicitDrug.getUseQualifier() != null) {
				InsightModelIllicitDrugUseQualifier imdUseQualifier = imdIllicitDrug.getUseQualifier();
				Float lightScore = imdUseQualifier.getLightScore();
				if (lightScore != null) {
					Assert.assertTrue(lightScore >= 0);
				}
			}
		}
		if (insightModelData.getSubstance() != null) {
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
