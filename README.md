# shopping-cart-automation
The project demonstrates automating the following tasks using Selenium with ChromeWebDriver, FirefoxDriver. This has been designed to run on Mac OS.

Flow of the Scenario:
1. Go to zalando website www.zalando.de
2. Go to the Search box and search for article DK151H09R-Q11
3. Add it to the cart
4. Go to the cart and change the quantity to 2
5. Move the items from the basket to the wishlist.

# Prerequisites 

* Have [java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed
* Have [maven](http://maven.apache.org/) installed

# Test Execution Steps:
1. Install shopping-cart-automation project
	1. Download the project zip from :(https://github.com/sudhaberde/shopping-cart-automation/archive/master.zip)
	2. Extract the zip file to the directory of choice (hereafter referred to as base-path)
	* You can also clone the codebase to base-path if you have GIT installed
2. Go to the base-path directory 
	Markup : `cd shopping-cart-automation`
3. Run the maven command 
	Markup : `mvn clean test`
	The first time execution of this command, it will take some time downloading the required packages, clear the cache.


# Note:
1. The project is written in such a way that it supports Cross browser-execution on Firefox and Chrome.
   The Firefox browser execution happens first and then execution on Chrome follows.
   If the execution one of the browsers is not needed, then the tests grouped under respective names need to be commented in [testng.xml](testng.xml) which is located in base path.
2. The geckodriver required for execution on Firefox and chromedriver required for execution on Chrome browser are kept in [webdriver/bin](webdriver/bin)
3. Each step of the flow has been logically treated as a Test. The success and failure of each step will be logged in an html based report. This report test_report.html will be generated in the base path itself. This report gives information in the Pie chart form as well as tabular form. Details of the execution will also be available under each link.