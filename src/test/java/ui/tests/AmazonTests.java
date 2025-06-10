package ui.tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.ConfigManager;
import utils.ExtentManager;

import java.lang.reflect.Method;


public class AmazonTests extends BaseTest {

    private LoginPage loginPage;
    private NavigationPage navigationPage;
    private FilterPage filterPage;
    private SortPage sortPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private  CheckoutPage checkoutPage;
    WebDriver driver;
    boolean headless =Boolean.parseBoolean(ConfigManager.getProperty("headless"));

@BeforeTest

public void setUp()
{
    String user =ConfigManager.getProperty("user");
    String password= ConfigManager.getProperty("password");
    driver = BrowserFactory.createDriver(ConfigManager.getProperty("browser"), headless);

    driver.manage().window().maximize();

   driver.get(ConfigManager.getProperty("amazon.url"));

    loginPage = new LoginPage(driver);
    navigationPage = new NavigationPage(driver);
    filterPage = new FilterPage(driver);
    sortPage = new SortPage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
    checkoutPage= new CheckoutPage(driver);
    loginPage.login( user,password);
}
    @Test
    public void testVideoGamesNavigation(Method method) throws InterruptedException {

        test = extent.createTest(method.getName());

        navigationPage.goToAllVideoGames();
        ExtentManager.logInfo(test, "Open All Video Games ");

        filterPage.applyFilters();
        ExtentManager.logInfo(test, "Filter with New and Free Shipping ");

        sortPage.sortByPriceHighToLow();
        ExtentManager.logInfo(test, "sort By Price High To Low ");

        productPage.addProductsBelow15K();
        ExtentManager.logInfo(test, "Add Products Below 15K to Cart ");

        int cartItemCount = cartPage.getCartItemsCount();
        double cartItemsTotalValue=cartPage.getCartTotal();
        boolean checkProductsAdded=cartItemCount > 0;
        ExtentManager.logStep(test, "Products added to cart ",checkProductsAdded );

        Assert.assertTrue(checkProductsAdded, "No products were added to the cart!");
        cartPage.gotoCheckoutPage();
        ExtentManager.logInfo(test, "Go to Checkout Page ");
        checkoutPage.addAddress();
        ExtentManager.logInfo(test, "Add Address ");

        checkoutPage.selectCashOnDelivery();
        ExtentManager.logInfo(test, "Choose Cash On Delivery ");



    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}