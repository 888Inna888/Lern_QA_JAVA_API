package Ex8token;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class Ex8token {
    @Test
    public void testRestAssured() {

        Response responseForGet = RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();
        responseForGet.print();


        JsonPath responsePath = RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String token = responsePath.getString("token");
        int time = Integer.valueOf(responsePath.getString("seconds")) * 1000;

        System.out.println("response_token: " + token);
        System.out.println("response_seconds: " + time / 1000);


        JsonPath response_job_error = RestAssured
                .given()
                .queryParam("token", token)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        System.out.println("Status before task: " + response_job_error.getString("status"));

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JsonPath response_job_comleted = RestAssured
                .given()
                .queryParam("token", token)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        System.out.println("Status before task: " + response_job_comleted.getString("status"));
        System.out.println("Result: " + response_job_comleted.getString("result"));
    }
}
