package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {
    private final By productsPrice = By.xpath("//div[@class='a-section']//span[contains(@class,'a-price-whole')]");
   // private final By priceWhole = By.cssSelector(".a-price .a-price-whole");
    private final By addToCartBtn = By.cssSelector("input[name='submit.add-to-cart']");
    private final By nextPage = By.cssSelector(".s-pagination-next");
    private final By nothanks =By.xpath("(//span[text()=' No Thanks ']/ancestor::span[@class='a-button-inner']//input)[1]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductsBelow15K() throws InterruptedException {
        boolean hasMorePages = true;

        while (hasMorePages) {
            Thread.sleep(2000); // Optional: Add a proper wait instead of Thread.sleep

            List<WebElement> productElements = findAll(productsPrice);
            boolean foundProductBelow15K = false;

            for (WebElement product : productElements) {
                try {
                    String priceText = product.getText().replace(",", "").trim();

                    if (!priceText.isEmpty()) {
                        int price = Integer.parseInt(priceText);
                        if (price < 15000) {
                            System.out.println(" product price: " + priceText);

                            foundProductBelow15K = true;
                            clickWithRetry(() -> product, 3);
                            click(addToCartBtn);
                            if(findAll(nothanks).size()>0) click(nothanks);
                            sleep(2000);
                            driver.navigate().back();
                            driver.navigate().back();

                            sleep(2000); // Wait after navigating back
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error processing product: " + e.getMessage());
                }
            }

            if (!foundProductBelow15K && driver.findElements(nextPage).size() > 0) {
                click(nextPage);
            } else {
                hasMorePages = false; // Either no next page or some products were < 15K
            }
        }
    }
}
