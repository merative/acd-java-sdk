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
package com.ibm.watson.health.iml.v1.search;
import static com.ibm.watson.health.iml.v1.utils.ServiceUtilities.getProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.AggregationModel;
import com.ibm.watson.health.iml.v1.model.Aggregations;
import com.ibm.watson.health.iml.v1.model.Attribute;
import com.ibm.watson.health.iml.v1.model.Attributes;
import com.ibm.watson.health.iml.v1.model.Concept;
import com.ibm.watson.health.iml.v1.model.Concepts;
import com.ibm.watson.health.iml.v1.model.DateHistograms;
import com.ibm.watson.health.iml.v1.model.Documents;
import com.ibm.watson.health.iml.v1.model.HistogramData;
import com.ibm.watson.health.iml.v1.model.Passages;
import com.ibm.watson.health.iml.v1.model.Query;
import com.ibm.watson.health.iml.v1.model.QueryConcept;
import com.ibm.watson.health.iml.v1.model.Range;
import com.ibm.watson.health.iml.v1.model.RangeModel;
import com.ibm.watson.health.iml.v1.model.Ranges;
import com.ibm.watson.health.iml.v1.model.RankedDocConcept;
import com.ibm.watson.health.iml.v1.model.RankedDocLinks;
import com.ibm.watson.health.iml.v1.model.RankedDocument;
import com.ibm.watson.health.iml.v1.model.ReturnsModel;
import com.ibm.watson.health.iml.v1.model.SearchBody;
import com.ibm.watson.health.iml.v1.model.SearchModel;
import com.ibm.watson.health.iml.v1.model.SearchOptions;
import com.ibm.watson.health.iml.v1.model.SearchOptions.Builder;
import com.ibm.watson.health.iml.v1.model.SortEntry;
import com.ibm.watson.health.iml.v1.model.SortEntry.Order;
import com.ibm.watson.health.iml.v1.model.Title;
import com.ibm.watson.health.iml.v1.model.Typeahead;
import com.ibm.watson.health.iml.v1.model.Values;
import com.ibm.watson.health.iml.v1.model.YearAndHits;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 *
 * Class to test /v1/corpora/{corpus}/search.
 *
 */
public class TestSearch {
	private InsightsForMedicalLiteratureService imlService;

	public TestSearch() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetDocumentSearch() {
		Title titleBoost = new Title();
		titleBoost.setBoost(0);
		List<String> relations = new ArrayList<String>(1);
		relations.add("children");
		List<QueryConcept> concepts = new ArrayList<QueryConcept>(1);
		QueryConcept queryConcept = new QueryConcept();
		queryConcept.setBool("Sepsis");
		queryConcept.setId("C0243026");
		queryConcept.setIncludeRelated(null);
		queryConcept.setNegated(false);
		queryConcept.setOntology(Constants.UMLS);
		queryConcept.setRank("10");
		queryConcept.setType("DiseaseOrSyndrome");
		queryConcept.setIncludeRelated(relations);
		queryConcept.setNegated(false);
		concepts.add(queryConcept);
		Range dateRange = new Range();
		dateRange.setBegin("2019-01-01");
		dateRange.setEnd("2019-07-31");
		Map<String, Range> rangeMap = new HashMap<String, Range>();
		rangeMap.put("publishDate", dateRange);
		Query query = new Query();
		query.setBool("Sepsis");
		query.setConcepts(concepts);
		query.setDateRange(rangeMap);
		query.setTitle(titleBoost);

		ReturnsModel returns = new ReturnsModel();
		Documents documents = new Documents();
		documents.setLimit(10);
		documents.setOffset(0);
		returns.setDocuments(documents);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.query(query).returns(returns).verbose(false).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<RankedDocument> rankedDocs = sm.getDocuments();
		for (RankedDocument doc : rankedDocs) {
			Assert.assertNotNull(doc.getDocumentId());
			Assert.assertNotNull(doc.getTitle());
			RankedDocLinks links = doc.getLinks();
			Assert.assertNotNull(links.getHrefCategories());
			Assert.assertNotNull(links.getHrefSearchMatches());
			Assert.assertNull(doc.getPassages());
			Assert.assertNull(doc.getAnnotations());
		}
	}

