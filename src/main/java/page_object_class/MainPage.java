package page_object_class;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement personalAccountBtn;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement logInToYourAccountBtn;

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorBtn;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoBtn;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsBtn;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesBtn;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsBtn;

    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement ingredientBtnAfterClick;

    public LoginPage clickPersonalAccountBtn() {
        personalAccountBtn.scrollIntoView(true);
        personalAccountBtn.click();
        return page(LoginPage.class);
    }

    public AccountPage clickConstructorBtn() {
        constructorBtn.scrollIntoView(true);
        constructorBtn.click();
        return page(AccountPage.class);
    }

    public AccountPage clickLogoBtn() {
        logoBtn.scrollIntoView(true);
        logoBtn.click();
        return page(AccountPage.class);
    }

    public LoginPage clickLogInToYourAccountBtn() {
        logInToYourAccountBtn.scrollIntoView(true);
        logInToYourAccountBtn.click();
        return page(LoginPage.class);
    }

    public MainPage clickBunBtn() {
        bunsBtn.scrollIntoView(true);
        bunsBtn.click();
        return this;
    }

    public MainPage clickSaucesBtn() {
        saucesBtn.scrollIntoView(true);
        saucesBtn.click();
        return this;
    }

    public MainPage clickFillingBtn() {
        fillingsBtn.scrollIntoView(true);
        fillingsBtn.click();
        return this;
    }

    public boolean isBunsBtnDisplayed() {
        bunsBtn.scrollIntoView(true);
        bunsBtn.shouldBe(Condition.exist);
        return bunsBtn.isDisplayed();
    }

    public boolean isIngredientsCorrect(String title) {
        return ingredientBtnAfterClick.getText().contentEquals(title);
    }
}
