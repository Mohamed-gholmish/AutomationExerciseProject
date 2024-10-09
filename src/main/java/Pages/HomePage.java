package Pages;

import Utilities.Utility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public final By loginButton = By.xpath("//a[@href='/login']");
    private final By featuresText = By.xpath("//h2[text()='Features Items']");
    private final By firstProduct = By.xpath("//a[@href='/product_details/1']");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO search for the best practice for naming
    @Step("Click to open Login Page")
    public LoginPage clickOnLogin() {
        Utility.clickingOnElement(driver, loginButton);
        return new LoginPage(driver);
    }

    @Step("Choose product then open Product Details Page")
    public ProductDetailsPage chooseProduct() {
        Utility.clickingOnElement(driver, firstProduct);
        return new ProductDetailsPage(driver);
    }
}
