package pages;

import org.json.simple.parser.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;


import java.util.List;

public class SignupPage {
    @FindBy(id = "email_create")
    WebElement txtRegEmail;
    @FindBy(css = "[type=submit]")
    List<WebElement> btnSignup;
    @FindBy(id = "id_gender1")
    WebElement rb1;
    @FindBy(id = "customer_firstname")
    public WebElement txtFirstName;
    @FindBy(id = "customer_lastname")
    WebElement txtLastName;
    @FindBy(id = "passwd")
    WebElement txtPassword;
    @FindBy(id = "days")
    WebElement cbDays;
    @FindBy(id = "months")
    WebElement cbMonths;
    @FindBy(id = "years")
    WebElement cbYears;
    @FindBy(id = "address1")
    WebElement txtAddress1;
    @FindBy(id = "city")
    WebElement txtCity;
    @FindBy(id = "id_state")
    WebElement cbState;
    @FindBy(id = "postcode")
    WebElement txtPostCode;
    @FindBy(id = "phone_mobile")
    WebElement txtMobile;
    @FindBy(id = "submitAccount")
    public WebElement regButton;
    @FindBy(className = "account")
    public WebElement userAccountName;
    @FindBy(className = "page-heading")
    public WebElement pageHeading;
    @FindBy(css = "[title=Home]")
    public WebElement btnHome;
    @FindBy(className = "logout")
    public WebElement btnLogOut;
    @FindBy(xpath = "//li[contains(text(),'An account using this email address has already be')]")
    public WebElement msgAlreadyRegistered;
    @FindBy(xpath = "//li[contains(text(),'You must register at least one phone number.')]")
    public WebElement atleastOnePhoneNumber;
    @FindBy(xpath = "//li[contains(text(),' is invalid.')]")
    public List<WebElement> errorMessages;
    @FindBy(xpath = "//li[contains(text(),\"The Zip/Postal code you've entered is invalid. It \")]")
    public WebElement invalidZipCodeMsg;
    @FindBy(xpath = "//h1[contains(text(),'Create an account')]")
    public WebElement txtcreateAccount;
    @FindBy(xpath = "//p[contains(text(),'There are 8 errors')]")
    public WebElement totalErrors;
    @FindBy(xpath = "//li[contains(text(),' is invalid')]")
    public List<WebElement> errorPassAddressCity;
    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //test steps
    //positive test steps
    Utils utils = new Utils();
    String password = utils.generateRandomPassword(8);
    String email;
    public String firstName = "Test" + ((char) utils.generateRandomNumber(65, 123));

    //after giving valid email for signup register form will appear
    public void validEmailandRegisterForm(String email) throws InterruptedException {
        Thread.sleep(1000);
        txtRegEmail.clear();
        txtRegEmail.sendKeys(email);
        this.email = email;
        btnSignup.get(1).click();
        Thread.sleep(1200);
    }

    public String alreadyRegisteredEmail(String email) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        Thread.sleep(1000);
        txtRegEmail.sendKeys(email);
        btnSignup.get(1).click();
        Thread.sleep(2000);
        return msgAlreadyRegistered.getText();

    }
}
