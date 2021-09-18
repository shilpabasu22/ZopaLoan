# Hotel Booking Test cases for Equal Experts

## Project Compilation and Build
The Project has been compiled with Java 11 in IntelliJ. Chrome version used for testing is 72.0.3626.81

#Chromedriver.exe
Chromedriver.exe is provided at location Binary/chromedriver.exe . This file is referred by BasePageHelper class for execution

# Feature Files
The test contains two feature files:
1. Create Booking - This Feature creates new Bookings for various formats such as Alphanumeric and special characters
2. Delete Booking - This Feature deletes the Bookings created by Create Booking Feature
 
#Runner
There are 2 runner classes that could be run individually:
1. ../src/test/java/runners/CreateBooking.java 
2. ../src/test/java/runners/DeleteBooking.java

#Reports
The framework used Extent Reports to record the test execution reports. These reports are saved under Reports Folder.
<br>Any failures are saved with a screen shot and can be referred as required. Screenshots are saved under the Reports folder and the individual execution report.

##Manual Test Cases
Manual test cases could be found at Manual Test Case Scenarios.docx

##Test Suite
Tests are created using TestNG framework. These tests could be run through testng.xml file.

##Execution
These tests could be run in 3 different ways:
* Executing the individual runner classes. - To execute them, go to 
    * runners.CreateBooking - To execute Create Booking Feature
    * runners.DeleteBooking - To execute Delete Booking Feature (If the record doesn't exists, it will be recorded as a failure)
* Executing the Test Suite
    * To execute test suite, you can run the testng.xml file. This will run both Create Booking and Delete Booking features in sequence
* Executing as Maven test
    * These tests could also be triggered through command line using the command "mvn test" - This internally uses testng.xml file and thus will run both the features in sequence
###Assumptions:
1. As this is a test project, only Chrome driver is used for testing
2. TestNG is used as  testing framework
3. Only valid scenarios are tested for Automation testing
4. Only create Booking and delete Booking are tested
5. Bookings with min 2 character and Max. 300 characters is tested
 