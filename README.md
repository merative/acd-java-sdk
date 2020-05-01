# IBM Watson Health Cognitive Services Java SDK Version 0.0.1

The IBM Watson Health Cognitive Services (WHCS) Java SDK allows developers to programmatically interact with the following WHCS services:

| Service Name | Artifact Id |
|--------------|-------------|
| [Annotator for Clinical data](https://cloud.ibm.com/apidocs/wh-acd) | annotator-for-clinical-data |
| [Insights for Medical Literature](https://cloud.ibm.com/apidocs/wh-iml) | insights-for-medical-literature |

NOTE:  You must be signed in to IBM Cloud to see the docs.

## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

* An [IBM Cloud][ibm-cloud-onboarding] account.
* An IAM API key to allow the SDK to access your account. Create one [here](https://cloud.ibm.com/iam/apikeys).
* Java 8 or above.

## Installation
The current version of this SDK is: 0.0.1

#### All the services
To define a dependency on the entire set of services contained in the project, use a dependency like these:

##### Maven

```xml
<dependency>
	<groupId>com.ibm.watson.health.cognitive_services</groupId>
	<artifactId>ibm-whcs-services</artifactId>
	<version>0.0.1</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson.health.cognitive_services:ibm-whcs-services:0.0.1'
```

#### A single service
To define a dependency on a single service, use a dependency that contains the artifact id for the service, like this:

##### Maven

```xml
<dependency>
    <groupId>com.ibm.watson.health.cognitive_services</groupId>
    <artifactId>annotator-for-clinical-data</artifactId>
    <version>0.0.1</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.health.cognitive_services:annotator-for-clinical-data:0.0.1'
```
Each service's artifact id is listed in the table of services above.

## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md)


## Questions

If you are having difficulties using this SDK or have a question about the IBM Cloud services,
please ask a question at
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues
If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/IBM/whcs-java-sdk/issues).
Before that, please search for similar issues. It's possible that someone has already reported the problem.

## Open source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## Contributing
See [CONTRIBUTING](CONTRIBUTING.md).

## License

The IBM Cloud MySDK Java SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
