import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class NewUserPost {

    @Test
    public void newUser() throws JSONException {

        //  RestAssured.post("http://localhost:9090/user-registration");

        RestAssured.baseURI = "http://localhost:9090";
        RequestSpecification request = given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "saisanchi123@gmail.com");
        requestParams.put("password", "happy@123");
        requestParams.put("name", "Sanchi");
        requestParams.put("phoneNumber", "7397327777");
        requestParams.put("dateOfBirth", "1996-06-13");
        requestParams.put("billingAddress", "US");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());

        Response response =  request.post("/user-registration");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(HttpStatus.CREATED,statusCode);

        System.out.println( response.body().asString());
        System.out.println("The status received: " + response.statusLine());

    }

    @Test
    public void userGet() {
        given()
                .auth().preemptive()
                .basic("saisoujanya100@gmail.com", "password")
                .when()
                .get("http://localhost:9090/users/saisoujanya100@gmail.com")
                .then().statusCode(200);


        //   Response response = RestAssured.get("http://localhost:9090/users/saisoujanya100@gmail.com");

        //System.out.println(response.getStatusCode());
        //  System.out.println(response.getBody().asString());
        //   int statusCode = response.getStatusCode();
        //   Assert.assertEquals(statusCode,200);

    }

}
