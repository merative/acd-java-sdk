# IBM Watson Health Cognitive Services Java SDK Version 1.5.5

## Overview

The IBM Watson Health Cognitive Services (WHCS) Java SDK allows developers to programmatically interact with the following IBM Watson service:

| Service Name | Artifact ID |
|--------------|-------------|
| [Annotator for Clinical Data](https://merative.github.io/acd-containers/) | annotator-for-clinical-data |

## Prerequisites

* Refer to the IBM Watson Annotation for Clinical Data documentation:
  * [Prerequisites](https://merative.github.io/acd-containers/installing/prereqs/)
  * [Software Development Kits](https://merative.github.io/acd-containers/usage/sdks/)
* Java 8 or above.

## Installation
The current version of this SDK is: 1.5.5

#### WHCS service (Option 1)
To define a dependency on the WHCS service contained in the project, use a dependency like these:

##### Maven

```xml
<dependency>
	<groupId>com.ibm.watson.health.cognitive-services</groupId>
	<artifactId>ibm-whcs-services</artifactId>
	<version>1.5.5</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson.health.cognitive-services:ibm-whcs-services:1.5.5'
```

#### Annotator for Clinical Data service (Option 2)
To define a dependency on the Annotator for Clinical Data service, use a dependency like this:

##### Maven

```xml
<dependency>
    <groupId>com.ibm.watson.health.cognitive-services</groupId>
    <artifactId>annotator-for-clinical-data</artifactId>
    <version>1.5.5</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.health.cognitive-services:annotator-for-clinical-data:1.5.5'
```
The artifact ID is listed in the table above.

## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md)


## Questions

For questions, refer to: 
* [IBM Watson Annotator for Clinical Data product site](https://www.ibm.com/cloud/watson-annotator-for-clinical-data)
* [IBM Watson Annotator for Clinical Data documentation](https://merative.github.io/acd-containers/)

## Issues
If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/merative/whcs-java-sdk/issues).

## Open source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## Contributing
See [CONTRIBUTING](CONTRIBUTING.md).

## License

The IBM Watson Health Cognitive Services Java SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
