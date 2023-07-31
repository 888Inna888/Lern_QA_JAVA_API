package Ex11cookie;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex11cookie {


    @Test
    public void testCookie(){

        Response responseCookie = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_cookie");

        System.out.println("\nHeaders:");
        Headers responseHeader = responseCookie.getHeaders();
        System.out.println(responseHeader);

        System.out.println("\nCookies:");
        Map<String, String> responseCookies = responseCookie.getCookies();
        System.out.println(responseCookies);

        Map<String, String> cookies = responseCookie.getCookies();
        Headers headers = responseCookie.getHeaders();

        assertTrue(headers.hasHeaderWithName("Set-Cookie"), "Response doesn't have 'Set-Cookie' Header");
        assertTrue(cookies.containsKey("HomeWork"), "Response doesn't have 'HomeWork' cookie");
        assertTrue(cookies.containsValue("hw_value"), "The HomeWork is not hw_value");


    }
}
