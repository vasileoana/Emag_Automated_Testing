# Automationpractice-EBusiness

We will create a test suite using Java, Selenium, TestNG and the Chrome Driver to run our tests

#  Get the webdriver for your platform: Windows, MacOS, Linux (configured)
**You need to change your driver, if you try to run on another platform!!**

If you are running this on Windows or MacOS you need to change the webdriver that is under the Drivers/ folder. Right now it is configurade with the Linux WebDriver for Chrome. You also need to modify the Config class under the config package to specify chromedrive.exe because on Linux I did not need to specify an extension. 
[Download ChromeWebdriver for your platform](https://chromedriver.storage.googleapis.com/index.html?path=2.37/)
# Configure your compiler
Make sure you go into File -> Build Execution and Deployment-> Compiler and change the compiler to java 8 (or 1.8)

# Make sure you are using the proper Language Level
Go to File -> Project Structure -> Modules and change the Language Level to Level 8 

# Steps

1. Create a maven project and import Selenium and TestNG in your pom.xml

```
<dependencies>
         <dependency>
             <groupId>org.seleniumhq.selenium</groupId>
             <artifactId>selenium-java</artifactId>
             <version>3.10.0</version>
         </dependency>
     <dependency>
         <groupId>org.testng</groupId>
         <artifactId>testng</artifactId>
         <version>6.8</version>
         <scope>test</scope>
     </dependency>
     </dependencies>
 ```
 
 2. Create a config class under the config package
 
 3. Instantiate the ChromeDriver in the Config class
 
 4. [Download and place the ChromeDriver under Drivers in the project root directory](https://chromedriver.storage.googleapis.com/index.html?path=2.37/)
 
 5. Create your page objects under the package /pages

 6. Create your WebActions helper class to expand the selenium wait api. Create it under the package utils
 
 7. Create your tests under the test/java/smoketests 
 
 8. Create your testng.xml file in the project root directory
 
 ```
 <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
 
 <suite name="smoketests" verbose="1" >
     <test name="Somketests">
         <packages>
             <package name="smoketests" />
         </packages>
     </test>
 </suite>

```
9. Happy test Execution

10. Write a new test!
 