package config;

import org.aeonbits.owner.Config;


@Config.Sources({"classpath:${environment}.properties"})

public interface WebDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browser_version")
    @DefaultValue("122.0")
    String getBrowserVersion();

    @Key("browser_size")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("baseURI")
    @DefaultValue("https://demoqa.com")
    String getBaseUri();

    @Key("remote_url")
    String getRemoteUrl();
}




