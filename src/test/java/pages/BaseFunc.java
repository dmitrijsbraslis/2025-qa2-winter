package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunc {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BaseFunc() {
        LOGGER.info("Opening Web Browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        actions = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void goToUrl(String url) {
        LOGGER.info("Open URL: " + url);
        if (!url.startsWith("http://") && !url.startsWith("https://")) url = "http://" + url;

        driver.get(url);
    }

    public HomePage openHomePage() {
        LOGGER.info("Opening Home Page");
        goToUrl("1a.lv");
        return new HomePage(this);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//        driver.findElement(locator).click();
    }

    public void scrollToElement(By locator) {
        WebElement we = findElement(locator);

        actions.scrollToElement(we);
        actions.perform();
    }

    public void type(By locator, String text) {
        WebElement inputField = findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
}
