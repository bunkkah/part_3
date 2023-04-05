import jdk.jfr.Description;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BrowserStarter {
    User user;

    @Before
    public void startUp() {
        user = User.getRandom();
    }

    @Test
    @Description("Successful user registration")
    public void successfulRegistration() {
        // нажать кнопку Личный кабинет
        // нажать на кнопку регистрации
        // зарегистрировать пользователя

        final boolean isRegistrationComplited = mainPage
                .clickPersonalAccountBtn()
                .clickSignupBtn()
                .signup(user)
                .isLoginBtnDisplayed();
        assertTrue("Регистрация пользователя завершилась ошибкой", isRegistrationComplited);
    }

    @Test
    @Description("Unsuccessful registration of a user. Password has a five-character symbols.")
    public void registrationWithInvalidPassword() {
        // нажать кнопку Личный кабинет
        // нажать на кнопку регистрации
        // зарегистрировать пользователя, заполнив поле "пароль" 5ю символами
        user.setPassword(RandomStringUtils.randomAlphanumeric(5));

        final boolean isRegistrationEndedWithError = mainPage
                .clickPersonalAccountBtn()
                .clickSignupBtn()
                .signupWithError(user)
                .isPasswordErrorCorrect();
        assertTrue("Ошибка неверной длины пароля отсутствует или имеет неверный текст", isRegistrationEndedWithError);
    }
}
