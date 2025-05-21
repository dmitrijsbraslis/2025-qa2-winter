package pages;

import model.PageObjectUser;
import org.openqa.selenium.By;

public class RegistrationPage {
    private final By FIRST_NAME = By.id("user_first_name");
    private final By LAST_NAME = By.id("user_last_name");
    private final By EMAIL = By.id("user_email");
    private final By PASSWORD = By.id("user_password");
    private final By PASSWORD_CONFIRM = By.id("user_password_confirmation");
    private final By MARKETING_CHECKBOX = By.id("user_marketing_consent_1");
    private final By INFORMATION_CHECKBOX = By.id("user_marketing_consent_2");
    private final By REGISTER_BTN = By.name("commit");

    private BaseFunc baseFunc;

    public RegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void registerUser(PageObjectUser user, boolean withIncorrectPassword) {
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
}
