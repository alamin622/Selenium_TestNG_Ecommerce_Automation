package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchFunctionality {
    @FindBy(id="search_query_top")
    public
    WebElement txtSearch;
    @FindBy(name="submit_search")
    public
    WebElement btnSearch;
    @FindBy(className = "heading-counter")
    WebElement lblResult;
    @FindBy(className = "alert")
    WebElement noResultFoundWarning;
    @FindBy(className = "lighter")
    public WebElement searchProductName;
    @FindBy(className = "product-name")
    public List<WebElement>productName;
    @FindBy(id = "selectProductSort")
    public WebElement sortByDropdown;
    //index->11 and 13
    @FindBy(className = "price")
    public List<WebElement> productPrice;
    WebDriver driver;
    public SearchFunctionality(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String searchProduct(String product) throws InterruptedException {
        txtSearch.clear();
        Thread.sleep(1000);
        txtSearch.sendKeys(product);
        Thread.sleep(1000);
        btnSearch.click();
        return lblResult.getText();
    }

    public String incorrectSearchProduct(String product) throws InterruptedException {
        Thread.sleep(1000);
        txtSearch.clear();
        txtSearch.sendKeys(product);
        Thread.sleep(1000);
        btnSearch.click();
        return noResultFoundWarning.getText();
    }
}
