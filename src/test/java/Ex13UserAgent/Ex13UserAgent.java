package Ex13UserAgent;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Ex13UserAgent {
    @Test
    public void testRestAssured() {
        Response responseForGet = RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .andReturn();
        responseForGet.print();

        JsonPath responsePath = RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .jsonPath();

        String user_agent = responsePath.getString("user_agent");
        String platform = responsePath.getString("platform");
        String browser = responsePath.getString("browser");
        String device = responsePath.getString("device");


        System.out.println("UserAgent: " + user_agent);
        System.out.println("platform: " + platform);
        System.out.println("browser: " + browser);
        System.out.println("device: " + device);
    }

}
