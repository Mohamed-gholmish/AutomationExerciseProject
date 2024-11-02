package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static void setupDriver(String specificDriver) {
        switch (specificDriver.toLowerCase()) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximize");

                threadLocal.set(new ChromeDriver(chromeOptions));

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximize");
                new EdgeDriver(edgeOptions);
        }
    }

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        threadLocal.remove();
    }
}