package Pages;

import Utilities.Utility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private final By addToCartButton = By.xpath("//button[@class='btn btn-default cart']");
    private final By viewCartLink = By.xpath("//a[@href='/view_cart'][contains(.,'View Cart')]");
    private final WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {

        this.driver = driver;
    }
    @Step("Add product to the Cart")
    public ProductDetailsPage clickOnAddToCartButton() {
        Utility.clickingOnElement(driver, addToCartButton);
        return this;
    }
   @Step("Open Cart Page")
    public CartPage clickOnViewCartLink() {
        Utility.clickingOnElement(driver, viewCartLink);
        return new CartPage(driver);
    }

}
