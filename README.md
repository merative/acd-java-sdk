# IBM Watson Health Cognitive Services Java SDK Version 1.1.13

## Overview

The IBM Watson Health Cognitive Services (WHCS) Java SDK allows developers to programmatically interact with the following IBM Cloud service:

| Service Name | Artifact ID |
|--------------|-------------|
| [Annotator for Clinical Data](https://cloud.ibm.com/apidocs/wh-acd) | annotator-for-clinical-data |

NOTE: You must be signed in to IBM Cloud to see the docs.

## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

* An [IBM Cloud][ibm-cloud-onboarding] account.
* An IAM API key to allow the SDK to access your service instance. For instructions about copying the credentials of an existing service instance, or creating a new service instance, refer to Getting Started [here](https://cloud.ibm.com/docs/wh-acd?topic=wh-acd-getting-started).
* Java 8 or above.

## Installation
The current version of this SDK is: 1.1.13

#### WHCS service (Option 1)
To define a dependency on the WHCS service contained in the project, use a dependency like these:

##### Maven

```xml
<dependency>
	<groupId>com.ibm.watson.health.cognitive-services</groupId>
	<artifactId>ibm-whcs-services</artifactId>
	<version>1.1.13</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson.health.cognitive-services:ibm-whcs-services:1.1.13'
```

#### Annotator for Clinical Data service (Option 2)
To define a dependency on the Annotator for Clinical Data service, use a dependency like this:

##### Maven

```xml
<dependency>
    <groupId>com.ibm.watson.health.cognitive-services</groupId>
    <artifactId>annotator-for-clinical-data</artifactId>
    <version>1.1.13</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.health.cognitive-services:annotator-for-clinical-data:1.1.13'
```
The artifact ID is listed in the table above.

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

The IBM Watson Health Cognitive Services Java SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
