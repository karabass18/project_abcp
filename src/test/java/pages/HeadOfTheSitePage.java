package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HeadOfTheSitePage {
    public HeadOfTheSitePage checkHeadVideoVisible() {
        step("Проверка видимости банера", () -> {
            $("body").scrollIntoView("{block: \"start\"}");
            $("#video-bg").hover();
            $("#video-bg").shouldBe(Condition.visible);
        });
        return this;
    }

    public HeadOfTheSitePage checkHeadVideoFileName() {
        step("Проверка источника видео", () -> {
            $("#video-bg").$("[type='video/mp4']")
                    .shouldHave(attributeMatching("src", ".*video/bg.mp4"));
        });
        return this;
    }

    public HeadOfTheSitePage checkFirstCardVisible() {
        step("Проверка видимости первой карточки", () -> {
            $("#simplehome").scrollIntoView(true);
            $("#simplehome").shouldBe(Condition.visible);
        });
        return this;
    }

    public HeadOfTheSitePage checkFirstCardHover() {
        step("Проверка действия если навести курсор на карточку", () -> {
            $("#simplehome").shouldHave(attribute("class", "card card-noactive1"));
            $("#simplehome").hover();
            $("#simplehome").shouldNotHave(attribute("class", "card-noactive1"));
        });
        return this;
    }

    public HeadOfTheSitePage checkFirstCardClick() {
        step("Проверка URL страницы после клика на карточку", () -> {
            $("#simplehome").click();
            assertThat(WebDriverRunner.url()).contains("https://simplehome.liis.su");
            Selenide.back();
        });
        return this;
    }

    public HeadOfTheSitePage checkHeadMenuVisible() {
        step("Проверка появления верхнего меню", () -> {
            $("#video-bg").scrollIntoView(true);
            $(".logo").shouldBe(hidden);
            $(".maps-img").scrollIntoView(true);
            $(".logo").shouldBe(visible);
        });
        return this;
    }

    public HeadOfTheSitePage checkLogo() {
        step("Проверка logo", () -> {
            $(".logo img").shouldHave(attributeMatching("src", ".*img/logo.svg"));
        });
        return this;
    }

    public HeadOfTheSitePage checkTextOfTheNavigationLinks() {
        step("Проверка текста в элементах навигации", () -> {
            $(".nav").shouldHave(text("Simple Home"), text("Simple Office"), text("Simple Media"));
        });
        return this;
    }

    public HeadOfTheSitePage checkThePhoneNumbers() {
        step("Проверка телефонов", () -> {
            $(".phone").shouldHave(text("Спб: +7 (812) 241 12 73"), text("Мск: +7 (495) 278 07 20"));
        });
        return this;
    }

}
