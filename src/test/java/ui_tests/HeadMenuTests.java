package ui_tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HeadMenuPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HeadMenuTests extends TestsBase {

    HeadMenuPage headMenuPage = new HeadMenuPage();

    @Test
    @DisplayName("Проверка логотипа")
    public void checkLogo(){
        headMenuPage
                .checkLogoVisibility()
                .checkLogoHref()
                .checkLogoSrc();
    }

    @Test
    @DisplayName("Проверка блока верхних ссылок")
    public void checkHeadLinks(){
headMenuPage
        .checkLinksHref(contentConfig.getHeadLinksHref())
        .checkLinksText(contentConfig.getHeadLinksText());

    }

}
