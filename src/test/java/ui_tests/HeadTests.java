package ui_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HeadPage;

public class HeadTests extends TestsBase {

    HeadPage headPage = new HeadPage();


    @Test
    @DisplayName("Проверка логотипа")
    public void checkLogo() {
        headPage
                .checkLogoVisibility()
                .checkLogoHref()
                .checkLogoSrc();
    }

    @Test
    @DisplayName("Проверка блока верхних ссылок")
    public void checkHeadLinks() {
        headPage
                .checkLinksHref(contentConfig.getHeadLinksHref())
                .checkLinksText(contentConfig.getHeadLinksText());

    }

    @Test
    @DisplayName("Проверка кнопки \"ВОЙТИ\"")
    public void checkLogInButton() {
        headPage
                .checkButtonVisibility()
                .checkBackgroundColor()
                .checkButtonLink();

    }
}
