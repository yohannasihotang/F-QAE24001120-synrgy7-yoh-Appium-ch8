package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])[1]")
    private WebElement addToCartButton1;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])[2]")
    private WebElement addToCartButton2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    private WebElement cartPage;

    @AndroidFindBy(id = "test-CHECKOUT")
    private WebElement checkoutButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: INFORMATION']")
    private WebElement checkoutInfoPage;

    @AndroidFindBy(id = "test-First Name")
    private WebElement firstNameField;

    @AndroidFindBy(id = "test-Last Name")
    private WebElement lastNameField;

    @AndroidFindBy(id = "test-Zip/Postal Code")
    private WebElement zipCodeField;

    @AndroidFindBy(id = "test-CONTINUE")
    private WebElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private WebElement checkoutOverviewPage;

    @AndroidFindBy(id = "test-FINISH")
    private WebElement finishButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"CHECKOUT: COMPLETE!\")")
    private WebElement checkoutCompleteText;

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton2)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartPage)).click();
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String zipCode) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(zipCodeField)).sendKeys(zipCode);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void clickFinishButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public boolean isCheckoutCompleteDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(checkoutCompleteText));
            return checkoutCompleteText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
