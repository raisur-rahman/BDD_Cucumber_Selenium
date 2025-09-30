package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CityWeatherPage;

import static io.qameta.allure.Allure.step;

public class CityWeatherPageSteps {
    CityWeatherPage cityWeatherPage = new CityWeatherPage();

    @Then("the city weather page header contains city name {string}")
    public void theCityWeatherPageHeaderContainsCityName(String cityName) {
        step("Check that city weather page header contains city name: " + cityName);
        String header = cityWeatherPage.getCityName();
        Assert.assertTrue(header.contains(cityName), "City name is not present in the header");
    }

    @When("I go back to the main page")
    public void iGoBackToTheMainPage() {
        step("Go back to the main page");
        cityWeatherPage.backToLandingPage();
    }
}
