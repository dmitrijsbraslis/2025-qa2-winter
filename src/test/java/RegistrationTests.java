import model.PageObjectUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.BaseFunc;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;

public class RegistrationTests {
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By REGISTRATION_BTN = By.xpath(".//strong[@class = 'user-block__title--strong']");
    private final By REGISTRATION_LINK = By.xpath(".//p[@class = 'users-session-form__signup']/a");
    private final By FIRST_NAME = By.id("user_first_name");
    private final By LAST_NAME = By.id("user_last_name");
    private final By EMAIL = By.id("user_email");
    private final By PASSWORD = By.id("user_password");
    private final By PASSWORD_CONFIRM = By.id("user_password_confirmation");
    private final By MARKETING_CHECKBOX = By.id("user_marketing_consent_1");
    private final By INFORMATION_CHECKBOX = By.id("user_marketing_consent_2");
    private final By REGISTER_BTN = By.name("commit");
    private final By ERROR_MSG = By.xpath(".//p[@class = 'users-session-form__error-message']");

    private final String PASSWORD_COMPLEXITY_ERROR = "parolei jāsatur vismaz viens skaitlis, mazā burti, lielā burti un īpašais simbols";
    private final String PASSWORD_MATCH_ERROR = "nesakrīt ar apstiprinājumu";

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
//    private PageObjectUser user = new PageObjectUser("FirstName", "Tester",
//            "tester@tester.lv", "qwerty12345!");

    @Test
    public void passwordInconsistencyTestOnPageObjects() {
        LOGGER.info("This test will check password inconsistency error msg");
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openHomePage()
                .acceptCookies()
                .openLoginPage()
                .openRegistrationPage()
                .registerUser(new PageObjectUser(true), true);

        LOGGER.info("Checking error messages");
        RegistrationPage registrationPage = new RegistrationPage(baseFunc);
        registrationPage.checkForErrorMsg(PASSWORD_COMPLEXITY_ERROR);
        registrationPage.checkForErrorMsg(PASSWORD_MATCH_ERROR);

//        --------------ALTERNATIVE--------------------------------
//        BaseFunc baseFunc = new BaseFunc();
//        baseFunc.openHomePage()
//                .acceptCookies()
//                .openLoginPage()
//                .openRegistrationPage()
//                .typeFirstName("FirstName")
//                .typeLastName("Tester")
//                .typeEmail("tester@tester.lv")
//                .typePassword("qwerty12345!")
//                .confirmPassword("qwerty12345")
//                .scrollToRegistrationBtn()
//                .applyForMarketingEmails()
//                .applyForNews()
//                .pressRegistrationBtn();
//        ---------------------------------------------------------

//        --------------ALTERNATIVE--------------------------------
//        baseFunc.openHomePage();
//
//        HomePage homePage = new HomePage(baseFunc);
//        homePage.acceptCookies();
//        homePage.openLoginPage();
//
//        SignInPage signInPage = new SignInPage(baseFunc);
//        signInPage.openRegistrationPage();
//        ---------------------------------------------------------
    }

//    @Test
//    public void passwordInconsistencyTest() {
//        //Open Browser window
//        WebDriver browser = new ChromeDriver();
//        browser.manage().window().maximize();
//
//        //Open Home Page
//        browser.get(HOME_PAGE_URL);
//
//        //Accept cookies
//        WebElement acceptCookiesBtn = browser.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
//        acceptCookiesBtn.click();
//        browser.findElement(ACCEPT_COOKIES_BTN).click();
//
//        //Press Registration btn
////        WebElement registrationBtn = browser.findElement(By.xpath(".//strong[@class = 'user-block__title--strong']"));
////        registrationBtn.click();
//        browser.findElement(REGISTRATION_BTN).click();
//
//        //Click Registration link
////        browser.findElement(REGISTRATION_LINK).click();
//        WebElement registrationLink = browser.findElement(REGISTRATION_LINK);
//
//        Actions actions = new Actions(browser);
//        actions.scrollToElement(registrationLink);
//        actions.perform();
//
//        registrationLink.click();
//
//        //Enter First Name
//        browser.findElement(FIRST_NAME).sendKeys("Dmitrijs");
//
//        //Enter Last Name
//        browser.findElement(LAST_NAME).sendKeys("Tester");
//
//        //Enter E-mail
//        browser.findElement(EMAIL).sendKeys("test@test.lv");
//
//        //Enter Password
//        browser.findElement(PASSWORD).sendKeys("qwerty12345!");
//
//        //Enter Password again with mistake
//        browser.findElement(PASSWORD_CONFIRM).sendKeys("qwerty12345");
//
//        //Scroll to the Registration btn
//        WebElement registrationBtn = browser.findElement(REGISTER_BTN);
//        actions.scrollToElement(registrationBtn);
//        actions.perform();
//
//        //Select marketing check-box
//        browser.findElement(MARKETING_CHECKBOX).click();
//
//        //Select news check-box
//        browser.findElement(INFORMATION_CHECKBOX).click();
//
//        //Press Registration button
//        registrationBtn.click();
//
//
//        //Check wrong password error message
//        List<WebElement> errorMessages = browser.findElements(ERROR_MSG);
//        Assertions.assertEquals(2, errorMessages.size(), "Wrong errors amount!");
//        Assertions.assertEquals(PASSWORD_COMPLEXITY_ERROR, errorMessages.get(0).getText(), "Error msg!");
//        Assertions.assertEquals(PASSWORD_MATCH_ERROR, errorMessages.get(1).getText(), "Error msg!");
//    }
}
