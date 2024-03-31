package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtils {

    //Скролл до элемента
//    public static void scrollToElement(WebDriver driver, WebElement element){
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
//    }
    //Найти и кликнуть на элемент div
    public static void clickDivElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