	@Test
	public void testGetDocumentSearchWithMetadata() {

		List<QueryConcept> concepts = new ArrayList<QueryConcept>(1);
		QueryConcept queryConcept = new QueryConcept();
		queryConcept.setBool("Sepsis");
		queryConcept.setId("C0243026");
		queryConcept.setIncludeRelated(null);
		queryConcept.setNegated(false);
		queryConcept.setOntology(Constants.UMLS);
		queryConcept.setRank("10");
		queryConcept.setType("DiseaseOrSyndrome");
		concepts.add(queryConcept);

		Query query = new Query();
		query.setBool("Sepsis");
		query.setConcepts(concepts);

		ReturnsModel returns = new ReturnsModel();
		Documents documents = new Documents();
		List<String> fields = new ArrayList<String>(2);
		fields.add("publicationName");
		fields.add("publishDate");
		documents.setMetadata(fields);

		documents.setLimit(10);
		documents.setOffset(0);
		documents.setMetadata(fields);
		returns.setDocuments(documents);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.query(query).returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<RankedDocument> rankedDocs = sm.getDocuments();
		for (RankedDocument doc : rankedDocs) {
			Assert.assertNotNull(doc.getDocumentId());
			Map<String, List<String>> metadata = doc.getMetadata();
			Set<String> metadataKeys = metadata.keySet();
			for (String key : metadataKeys) {
				Assert.assertTrue(fields.contains(key));
			}
			Assert.assertNotNull(doc.getCorpus());
			RankedDocLinks links = doc.getLinks();
			Assert.assertNotNull(links.getHrefCategories());
			Assert.assertNotNull(links.getHrefSearchMatches());
		}
	}

	@Test
	public void testGetDocumentSearchWithSortOrder() {

		List<QueryConcept> concepts = new ArrayList<QueryConcept>(1);
		QueryConcept queryConcept = new QueryConcept();
		queryConcept.setBool("Sepsis");
		queryConcept.setId("C0243026");
		queryConcept.setIncludeRelated(null);
		queryConcept.setNegated(false);
		queryConcept.setOntology(Constants.UMLS);
		queryConcept.setRank("10");
		queryConcept.setType("DiseaseOrSyndrome");
		concepts.add(queryConcept);

		Query query = new Query();
		query.setBool("Sepsis");
		query.setConcepts(concepts);

		ReturnsModel returns = new ReturnsModel();
		Documents documents = new Documents();

		documents.setLimit(10);
		documents.setOffset(0);
		SortEntry sortField = new SortEntry();
		sortField.setField("publishDate");
		sortField.setOrder(Order.DESC);
		SortEntry[] sortFields = new SortEntry[1];
		sortFields[0] = sortField;
		documents.setSort(sortFields);
		returns.setDocuments(documents);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.query(query).returns(returns).verbose(true).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		Assert.assertTrue(sm.getPageNumber() > 0);
		Assert.assertTrue(sm.getTotalDocumentCount() > 0);
		Assert.assertNull(sm.getGetLimit());
		List<Concept> conceptList = sm.getConcepts();
		Assert.assertNull(sm.getHref());
		Assert.assertNull(sm.getCursorId());

		List<RankedDocument> rankedDocs = sm.getDocuments();
		for (RankedDocument doc : rankedDocs) {
			Assert.assertNotNull(doc.getDocumentId());
			Assert.assertNotNull(doc.getCorpus());
			RankedDocLinks links = doc.getLinks();
			Assert.assertNotNull(links.getHrefCategories());
			Assert.assertNotNull(links.getHrefSearchMatches());
		}
	}

	@Test
	public void testGetDocumentSearchBoolean() {
		Query query = new Query();
		query.setBool("Transplantation");

		ReturnsModel returns = new ReturnsModel();
		Documents documents = new Documents();
		documents.setLimit(10);
		documents.setOffset(0);
		returns.setDocuments(documents);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.query(query).returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<RankedDocument> rankedDocs = sm.getDocuments();
		for (RankedDocument doc : rankedDocs) {
			Assert.assertNotNull(doc.getDocumentId());
			Assert.assertNotNull(doc.getTitle());
			RankedDocLinks links = doc.getLinks();
			Assert.assertNotNull(links.getHrefCategories());
			Assert.assertNotNull(links.getHrefSearchMatches());
		}
	}

