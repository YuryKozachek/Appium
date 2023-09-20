import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    enum Platform {Android}

    private Platform platform = Platform.Android;

    private AppiumDriver driver;


    PageObjects pageObjects;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL remoteUrl = new URL("http://127.0.0.1:4723");


        if (platform == Platform.Android) {
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:deviceName", "testPhone");
            desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
            desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        }

        pageObjects = new PageObjects(driver);
    }

    @Test
    public void shouldCheckFirstFormOnSpace() {

        pageObjects.clickForm.isDisplayed();
        pageObjects.clickForm.click();
        pageObjects.clickForm.sendKeys(pageObjects.getTextToSpace());

        pageObjects.pressButton.isDisplayed();
        pageObjects.pressButton.click();

        pageObjects.seeResult.isDisplayed();

        Assertions.assertNotEquals(pageObjects.getTextToSpace(), pageObjects.seeResult.getText());

//        WebElement el1 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
//        el1.isDisplayed();
//        el1.sendKeys(textToSpace);
//        WebElement el2 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
//        el2.isDisplayed();
//        el2.click();
//        WebElement el3 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
//        el3.isDisplayed();
//        el3.click();
//        Assertions.assertEquals(el3.getText(), textToActivity);
    }

    @Test
    public void shouldCheckSecondForm() {

        pageObjects.clickForm.isDisplayed();
        pageObjects.clickForm.click();
        pageObjects.clickForm.sendKeys(pageObjects.getTextToSet());

        pageObjects.pressButtonActivity.isDisplayed();
        pageObjects.pressButtonActivity.click();

        pageObjects.textResultActivity.isDisplayed();

        Assertions.assertEquals(pageObjects.getTextToSet(), pageObjects.textResultActivity.getText());

//        WebElement el1 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
//        el1.isDisplayed();
//        el1.sendKeys(textToSet);
//        WebElement el2 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
//        el2.isDisplayed();
//        el2.click();
//        WebElement el3 = driver.findElement(By.xpath("\t\n" + "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.TextView"));
//        el3.isDisplayed();
//        el3.click();
//        Assertions.assertEquals(el3.getText(), textToSet);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
