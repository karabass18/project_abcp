package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:menuContent.properties"})

public interface ContentConfig extends Config {

    @Key("headLinksHref")
    String[] getHeadLinksHref();

    @Key("headLinksText")
    String[] getHeadLinksText();

    @Key("headMenuTabs")
    String[] getHeadMenuTabs();

}
