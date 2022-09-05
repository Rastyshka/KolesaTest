package Web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTest {

    @BeforeAll
    static void browserSetting() {

        Configuration.browserSize = "1920x1080";

    }

    @Test
    @Tag("KolesaMainPage")
    @DisplayName("Проверка поиска с заданными фильтрами")
    void searchWithFilters() {

        step("Открытие страницы сайта", () ->
                open("https://kolesa.kz/"));
        step("Выбор фильтра 'Тип машины'", () ->
                $("[data-id='2']").click());
        step("Выбор фильтра 'Город'", () ->
                $("[data-alias=almaty]").click());
        step("Выбор фильтра 'Марка'", () ->
                $("[data-alias=toyota]").click());
        step("Выбор фильтра 'Модель'", () ->
                $("[data-alias=camry]").click());
        step("Выбор фильтра 'Модель'", () ->
                $("[data-alias=camry]").click());
        step("Выбор фильтра 'Пробег'", () ->
                $("[title=Новая]").click());
        step("Выбор фильтра 'Фото'", () ->
                $(byTagAndText("label", "С фото")).click());
        step("Выбор фильтра 'Год выпуска'", () ->
                $("[id='year[to]']").setValue("2021"));
        step("Нажатие на подтверждение ", () ->
                $("[type=submit]").click());
        step("Проверка на непустой результат", () ->
                $("[class=a-list]").shouldNotBe(Condition.empty));

    }

}
