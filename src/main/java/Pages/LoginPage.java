package Pages;

import Utilities.Utility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By emailInput = By.xpath("//input[@data-qa='login-email']");
    private final By passwordInput = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter valid login data")
    public LoginPage loginWithValidLogin(String emailText ,String passwordText) {
        Utility.sendData(driver, emailInput, emailText);

        Utility.sendData(driver,passwordInput, passwordText  );
        return this;
    }


    @Step("Click on login ")
    public HomePage clickOnLoginButton() {
        Utility.clickingOnElement(driver, loginButton);
        return new HomePage(driver);
    }
}