	@Test
	public void testGetDocumentSearchBooleanTerm() {
		Map<String, String> termMap = new HashMap<String, String>();
		termMap.put("publicationName", "JAMA");
		Query query = new Query();
		query.setBoolTerm(termMap);

		ReturnsModel returns = new ReturnsModel();
		Documents documents = new Documents();
		documents.setLimit(10);
		documents.setOffset(0);
		returns.setDocuments(documents);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.query(query).returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<RankedDocument> rankedDocs = sm.getDocuments();
		for (RankedDocument doc : rankedDocs) {
			Assert.assertNotNull(doc.getDocumentId());
			Assert.assertNotNull(doc.getTitle());
			RankedDocLinks links = doc.getLinks();
			Assert.assertNotNull(links.getHrefCategories());
			Assert.assertNotNull(links.getHrefSearchMatches());
		}
	}

	@Test
	public void testGetDocumentSearchBooleanRegExp() {
		Map<String, String> boolRegexp = new HashMap<String, String>();
		boolRegexp.put("title", ".*heart.* AND .*attack.*");
		Query query = new Query();
		query.setBoolRegexp(boolRegexp);

		ReturnsModel returns = new ReturnsModel();
		Documents documents = new Documents();
		documents.setLimit(10);
		documents.setOffset(0);
		returns.setDocuments(documents);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.query(query).returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<RankedDocument> rankedDocs = sm.getDocuments();
		for (RankedDocument doc : rankedDocs) {
			Assert.assertNotNull(doc.getDocumentId());
			Assert.assertNotNull(doc.getTitle());
			RankedDocLinks links = doc.getLinks();
			Assert.assertNotNull(links.getHrefCategories());
			Assert.assertNotNull(links.getHrefSearchMatches());
		}
	}

	@Test
	public void testGetDocumentSearchRegExp() {
		Map<String, String> boolRegexp = new HashMap<String, String>();
		boolRegexp.put("authors", "anders*|Anders*");
		Query query = new Query();
		query.setBoolRegexp(boolRegexp);

		ReturnsModel returns = new ReturnsModel();
		Documents documents = new Documents();
		documents.setLimit(10);
		documents.setOffset(0);
		returns.setDocuments(documents);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.query(query).returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();
		Assert.assertNotNull(sm);
	}

	@Test
	public void testGetConceptsSearch() {
		List<QueryConcept> concepts = new ArrayList<QueryConcept>(1);
		QueryConcept queryConcept = new QueryConcept();
		queryConcept.setBool("Sepsis");
		queryConcept.setId("C0243026");
		queryConcept.setIncludeRelated(null);
		queryConcept.setNegated(false);
		queryConcept.setOntology(Constants.UMLS);
		queryConcept.setRank("10");
		queryConcept.setType("DiseaseOrSyndrome");
		concepts.add(queryConcept);

		Query query = new Query();
		query.setBool("Sepsis");
		query.setConcepts(concepts);

		List<String> typesList = new ArrayList<String>(1);
		typesList.add("SignOrSymptom");
		ReturnsModel returns = new ReturnsModel();
		Concepts returnConcepts = new Concepts();
		returnConcepts.setLimit(5);
		returnConcepts.setMode("popular");
		returnConcepts.setOntology(Constants.UMLS);
		returnConcepts.setScope("corpus");
		returnConcepts.setTypes(typesList);
		returns.setConcepts(returnConcepts);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.query(query).returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<Concept> cooccurringConcepts = sm.getConcepts();
		for (Concept cooccurringConcept : cooccurringConcepts) {
			Assert.assertNotNull(cooccurringConcept.getCui());
			Assert.assertNotNull(cooccurringConcept.getPreferredName());
			Assert.assertTrue(typesList.contains(cooccurringConcept.getSemanticType()));
			Assert.assertEquals(cooccurringConcept.getOntology(), Constants.UMLS);
			Assert.assertNull(cooccurringConcept.getAlternativeName());
			Assert.assertNull(cooccurringConcept.getDataType());
			Assert.assertNull(cooccurringConcept.getMaxValue());
			Assert.assertNull(cooccurringConcept.getMinValue());
			Assert.assertNull(cooccurringConcept.getOperator());
			Assert.assertNull(cooccurringConcept.getUnit());
			Assert.assertTrue(cooccurringConcept.getCount() > 0);
			Assert.assertTrue(cooccurringConcept.getHitCount() > 0);
			Assert.assertNull(cooccurringConcept.getDocumentIds());
			Assert.assertNull(cooccurringConcept.getChildren());
			Assert.assertNull(cooccurringConcept.getParents());
			Assert.assertNull(cooccurringConcept.getSiblings());
			Assert.assertNull(cooccurringConcept.getRelated());
			Assert.assertNull(cooccurringConcept.getScore());
		}
	}

