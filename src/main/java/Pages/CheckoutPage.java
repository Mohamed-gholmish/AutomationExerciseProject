package Pages;

import Utilities.Utility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final By messageTextArea = By.tagName("textarea");
    private final By placeOrderButton = By.xpath("//a[@href='/payment']");
    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter message in Checkout Page")
    public CheckoutPage enterMessage(String messageText) {
        Utility.sendData(driver, messageTextArea, messageText);
        return this;
    }

    @Step("Place the order")
    public PaymentPage clickOnPlaceOrderButton() {
        Utility.clickingOnElement(driver, placeOrderButton);
        return new PaymentPage(driver);
    }
}
