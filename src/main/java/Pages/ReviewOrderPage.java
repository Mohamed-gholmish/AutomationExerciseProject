package Pages;

import Utilities.Utility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewOrderPage {
    private final By orderPlacedText = By.xpath("//b[text()='Order Placed!']");
    private final By continueButton = By.xpath("//a[@data-qa='continue-button']");

    private final WebDriver driver;

    public ReviewOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Get the text of the order Placed success")
    public String getOrderPlaceResultText() {
        return Utility.getText(driver, orderPlacedText);
    }

    @Step("Click continue to return to the Home page")
    public HomePage clickOnContinueButton() {
        Utility.clickingOnElement(driver, continueButton);
        return new HomePage(driver);
    }

    @Step("Take Screenshot for the checkout result")
    public ReviewOrderPage takeScreenShotForSuccessProcess() {
        Utility.takeScreenShot(driver, "SuccessProcess");
        return this;
    }

}
