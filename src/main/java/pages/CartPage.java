package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.fasterxml.jackson.core.io.NumberInput.parseInt;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30, 500));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='info-item cart-sidebar__item']//div[@class='info-item__title']")
    private WebElement numberOfGoods;
    @FindBy(xpath = "//div[@class='products']/div[1]/div[4]//div[@class='product-price__value product-price__value--discount']")
    private WebElement priceBook1Cart;
    @FindBy(xpath = "//div[@class='products']/div[1]/div[3]//div[@class='product-price__value product-price__value--discount']")
    private WebElement priceBook2Cart;
    @FindBy(xpath = "//div[@class='products']/div[1]/div[2]//div[@class='product-price__value product-price__value--discount']")
    private WebElement priceBook3Cart;


    public String getNumberOfGoods(){
        return numberOfGoods.getText();
    }
    public String getBook1CartPrice(){
        return priceBook1Cart.getText();
    }
    public String getBook2CartPrice(){
        return priceBook2Cart.getText();
    }
    public String getBook3CartPrice(){
        return priceBook3Cart.getText();
    }

//    public int getbook1NumberPrice(){
//        String book1PriceCart = priceBook1Cart.getText();
//        book1PriceCart = book1PriceCart.substring(0,book1PriceCart.length()-1);
//        return Integer.parseInt(book1PriceCart);
//    }

    public double getbook1NumberPrice(){
        return Double.parseDouble(priceBook1Cart.getText());
    }




}
