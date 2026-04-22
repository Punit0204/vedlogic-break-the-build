package AutomationTest.vedlogic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {
    private final WebDriver driver;

    private final By title = By.className("title");
    private final By backpackAddToCart = By.id("add-to-cart-sauce-labs-backpack-pack");
    private final By cartLink = By.className("shopping_cart_link");
    private final By cartBadge = By.className("cart_badge");
    private final By sortDropdown = By.className("product_sort_container");
    private final By itemPrices = By.className("item_price");
    private final By removeBackpackButton = By.id("remove-sauce-labs-backpack");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void sortBy(String visibleText) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(visibleText);
    }

    public List<Double> getDisplayedPrices() {
        List<WebElement> priceElements = driver.findElements(itemPrices);
        return priceElements.stream()
                .map(e -> Double.parseDouble(e.getText()))
                .collect(java.util.stream.Collectors.toList());
    }
}
