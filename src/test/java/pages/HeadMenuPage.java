package pages;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HeadMenuPage {

    private final String BACK_GROUND_OUT_OF_FOCUS = "rgba(0, 0, 0, 0)";
    private final String BACK_GROUND_IN_FOCUS = "rgba(0, 61, 99, 1)";


    public HeadMenuPage containsText(String[] value){
        for (int i = 0; i < value.length; i++) {
            $(".mainMenu").$("li", i).shouldHave(text(value[i]));
        }
        return this;
    }

    public HeadMenuPage checkBackGround(){
        assertThat($(".mainMenu a").getCssValue("background-color")).isEqualTo(BACK_GROUND_OUT_OF_FOCUS);
        $(".mainMenu a").hover();
        sleep(100);
        assertThat($(".mainMenu a").getCssValue("background-color")).isEqualTo(BACK_GROUND_IN_FOCUS);

        return this;
    }

    public HeadMenuPage checkAppearance(){
        $(".head .logo").hover();
        $(".mainNav__submenu").shouldBe(hidden);

        return this;
    }
}
