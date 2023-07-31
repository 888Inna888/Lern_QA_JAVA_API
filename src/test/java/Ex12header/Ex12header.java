package Ex12header;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex12header {
    @Test
    public void testHeader(){

        Response responseHeaders = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_header");

        System.out.println("\nHeaders:");
        Headers responseHeader = responseHeaders.getHeaders();
        System.out.println(responseHeader);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://playground.learnqa.ru/api/homework_header");

        String header = response.getHeaders().getValue("x-secret-homework-header");
        assertTrue(header.equals("Some secret value"), "Response doesn't have Some secret value");

            }
}
