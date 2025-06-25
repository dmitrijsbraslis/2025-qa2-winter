package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.weather.WeatherResponse;
import requesters.WeatherRequester;

import java.util.Map;

import static java.lang.Double.*;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private double lat;
    private double lon;
    private WeatherResponse response;

    @Given("location coordinates:")
    public void set_coordinates(Map<String, Double> params) {
        lat = params.get("latitude"); //-> 52.52
        lon = params.get("longitude"); //-> 13.419998
    }

    @When("we are requesting weather data")
    public void request_weather_data() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(lat, lon);
    }

    @Then("main information is:")
    public void check_main_info(Map<String, String> params) {
        assertEquals(parseDouble(params.get("latitude")), response.getLatitude(), "Wrong latitude!");
        assertEquals(parseDouble(params.get("longitude")), response.getLongitude(), "Wrong longitude!");
        //.....
        assertEquals(params.get("timezone"), response.getTimezone(), "Wrong timezone!");
    }

    @Then("current units are:")
    public void check_current_units(Map<String, String> params) {
        assertEquals(params.get("time"), response.getCurrentUnits().getTime(), "Wrong time!");
        //...
        assertEquals(params.get("is_day"), response.getCurrentUnits().getIsDay(), "Wrong" +
                "is_day parameter");
    }
}
