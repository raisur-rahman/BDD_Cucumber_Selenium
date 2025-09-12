package base;

import core.*;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected Browser browser;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        // Aquality reads settings.json from test resources (on classpath)
        browser = AqualityServices.getBrowser();
        browser.maximize();
    }

    @BeforeMethod(alwaysRun = true)
    public void openBaseUrl() {
        browser.goTo(Config.ENV.baseUrl);
        browser.waitForPageToLoad();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (browser != null && browser.isStarted()) {
            browser.quit();
        }
    }
}