	@Test
	public void testGetAttributes() {
		ReturnsModel returns = new ReturnsModel();
		Attributes returnAttrs = new Attributes();

		returns.setAttributes(returnAttrs);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<Attribute> attributes = sm.getAttributes();
		for (Attribute attribute : attributes) {
			Assert.assertNotNull(attribute.getAttributeId());
			Assert.assertNotNull(attribute.getCount());
			String displayName = attribute.getDisplayName();
			if (displayName != null) {
				Assert.assertTrue(displayName.length() > 0);
			}
		}
	}

	@Test
	public void testGetAttributeRanges() {
		ReturnsModel returns = new ReturnsModel();
		Ranges returnRanges = new Ranges();
		returnRanges.setAttributeId("age_group");

		returns.setRanges(returnRanges);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		Map<String, RangeModel> ranges = sm.getRanges();
		Set<String> rangeKeys = ranges.keySet();
		for (String key : rangeKeys) {
			RangeModel range = ranges.get(key);
			Assert.assertNotNull(range.getMin());
			Assert.assertNotNull(range.getMax());
		}
	}

	@Test
	public void testGetAttributeValues() {
		ReturnsModel returns = new ReturnsModel();
		Values returnValues = new Values();
		returnValues.setAttributeId("age_group");

		returns.setValues(returnValues);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<Concept> values = sm.getValues();
		for (Concept value : values) {
			Assert.assertNotNull(value.getPreferredName());
			Assert.assertNotNull(value.getDataType());
			Assert.assertNotNull(value.getMinValue());
			Assert.assertNotNull(value.getMaxValue());
			Assert.assertNotNull(value.getCount());
			Assert.assertNotNull(value.getHitCount());
		}
	}

	@Test
	public void testGetTypeaheadValues() {
		ReturnsModel returns = new ReturnsModel();
		Typeahead typeaheadValues = new Typeahead();
		typeaheadValues.setLimit(5);
		typeaheadValues.setNoDuplicates(true);
		typeaheadValues.setOntology(Constants.UMLS);
		typeaheadValues.setQuery("park");
		List<String> typesList = new ArrayList<String>(1);
		typesList.add("DiseaseOrSyndrome");
		typeaheadValues.setTypes(typesList);
		returns.setTypeahead(typeaheadValues);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<Concept> values = sm.getTypeahead();
		for (Concept value : values) {
			Assert.assertNotNull(value.getPreferredName());
			Assert.assertNotNull(value.getCui());
			Assert.assertNotNull(value.getCount());
			Assert.assertNotNull(value.getHitCount());
		}
	}

	@Test
	public void testGetDateHistograms() {
		ReturnsModel returns = new ReturnsModel();
		Map<String, DateHistograms> histogramMap = new HashMap<String, DateHistograms>();
		DateHistograms histogram = new DateHistograms();
		if (histogram.getInterval() == null) {
			histogram.setInterval("1y");
		}
		if (histogram.getUtc() == null) {
			histogram.setUtc(-6);
		}
		histogramMap.put("publishDate", histogram);
		returns.setDateHistograms(histogramMap);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		Map<String, List<HistogramData>> resultMap = sm.getDateHistograms();
		Set<String> keys = resultMap.keySet();
		for (String key : keys) {
			List<HistogramData> yandhList = resultMap.get(key);
			for (HistogramData yandh : yandhList) {
				Assert.assertNotNull(yandh.getDate());
				Assert.assertTrue(yandh.getHits() > 0);
			}
		}
	}

	@Test
	public void testGetAggregations() {
		ReturnsModel returns = new ReturnsModel();
		Map<String, Aggregations> aggMap = new HashMap<String, Aggregations>();
		Aggregations aggregation = new Aggregations();
		if (aggregation.getLimit() == null) {
			aggregation.setLimit(10);
		}
		aggMap.put("authors", aggregation);
		returns.setAggregations(aggMap);

		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.returns(returns).build();

		ServiceCall<SearchModel> sc = imlService.search(options);

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		Map<String, List<AggregationModel>> resultMap = sm.getAggregations();
		Set<String> keys = resultMap.keySet();
		for (String key : keys) {
			List<AggregationModel> aggList = resultMap.get(key);
			for (AggregationModel agg : aggList) {
				Assert.assertNotNull(agg.getName());
				Assert.assertTrue(agg.getDocumentCount() > 0);
			}
		}
	}

