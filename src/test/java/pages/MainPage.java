package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class MainPage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final IButton btnCurrentLocation = elementFactory.getButton(
            By.cssSelector("button[data-testid='gps-search-btn']"), "Current Location");

    private final ITextBox txtSearch = elementFactory.getTextBox(
            By.cssSelector("input.search-input"), "Search Input");

    private final IButton firstSuggestion = elementFactory.getButton(
            By.cssSelector(".results-container button"), "First Suggestion");

    private final IButton firstRecentLocation = elementFactory.getButton(
            By.cssSelector(".featured-locations__locations a"), "First Recent Location");

    private final List<IButton> elements = elementFactory.findElements(
            By.cssSelector(".results-container button"), ElementType.BUTTON);

    private final List<IButton> recentLocations = elementFactory.findElements(
            By.cssSelector(".featured-locations__locations a"), ElementType.BUTTON);

    public MainPage() {
        super(By.cssSelector("div.main-page"), "Main Page");
    }

    public void openMainPage() {
        this.state().waitForDisplayed();
    }

    public void clickSearchButton() {
        txtSearch.click();
    }

    public void searchCity(String cityName) {
        txtSearch.clearAndType(cityName);
    }

    public boolean isSuggestionsDisplayed() {
        return elements.stream().anyMatch(button -> button.state().isDisplayed());
    }

    public void clickFirstSuggestion() {
        firstSuggestion.click();
    }

    public void backToLandingPage() {
        AqualityServices.getBrowser().goBack();
    }

    public boolean isRecentLocationsDisplayed() {
        return recentLocations.stream().anyMatch(button -> button.state().isDisplayed());
    }

    public void clickFirstRecentLocation() {
        firstRecentLocation.click();
    }

    public boolean isCurrentLocationButtonDisplayed() {
        return btnCurrentLocation.state().isDisplayed();
    }

    public void clickCurrentLocation() {
        btnCurrentLocation.click();
    }
}
