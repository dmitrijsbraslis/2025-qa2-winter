import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BaseFunc;
import pages.HomePage;

import java.util.List;

public class CartTest {
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By MAIN_MENU = By.xpath(".//ul[@class = 'submenu-lvl1__list']");
    private final By MAIN_MENU_ITEM = By.xpath(".//li[contains(@class, 'submenu-lvl1__list-item')]");

    @Test
    public void itemsInCartCheckOnPageObjects() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openHomePage();

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
    }

//    @Test
//    public void itemsInCartCheck() {
//        WebDriver browser = new ChromeDriver();
//        browser.manage().window().maximize();
//
//        browser.get(HOME_PAGE_URL);
//
//        browser.findElement(ACCEPT_COOKIES_BTN).click();
//
//        List<WebElement> mainMenus = browser.findElements(MAIN_MENU);
//        WebElement mainMenuToUse = mainMenus.get(1);
//
//        List<WebElement> mainMenuItems = mainMenuToUse.findElements(MAIN_MENU_ITEM);
//
////        for (int i = 0; i < mainMenuItems.size(); i++) {
////            if (mainMenuItems.get(i).getText().equals("Spēļu konsoles un piederumi")) {
////                mainMenuItems.get(i).click();
////                break;
////            }
////        }
//
//        for (WebElement menuItem : mainMenuItems) {
//            if (menuItem.getText().equals("Spēļu konsoles un piederumi")) {
//                menuItem.click();
//                break;
//            }
//        }
//    }
}
