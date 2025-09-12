package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By USERNAME = By.name("username");
    private static final By PASSWORD = By.name("password");
    private static final By LOGIN_BTN = By.cssSelector("button[type='submit']");
    private static final By LOGIN_FORM = By.cssSelector("div.orangehrm-login-form"); // page guard
    private static final By DASHBOARD_H6 = By.xpath("//h6[text()='Dashboard']");
    private static final By ERROR_TOAST = By.cssSelector(".oxd-alert-content-text");

    public LoginPage() {
        super(LOGIN_FORM, "Login Page");
    }

    @Step("Enter username")
    public LoginPage enterUsername(String username) {
        type(USERNAME, "Username", username);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        type(PASSWORD, "Password", password);
        return this;
    }

    @Step("Submit login form")
    public void submit() {
        click(LOGIN_BTN, "Login");
    }

    @Step("Login as user")
    public void loginAs(String username, String password) {
        enterUsername(username).enterPassword(password).submit();
    }

    @Step("Check Dashboard visible")
    public boolean isLoggedIn() {
        return label(DASHBOARD_H6, "Dashboard").state().waitForDisplayed();
    }

    @Step("Read login error")
    public String getErrorMessage() {
        return label(ERROR_TOAST, "Error toast").getText();
    }
}

