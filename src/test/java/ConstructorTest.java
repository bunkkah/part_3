import jdk.jfr.Description;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BrowserStarter {
    //Раздел «Конструктор»
    //Проверь, что работают переходы к разделам:
    //«Булки»,
    //«Соусы»,
    //«Начинки».

    @Test
    @Description("checkBuns")
    public void checkBuns() {
        // нажать кнопку Булки
        // проверить отображение заголовка после нажатия кнопки - булки
        final boolean isGetBunsCorrect = mainPage
                .isIngredientsCorrect("Булки");
        assertTrue("Ошибка отображения булок", isGetBunsCorrect);
    }

    @Test
    @Description("checkSauces")
    public void checkSauces() {
        // нажать кнопку Соусы
        // проверить отображение заголовка после нажатия кнопки - соусы
        final boolean isGetSaucesCorrect = mainPage
                .clickSaucesBtn()
                .isIngredientsCorrect("Соусы");
        assertTrue("Ошибка отображения соусов", isGetSaucesCorrect);
    }

    @Test
    @Description("checkFillings")
    public void checkFillings() {
        // нажать кнопку Начинки
        // проверить отображение заголовка после нажатия кнопки - начинки
        final boolean isGetFillingsCorrect = mainPage
                .clickFillingBtn()
                .isIngredientsCorrect("Начинки");
        assertTrue("Ошибка отображения начинок", isGetFillingsCorrect);
    }
}
