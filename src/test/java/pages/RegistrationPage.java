package pages;

import model.PageObjectUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.*;

public class RegistrationPage {
    private final By FIRST_NAME = id("user_first_name");
    private final By LAST_NAME = id("user_last_name");
    private final By EMAIL = id("user_email");
    private final By PASSWORD = id("user_password");
    private final By PASSWORD_CONFIRM = id("user_password_confirmation");
    private final By MARKETING_CHECKBOX = id("user_marketing_consent_1");
    private final By INFORMATION_CHECKBOX = id("user_marketing_consent_2");
    private final By REGISTER_BTN = name("commit");
    private final By ERROR_MSG = xpath(".//p[contains(@class, 'error-message')]");
    private final By REGISTRATION_FORM_TITLE = tagName("h2");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public RegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assertions.assertEquals("Reģistrēties", baseFunc.getText(REGISTRATION_FORM_TITLE), "We are not on registration page");
        LOGGER.info("We are on Registration page");
    }

    public void registerUser(PageObjectUser user, boolean withIncorrectPassword) {
        LOGGER.info("Registering new user");
        typeFirstName(user.getFirstName())
                .typeLastName(user.getLastName())
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword());

        if (withIncorrectPassword) {
            confirmPassword(user.getPassword() + "!");
        } else {
            confirmPassword(user.getPassword());
        }

        scrollToRegistrationBtn()
                .applyForMarketingEmails()
                .applyForNews()
                .pressRegistrationBtn();
    }

    public RegistrationPage typeFirstName(String firstName) {
        baseFunc.type(FIRST_NAME, firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        baseFunc.type(LAST_NAME, lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        baseFunc.type(EMAIL, email);
        return this;
    }

    public RegistrationPage typePassword(String password) {
        baseFunc.type(PASSWORD, password);
        return this;
    }

    public RegistrationPage confirmPassword(String password) {
        baseFunc.type(PASSWORD_CONFIRM, password);
        return this;
    }

    public RegistrationPage scrollToRegistrationBtn() {
        baseFunc.scrollToElement(REGISTER_BTN);
        return this;
    }

    public RegistrationPage applyForMarketingEmails() {
        baseFunc.click(MARKETING_CHECKBOX);
        return this;
    }

    public RegistrationPage applyForNews() {
        baseFunc.click(INFORMATION_CHECKBOX);
        return this;
    }

    public void pressRegistrationBtn() {
        baseFunc.click(REGISTER_BTN);
    }

    public RegistrationPage checkForErrorMsg(String errorMsg) {
        List<WebElement> errorMsgElements = baseFunc.findElements(ERROR_MSG);
        Assertions.assertFalse(errorMsgElements.isEmpty(), "There are no error messages at all!");

        boolean isErrorMsgFound = false;
        for (WebElement we : errorMsgElements) {
            if (we.getText().trim().equals(errorMsg)) {
                isErrorMsgFound = true;
                break;
            }
        }

        Assertions.assertTrue(isErrorMsgFound, "There is no error msg: " + errorMsg);

        return this;
    }
}
