import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class FailedTest {
    AndroidDriver driver;

    @BeforeClass
    public void setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","13.0");
        capabilities.setCapability("deviceName", "a4187d9");
        capabilities.setCapability("app", "C:\\Users\\ASUS\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage","com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("yoana");
        loginPage.inputPassword("12345678");
        loginPage.clickLoginButton();

        // Locator for the error message
        By errorMessageLocator = By.xpath("//android.widget.TextView[@text='Username and password do not match any user in this service.']");

        // Wait for the error message to be visible
        boolean isErrorDisplayed = driver.findElement(errorMessageLocator).isDisplayed();

        // Validation and Assertion
        Assert.assertTrue(isErrorDisplayed, "Error message is not displayed as expected");

        // Additional check to verify the error message text
        String expectedErrorMessage = "Username and password do not match any user in this service.";
        String actualErrorMessage = driver.findElement(errorMessageLocator).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message text does not match");
    }

    @AfterClass
    public void closeSession(){
        if (driver != null) {
            driver.quit();
        }
    }
}
