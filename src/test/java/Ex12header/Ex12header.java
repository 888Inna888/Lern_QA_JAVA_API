package Ex12header;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

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

        Headers headers = responseHeaders.getHeaders();
        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"), "Response doesn't have 'x-secret-homework-header' Header");

    }
}
