package TestRunner;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;
import setup.Setup;
import utils.Utils;
import java.io.IOException;
import java.util.List;

public class SignupTestRunner extends Setup {
    //positive test case
    Utils utils=new Utils();
    String email;
    String password;
    String mobile;
    public void basicInfo(){
        String emailUserAcc="testautouser"+utils.generateRandomNumber(1000,9999);
        email=emailUserAcc+"@test.com";
        password=utils.generateRandomPassword(8);
        mobile="175"+utils.generateRandomNumber(1000000,9999999);
    }
    @Test(priority=1,description = "Cannot Create Account with already registered email")
    public void alreadyRegisteredEmail() throws IOException, ParseException, InterruptedException {
        driver.get("http://automationpractice.com/");
        SignupPage signupPage=new SignupPage(driver);
        utils.getUserCreds(0);
        String errorAlreadyregisteredMsg=signupPage.alreadyRegisteredEmail(utils.getEmail());
        Assert.assertTrue(errorAlreadyregisteredMsg.contains("already been registered"));
        Thread.sleep(1500);
        Allure.description("Already been registered email cannot be used for creating new user and an " +
                "error message will be given and user will not be taken to the next step and form fillup."
        );
    }
    @Test(priority = 2,description = "After giving valid email,user will be redirecrted to registration form")
    public void validEmailandRegisterForm() throws InterruptedException {
//        driver.get("http://automationpractice.com/");
        SignupPage signupPage=new SignupPage(driver);
        basicInfo();
        signupPage.validEmailandRegisterForm(email);
        //after logging with valid email
        Assert.assertTrue(signupPage.txtcreateAccount.getText().contains("CREATE AN ACCOUNT"));
        Assert.assertTrue(signupPage.regButton.isDisplayed());
        Allure.description("After giving valid email, user should be redirected to the registration form containing Create Account and register button");
    }
}
