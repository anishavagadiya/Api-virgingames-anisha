package com.virgingames.steps;

import com.virgingames.constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class BingoLobbySteps {
@Step
    public ValidatableResponse getBingoLobbyFeed(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_FIELD)
                .then();

    }

    @Step("Getting Stream name from streams at index 1")
    public HashMap<String, Object> getStreamNameFromStreams(String streamName) {
        String p1 = "bingoLobbyInfoResource.streams.findAll{it.streamName == '";
        String p2 = "'}.get(0)";

        RestAssured.registerParser("text/plain", Parser.JSON);

        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_FIELD)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + streamName + p2);

    }

    }
