/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.common;

public class Constants {
	public static final String URL = "URL";
        public static final String BEARER_TOKEN = "BEARER_TOKEN";
	public static final String APIKEY = "APIKEY";
	public static final String VERSION = "VERSION";
	public static final String IAM_URL = "IAM_URL";
	public static final String DISABLE_SSL = "DISABLE_SSL";
	public static final String PROFILE_ID = "wh_acd.ibm_clinical_insights_v1.0_profile";
	public static final String FLOW_ID = "wh_acd.ibm_clinical_insights_v1.0_standard_flow";
	public static final String CARTRIDGE_ID = "wh_acd.ibm_clinical_insights_v1.0";
	public static final String ATTRIBUTE_DETECTION_NAME = "attribute_detection";
	public static final String ALLERGY = "allergy";
	public static final String BATHING = "bathing_assistance";
	public static final String CANCER = "cancer";
	public static final String CONCEPT_DETECTION_NAME = "concept_detection";
	public static final String CONCEPT_VALUE = "concept_value";
	public static final String DISAMBIGUATION = "disambiguation";
	public static final String DRESSING = "dressing_assistance";
	public static final String EATING = "eating_assistance";
	public static final String EJECTION_FRACTION = "ejection_fraction";
	public static final String HYPOTHETICAL = "hypothetical";
	public static final String LAB_VALUE = "lab_value";
	public static final String MEDICATION = "medication";
	public static final String MODEL_BROKER = "model_broker";
	public static final String NAMED_ENTITIES = "named_entities";
	public static final String NEGATION = "negation";
	public static final String PROCEDURE = "procedure";
	public static final String RELATION = "relation";
	public static final String SECTION = "section";
	public static final String SECTION_NAME_HISTORY = "HISTORY";
	public static final String SECTION_NAME_PATIENT = "Patient";
	public static final String SEEING = "seeing_assistance";
	public static final String SMOKING = "smoking";
	public static final String SPELL_CHECKER = "spell_checker";
	public static final String SYMPTOM_DISEASE = "symptom_disease";
	public static final String TOILETING = "toileting_assistance";
	public static final String WALKING = "walking_assistance";
	public static final String TEXT = "The patient has cancer and is currently taking 400 ml sisplatin chemotherapy."
			+ "Echocardiogram demonstrated ejection fraction of approx 60%."
			+ "The lab values were: white blood cell count 4.6, hemoglobin 12.2.\n"
			+ "HISTORY:  Patient is allergic to latex.  Patient cannot walk and needs help bathing and getting around."
			+ "  Patient cannot dress or feed without help as the patient can not see.  Patient may die soon"
			+ "but has not died yet.  Patient smoked for 20 years.  Patient can not clean up after defacating in toilet."
			+ "John Doe was seen at Baylor Hospital in Austin, TX."
			+ "noone@testaddress.com"
			+ "(555) 555-5555"
			+ "The patient started on metformin because his blood sugar was too high."
			+ "CT scan showed a tumor in his lung."
			+ "She had gallbladder removal September 19 2020"
			+ "Her father had lung cancer. Her mother had asthma and diabetes.";
	public static final String TEXT2 = "Patient is a 43-year-old obese male with a history of diabetes. He presents today with numbness and pain in his left foot which he says began last Wednesday and progressively got worse over the course of a week. Allergic to penicillin. "
			+ "ALLERGY HISTORY: "
			+ "penicillin. allergic to peanuts "
			+ "FAMILY HISTORY: "
			+ "-mother: T2D, liver disease "
			+ "-father: MI x 3 in 2003. Died of MI in 2004. "
			+ "COURSE OF TREATMENT: "
			+ "IV insulin. Scheduled for a nerve conduction study";
	public static final String TEXT3 = "Patient:    Kevin Hudson (M)         MRN:0099598    01/01/1900(121y)\n"
			+ "Family Information\n"
			+ "by report, pt with hx of ETOH abuse; BAL 147.\n"
			+ "Patient is a 43-year-old obese male with a history of diabetes."
			+ "Allergic to penicillin.  Patient had a colonoscopy in 2009."
			+ "Patient abuses vodka and smokes cigarettes and marijuana."
			+ "Will follow-up with an additional blood glucose test in 3 months."
			+ "She is taking ibuprofen to help with her pain.";
	public static final String[] SAMPLE_TEXT_ARRAY = {TEXT, TEXT2, TEXT3};
	public static final String CONTENT_TYPE = "application/json";
}
