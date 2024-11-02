package Tests;

import Pages.HomePage;
import Pages.ReviewOrderPage;
import Utilities.DataUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;

@Epic("Automation Exercise Website")
@Feature("Checkout Process End To End ")
public class TestCheckoutProcess {
    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(Utilities.DataUtils.getPropertyValue("environment", "Browser"));
        getDriver().get(Utilities.DataUtils.getPropertyValue("environment", "BASE_URL"));
    }
    @Description
            (
                    "Given user open Automation Exercise Website" +
                            " And click on Login" +
                            " And login Using Valid Email & Password" +
                            " And choose Product and click View Product" +
                            " And click on add To Cart button" +
                            " And click on View Cart" +
                            " And click on Proceed To Checkout Button" +
                            " And fill message in Checkout Page" +
                            " And fill Payment Information" +
                            " And click on pay and confirm order" +
                            " And click on continue  button" +
                            " Then user should return to Home screen"
            )
    @Severity(SeverityLevel.CRITICAL)
    @Story("Checkout Process")

    @Test(description = "testCheckoutProcess")
    public void testCheckoutProcess() {
        new HomePage(getDriver())
                .clickOnLogin()
                .loginWithValidLogin(

                        DataUtils.getJsonData("validLogin", "emailAddress"),
                        DataUtils.getJsonData("validLogin", "password")

                )
                .clickOnLoginButton()
                .chooseProduct()
                .clickOnAddToCartButton()
                .clickOnViewCartLink()
                .clickOnProceedToCheckout()
                .enterMessage(DataUtils.getJsonData("checkOutData", "message"))
                .clickOnPlaceOrderButton()
                .fillPaymentInformation(

                        DataUtils.getJsonData("paymentInformationData", "nameOnCard"),
                        DataUtils.getJsonData("paymentInformationData", "cardNumber"),
                        DataUtils.getJsonData("paymentInformationData", "cvc"),
                        DataUtils.getJsonData("paymentInformationData", "expirationMonth"),
                        DataUtils.getJsonData("paymentInformationData", "expirationYear")

                )
                .clickOnPayAndConfirmPaymentButton()
                .takeScreenShotForSuccessProcess();
        String productCheckoutResult = new ReviewOrderPage(getDriver()).getOrderPlaceResultText();
        Assert.assertEquals(productCheckoutResult, "ORDER PLACED!");



    }

    @AfterMethod
    public void quitTheDriver() {
        quitDriver();
    }
}
