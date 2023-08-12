# Telephone Dial Pad solution

The objective of this repository is to print the possible combination of alphabets for the numeric that we see in a telephone dial pad. Additionally, the repository also contains test cases that covers the possible combination to test the feature and prioritizes these test cases based on High / Medium / Low categories.
The test cases are automated by providing the multiple combinations of input in the attached CSV file and a corresponding report is generated containing the details of executed test cases.

## Pre-requisites

This execution of this project requires the following applications
a. JUnit (v5)
b. Maven
c. SureFire report plugin

## SureFire Plugin Details

````
<plugin>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>2.22.1</version>
</plugin>
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-report-plugin</artifactId>
  <version>2.22.2</version>
  <configuration>
  <outputName>Junit-SureFire-HTML-Report</outputName>
  </configuration>
</plugin>
````

## Usage steps

The following are the steps to execute the code as well as test cases
1. Clone the repository
2. Run **mvn package** from the command prompt
   The project should run without any errors. The error can be as a result of the incompatible version. Please update the version and run again.
3. The JUnit file **TestTelephoneDialPad.java** contains all the test cases and the same is located in <project location>\src\test\java\com\telephonedailpad
4. Run **mvn install**
   The test code will fetch the data from testData.csv file placed in <project location>\src\test\resources folder and will execute the tests.
   The results will be shown both in the test terminal and in SureFire XML reports generated in <project location>\target\surefire-reports folder.
5. Run **mvn surefire-report:report** to get the HTML report in <project location>\target\site\Junit-SureFire-HTML-Report.html
6. The XML and HTML reports will contain the details of the number of test cases that were executed and their respective results (Pass / Fail)


