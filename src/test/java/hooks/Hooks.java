package hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.SettingsTestData;

import java.io.ByteArrayInputStream;

public class Hooks {
    private Browser browser = AqualityServices.getBrowser();

    @Before
    public void setup() {
        browser.maximize();
        browser.goTo(SettingsTestData.getEnvData().getHost());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) browser.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshot));
        }
        if (browser != null) {
            browser.quit();
        }
    }
}
