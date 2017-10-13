# shopping-cart-automation
The project automate the following tasks using Selenium with ChromeWebDriver, FirefoxDriver. The project supports Cross browser-execution on Firefox and Chrome. The Firefox browser execution happens first and then execution on Chrome follows.
   
If the execution one of the browsers is not required, then the tests grouped under respective names need to be commented in [testng.xml](testng.xml) which is located in base path.

Flow of the Scenario:
1. Go to zalando website www.zalando.de
2. Go to the Search box and search for article DK151H09R-Q11
3. Add it to the cart
4. Go to the cart and change the quantity to 2
5. Move the items from the basket to the wishlist.

# Prerequisites 
### This automation project been designed to run on Mac OS ###
* Chrome 60 (and greater) and Firefox 55.0 (and greater) browsers installed
* Have [java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed
* Have [maven](http://maven.apache.org/) installed

# Test Execution Steps:
1. Install shopping-cart-automation project
	1. Download the project zip from :(https://github.com/sudhaberde/shopping-cart-automation/archive/master.zip)
	2. Extract the zip file to the directory of choice (hereafter referred to as base-path)
	* You can also clone the codebase to base-path if you have GIT installed
2. Go to the base-path directory 
	`cd shopping-cart-automation`
3. Run the maven command 
	`mvn clean test`
	* The first time execution of this command will take some time for downloading the required packages. Also, please manually clear the browser cache.

# Note:
1. The geckodriver required for execution on Firefox and chromedriver required for execution on Chrome browser are kept in [webdriver/bin](webdriver/bin)
2. Each step of the flow has been logically treated as a Test. The success and failure of each step will be logged in an html based report. This report test_report.html will be generated in the base path itself. This report gives information in the Pie chart form as well as tabular form. Details of the execution will also be available under each link.
3. The test also contains steps to clean up wishlist, logout and close browser as part of clean-up activity at the end of execution.

# Scope for Improvement
1. Provide support for windows execution
2. Extend browser support to IE and Safari
3. Enable logout support for chrome browser execution