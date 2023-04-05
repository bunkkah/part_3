import clients.UserClient;
import jdk.jfr.Description;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LogoutTest extends BrowserStarter {
    //Выход из аккаунта
    //Проверка выхода по кнопке «Выйти» в личном кабинете.

    User user;
    UserClient userClient;
    String accessToken;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = User.getRandom();
        accessToken = userClient.createUser(user);
    }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    @Description("Logout")
    public void successLogout() {
        // нажать кнопку Войти в аккаунт
        // ввести почту и пароль
        // нажать кнопку входа
        // нажать на кнопку личного кабинета
        // нажать на кнопку выхода

        final boolean isLogoutCorrect = mainPage
                .clickLogInToYourAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnFromAccount()
                .clickLogoutBtn()
                .isLoginBtnDisplayed();
        assertTrue("Ошибка выхода из личного кабинета", isLogoutCorrect);
    }
}
