# personio-automation-ui
Core Path : Create and assign an onboarding template to an employee.
This is the most important critical path in the onboarding flow. End users have to assign onboarding steps to a new joinee by creating and assign a template.
Each of the end users will be using this onboarding flow. The scenario should be automated and it should be the part of smoke test as well.


The current framework implementation will support test execution in following environments.
 Browsers: Chrome,Firefox,Ie
 Platform: Windows, Android

Prerequisites for windows:
Install JDK 11 and set the JAVA_HOME
Install latest gradle and set the GRADLE_HOME
Download latest browser drivers in the folder "lib"

Prerequisites for android:
Install android sdk and set ANDROID_HOME
Install nodejs
Install npm module appium using npm -g install appium

Supporting Test Configuration Properties((./testConfig.properties)):
browser - The browser in which test should be executed. Supports Chrome,Firefox and IE
headless - Whether to launch the browser without GUI( true or false )
appURL: The URL against which test should be executed
gridHubURL: Provide the selenium grid URL or appium URL. Ensure that the property is blank if test are not executed in appium or selenium grid environment.
platform - OS in which test executes. Supports windows and android
deviceName - Android device name in which test should be executed

Configuration changes to execute test suite in windows:
Open the test configuration file(./testConfig.properties)
Change the browser name and mode of browser(whether to run in headless mode)
Change the patform name to windows

Configuration changes to execute test suite in android:
Open the test configuration file(./testConfig.properties) and make the following changes.
Set the browser name as Chrome
Navigate to libs folder and execute the following command in command line to start the appium server
"appium -p 4723 --nodeconfig appiumAndroidConf.json --chromedriver-executable chromedriver.exe"
Set the grid hub url as - http://0.0.0.0:4723/wd/hub
Connect an android device and update the device name

Steps To Execute Tests:
Open the command prompt from the project root folder
Execute command "gradle build" for running the entire test suite
Execute command "gradle clean assemble -DTags_TO_Be_RUN='add scenario tag here' executeTest" for executing scenarios based on tags
eg: gradle clean assemble -DTags_TO_Be_RUN="@smoketest" executeTests

Test execution results will be stored under ./test-results/cucumber-reports/report.html


