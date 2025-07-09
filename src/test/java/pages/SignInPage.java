package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SignInPage {
    private final By REGISTRATION_LINK = By.xpath(".//p[@class = 'users-session-form__signup']/a");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public SignInPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        LOGGER.info("We are on Sign In page");
    }

    public RegistrationPage openRegistrationPage() {
        LOGGER.info("Opening Registration Page");
        baseFunc.scrollToElement(REGISTRATION_LINK);
        baseFunc.click(REGISTRATION_LINK);
        return new RegistrationPage(baseFunc);
    }
}
