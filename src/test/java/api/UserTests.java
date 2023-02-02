package api;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

/*
 * user test cases.
 */
public class UserTests extends ApiTestBase {

    @Test(priority = 1, description = "Verify adding users within an array")
    public void isUserArrayAdded() {
        UserBody[] user
            = {new UserBody("User 1", "User", "1", "user1@gmail.com", "123",
                            "01067721442", 1),
               new UserBody(2, "User 2", "User", "2", "user2@gmail.com", "546",
                            "010677245323", 0)};

        RestAssured.given().when().header("Content-Type", "application/json")
            .body(user).post(apiPropertyFileLoader.getUserArrayUrl()).then()
            .assertThat().statusCode(200).body("message", Matchers.equalTo("ok"));
    }

    @Test(priority = 2, description = "Verify adding user within a list")
    public void isUserListAdded() {
        List<UserBody> user = new ArrayList<>();
        user.add(new UserBody("User Array", "User", "Array",
                              "userarray@gmail.com", "123", "01067721442", 1));

        RestAssured.given().when().header("Content-Type", "application/json")
            .body(user).post(apiPropertyFileLoader.getUserListUrl()).then()
            .assertThat().statusCode(200).body("message", Matchers.equalTo("ok"));
    }

    @Test(priority = 3, description = "Verify searching for a non exist user")
    public void isNotUserExist() {

        String username = "user2";

        RestAssured.given().when()
            .get(apiPropertyFileLoader.getUesrNameUrl() + username).then()
            .assertThat().statusCode(404).body("type", Matchers.equalTo("error"));
    }

    @Test(priority = 4, description = "Verify searching for an exist user")
    public void isUserExist() {

        String username = "User 1";

        RestAssured.given().when()
            .get(apiPropertyFileLoader.getUesrNameUrl() + username)
            .then().assertThat().body("username", Matchers.equalTo(username));
    }

}
