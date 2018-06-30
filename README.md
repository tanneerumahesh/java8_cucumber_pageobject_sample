##Framework Description

- framework is created using typical pageobject pattern using pagefactory

- in src/main/java there is a pageobject folder created which consists of different page classes 
- each page class contains elements and actions on page and elements are initialised using pagefactory
- a PageUtils class is created with some of the common functions related to all pages  

- in src/test/java a stepdefinition folder is created with stepdefinition files generated using feature files
- Hooks file is create in stepdefinitions folder which consists of before and after scenarios 
- a test runner file is created in stepdefinitions folder with options related to cucumber
- DriverUtils class is created with some common functions around webdriver initialization and waits
- FactoryUtils is created with some common math/conversions logical functions which can be used across all other clases


##Running Tests

- To run tests from IDE right click on TestRunner file and select 'Run as junit'

- To run tests from command line navigate to project root in command prompt and run *'mvn test'*. to run particular scenarios 
use below command

    *mvn test  -Dtest=TestRunner -Dcucumber.options="--tags @001"*