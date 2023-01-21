package com.virgingames.cucumber.steps;

import com.virgingames.steps.BingoLobbySteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {
    static ValidatableResponse response;
    @Steps
    BingoLobbySteps bingoLobbySteps;


    @Given("^I am on the Virgin games bingo api$")
    public void iAmOnTheVirginGamesBingoApi() {
    }

    @When("^I send Get request to the Lobby feed endpoint$")
    public void iSendGetRequestToTheLobbyFeedEndpoint() {
        response = bingoLobbySteps.getBingoLobbyFeed();

    }


    @Then("^I get valid status code 200$")
    public void iGetValidStatusCode() {
        response.statusCode(200);
    }


    @And("^I verify that the stream name is \"([^\"]*)\" at streams index 1$")
    public void iVerifyThatTheStreamNameIsAtStreamsIndex(String streamName) {
        HashMap<String, Object> streamMap = bingoLobbySteps.getStreamNameFromStreams(streamName);
        Assert.assertThat(streamMap, hasValue(streamName));

    }
}
