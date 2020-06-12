/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

public class Constants {
	public static final String URL = "URL";
	public static final String APIKEY = "APIKEY";
	public static final String VERSION = "VERSION";
	public static final String IAM_URL = "IAM_URL";
	public static final String DISABLE_SSL = "DISABLE_SSL";
	public static final String PROFILE_ID = "wh_acd.ibm_clinical_insights_v1.0_profile";
	public static final String FLOW_ID = "wh_acd.ibm_clinical_insights_v1.0_standard_flow";
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
	public static final String NAMED_ENTITIES = "named_entities";
	public static final String NEGATION = "negation";
	public static final String PROCEDURE = "procedure";
	public static final String RELATION = "relation";
	public static final String SECTION = "section";
	public static final String SECTION_NAME = "HISTORY";
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
			+ "The patient started on metformin because his blood sugar was too high.";
	public static final String CONTENT_TYPE = "application/json";
}
