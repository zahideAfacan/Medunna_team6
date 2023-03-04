package stepdefinitions.api_stepdef;
import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationMedunna.generateToken;

import pojos.Registration;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class Registration_Api {

    Response response;
    Response responseGet;

    Registration registration = new Registration();

    Faker faker = new Faker();
    String ssn = faker.regexify("[1-8]{3}-[2-9]{2}-[1-9]{4}");


    @Given("user sends post request for registration")
    public void user_sends_post_request_for_registration() {
        spec.pathParams("first", "api", "second", "register");

        System.out.println("ssn = " + ssn);
        registration.setSsn(ssn);


        registration.setFirstName(faker.name().firstName());
        registration.setLastName(faker.name().lastName());
        registration.setLogin(faker.name().username());
        registration.setEmail(faker.internet().emailAddress());
        registration.setPassword(faker.internet().password());
        registration.setCreatedBy("Team06");

        response = given().
                headers("Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                spec(spec).
                contentType(ContentType.JSON).
                body(registration).
                post("/{first}/{second}");
        response.prettyPrint();

    }
    @Then("user gets registrant info and validates it")
    public void user_gets_registrant_info_and_validates_it() {
        assertEquals(201, response.getStatusCode());

        Registration actualDataPojo = response.as(Registration.class);
        System.out.println("actualDataPojo = " + actualDataPojo);

        assertEquals(registration.getSsn(), actualDataPojo.getSsn());
        assertEquals(registration.getFirstName(), actualDataPojo.getFirstName());
        assertEquals(registration.getLastName(), actualDataPojo.getLastName());
        assertEquals(registration.getLogin(), actualDataPojo.getLogin());
        assertEquals(registration.getEmail(), actualDataPojo.getEmail());
 //       assertEquals(registration.getPassword(), actualDataPojo.getPassword());
 //       assertEquals(registration.getCreatedBy(), actualDataPojo.getCreatedBy());

    }

    @Then("user sends get request for validation with SSN")
    public void userSendsGetRequestForValidationWithSSN() {

    //    spec.pathParams("first", "api", "second", "users");
        spec.pathParams("first", "api", "second", "user").queryParams("ssn", ssn);

       responseGet = given().spec(spec).contentType(ContentType.JSON).headers("Authorization","Bearer " +generateToken()).when().get("/{first}/{second}");
       responseGet.prettyPrint();

      assertEquals(200, responseGet.statusCode());
    }

    @Then("validate that username is unique")
    public void validate_that_username_is_unique() {

       assertEquals(201, response.getStatusCode());
       boolean isUnique = response.getBody().as(Boolean.class);
       Assert.assertTrue(isUnique);



    }



}

/*
// Add basic auth header with a chrome extension on every request
File authExtension = new SeleniumChromeAuthExtensionBuilder()
    .withBasicAuth("Ali Baba", "Open sesame")
    .withBaseUrl("https://example.org/*")
    .build();
 */

/*
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiTest {
   public static void main(String[] args) throws IOException {
      // Set SSN parameter
      String ssn = "123-45-6789";
      // Set API endpoint URL
      String apiUrl = "https://example.com/api/user?ssn=" + ssn;
      // Create URL object
      URL url = new URL(apiUrl);
      // Create HTTP connection
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      // Set request method
      conn.setRequestMethod("GET");
      // Get response code
      int responseCode = conn.getResponseCode();
      // If response code is successful (200-299), read response data
      if (responseCode >= 200 && responseCode <= 299) {
         // Create scanner to read response stream
         Scanner scanner = new Scanner(conn.getInputStream());
         // Read response data line by line
         while (scanner.hasNextLine()) {
            String responseData = scanner.nextLine();
            // Do something with the response data
            System.out.println(responseData);
         }
         scanner.close();
      }
      // If response code is unsuccessful, print error message
      else {
         System.out.println("Error: Response code " + responseCode);
      }
      // Disconnect HTTP connection
      conn.disconnect();
   }
}
This code sets the SSN parameter as a string variable, appends it to the API endpoint URL, creates a URL object, and opens an HTTP connection using HttpURLConnection. The code sets the request method to "GET" and gets the response code. If the response code is successful (between 200 and 299), the code creates a scanner to read the response stream and reads the response data line by line. If the response code is unsuccessful, the code prints an error message. Finally, the code disconnects the HTTP connection.

You can customize this code to suit your specific API endpoint and SSN parameter values.





 */