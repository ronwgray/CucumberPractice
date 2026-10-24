package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestDriver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        if (driver.get() == null) {
            // Chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("start-maximized");
            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        } else {
            System.out.println("driver currently null");
        }
    }
}