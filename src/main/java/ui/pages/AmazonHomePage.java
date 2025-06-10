package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By allMenuButton = By.id("nav-hamburger-menu");
    private final By videoGamesLink = By.xpath("//div[text()='Video Games']");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openAllMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(allMenuButton)).click();
    }

    public void selectVideoGames() {
        wait.until(ExpectedConditions.elementToBeClickable(videoGamesLink)).click();
    }
}