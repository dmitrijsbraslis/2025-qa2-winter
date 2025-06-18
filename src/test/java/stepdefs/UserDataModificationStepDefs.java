package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.User;
import org.junit.jupiter.api.Assertions;

public class UserDataModificationStepDefs {
    private User user = new User();
    private String expectedLastName;

    @Given("user first name: {string}")
    public void set_first_name(String firstName) {
        user.setFirstName(firstName);
    }

    @Given("user last name: {string}")
    public void set_last_name(String lastName) {
        user.setLastName(lastName);
        expectedLastName = lastName;
    }

    @Given("user e-mail: {string}")
    public void set_email(String email) {
        user.setEmail(email);
    }

    @When("we are changing first name to {string}")
    public void change_first_name(String newFirstName) {
        user.setFirstName(newFirstName);
    }

    @Then("first name is: {string}")
    public void check_first_name(String firstNameToCheck) {
        Assertions.assertEquals(firstNameToCheck, user.getFirstName(), "Wrong First Name!");
    }

    @Then("last name is not changed")
    public void check_last_name_not_changed() {
        Assertions.assertEquals(expectedLastName, user.getLastName(), "Last name changed!");
    }
}
