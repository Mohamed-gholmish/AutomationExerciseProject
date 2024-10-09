package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final By proceedToCheckout = By.xpath("//a[text()='Proceed To Checkout']");

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on Proceed to Checkout")
    public CheckoutPage clickOnProceedToCheckout() {
        driver.findElement(proceedToCheckout).click();
        return new CheckoutPage(driver);
    }
}
