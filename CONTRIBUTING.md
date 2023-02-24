# Questions
If you are having problems using this SDK or have a question about the Annotator for Clinical Data service,
refer here:
* [README](README.md)
* [Annotator for Clinical Data documentation](https://merative.github.io/acd-containers/)
* [Annotator for Clinical Data product site](https://www.ibm.com/cloud/watson-annotator-for-clinical-data)

# Issues
If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/merative/whcs-java-sdk/issues).

# Code
## Commit Messages
Commit messages should follow the [Angular Commit Message Guidelines](https://github.com/angular/angular/blob/master/CONTRIBUTING.md#-commit-message-guidelines).
This is because our release tool - [semantic-release](https://github.com/semantic-release/semantic-release) -
uses this format for determining release versions and generating changelogs.
Tools such as [commitizen](https://github.com/commitizen/cz-cli) or [commitlint](https://github.com/conventional-changelog/commitlint)
can be used to help contributors and enforce commit messages.
Here are some examples of acceptable commit messages, along with the release type that would be done based on the commit message:

| Commit message                                                                                                                                                              | Release type               |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------|
| `fix: propagate request errors back to request invocation thread`                                                                                                           | Patch Release              |
| `feat(Insights Model): add support for clinical insights model`                                                                                                             | ~~Minor~~ Feature Release  |
| `BREAKING CHANGE: The ACD service has been updated to reflect version 2 of the API.`                                                                                        | ~~Major~~ Breaking Release |

# Pull Requests

If you want to contribute to the repository, here's a quick guide:
  1. Fork the repository
  2. Develop and test your code changes:
      * To build/test: `mvn clean package` (Java 11+ is required when building the project)
      * Please add one or more tests to validate your changes.
  3. Make sure everything builds/tests cleanly
  4. Commit your changes  
  5. Push to your fork and submit a pull request to the **main** branch

# Developer's Certificate of Origin 1.1
By making a contribution to this project, I certify that:

(a) The contribution was created in whole or in part by me and I
   have the right to submit it under the open source license
   indicated in the file; or

(b) The contribution is based upon previous work that, to the best
   of my knowledge, is covered under an appropriate open source
   license and I have the right under that license to submit that
   work with modifications, whether created in whole or in part
   by me, under the same open source license (unless I am
   permitted to submit under a different license), as indicated
   in the file; or

(c) The contribution was provided directly to me by some other
   person who certified (a), (b) or (c) and I have not modified
   it.

(d) I understand and agree that this project and the contribution
   are public and that a record of the contribution (including all
   personal information I submit with it, including my sign-off) is
   maintained indefinitely and may be redistributed consistent with
   this project or the open source license(s) involved.

# Additional Resources
- [General GitHub documentation](https://help.github.com/)
- [GitHub pull request documentation](https://help.github.com/send-pull-requests/)
- [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
