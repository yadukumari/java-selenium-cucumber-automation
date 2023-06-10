package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDataFromFile;
import static support.TestContext.getPositionFromFile;

import org.junit.runner.Request;
import org.openqa.selenium.devtools.v101.fetch.model.AuthChallengeResponse;
import support.RestClient;

import java.util.List;
import java.util.Map;

public class RestStepDefs {
    RequestSpecification request = RestAssured.given().baseUri("https://skryabin.com/recruit/api/v1/");

    Response response;

    List<Map<String, Object>> list;

    Map<String, Object> map;

    private RestClient restClient = new RestClient();

    @Given("I make rest api requests")
    public void iMakeRestApiRequests() {
        //getPosition:

        //parse and verify

        list = restClient.getPosition();
        boolean found = false;
        for (Map item : list){
            if(item.get("id").equals(5)){
                found = true;
            }
        }
        assertThat(found).isTrue();
        //System.out.println(list);



        //post Position
        Map<String, String> positionToCreate = getPositionFromFile("automation");

        int positionId = restClient.postPosition(positionToCreate);
        System.out.println("The created position Id: " + positionId);
        List<Map<String,Object>> list = restClient.getPosition();
        for (Map item : list){
            if(item.get("id").equals(positionId)){
                found = true;
            }
        }
        assertThat(found).isTrue();
        Map<String,Object> position = restClient.getPositionId("Jr Automation Engineer", positionId);
        assertThat(position.get("title")).isEqualTo(positionToCreate.get("title"));


        //update Position
        Map<String, String> fieldToUpdate = getPositionFromFile("automation_updated");
        restClient.updatePosition(fieldToUpdate, positionId);
        position = restClient.getPositionId("Jr Automation Engineer", positionId);
        assertThat(position.get("address")).isEqualTo(fieldToUpdate.get("address"));
        assertThat(position.get("description")).isEqualTo(fieldToUpdate.get("description"));


        //delete position
        restClient.deletePosition(positionId);
        List<Map<String,Object>> updatedList = restClient.getPosition();
        boolean deletedId = false;
        for (Map positionList:updatedList){
            if(positionList.get("id").equals(positionId)){
                deletedId = true;
            }
        }

        assertThat(deletedId).isFalse();


    }

}
