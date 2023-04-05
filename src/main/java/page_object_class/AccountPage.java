package page_object_class;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AccountPage extends MainPage {

    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement personalAccountBtn;

    public PersonalAccountPage clickPersonalAccountBtnFromAccount() {
        personalAccountBtn.scrollIntoView(true);
        personalAccountBtn.click();
        return page(PersonalAccountPage.class);
    }

    public boolean isUrlCorrectAfterLogin() {
        createOrderButton.shouldBe(Condition.visible);
        return url().equals(MAIN_PAGE_URL);
    }
}
