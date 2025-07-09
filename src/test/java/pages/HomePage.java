package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By REGISTRATION_BTN = By.xpath(".//strong[@class = 'user-block__title--strong']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        LOGGER.info("We are on Home Page");
    }

    public HomePage acceptCookies() {
        LOGGER.info("Accepting Cookies");
        baseFunc.click(ACCEPT_COOKIES_BTN);
        return this;
    }

    public SignInPage openLoginPage() {
        LOGGER.info("Opening Sign In Page");
        baseFunc.click(REGISTRATION_BTN);
        return new SignInPage(baseFunc);
    }
}
