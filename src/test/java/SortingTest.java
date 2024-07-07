import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SortingPage;

public class SortingTest {
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
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        // Add assertion to verify text products is displayed
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.setTextProductsIsDisplayed(), "Products text is displayed");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testSortByPriceLowToHigh() {
        SortingPage sortingPage = new SortingPage(driver);

        // Click the filter button
        sortingPage.clickFilterButton();

        // Select sorting by Price (low to high)
        sortingPage.selectSortByPriceLowToHigh();

        // Validate the sorting - Here we just print the first item price as an example
        String firstItemPrice = sortingPage.getFirstItemPrice();
        System.out.println("First item price after sorting: " + firstItemPrice);

        Assert.assertTrue(firstItemPrice != null && !firstItemPrice.isEmpty(), "First item price is displayed or empty");
    }

    @AfterClass
    public void closeSession(){
        if (driver != null) {
            driver.quit();
        }
    }
}
