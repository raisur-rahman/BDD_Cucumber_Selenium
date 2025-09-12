package base;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public abstract class BasePage extends Form {

    protected BasePage(By uniqueLocator, String name) {
        super(uniqueLocator, name);
    }

    protected ITextBox textBox(By locator, String name) {
        return AqualityServices.getElementFactory().getTextBox(locator, name);
    }

    protected IButton button(By locator, String name) {
        return AqualityServices.getElementFactory().getButton(locator, name);
    }

    protected ILabel label(By locator, String name) {
        return AqualityServices.getElementFactory().getLabel(locator, name);
    }

    @Step("Wait for page to be open")
    public boolean isOpen() {
        return state().waitForDisplayed();
    }

    @Step("Type into '{fieldName}'")
    protected void type(By locator, String fieldName, String value) {
        textBox(locator, fieldName).clearAndType(value);
    }

    @Step("Click '{buttonName}'")
    protected void click(By locator, String buttonName) {
        button(locator, buttonName).click();
    }
}
