package TestRunner;

import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
//import org.junit.Test;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    Utils utils=new Utils();
    @Test(priority=9,description = "valid credentials and login  successful")
    public void doLoginWithValidCreds() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);
        utils=new Utils();
        utils.getUserCreds(0);
        boolean isLogOutFound=loginPage.doLoginWithValidCreds(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(isLogOutFound,true);
        Allure.description("After giving valid credintials of the user, user will be able to successfully login " +
                "and after login logout button will be displayed");
    }
    @Test(priority = 1,description = "Registered Email but incorrect Password Given")
    public void doLoginWithInvalidCreds() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);
        utils.getUserCreds(1);
        driver.get("http://automationpractice.com/");
        String validationMessage=loginPage.doLoginWithInvalidCreds(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(validationMessage.contains("failed"));
        Allure.description("User has given registered email but incorrect password");
    }
    @Test(priority = 2,description = " blank email")
    public void doLoginWithblankEmail() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);
        String validationMessage=loginPage.doLoginWithblankEmail("", utils.getPassword());
        Assert.assertTrue(validationMessage.contains("email address required"));
        Allure.description("User has given valid password but no email address is given,the email address field is kept blank.Should give 'email required message' ");
    }
    @Test(priority = 3,description = " blank password")
    public void doLoginWithblankPass() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);
        utils.getUserCreds(4);
        String validationMessage=loginPage.doLoginWithblankPass(utils.getEmail(), "");
        Assert.assertTrue(validationMessage.contains("Password  required"));
        Allure.description("User has given valid email but the password is kept as blank," +
                "Should give 'Password required Message'");
    }
    @Test(priority=4,description = "User tries to login with invalid email")
    public void doLoginWithInvalidEmail() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);
        utils.getUserCreds(4);
        String invalidEmail=utils.getEmail().substring(0,5)+" "+utils.getEmail().substring(5);
        String validationMessage=loginPage.doLoginWithInvalidEmail(invalidEmail,utils.getPassword());
        Assert.assertTrue(validationMessage.contains("Invalid email "));
        Allure.description("If user does some mistake inputting email e.g: an initial extra space in between the email, " +
                "then the user will prompted as invalid email being given");
    }
    @Test(priority = 5,description = "incorrect email  correct password")
    public void doLoginWithIncorrectEmailCorrectPass() throws IOException, ParseException, InterruptedException {
        loginPage = new LoginPage(driver);
        utils.getUserCreds(2);
        String validationMessage = loginPage.doLoginWithIncorrectEmailCorrectPass(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(validationMessage.contains("Authentication failed"));
        Allure.description("User tries to login with unauthorized email but valid email and correct password" +
                "User will not be allowed to login and 'Authentication failed' will be prompted");
    }
}
