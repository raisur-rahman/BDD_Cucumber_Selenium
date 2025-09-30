package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class CityWeatherPage extends Form {
    private final ILabel lblCityHeader;

    public CityWeatherPage() {
        super(By.cssSelector("div.city-weather-page"), "City Weather Page");
        lblCityHeader = getElementFactory().getLabel(By.cssSelector(".header-loc"), "City Header");
    }

    public void backToLandingPage() {
        getBrowser().goBack();
    }

    public String getCityName() {
        return lblCityHeader.getText();
    }
}
