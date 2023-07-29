package Ex10text;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Ex10text {
    @ParameterizedTest
    @ValueSource(strings = {"text1", "test15_89012345", "text123456789101112fghghfg"})
    public void testText(String name){
        Map<String, String> queryParams = new HashMap<>();

        if (name.length() < 16){
            queryParams.put("name", name);
        }

        JsonPath response = RestAssured
                .given()
                .queryParams(queryParams)
                .get ("https://playground.learnqa.ru/ajax/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        String expectedName = (name.length() < 16) ? name : "someone";
        assertEquals ("Hello, someone", answer, "The answer is not expected");


    }
}
