package ui_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HeadOfTheSitePage;

public class HeadOfTheSiteTests extends TestsBase {

    HeadOfTheSitePage headOfTheSitePage = new HeadOfTheSitePage();

    @DisplayName("Провека верхнего видео")
    @Test
    public void checkStartingVideo() {
        headOfTheSitePage
                .checkHeadVideoVisible()
                .checkHeadVideoFileName();

    }

    @DisplayName("Проверка 1 из 3 карточки ")
    @Test
    public void checkTheFirstCard() {
        headOfTheSitePage
                .checkFirstCardVisible()
                .checkFirstCardHover()
                .checkFirstCardClick();

    }

    @DisplayName("Проверка верхнего меню")
    @Test
    public void checkHeadMenu() {
        headOfTheSitePage
                .checkHeadMenuVisible()
                .checkLogo()
                .checkTextOfTheNavigationLinks()
                .checkThePhoneNumbers();
    }
}
