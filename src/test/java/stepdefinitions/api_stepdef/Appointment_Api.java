package stepdefinitions.api_stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Appointment;
import pojos.Registration;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationMedunna.*;

public class Appointment_Api {

    Response response;
    Response responseGet;

    Appointment appointment = new Appointment();

    String id;

    @Given("user goes to appointment page")
    public void user_goes_to_appointment_page() {

       spec.pathParams("first", "api", "second", "appointments", "third", "request"); //https://medunna.com/api/appointments/request

    }
    @Then("user sends post request for appointment")
    public void user_sends_post_request_for_appointment() {


        appointment.setStatus("UNAPPROVED");
        appointment.setStartDate("2023-03-02");
        appointment.setEndDate("2023-03-04");
        appointment.setPhone("5557771144");
        appointment.setEmail("aaa@gmail.com");
        appointment.setFirstname("Hasta");
        appointment.setLastname("Iyi");
        appointment.setSsn("123-45-9876");
        appointment.setGender("male");


        response = given().
                headers("Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                spec(spec).
                contentType(ContentType.JSON).
                body(appointment).
                post("/{first}/{second}/{third}");
        response.prettyPrint();

        assertEquals(201, response.getStatusCode());

        id = response.jsonPath().getString("id");
        System.out.println("response.jsonPath().getString(\"id\") = " + response.jsonPath().getString("id"));


    }
    @Then("user gets appointment info and validates it")
    public void user_gets_appointment_info_and_validates_it() {


        spec.pathParams("first", "api", "second", "appointments", "third", id ); //https://medunna.com/api/appointments/13026




        responseGet = given().spec(spec).contentType(ContentType.JSON).headers("Authorization","Bearer " +generateStaffToken()).when().get("/{first}/{second}/{third}");
        responseGet.prettyPrint();

        assertEquals(200, responseGet.statusCode());
    }

}