	@Test
	public void testGetPassages() {
		Title titleBoost = new Title();
		titleBoost.setBoost(0);
		List<String> relations = new ArrayList<String>(1);
		relations.add("children");
		List<QueryConcept> concepts = new ArrayList<QueryConcept>(1);
		QueryConcept queryConcept = new QueryConcept();
		queryConcept.setBool("Sepsis");
		queryConcept.setId("C0243026");
		queryConcept.setIncludeRelated(null);
		queryConcept.setNegated(false);
		queryConcept.setOntology(Constants.UMLS);
		queryConcept.setRank("10");
		queryConcept.setType("DiseaseOrSyndrome");
		queryConcept.setIncludeRelated(relations);
		queryConcept.setNegated(false);
		concepts.add(queryConcept);
		Range dateRange = new Range();
		dateRange.setBegin("2019-01-01");
		dateRange.setEnd("2019-07-31");
		Map<String, Range> rangeMap = new HashMap<String, Range>();
		rangeMap.put("publishDate", dateRange);
		Query query = new Query();
		query.setBool("Sepsis");
		query.setConcepts(concepts);
		query.setDateRange(rangeMap);
		query.setTitle(titleBoost);

		ReturnsModel returns = new ReturnsModel();
		Passages passages = new Passages();
		passages.setConceptsToHighlight(concepts);
		passages.setLimit(5);
		passages.setMinScore((float) 0.5);
		passages.setRelatedTagBegin("<i>");
		passages.setRelatedTagEnd("</i>");
		passages.setSearchTagBegin("<u>");
		passages.setSearchTagEnd("</u>");
		returns.setPassages(passages);

		Builder builder = new SearchOptions.Builder(getProperty(Constants.CORPUS), returns);
		builder.query(query);

		ServiceCall<SearchModel> sc = imlService.search(builder.build());
//		Response<SearchModel> response = sc.execute();
//		SearchModel sm = response.getResult();

	}

	@Test
	public void testGetDocumentSearchBuilder() {
		Title titleBoost = new Title();
		titleBoost.setBoost(0);
		List<String> relations = new ArrayList<String>(1);
		relations.add("children");
		List<QueryConcept> concepts = new ArrayList<QueryConcept>(1);
		QueryConcept queryConcept = new QueryConcept();
		queryConcept.setBool("Sepsis");
		queryConcept.setId("C0243026");
		queryConcept.setIncludeRelated(null);
		queryConcept.setNegated(false);
		queryConcept.setOntology(Constants.UMLS);
		queryConcept.setRank("10");
		queryConcept.setType("DiseaseOrSyndrome");
		queryConcept.setIncludeRelated(relations);
		queryConcept.setNegated(false);
		concepts.add(queryConcept);
		Range dateRange = new Range();
		dateRange.setBegin("2019-01-01");
		dateRange.setEnd("2019-07-31");
		Map<String, Range> rangeMap = new HashMap<String, Range>();
		rangeMap.put("publishDate", dateRange);
		Query query = new Query();
		query.setBool("Sepsis");
		query.setConcepts(concepts);
		query.setDateRange(rangeMap);
		query.setTitle(titleBoost);

		ReturnsModel returns = new ReturnsModel();
		Documents documents = new Documents();
		documents.setLimit(10);
		documents.setOffset(0);
		returns.setDocuments(documents);

		Builder builder = new SearchOptions.Builder(getProperty(Constants.CORPUS), returns);
		builder.query(query);

		ServiceCall<SearchModel> sc = imlService.search(builder.build());

		Response<SearchModel> response = sc.execute();
		SearchModel sm = response.getResult();

		List<RankedDocument> rankedDocs = sm.getDocuments();
		for (RankedDocument doc : rankedDocs) {
			Assert.assertNotNull(doc.getDocumentId());
			Assert.assertNotNull(doc.getTitle());
			RankedDocLinks links = doc.getLinks();
			Assert.assertNotNull(links.getHrefCategories());
			Assert.assertNotNull(links.getHrefSearchMatches());
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		ReturnsModel returns = new ReturnsModel();
		SearchOptions options = new SearchOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.returns(returns).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}

}
