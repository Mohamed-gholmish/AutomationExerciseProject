package Pages;

import Utilities.Utility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private final By nameOnCardInput = By.name("name_on_card");
    private final By cardNumberInput = By.name("card_number");
    private final By cvcCardInput = By.name("cvc");
    private final By expiryMonthCardInput = By.name("expiry_month");
    private final By expiryYearCardInput = By.name("expiry_year");
    private final By payAndConfirmPaymentButton = By.id("submit");

    private final WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
@Step("Fill all Payment information ")
    public PaymentPage fillPaymentInformation(String nameOnCardText, String cardNumberText, String cvcCode, String expiryMonthText, String expiryYearText) {
        Utility.sendData(driver, nameOnCardInput, nameOnCardText);
        Utility.sendData(driver, cardNumberInput, cardNumberText);
        Utility.sendData(driver, cvcCardInput, cvcCode);
        Utility.sendData(driver, expiryMonthCardInput, expiryMonthText);
        Utility.sendData(driver, expiryYearCardInput, expiryYearText);

        return this;
    }
@Step("Click on Pay and Confirm Payment ")
    public ReviewOrderPage clickOnPayAndConfirmPaymentButton() {
        Utility.clickingOnElement(driver, payAndConfirmPaymentButton);
        return new ReviewOrderPage(driver);

    }
}
