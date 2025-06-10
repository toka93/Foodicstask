package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage  extends BasePage {
    private final By cartItems = By.cssSelector(".sc-list-item");
    private final By subtotal = By.id("sc-subtotal-amount-activecart");
    private final By cart = By.id("nav-cart");
    private final By proceed=By.xpath("//input[@name='proceedToRetailCheckout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart()
    {

        click(cart);
    }
    public int getItemsCount() {
        return countElements(cartItems);
    }

    public double getCartTotal() {
        String totalText = find(subtotal).getText().replace("EGP", "").replace(",", "").trim();
        return Double.parseDouble(totalText);
    }




    public int getCartItemsCount()
    {
        openCart();
       return getItemsCount();

    }

public  void gotoCheckoutPage()
{
    click(proceed);
}
}