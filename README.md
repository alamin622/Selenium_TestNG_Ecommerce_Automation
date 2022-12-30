# TestNG_Ecommerce_Automation
### This is a complete project where an [E-commerce site](http://automationpractice.com/) site is automated by writing test suites using selenium-webdriver and TestNg as testing framework.
The following key modules/pages are automated:
- **SignUp** 
- **Login**
- **Search**
- **Cart**
- **Checkout**</br>

### Technology: </br>
- Tool: Selenium Webdriver
- IDE: Intellij IDEA
- Build tool: Gradle
- Language: Java
- Testing Framework : TestNG

### Prerequisite: </br>
- Need to install jdk 11, gradle and allure
- Configure Environment variable for jdk 11, gradle and allure
- Clone this project and unzip it
- Open the project folder
- Double click on "build.gradle" and open it through IntellIJ IDEA
- Let the project build successfully
- Click on "Terminal" and run the automation scripts

### Run the Automation Script by the following command:
 ```
 gradle clean test 
 ```
- Selenium will open the browser and start automating.
- After automation to view allure report , give the following commands:
 ```
allure generate allure-results --clean -o allure-report
allure serve allure-results
 ```

**Below is my allure overview report**:

![Overview](https://user-images.githubusercontent.com/55280106/185918375-8ac0df03-ee09-4215-a6df-ecdbcf9fd5cd.png)

**Here are the suites of this project**:

![suites](https://user-images.githubusercontent.com/55280106/185918539-c40ea3e9-dd3f-4e56-b223-adcf80fcbf25.png)


 
