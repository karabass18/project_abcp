package ui_tests;

import org.junit.jupiter.api.Test;
import pages.FooterPage;

public class FooterTests extends TestsBase {

    FooterPage footerPage = new FooterPage();

    @Test
    public void checkTheFooter(){
        footerPage
                .checkFooterVisible()
                .checkPrivatePolicy()
                .checkVK()
                .checkYouTube();
    }

}
