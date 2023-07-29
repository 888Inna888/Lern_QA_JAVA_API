package Ex6redirect;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
public class Ex6redirect {
    @Test
    public void testRestAssured(){
        Map<String, String> headers = new HashMap<>();


        Response response = RestAssured
                .given()
                .redirects()
                .follow (false)
                .when()
                .get ("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        response.print();

        String locationHeader = response.getHeader("Location");
        System.out.println(locationHeader);
    }
}
