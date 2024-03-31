package pages;

import org.openqa.selenium.WebDriver;

public class ChitaiGorodSite {
    private final WebDriver driver;
    private MainPage mainPage;
    private CartPage cartPage;

    public ChitaiGorodSite(WebDriver driver) {
        this.driver = driver;

        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }


    public MainPage getMainPage() {
        return mainPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }
}
