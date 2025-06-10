package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    private final By allMenu = By.id("nav-hamburger-menu");
    private final By seeAll = By.xpath("//a[@aria-label='See All Categories']");
    private final By videoGamesLink = By.xpath("//a[@class='hmenu-item' and div[text()='Video Games']]");
    private final By allVideoGamesLink = By.xpath("//a[contains(text(),'All Video Games')]");

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public void goToAllVideoGames() throws InterruptedException {
        click(allMenu);

        click(seeAll);

        click(videoGamesLink);

        click(allVideoGamesLink);
    }
}