package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.*;

public class MedunnaBaseUrl {

    public static RequestSpecification spec;

    public static void medunnaSetUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://www.medunna.com/").build();

    }
}
