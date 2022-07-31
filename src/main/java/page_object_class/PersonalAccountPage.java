package page_object_class;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PersonalAccountPage extends MainPage {

    @FindBy(how = How.NAME, using = "Name")
    private SelenideElement nameInput;

    @FindBy(how = How.NAME, using = "name")
    private SelenideElement loginInput;

    @FindBy(how = How.XPATH, using = ".//a[@href='/account/profile']")
    private SelenideElement profileBtn;

    @FindBy(how = How.XPATH, using = ".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement logoutBtn;

    public String getNameValue() {
        return nameInput.getValue();
    }

    public String getLoginValue() {
        return loginInput.getValue();
    }

    public boolean isProfileBtnDisplayed() {
        profileBtn.scrollIntoView(true);
        profileBtn.shouldBe(Condition.exist);
        return profileBtn.isDisplayed();
    }

    public LoginPage clickLogoutBtn() {
        logoutBtn.scrollIntoView(true);
        logoutBtn.click();
        return page(LoginPage.class);
    }
}
