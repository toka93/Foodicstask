package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SortPage extends BasePage {
    private final By sortMenu = By.id("s-result-sort-select");
    private final By highToLowOption = By.xpath("//option[contains(text(),'Price: High to Low')]");

    public SortPage(WebDriver driver) {
        super(driver);
    }

    public void sortByPriceHighToLow() throws InterruptedException {
        click(sortMenu);
        click(highToLowOption);
    }
}