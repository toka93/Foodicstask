package ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class BrowserFactory {

    private BrowserFactory() {
        // Prevent instantiation
    }

    public static WebDriver createDriver(String browserName, boolean headless) {
        if (browserName == null || browserName.trim().isEmpty()) {
            throw new IllegalArgumentException("Browser name cannot be null or empty");
        }

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                return createChromeDriver(headless);
            case "firefox":
                return createFirefoxDriver(headless);
            case "edge":
                return createEdgeDriver(headless);
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    private static WebDriver createChromeDriver(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-infobars", "--disable-extensions",
                "--remote-allow-origins=*", "--no-sandbox", "--disable-dev-shm-usage", "--lang=en");

        if (headless) {
            options.addArguments("--headless=new");
        }

        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized", "--disable-infobars");
        options.addPreference("intl.accept_languages", "en");

        if (headless) {
            options.addArguments("--headless");
        }

        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean headless) {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized", "--disable-infobars",
                "--remote-allow-origins=*", "--no-sandbox", "--disable-dev-shm-usage", "--lang=en");

        if (headless) {
            options.addArguments("--headless");
        }

        return new EdgeDriver(options);
    }
}
