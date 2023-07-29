package Ex7Lredirect;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class Ex7Lredirect {
    @Test
    public void testRestAssured(){

        Response response = RestAssured
                .given()
                .redirects()
                .follow (true)
                .when()
                .get ("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

    }
}
