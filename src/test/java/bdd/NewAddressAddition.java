package bdd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewAddressAddition {
    @Given("user is on the CodersLab MyStore main paige")
    public void userIsOnTheCodersLabMyStoreMainPaige() {
    }

    @When("user clicks SignIn button")
    public void userClicksSignInButton() {
    }

    @And("fill {string} and {string} and click SingIn button on login page")
    public void fillEmailAndPasswordAndClickSingInButtonOnLoginPage() {
    }

    @Then("is logged successfully into account")
    public void isLoggedSuccessfullyIntoAccount() {
    }

    @When("logged user clicks AddFirstAddress button")
    public void loggedUserClicksAddFirstAddressButton() {
    }

    @And("fills user address data {string}, {string}, {string}, {string}, {string} and clisks Save button")
    public void fillsUserAddressDataAliasAddressZipPostalCodeCityCountryAndClisksSaveButton() {
    }

    @Then("new address is added to account with proper data")
    public void newAddressIsAddedToAccountWithProperData() {
    }
}
