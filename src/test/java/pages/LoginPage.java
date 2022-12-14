package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    @FindBy(className = "login")
    public
    WebElement linkLogin;
    @FindBy(id = "email")
    public WebElement txtEmail;
    @FindBy(id = "passwd")
    public WebElement txtPassword;
    @FindBy(id = "SubmitLogin")
    public WebElement btnSubmit;
    @FindBy(className = "logout")
    public
    WebElement linkLogout;
    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    WebElement blankEmailAuthError;
    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement lblAuthError;
    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    public WebElement emailRequiredErrorMsg;
    @FindBy(xpath = "//li[contains(text(),'Password is required.')]")
    public WebElement passRequiredErrorMsg;
    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    public WebElement invalidEmailErrorMsg;
    @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    public WebElement linkForgotPassword;
    @FindBy(css = "[type=submit]")
    public List<WebElement> btnRetrieve;
    @FindBy(css = "[title='Back to Login']")
    public WebElement btnBackToLogin;
    @FindBy(css = "[title='T-shirts']")
    public List<WebElement> btnTshirts;
    @FindBy(css = "[title=Information]")
    public WebElement personalInformation;
    @FindBy(id = "old_passwd")
    public WebElement oldPassword;
    @FindBy(id = "confirmation")
    public WebElement confirmPassword;
    //index=39->save button
    //index=32->back to your account button
    @FindBy(css = "[name=submitIdentity]")
    public WebElement btnSave;
    @FindBy(xpath = "//li[contains(text(),'The password you entered is incorrect.')]")
    public WebElement incorrectPasswordMessage;
    @FindBy(xpath = "//p[contains(text(),'Your personal information has been successfully up')]")
    public WebElement msgPersonalInfoUpdated;
    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    public WebElement txtMyAccount;
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Test Steps
    public Boolean doLoginWithValidCreds(String email, String password) throws InterruptedException {
//        linkLogin.click();
        txtEmail.clear();
        txtPassword.clear();
        txtEmail.sendKeys(email);
        Thread.sleep(1000);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        Thread.sleep(1000);
        return linkLogout.isDisplayed();
    }

    public String doLoginWithInvalidCreds(String email, String password) throws InterruptedException {
        linkLogin.click();
        txtEmail.sendKeys(email);
        Thread.sleep(1000);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        Thread.sleep(1000);
        return lblAuthError.getText();
    }

    public String doLoginWithblankEmail(String email, String password) throws InterruptedException {
        txtEmail.clear();
        txtEmail.sendKeys(email);
        Thread.sleep(1000);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return emailRequiredErrorMsg.getText();
    }

    public String doLoginWithblankPass(String email, String password) throws InterruptedException {
        txtEmail.clear();
        txtPassword.clear();
        txtEmail.sendKeys(email);
        Thread.sleep(1500);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return passRequiredErrorMsg.getText();
    }

    public String doLoginWithInvalidEmail(String email, String password) throws InterruptedException {
        txtEmail.clear();
        txtPassword.clear();
        txtEmail.sendKeys(email);
        Thread.sleep(1000);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return invalidEmailErrorMsg.getText();
    }

    public String doLoginWithIncorrectEmailCorrectPass(String email, String password) throws InterruptedException {
        txtEmail.clear();
        txtPassword.clear();
        txtEmail.sendKeys(email);
        Thread.sleep(1000);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblAuthError.getText();
    }

}