package pages;

import org.openqa.selenium.By;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By REGISTRATION_BTN = By.xpath(".//strong[@class = 'user-block__title--strong']");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public HomePage acceptCookies() {
        baseFunc.click(ACCEPT_COOKIES_BTN);
        return this;
    }

    public SignInPage openLoginPage() {
        baseFunc.click(REGISTRATION_BTN);
        return new SignInPage(baseFunc);
    }
}
