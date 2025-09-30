package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @Then("The main page is opened")
    public void iOpenTheMainPage() {
        step("Open the main page");
        mainPage.openMainPage();
    }

    @When("I click on search field")
    public void iClickOnSearchField() {
        step("Click on search field");
        mainPage.clickSearchButton();
    }

    @When("I input {string} in the search field")
    public void iInputInTheSearchField(String cityName) {
        step("Input city name in the search field: " + cityName);
        mainPage.searchCity(cityName);
    }

    @Then("the search results list is displayed")
    public void theSearchResultsListIsDisplayed() {
        step("Check that search results list is displayed");
        Assert.assertTrue(mainPage.isSuggestionsDisplayed(), "Search results list is not displayed");
    }

    @When("I click on the first search result")
    public void iClickOnTheFirstSearchResult() {
        step("Click on the first search result");
        mainPage.clickFirstSuggestion();
    }

    @Then("the recent location result is displayed")
    public void theRecentLocationResultIsDisplayed() {
        step("Check that recent location result is displayed");
        Assert.assertTrue(mainPage.isRecentLocationsDisplayed(), "Recent location result is not displayed");
    }

    @And("I click on the first result in the recent location result")
    public void iClickOnTheFirstResultInTheRecentLocationResult() {
        step("Click on the first result in the recent location result");
        mainPage.clickFirstRecentLocation();
    }

    @Then("the Use your current location label is displayed")
    public void theUseYourCurrentLocationLabelIsDisplayed() {
        step("Check that Use your current location label is displayed");
        Assert.assertTrue(mainPage.isCurrentLocationButtonDisplayed(),
                "Use your current location label is not displayed");
    }

    @And("I click on current location button")
    public void iClickOnCurrentLocationButton() {
        step("Click on current location button");
        mainPage.clickCurrentLocation();
    }
}
