# Merative Annotator for Clinical Data Java SDK Version 1.5.13

## Overview

This Java SDK allows developers to programmatically interact with the following service:

| Service Name | Artifact ID |
|--------------|-------------|
| [Annotator for Clinical Data](https://merative.github.io/acd-containers/) | annotator-for-clinical-data |

## Prerequisites

* Refer to the Annotation for Clinical Data documentation:
  * [Prerequisites](https://merative.github.io/acd-containers/installing/prereqs/)
  * [Software Development Kits](https://merative.github.io/acd-containers/usage/sdks/)
* Java 8 or above.

## Installation
The current version of this SDK is: 1.5.13

#### Parent Project (Option 1)
To define a dependency on the parent project `acd-sdk`, use a dependency like these:

##### Maven

```xml
<dependency>
	<groupId>com.merative.acd</groupId>
	<artifactId>acd-sdk</artifactId>
	<version>1.5.13</version>
</dependency>
```

##### Gradle

```gradle
'com.merative.acd:acd-sdk:1.5.13'
```

#### Annotator for Clinical Data Subproject (Option 2)
To define a dependency on the subproject `annotator-for-clinical-data`, use a dependency like this:

##### Maven

```xml
<dependency>
    <groupId>com.merative.acd</groupId>
    <artifactId>annotator-for-clinical-data</artifactId>
    <version>1.5.13</version>
</dependency>
```

##### Gradle
```gradle
'com.merative.acd:1.5.13'
```
The artifact ID is listed in the table above.

## Migrating from version 1.x.x 

The 2.0 release of the Annotator for Clinical Data Java SDK introduces a Java package name change from `com.ibm.watson.health.acd.v1` to `com.merative.acd.v1`.  For the migration from 1.x.x:

1. Update the Maven dependencies by changing all `acd-sdk` or `annotator-for-clinical-data` dependency version tags to `2.0.0` in the pom.xml.  Verify that there are no SDK module dependencies in the pom.xml with a version earlier than `2.0.0`.
2. Update any import declarations from `com.ibm.watson.health.acd.v1` to `com.merative.acd.v1`.

## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md)


## Questions

For questions, refer to: 
* [Annotator for Clinical Data product site](https://www.ibm.com/cloud/watson-annotator-for-clinical-data)
* [Annotator for Clinical Data documentation](https://merative.github.io/acd-containers/)

## Issues
If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/merative/whcs-java-sdk/issues).

## Contributing
See [CONTRIBUTING](CONTRIBUTING.md).

## License

The Annotator for Clinical Data Java SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
