# Change log for selenium-htmltojava-maven-plugin #

* current development version
 - Support for verifyEditable
* v1.0.4
 - Support for verifyNotEditable
 - Support for waitForVisible
 - Support for verifyVisible and verifyNotVisible
 - Temporary override timeout before open when a forced timeout is specified
 - Support the verifySelectedLabel command, with exact match only
 - Dropped support for Java 1.5
 - Added support for refresh
* v1.0.3
 - Some more work on verifyEval and regular expressions.
* v1.0.2b
 - Fixed an error involving verifyEval. It should be now 'useable'
* v1.0.2
 - Added support for asterisks in glob expressions
 - Added support for check
 - Added logging statements for startup and ending of tests through the "verbose" parameter
* v1.0.1
 - Support global test timeouts
 - Added support for verifyNotChecked
 - Added support for uncheck
 - Added support for verifyChecked
 - Added support for fireEvent
 - Cleaned up code violations detected by [Sonar](http://www.sonarsource.org/)
 - Added support for multiline text verifications
 - Added support for waitForNotValue
 - Added support for waitForEditable
 - Added javascript escaping of html source
* v1.0.0
 - Initial release. Supports all commands needed so far to execute a basic test suite

