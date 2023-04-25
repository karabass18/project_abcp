package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HeadPage {

    private final String BACK_GROUND_OUT_OF_FOCUS = "rgba(0, 0, 0, 0)";
    private final String BACK_GROUND_IN_FOCUS = "rgba(0, 93, 150, 1)";

    public HeadPage checkLogoVisibility() {
        $(".head .logo").shouldBe(visible);
        return this;
    }

    public HeadPage checkLogoHref() {
        $(".head .logo").$("a").shouldHave(attribute("href", "https://abcp.ru/"));
        return this;
    }

    public HeadPage checkLogoSrc() {
        $(".head .logo").$("img").shouldHave(attributeMatching("src", ".*//f.nodacdn.net/268621"));
        return this;
    }

    public HeadPage checkLinksHref(String[] value) {
        for (int i = 0; i < value.length; i++) {
            $(".headLinks").$("a", i).shouldHave(attribute("href", value[i]));
        }
        return this;
    }

    public HeadPage checkLinksText(String[] value) {
        for (int i = 0; i < value.length; i++) {
            $(".headLinks").$("a", i).shouldHave(text(value[i]));
        }
        return this;
    }

    public HeadPage checkButtonVisibility(){
        $(".fr-hidden-xs").shouldBe(visible);
        return this;
    }

    public HeadPage checkBackgroundColor(){
        assertThat($(".fr-hidden-xs").getCssValue("background-color")).isEqualTo(BACK_GROUND_OUT_OF_FOCUS);
        $(".fr-hidden-xs").hover();
        sleep(100);
        assertThat($(".fr-hidden-xs").getCssValue("background-color")).isEqualTo(BACK_GROUND_IN_FOCUS);
        return this;
    }

    public HeadPage checkButtonLink(){
        $(".fr-hidden-xs").shouldHave(attribute("href", "https://cp.abcp.ru/"));
        return this;
    }
}
