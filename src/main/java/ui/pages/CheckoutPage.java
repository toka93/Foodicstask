package ui.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class CheckoutPage extends BasePage {
    private final By addAddressBtn = By.xpath("//a[contains(text(),'Add a new delivery address') or contains(text(),'Add address')]");
    private final By fullNameInput = By.id("address-ui-widgets-enterAddressFullName");
    private final By phoneInput = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private final By addressInput = By.id("address-ui-widgets-enterAddressLine1");
    private final By buildingNo = By.id("address-ui-widgets-enter-building-name-or-number");
    private final By cityInput = By.id("address-ui-widgets-enterAddressCity");
    private final By regionSelect = By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId");
    private final By saveAddressBtn = By.xpath("//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']");
    private final By cashOnDeliveryOption = By.xpath("//input[@type='radio' and contains(@name, 'COD')] | //span[contains(text(),'Cash on Delivery')]/ancestor::label/input[@type='radio']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private static final Faker faker = new Faker(new Locale("en-EG"));

    public void addAddress() {
        click(addAddressBtn);
        type(fullNameInput, faker.name().firstName());
        type(phoneInput, faker.numerify("0106########"));
        type(addressInput, faker.address().fullAddress());
        type(buildingNo, faker.address().buildingNumber());
        type(cityInput,"New Cairo City");
                pressOnKey(cityInput, Keys.LEFT_ALT);
        //New Cairo City" "New Cairo City-District No 1 (The 5th settlement)"
        type(regionSelect,"New Cairo City-District No 1 (The 5th settlement)");

        pressOnKey(regionSelect, Keys.LEFT_ALT);
        click(saveAddressBtn);
    }

    public void selectCashOnDelivery() {
        click(cashOnDeliveryOption);
    }
}

