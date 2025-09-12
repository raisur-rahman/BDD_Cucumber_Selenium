package tests;

import pages.*;
import base.*;
import core.*;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(description = "Valid login should open Dashboard")
    public void login_with_valid_credentials() {
        LoginPage login = new LoginPage();
        Assert.assertTrue(login.isOpen(), "Login page should be open");

        login.loginAs(Config.CREDS.username, Config.CREDS.password);
        Assert.assertTrue(login.isLoggedIn(), "Dashboard should be visible after login");
    }

    @Test(description = "Invalid login should show error")
    public void login_with_invalid_credentials() {
        LoginPage login = new LoginPage();
        Assert.assertTrue(login.isOpen(), "Login page should be open");

        login.loginAs("wrongUser", "wrongPass");
        String error = login.getErrorMessage();
        stepNote("Error text", error);
        Assert.assertTrue(error != null && !error.isEmpty(), "Error message should appear");
    }

    @Step("Note: {name} -> {value}")
    private void stepNote(String name, String value) {}
}
