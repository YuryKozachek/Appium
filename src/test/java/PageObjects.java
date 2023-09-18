import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PageObjects {

    private String textToSpace = " ";
    private String textToActivity = "Hello UiAutomator!";
    private String textToSet = "Netology";

    private AppiumDriver driver;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    public WebElement clickForm;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    public WebElement pressButton;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    public WebElement seeResult;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    public WebElement seeResultXpath;

    PageObjects(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);  //инициализация элементов(clickForm, pressBottom, seeResult) в самом классе SampleTest + пауза 10 сек
    }

    public String getTextToSpace() {
        return textToSpace;
    }

    public String getTextToActivity() {
        return textToActivity;
    }

    public String getTextToSet() {
        return textToSet;
    }
}
