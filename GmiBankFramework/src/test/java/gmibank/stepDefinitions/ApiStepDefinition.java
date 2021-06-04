package gmibank.stepDefinitions;

import gmibank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiStepDefinition {
    Response response;

    @Given("user go to api endpoint {string}")
    public void user_go_to_api_end_point(String api_endpoint){
                response =given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(api_endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();


    }

    @Given("read all customers and set response")
    public void read_all_customers_and_set_response(){

        response.prettyPrint();
    }
}
