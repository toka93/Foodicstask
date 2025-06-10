package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterPage  extends BasePage {
    private final By freeShippingCheckbox = By.xpath("//ul[@aria-labelledby='p_n_free_shipping_eligible-title']//a[contains(.,'Free Shipping')]");
    private final By newConditionCheckbox = By.xpath("//span[text()='New']");

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public void applyFilters() {

        click(freeShippingCheckbox);
        click(newConditionCheckbox);
    }
}