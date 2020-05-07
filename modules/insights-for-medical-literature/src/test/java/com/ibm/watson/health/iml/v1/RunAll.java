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
package com.ibm.watson.health.iml.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.watson.health.iml.v1.documents.TestAddDocumentToCorpus;
import com.ibm.watson.health.iml.v1.corpora.TestConfigureCorpus;
import com.ibm.watson.health.iml.v1.corpora.TestCreateCorpusSchema;
import com.ibm.watson.health.iml.v1.corpora.TestDeleteCorpus;
import com.ibm.watson.health.iml.v1.concepts.TestDefineCorpusConcept;
import com.ibm.watson.health.iml.v1.concepts.TestGetConcepts;
import com.ibm.watson.health.iml.v1.concepts.TestGetConceptByNameOrId;
import com.ibm.watson.health.iml.v1.concepts.TestGetConceptHitCount;
import com.ibm.watson.health.iml.v1.concepts.TestGetConceptRelatedConcepts;
import com.ibm.watson.health.iml.v1.concepts.TestGetConceptSimilarConcepts;
import com.ibm.watson.health.iml.v1.corpora.TestGetCorpora;
import com.ibm.watson.health.iml.v1.corpora.TestGetCorpusInfo;
import com.ibm.watson.health.iml.v1.documents.TestGetDocuments;
import com.ibm.watson.health.iml.v1.documents.TestGetDocumentsDocumentId;
import com.ibm.watson.health.iml.v1.documents.TestGetDocumentsDocumentAnnotations;
import com.ibm.watson.health.iml.v1.documents.TestGetDocumentsAnnotationCategories;
import com.ibm.watson.health.iml.v1.documents.TestGetDocumentsAnnotationsMultilpeCategories;
import com.ibm.watson.health.iml.v1.documents.TestGetDocumentSearchMatches;
import com.ibm.watson.health.iml.v1.status.TestGetStatusHealthCheck;
import com.ibm.watson.health.iml.v1.corpora.TestMonitorCorpus;
import com.ibm.watson.health.iml.v1.search.TestSearch;
import com.ibm.watson.health.iml.v1.search.TestGetSearchMetatdata;
import com.ibm.watson.health.iml.v1.search.TestGetSearchTypeahead;
import com.ibm.watson.health.iml.v1.unit.InsightsForMedicalLiteratureServiceTest;;



@RunWith(Suite.class)
@SuiteClasses({
	InsightsForMedicalLiteratureServiceTest.class,
	TestGetCorpora.class,
	TestGetCorpusInfo.class,
	TestGetConcepts.class,
	TestGetConceptByNameOrId.class,
	TestGetConceptHitCount.class,
	TestGetConceptRelatedConcepts.class,
	TestGetConceptSimilarConcepts.class,
	TestGetDocuments.class,
	TestGetDocumentsDocumentId.class,
	TestGetDocumentsDocumentAnnotations.class,
	TestGetDocumentsAnnotationCategories.class,
	TestGetDocumentsAnnotationsMultilpeCategories.class,
	TestGetDocumentSearchMatches.class,
	TestSearch.class,
	TestGetSearchMetatdata.class,
	TestGetSearchTypeahead.class,
	TestGetStatusHealthCheck.class,
	TestAddDocumentToCorpus.class,
	TestConfigureCorpus.class,
	TestCreateCorpusSchema.class,
	TestDeleteCorpus.class,
	TestMonitorCorpus.class,
	TestDefineCorpusConcept.class
})


public class RunAll {

}
