package tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;

import java.time.Duration;

public class FunctionalityCartTest extends BaseTest {
    private MainPage mainPage;
    private CartPage cartPage;


    @Test
    public void AddAndRemoveBooksToCart() {
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        SoftAssertions softAssert = new SoftAssertions();

        String currentTitle = driver.getTitle();
        softAssert.assertThat("Читай-город — интернет-магазин книг").isEqualTo(currentTitle);

        mainPage.searchBooks("тестирование");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String book1PriceCatalog = mainPage.getBook1Price();
        String book2PriceCatalog = mainPage.getBook2Price();
        String book3PriceCatalog = mainPage.getBook3Price();


        mainPage.clickBuyBook1Button();
        mainPage.clickBuyBook2Button();
        mainPage.clickBuyBook3Button();
        mainPage.goToCartPage();
//проверяем количество выбранных товаров
        String currentNumberOfGoods = cartPage.getNumberOfGoods();
        softAssert.assertThat("3 товара").isEqualTo(currentNumberOfGoods);

//проверяем цены выбранных товаров в корзине

        String book1PriceCart = cartPage.getBook1CartPrice();
        String book2PriceCart = cartPage.getBook2CartPrice();
        String book3PriceCart = cartPage.getBook3CartPrice();
        softAssert.assertThat(book1PriceCatalog).isEqualTo(book1PriceCart);
        softAssert.assertThat(book2PriceCatalog).isEqualTo(book2PriceCart);
        softAssert.assertThat(book3PriceCatalog).isEqualTo(book3PriceCart);

        System.out.println(cartPage.getbook1NumberPrice());


        softAssert.assertAll();


    }

}
