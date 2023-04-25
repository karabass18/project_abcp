package pages;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HeadMenuPage {
    public HeadMenuPage checkLogoVisibility() {
        $(".head .logo").shouldBe(visible);
        return this;
    }

    public HeadMenuPage checkLogoHref() {
        $(".head .logo").$("a").shouldHave(attribute("href", "https://abcp.ru/"));
        return this;
    }

    public HeadMenuPage checkLogoSrc() {
        $(".head .logo").$("img").shouldHave(attributeMatching("src", ".*//f.nodacdn.net/268621"));
        return this;
    }

    public HeadMenuPage checkLinksHref(String[] value) {
        for (int i = 0; i < value.length; i++) {
            $(".headLinks").$("a", i).shouldHave(attribute("href", Configuration.baseUrl + value[i]));
        }
        return this;
    }

    public HeadMenuPage checkLinksText(String[] value) {
        for (int i = 0; i < value.length; i++) {
            $(".headLinks").$("a", i).shouldHave(text(value[i]));
        }
        return this;
    }
}
