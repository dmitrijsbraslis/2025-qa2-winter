package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BaseFunc() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        actions = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void goToUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) url = "http://" + url;

        driver.get(url);
    }

    public HomePage openHomePage() {
        goToUrl("1a.lv");
        return new HomePage(this);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//        driver.findElement(locator).click();
    }

    public void scrollToElement(By locator) {
        WebElement we = driver.findElement(locator);

        actions.scrollToElement(we);
        actions.perform();
    }

    public void type(By locator, String text) {
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }
}
