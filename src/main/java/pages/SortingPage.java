package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SortingPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public SortingPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators for the sorting elements
    By filterButton = By.xpath("//android.view.ViewGroup[@content-desc='test-Modal Selector Button']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    By sortByPriceLowToHigh = By.xpath("//android.widget.TextView[@text='Price (low to high)']");

    // Locator for the first item price in the list (as an example for validation)
    By firstItemPrice = By.xpath("(//android.widget.TextView[@content-desc='test-Price'])[1]");

    // Method to click the filter button
    public void clickFilterButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterButton)).click();
    }

    // Method to select sorting by Price (low to high)
    public void selectSortByPriceLowToHigh() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortByPriceLowToHigh)).click();
    }

    // Method to get the price of the first item after sorting
    public String getFirstItemPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemPrice)).getText();
    }
}
