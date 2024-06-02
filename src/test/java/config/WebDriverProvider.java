package config;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {
    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static AuthSelenoidConfig authSelenoidConfig = ConfigFactory.create(AuthSelenoidConfig.class, System.getProperties());
    public static String url;

    public static void config() {
        Configuration.browser = WebDriverProvider.webDriverConfig.getBrowser();
        Configuration.browserVersion = WebDriverProvider.webDriverConfig.getBrowserVersion();
        Configuration.browserSize = WebDriverProvider.webDriverConfig.getBrowserSize();
        Configuration.baseUrl = WebDriverProvider.webDriverConfig.getBaseUrl();
        Configuration.pageLoadStrategy = "eager";

        RestAssured.baseURI = WebDriverProvider.webDriverConfig.getBaseUri();

        url = WebDriverProvider.webDriverConfig.getRemoteUrl();
        if (url != null) {
            Configuration.remote = "https://"
                    + WebDriverProvider.authSelenoidConfig.getRemoteUsername() + ":"
                    + WebDriverProvider.authSelenoidConfig.getRemotePassword() + "@"
                    + url + "/wd/hub";
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options",
                Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
        Configuration.browserCapabilities = capabilities;



    }


}
