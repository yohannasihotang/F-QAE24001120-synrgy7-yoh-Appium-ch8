package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    //locator atau element
    By textProducts = By.xpath("//*[@text='PRODUCTS']");

    //action method
    public boolean setTextProductsIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textProducts)).isDisplayed();
        return false;
    }

}
