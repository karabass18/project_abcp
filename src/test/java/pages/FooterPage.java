package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FooterPage {

    public FooterPage checkFooterVisible() {
        step("Проверка видимости футера", () -> {
            $(".footer").scrollIntoView(true);
            $(".footer").shouldBe(Condition.visible);
        });
        return this;
    }

    public FooterPage checkPrivatePolicy() {
        step("Проверка PrivatePolicy", () -> {
            $(".private-policy a").click();
            assertThat(WebDriverRunner.url()).contains("https://main.liis.su/policy");
            Selenide.back();
        });
        return this;
    }
    public FooterPage checkVK() {
        step("Проверка ссылки VK", () -> {
            $(".social", 0)
                    .shouldHave(Condition.attributeMatching("href","https://vk.com/liistechnology"));
            $(".social", 0).$("img")
                    .shouldHave(Condition.attributeMatching("src",".*img/vk.svg"));

        });
        return this;
    }

    public FooterPage checkYouTube() {
        step("Проверка ссылки YouTube", () -> {
            $(".social", 1)
                    .shouldHave(Condition.attributeMatching("href",
                            "https://www.youtube.com/c/%D0%9B%D0%98%D0%98%D0%A1%D0%A2%D0%B5%D1%85%D0%BD%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D0%B8"));
            $(".social", 1).$("img")
                    .shouldHave(Condition.attributeMatching("src",".*img/youtube.svg"));

        });
        return this;
    }
}
