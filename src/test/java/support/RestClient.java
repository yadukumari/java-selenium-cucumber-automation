package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

public class RestClient {

    public static final String BASE_URI = "https://skryabin.com/recruit/api/v1/";
    private final String CONTENT_TYPE = "Content-type";
    private final String JSON = "application/json";
    private final String ACCEPT = "Accept";

    public Map<String, Object> getPositionId(String title, int positionId) {
        System.out.println("\nRequest:\n-----------------------");

        RequestSpecification request = RestAssured
                .given()
                .baseUri(BASE_URI)
                .header(ACCEPT,JSON)
                .log().all();
        Response response = request
                .when()
                .get("/positions/" + positionId);
        System.out.println("\nResponse:\n--------------------------");
        Map<String, Object> position = response.then().statusCode(200).extract().jsonPath().getMap("");
        //assertThat(map.get("title")).isEqualTo(title);
        System.out.println(position);

        return position;
    }



    public int postPosition(Map<String,String> position) {
        System.out.println("\nRequest:\n-----------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri(BASE_URI)
                .header(CONTENT_TYPE,JSON)
                .auth().preemptive().basic("student@example.com", "welcome")
                .body(position)
                .log().all();

        System.out.println("\nResponse:\n-----------------------");
        Response response = request.when().post("/positions");
        int idValue =  response.then().statusCode(201).extract().jsonPath().getInt("id");

        System.out.println(idValue);

        TestContext.savePositionId(idValue);

        return idValue;

    }

    public void deletePosition(int id) {
        System.out.println("\nRequest:\n-----------------------");
        System.out.println("Id: " + id);
        RequestSpecification request = RestAssured
                .given().baseUri(BASE_URI)
                .auth().preemptive().basic("student@example.com","welcome")
                .log().all();
        System.out.println("\nResponse:\n-----------------------");
        Response response = request.when().delete("/positions/" + id);
        response.then().statusCode(204);
        System.out.println("deleted");
    }

    public void updatePosition(Map<String,String> fieldToUpdate, int id){
        System.out.println("\nRequest:\n-----------------------");
        RequestSpecification request = RestAssured
                .given().baseUri(BASE_URI)
                .header(CONTENT_TYPE, JSON)
                .auth().preemptive().basic("student@example.com","welcome")
                .body(fieldToUpdate)
                .log().all();
        System.out.println("\nResponse:\n-----------------------");
        Response response = request.when().patch("/positions/" + id);
        response.then().statusCode(200);

    }

    public List getPosition() {
        System.out.println("\nRequest:\n-----------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri(BASE_URI)
                .log().all();

        Response response = request.when().get("/positions");
        List<Map<String, Object>> list = response.then().statusCode(200).extract().jsonPath().getList("");
//        System.out.println(list);
//        for(Map list1:list){
//            System.out.println(list1);
//        }

        return list;
    }

}
