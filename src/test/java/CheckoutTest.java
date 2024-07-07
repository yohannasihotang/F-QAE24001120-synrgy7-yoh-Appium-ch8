import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutTest {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "a4187d9");
        capabilities.setCapability("app", "C:\\Users\\ASUS\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

//        // Add assertion to verify text products is displayed
//        HomePage homePage = new HomePage(driver);
//        Assert.assertTrue(homePage.isTextProductsDisplayed(), "Products text is not displayed");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testCheckout() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Add two items to cart
        checkoutPage.addItemToCart();

        // Go to cart page
        checkoutPage.goToCart();

        // Click the checkout button
        checkoutPage.clickCheckoutButton();

        // Fill in checkout information and proceed
        checkoutPage.fillCheckoutInformation("Yohanna", "Sihotang", "11421007");

        // Click finish button to complete checkout
        checkoutPage.clickFinishButton();

        // Validate checkout completion
        Assert.assertTrue(checkoutPage.isCheckoutCompleteDisplayed(), "CHECKOUT: COMPLETE!");
    }

    @AfterClass
    public void closeSession() {
        if (driver != null) {
            driver.quit();
        }
    }
}