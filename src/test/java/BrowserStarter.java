// import org.openqa.selenium.WebDriver;
import page_object_class.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

import static page_object_class.MainPage.MAIN_PAGE_URL;
// import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BrowserStarter {
    MainPage mainPage;

    @Before
    public void startBrowser() {
        //            Раскомментировать для прогона в Яндекс.Браузере
//          ChromeDriver driver;
////        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
////        driver = new ChromeDriver();
////        WebDriverRunner.setWebDriver(driver);

        mainPage = Selenide.open(MAIN_PAGE_URL, MainPage.class);
        Configuration.browserSize = "1920x1080";
    }

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }
}
