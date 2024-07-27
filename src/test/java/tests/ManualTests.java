package tests;

import extensions.Manual;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Manual tests: future automation")
@Feature("Manual verification")
public class ManualTests {
    @Test
    @Manual
    @DisplayName("Checking if a new tab opens")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingOpenedNewTabTest() {
        step("Open demoqa.com");
        step("Click on the \"Alerts, Frame & Windows\" button");
        step("Click on the \"Browser Windows\" button");
        step("Click on the \"New Tab\" button");
        step("Сheck that a new browser tab has opened");
    }

    @Test
    @Manual
    @DisplayName("Checking if a new window opens")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingOpenedNewWindowTest() {
        step("Open demoqa.com");
        step("Click on the \"Alerts, Frame & Windows\" button");
        step("Click on the \"Browser Windows\" button");
        step("Click on the \"New Window\" button");
        step("Сheck that a new browser window has opened");
    }

    @Test
    @Manual
    @DisplayName("Checking if a new tab opens")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingOpenedNewWindowMessageTest() {
        step("Open demoqa.com");
        step("Click on the \"Alerts, Frame & Windows\" button");
        step("Click on the \"Browser Windows\" button");
        step("Click on the \"New Window Message\" button");
        step("Сheck that a new browser window message has opened");
    }
}
