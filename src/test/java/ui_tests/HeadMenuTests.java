package ui_tests;

import org.junit.jupiter.api.Test;
import pages.HeadMenuPage;

public class HeadMenuTests extends TestsBase {

    HeadMenuPage headMenuPage = new HeadMenuPage();

    @Test
    public void checkTabsContent() {
        headMenuPage
                .containsText(contentConfig.getHeadMenuTabs())
                .checkBackGround();
    }

    @Test
    public void checkDropMenu() {
        headMenuPage
                .checkAppearance()
                .checkDropMenuContent();

    }
}
