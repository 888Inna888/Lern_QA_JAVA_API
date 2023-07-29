package Ex5parsJSON;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Ex5parsJSON {
    @Test
    public void testRestAssured(){

        RestAssured.registerParser("text/html", Parser.JSON);
        RestAssured.defaultParser = Parser.JSON;

        Response response =
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get("https://playground.learnqa.ru/api/get_json_homework").
                        then().extract().response();

        List<Map<String, String>> jsonResponse = response.jsonPath().getList("messages");
        System.out.println(jsonResponse.get(1).get("message"));

    }
}
