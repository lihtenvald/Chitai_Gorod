package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtils;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30, 500));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[class='header-search__input']")
    private WebElement searchField;
    @FindBy(css = "button[class='header-search__button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='products-list']//article[2]//span[@class='action-button__text']")
    private WebElement buyBook1Button;
    @FindBy(xpath = "//div[@class='products-list']//article[3]//span[@class='action-button__text']")
    private WebElement buyBook2Button;
    @FindBy(xpath = "//div[@class='products-list']//article[4]//span[@class='action-button__text']")
    private WebElement buyBook3Button;
    @FindBy(xpath = "//div//a[@class='header-cart sticky-header__controls-item']")
    private WebElement cartButton;
   //сама написала
    @FindBy(xpath = "//div//article[2]//div[@class='product-price__value product-price__value--discount']")
    private WebElement priceBook1;
    @FindBy(xpath = "//div//article[3]//div[@class='product-price__value product-price__value--discount']")
    private WebElement priceBook2;
    @FindBy(xpath = "//div//article[4]//div[@class='product-price__value product-price__value--discount']")
    private WebElement priceBook3;

    public void searchBooks(String search) {
        searchField.sendKeys(search);
        searchButton.click();
    }

    public void clickBuyBook1Button() {
        TestUtils.clickDivElement(driver, buyBook1Button);
    }

    public void clickBuyBook2Button() {
        TestUtils.clickDivElement(driver, buyBook2Button);
    }

    public void clickBuyBook3Button() {
        TestUtils.clickDivElement(driver, buyBook3Button);
    }

    public void goToCartPage() {
        TestUtils.clickDivElement(driver, cartButton);
    }
    public String getBook1Price(){
      return priceBook1.getText();
    }
    public String getBook2Price(){
        return priceBook2.getText();
    }
    public String getBook3Price(){
        return priceBook3.getText();
    }


}
