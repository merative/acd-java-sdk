package insightsformedicalliteratureservicev1_test

import (
	"fmt"
	"net/http"
	"net/http/httptest"
	"strings"

	"github.com/IBM/go-sdk-core/core"

	//	"github.com/cloudfoundry-community/go-cfenv"
	. "github.com/onsi/ginkgo"
	. "github.com/onsi/gomega"
	"github.com/watson-developer-cloud/go-sdk/insightsformedicalliteratureservicev1"
)

var _ = Describe("InsightsForMedicalLiteratureServiceV1", func() {
	Describe("Get credentials from VCAP", func() {
		version := "some.version"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Context("Successfully - Create InsightsForMedicalLiteratureServiceV1 with VCAP credentials", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.Header["Authorization"]).ToNot(BeNil())
			}))
			It("Succeed to create InsightsForMedicalLiteratureServiceV1", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				testService.GetHealthCheckStatus(testService.NewGetHealthCheckStatusOptions())
			})
		})
	})
	Describe("GetCorporaConfig(getCorporaConfigOptions *GetCorporaConfigOptions)", func() {
		getCorporaConfigPath := "/v1/corpora"
		version := "some.version"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Context("Successfully - Retrieves the available corpus names and configuration", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(getCorporaConfigPath))
				//				Expect(req.URL.Query()["version"]).To(Equal([]string{version}))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"corpora": [{"corpusName": "some.corpus", "ontologies": [ "some.ontology" ], "descriptiveName": "some.description", "bvt": false, "elasticsearchIndex": "some.index"}]}`)
			}))
			It("Succeed to call GetCorporaConfig", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetCorporaConfig(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getCorporaConfigOptions := testService.NewGetCorporaConfigOptions()
				returnValue, returnValueErr = testService.GetCorporaConfig(getCorporaConfigOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetCorporaConfigResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("SetCorpusSchema(setCorpusSchemaOptions *SetCorpusSchemaOptions)", func() {
		setCorpusSchemaPath := "/v1/corpora"
		version := "some.version1"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Context("Successfully - Define a custom corpus schema", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(setCorpusSchemaPath))
				Expect(req.Method).To(Equal("POST"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"corpora": [{"corpusName": "some.corpus", "ontologies": [ "some.ontology" ], "descriptiveName": "some.description", "bvt": false, "elasticsearchIndex": "some.index"},{"corpusName": "my corpus", "ontologies": [ "some.ontology" ], "descriptiveName": "Custom Corpus", "bvt": false, "elasticsearchIndex": "some.index"}]}`)
			}))
			It("Succeed to call SetCorpusSchema", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.SetCorpusSchema(nil)
				Expect(returnValueErr).NotTo(BeNil())

				setCorpusSchemaOptions := testService.NewSetCorpusSchemaOptions()
				returnValue, returnValueErr = testService.SetCorpusSchema(setCorpusSchemaOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetSetCorpusSchemaResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("DeleteCorpusSchema(deleteCorpusSchemaOptions *DeleteCorpusSchemaOptions)", func() {
		deleteCorpusSchemaPath := "/v1/corpora"
		version := "some.version"
		instance := "some.instance"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Context("Successfully - Delete a corpus", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(deleteCorpusSchemaPath))
				Expect(req.Method).To(Equal("DELETE"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"corpora": [{"corpusName": "some.corpus", "ontologies": [ "some.ontology" ], "descriptiveName": "some.descritpion", "bvt": false, "elasticsearchIndex": "some.index"}]}`)
			}))
			It("Succeed to call DeleteCorpusSchema", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.DeleteCorpusSchema(nil)
				Expect(returnValueErr).NotTo(BeNil())

				deleteCorpusSchemaOptions := testService.NewDeleteCorpusSchemaOptions(instance)
				returnValue, returnValueErr = testService.DeleteCorpusSchema(deleteCorpusSchemaOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetDeleteCorpusSchemaResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("SetCorpusConfig(setCorpusConfigOptions *SetCorpusConfigOptions)", func() {
		setCorpusConfigPath := "/v1/corpora/configure"
		version := "some.version"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Context("Successfully - Define a custom corpus repository connection", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(setCorpusConfigPath))
				Expect(req.Method).To(Equal("POST"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"corpora": [{"corpusName": "some.corpus", "ontologies": [ "some.ontology" ], "descriptiveName": "some.description", "bvt": false, "elasticsearchIndex": "some.index"}]}`)
			}))
			It("Succeed to call SetCorpusConfig", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.SetCorpusConfig(nil)
				Expect(returnValueErr).NotTo(BeNil())

				setCorpusConfigOptions := testService.NewSetCorpusConfigOptions()
				returnValue, returnValueErr = testService.SetCorpusConfig(setCorpusConfigOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetSetCorpusConfigResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("MonitorCorpus(monitorCorpusOptions *MonitorCorpusOptions)", func() {
		monitorCorpusPath := "/v1/corpora/monitor"
		version := "some.version"
		apikey := "instance.key"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Context("Successfully - Enable monitoring for a custom instance", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(monitorCorpusPath))
				Expect(req.Method).To(Equal("PUT"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"hi":"there"}`)
			}))
			It("Succeed to call MonitorCorpus", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.MonitorCorpus(nil)
				Expect(returnValueErr).NotTo(BeNil())

				monitorCorpusOptions := testService.NewMonitorCorpusOptions(apikey)
				returnValue, returnValueErr = testService.MonitorCorpus(monitorCorpusOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())
			})
		})
	})
	Describe("GetCorpusConfig(getCorpusConfigOptions *GetCorpusConfigOptions)", func() {
		getCorpusConfigPath := "/v1/corpora/{corpus}"
		version := "some.version"
		corpus := "some.corpus"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getCorpusConfigPath, "{corpus}", corpus, 1)
		Context("Successfully - Retrieves the corpus configuration", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"corpora": [{"corpusName": "some.corpus", "ontologies": [ "some.ontology" ], "descriptiveName": "same.description", "bvt": false, "elasticsearchIndex": "some.index"}]}`)
			}))
			It("Succeed to call GetCorpusConfig", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetCorpusConfig(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getCorpusConfigOptions := testService.NewGetCorpusConfigOptions(corpus)
				returnValue, returnValueErr = testService.GetCorpusConfig(getCorpusConfigOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetCorpusConfigResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetSemanticTypes(getSemanticTypesOptions *GetSemanticTypesOptions)", func() {
		getSemanticTypesPath := "/v1/corpora/{corpus}/types"
		version := "some.version"
		corpus := "some.corpus"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getSemanticTypesPath, "{corpus}", corpus, 1)
		Context("Successfully - Retrieves a list of semantic types used by this corpus", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"type" : [ "some.type"]}`)
			}))
			It("Succeed to call GetSemanticTypes", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetSemanticTypes(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getSemanticTypesOptions := testService.NewGetSemanticTypesOptions(corpus)
				returnValue, returnValueErr = testService.GetSemanticTypes(getSemanticTypesOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetSemanticTypesResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetConcepts(getConceptsOptions *GetConceptsOptions)", func() {
		getConceptsPath := "/v1/corpora/{corpus}/concepts"
		version := "some.version"
		corpus := "some.corpus"
		preferredNames := []string{"name"}
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getConceptsPath, "{corpus}", corpus, 1)
		Context("Successfully - Retrieves information for concepts mentioned in this corpus", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"concepts": [{"cui": "identifier", "ontology": "source", "preferredName": "name"}]}`)
			}))
			It("Succeed to call GetConcepts", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetConcepts(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getConceptsOptions := testService.NewGetConceptsOptions(corpus)
				getConceptsOptions.SetPreferredNames(preferredNames)
				returnValue, returnValueErr = testService.GetConcepts(getConceptsOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetConceptsResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("AddArtifact(addArtifactOptions *AddArtifactOptions)", func() {
		addArtifactPath := "/v1/corpora/{corpus}/concepts/definitions"
		version := "some.version"
		corpus := "some.corpus"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(addArtifactPath, "{corpus}", corpus, 1)
		Context("Successfully - Add cartridge artifact", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("POST"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"concepts": [ {"cui" : "myId", "ontology" : "custom", "preferredName" : "my artifact name" }]}`)
			}))
			It("Succeed to call AddArtifact", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.AddArtifact(nil)
				Expect(returnValueErr).NotTo(BeNil())

				//				dictionaryEntry := testService.NewDictionaryEntry()
				addArtifactOptions := testService.NewAddArtifactOptions(corpus)
				//				addArtifactOptions.SetDictionaryEntry
				returnValue, returnValueErr = testService.AddArtifact(addArtifactOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetAddArtifactResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetCuiInfo(getCuiInfoOptions *GetCuiInfoOptions)", func() {
		getCuiInfoPath := "/v1/corpora/{corpus}/concepts/{name_or_id}"
		version := "some.version"
		corpus := "some.corpus"
		nameOrID := "identifier"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getCuiInfoPath, "{corpus}", corpus, 1)
		Path = strings.Replace(Path, "{name_or_id}", nameOrID, 1)
		Context("Successfully - Retrieve information for a concept", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"cui":"identifier", "ontology": "some.ontology", "preferredName": "name", "semanticTypes": ["some.type"],
					"surfaceForms": ["synonym1", "synonym2"], "definition": "some.definition", "hasParents": true, "hasChildren": true, "hasSibling": true}`)
			}))
			It("Succeed to call GetCuiInfo", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetCuiInfo(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getCuiInfoOptions := testService.NewGetCuiInfoOptions(corpus, nameOrID)
				returnValue, returnValueErr = testService.GetCuiInfo(getCuiInfoOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetCuiInfoResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetHitCount(getHitCountOptions *GetHitCountOptions)", func() {
		getHitCountPath := "/v1/corpora/{corpus}/concepts/{name_or_id}/hit_count"
		version := "some.version"
		corpus := "corpus"
		nameOrID := "identifier"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getHitCountPath, "{corpus}", corpus, 1)
		Path = strings.Replace(Path, "{name_or_id}", nameOrID, 1)
		Context("Successfully - Retrieves a count of the number of times a concept is mentioned in the corpus", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"hitCount": 10}`)
			}))
			It("Succeed to call GetHitCount", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetHitCount(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getHitCountOptions := testService.NewGetHitCountOptions(corpus, nameOrID)
				returnValue, returnValueErr = testService.GetHitCount(getHitCountOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetHitCountResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetRelatedConcepts(getRelatedConceptsOptions *GetRelatedConceptsOptions)", func() {
		getRelatedConceptsPath := "/v1/corpora/{corpus}/concepts/{name_or_id}/related_concepts"
		version := "2020-01-01"
		corpus := "corpus"
		nameOrID := "identifier"
		relationship := "relation"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getRelatedConceptsPath, "{corpus}", corpus, 1)
		Path = strings.Replace(Path, "{name_or_id}", nameOrID, 1)
		Context("Successfully - Retrieve concepts related to a concept", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-Type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"name":"artifact-name", "cui": "identifier", "soruces": [], "children": []}`)
			}))
			It("Succeed to call GetRelatedConcepts", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetRelatedConcepts(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getRelatedConceptsOptions := testService.NewGetRelatedConceptsOptions(corpus, nameOrID, relationship)
				returnValue, returnValueErr = testService.GetRelatedConcepts(getRelatedConceptsOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetRelatedConceptsResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetSimilarConcepts(getSimilarConceptsOptions *GetSimilarConceptsOptions)", func() {
		getSimilarConceptsPath := "/v1/corpora/{corpus}/concepts/{name_or_id}/similar_concepts"
		version := "2020-01-01"
		corpus := "corpus"
		nameOrID := "identifier"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getSimilarConceptsPath, "{corpus}", corpus, 1)
		Path = strings.Replace(Path, "{name_or_id}", nameOrID, 1)
		Context("Successfully - Find similar concepts", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"name":"artifact-name", "cui": "identifier", "soruces": [], "children": []}`)
			}))
			It("Succeed to call GetSimilarConcepts", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetSimilarConcepts(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getSimilarConceptsOptions := testService.NewGetSimilarConceptsOptions(corpus, nameOrID)
				returnValue, returnValueErr = testService.GetSimilarConcepts(getSimilarConceptsOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetSimilarConceptsResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetDocuments(getDocumentsOptions *GetDocumentsOptions)", func() {
		getDocumentsPath := "/v1/corpora/{corpus}/documents"
		version := "some.version"
		corpus := "some.corpus"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getDocumentsPath, "{corpus}", corpus, 1)
		Context("Successfully - Retrieves information about the documents in this corpus", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"documentCount":10, "providers": [{ "documentCount": 10, "name": "some.provider"}]}`)
			}))
			It("Succeed to call GetDocuments", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetDocuments(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getDocumentsOptions := testService.NewGetDocumentsOptions(corpus)
				returnValue, returnValueErr = testService.GetDocuments(getDocumentsOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetDocumentsResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("AddCorpusDocument(addCorpusDocumentOptions *AddCorpusDocumentOptions)", func() {
		addCorpusDocumentPath := "/v1/corpora/{corpus}/documents"
		version := "some.verison"
		corpus := "some.corpus"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(addCorpusDocumentPath, "{corpus}", corpus, 1)
		Context("Successfully - Define enrichment document", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("POST"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"hi":"there"}`)
			}))
			It("Succeed to call AddCorpusDocument", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.AddCorpusDocument(nil)
				Expect(returnValueErr).NotTo(BeNil())

				addCorpusDocumentOptions := testService.NewAddCorpusDocumentOptions(corpus)
				returnValue, returnValueErr = testService.AddCorpusDocument(addCorpusDocumentOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())
			})
		})
	})
	Describe("GetDocumentInfo(getDocumentInfoOptions *GetDocumentInfoOptions)", func() {
		getDocumentInfoPath := "/v1/corpora/{corpus}/documents/{document_id}"
		version := "some.version"
		corpus := "some.corpus"
		documentID := "some.id"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getDocumentInfoPath, "{corpus}", corpus, 1)
		Path = strings.Replace(Path, "{document_id}", documentID, 1)
		Context("Successfully - Retrieves the external ID, title, abstract and text for a document", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"metatdata": { "publishDate": "some.date", "doc_id":"identifier"}, "title":"some.title"}}`)
			}))
			It("Succeed to call GetDocumentInfo", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetDocumentInfo(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getDocumentInfoOptions := testService.NewGetDocumentInfoOptions(corpus, documentID)
				returnValue, returnValueErr = testService.GetDocumentInfo(getDocumentInfoOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetDocumentInfoResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetDocumentAnnotations(getDocumentAnnotationsOptions *GetDocumentAnnotationsOptions)", func() {
		getDocumentAnnotationsPath := "/v1/corpora/{corpus}/documents/{document_id}/annotations"
		version := "some.version"
		corpus := "some.corpus"
		documentID := "some.id"
		documentSection := "some.section"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getDocumentAnnotationsPath, "{corpus}", corpus, 1)
		Path = strings.Replace(Path, "{document_id}", documentID, 1)
		Context("Successfully - Retrieves annotations for a document", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"unstructured": [{ "data" : { "concepts": [{ "cui": "identifier", "preferredName":"name", "type":"some.type", "begin": 4, "end": 10)] }} ]}`)
			}))
			It("Succeed to call GetDocumentAnnotations", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetDocumentAnnotations(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getDocumentAnnotationsOptions := testService.NewGetDocumentAnnotationsOptions(corpus, documentID, documentSection)
				returnValue, returnValueErr = testService.GetDocumentAnnotations(getDocumentAnnotationsOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())
			})
		})
	})
	Describe("GetDocumentCategories(getDocumentCategoriesOptions *GetDocumentCategoriesOptions)", func() {
		getDocumentCategoriesPath := "/v1/corpora/{corpus}/documents/{document_id}/categories"
		version := "some.version"
		corpus := "some.corpus"
		documentID := "some.id"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getDocumentCategoriesPath, "{corpus}", corpus, 1)
		Path = strings.Replace(Path, "{document_id}", documentID, 1)
		Context("Successfully - Categorizes concepts in a document", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"highlightedTitle":"title"}`)
			}))
			It("Succeed to call GetDocumentCategories", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetDocumentCategories(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getDocumentCategoriesOptions := testService.NewGetDocumentCategoriesOptions(corpus, documentID)
				returnValue, returnValueErr = testService.GetDocumentCategories(getDocumentCategoriesOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetDocumentCategoriesResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetDocumentMultipleCategories(getDocumentMultipleCategoriesOptions *GetDocumentMultipleCategoriesOptions)", func() {
		getDocumentMultipleCategoriesPath := "/v1/corpora/{corpus}/documents/{document_id}/categories"
		version := "some.version"
		corpus := "some.corpus"
		documentID := "some.id"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getDocumentMultipleCategoriesPath, "{corpus}", corpus, 1)
		Path = strings.Replace(Path, "{document_id}", documentID, 1)
		Context("Successfully - Categorizes concepts in a document", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("POST"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"highlightedTitle":"title"}`)
			}))
			It("Succeed to call GetDocumentMultipleCategories", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetDocumentMultipleCategories(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getDocumentMultipleCategoriesOptions := testService.NewGetDocumentMultipleCategoriesOptions(corpus, documentID)
				returnValue, returnValueErr = testService.GetDocumentMultipleCategories(getDocumentMultipleCategoriesOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetDocumentMultipleCategoriesResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetSearchMatches(getSearchMatchesOptions *GetSearchMatchesOptions)", func() {
		getSearchMatchesPath := "/v1/corpora/{corpus}/documents/{document_id}/search_matches"
		version := "some.version"
		corpus := "some.corpus"
		documentID := "some.id"
		minScore := float32(.5)
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getSearchMatchesPath, "{corpus}", corpus, 1)
		Path = strings.Replace(Path, "{document_id}", documentID, 1)
		Context("Successfully - Finds concepts in a document matching a set of search concepts", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"externalId":"identifier", "publicationName":"some.publication", "publicationDate":"some.date", "title": "some.title", "passages": {}}`)
			}))
			It("Succeed to call GetSearchMatches", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetSearchMatches(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getSearchMatchesOptions := testService.NewGetSearchMatchesOptions(corpus, documentID, minScore)
				returnValue, returnValueErr = testService.GetSearchMatches(getSearchMatchesOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetSearchMatchesResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("Search(searchOptions *SearchOptions)", func() {
		searchPath := "/v1/corpora/{corpus}/search"
		version := "some.version"
		corpus := "some.corpus"
		body := "{ query: { \"concepts\": [ {\"id\": \"C0018787\", \"ontology\" : \"concepts\", \"rank\": \"10\"} ]}, \"returns\": { \"documents\"; { \"limit\": \"10\", \"offset\": 10} }}"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(searchPath, "{corpus}", corpus, 1)
		Context("Successfully - Search for concepts, documents, and authors", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("POST"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"pageNubmer": 1, "_limit": 10, "totalDocumentCount": 20, "documents": [{"documentId": "some.id", "title": "some.title"}]}`)
			}))
			It("Succeed to call Search", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.Search(nil)
				Expect(returnValueErr).NotTo(BeNil())

				searchOptions := testService.NewSearchOptions(corpus, body)
				returnValue, returnValueErr = testService.Search(searchOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetSearchResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetFields(getFieldsOptions *GetFieldsOptions)", func() {
		getFieldsPath := "/v1/corpora/{corpus}/search/metadata"
		version := "some.version"
		corpus := "some.corpus"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(getFieldsPath, "{corpus}", corpus, 1)
		Context("Successfully - Retrieves a list of metadata fields defined in the corpus", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"fields": {"title": { "supports": ["some.support"]} }}`)
			}))
			It("Succeed to call GetFields", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetFields(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getFieldsOptions := testService.NewGetFieldsOptions(corpus)
				returnValue, returnValueErr = testService.GetFields(getFieldsOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetFieldsResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("Typeahead(typeaheadOptions *TypeaheadOptions)", func() {
		typeaheadPath := "/v1/corpora/{corpus}/search/typeahead"
		version := "some.version"
		corpus := "some.corpus"
		query := "some.text"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Path := strings.Replace(typeaheadPath, "{corpus}", corpus, 1)
		Context("Successfully - Find concepts matching the specified query string", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(Path))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"concepts": [{"cui": "identifier"}]}`)
			}))
			It("Succeed to call Typeahead", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.Typeahead(nil)
				Expect(returnValueErr).NotTo(BeNil())

				typeaheadOptions := testService.NewTypeaheadOptions(corpus, query)
				returnValue, returnValueErr = testService.Typeahead(typeaheadOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetTypeaheadResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetServiceStatus(getServiceStatusOptions *GetServiceStatusOptions)", func() {
		getServiceStatusPath := "/v1/status"
		version := "some.version"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Context("Successfully - Get status of service", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(getServiceStatusPath))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"serviceState":"OK"}`)
			}))
			It("Succeed to call GetServiceStatus", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetServiceStatus(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getServiceStatusOptions := testService.NewGetServiceStatusOptions()
				returnValue, returnValueErr = testService.GetServiceStatus(getServiceStatusOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetServiceStatusResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
	Describe("GetHealthCheckStatus(getHealthCheckStatusOptions *GetHealthCheckStatusOptions)", func() {
		getHealthCheckStatusPath := "/v1/status/health_check"
		version := "some.version"
		authenticator := &core.IamAuthenticator{
			ApiKey: "c6TdpmH29pTM57RzAM_S9HAAzf4OT3S-M_cnwPOfU40n",
		}
		Context("Successfully - Determine if service is running correctly", func() {
			testServer := httptest.NewServer(http.HandlerFunc(func(res http.ResponseWriter, req *http.Request) {
				defer GinkgoRecover()

				Expect(req.URL.Path).To(Equal(getHealthCheckStatusPath))
				Expect(req.Method).To(Equal("GET"))
				Expect(req.Header["Authorization"]).ToNot(BeNil())
				res.Header().Set("Content-type", "application/json")
				res.WriteHeader(200)
				fmt.Fprintf(res, `{"serviceState":"OK"}`)
			}))
			It("Succeed to call GetHealthCheckStatus", func() {
				defer testServer.Close()

				testService, testServiceErr := insightsformedicalliteratureservicev1.NewInsightsForMedicalLiteratureServiceV1(&insightsformedicalliteratureservicev1.InsightsForMedicalLiteratureServiceV1Options{
					URL:           testServer.URL,
					Version:       version,
					Authenticator: authenticator,
				})
				Expect(testServiceErr).To(BeNil())
				Expect(testService).ToNot(BeNil())

				// Pass empty options
				returnValue, returnValueErr := testService.GetHealthCheckStatus(nil)
				Expect(returnValueErr).NotTo(BeNil())

				getHealthCheckStatusOptions := testService.NewGetHealthCheckStatusOptions()
				returnValue, returnValueErr = testService.GetHealthCheckStatus(getHealthCheckStatusOptions)
				Expect(returnValueErr).To(BeNil())
				Expect(returnValue).ToNot(BeNil())

				result := testService.GetGetHealthCheckStatusResult(returnValue)
				Expect(result).ToNot(BeNil())
			})
		})
	})
})