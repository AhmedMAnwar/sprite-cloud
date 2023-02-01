package api;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fileloader.ApiPropertyFileLoader;
import io.restassured.RestAssured;

/*
 * Store test cases.
 */
public class StoreTests {

    ApiPropertyFileLoader apiPropertyFileLoader;

    @BeforeClass
    public void preConfiguration() throws IOException {
        apiPropertyFileLoader = new ApiPropertyFileLoader();
        RestAssured.baseURI = apiPropertyFileLoader.getBaseUrl();
    }

    @Test(priority = 1, description = "Verifying if the order is added")
    public void isOrderAdded() {
        int petId = 1;
        int quantity = 2;
        String shipDate = "2023-02-01T14:06:59.266Z";
        String status = "placed";
        boolean complete = true;

        StoreBody storeBody
            = new StoreBody(petId, quantity, shipDate, status, complete);

        RestAssured.given().when().header("Content-Type", "application/json")
            .body(storeBody).post(apiPropertyFileLoader.getOrderUrl())
            .then().assertThat()
            .statusCode(200).body("petId", IsEqual.equalTo(petId))
            .body(StoreResponse.quantity.toString(), IsEqual.equalTo(quantity))
            .body(StoreResponse.shipDate.toString(), Matchers.notNullValue())
            .body(StoreResponse.status.toString(), Matchers.equalTo(status))
            .body(StoreResponse.complete.toString(), IsEqual.equalTo(true));
    }

    @Test(priority = 2, description = "Verify searching for order id")
    public void isOrderIdRetrieved() {
        int id = 4;
        RestAssured.given().when()
        .get(apiPropertyFileLoader.getOrderUrl() + ""+id+"")
        .then().assertThat()
        .statusCode(200).body(StoreResponse.id.toString(), Matchers.equalTo(id));
    }


    @Test(priority = 3, description = "Verify deleting order by id")
    public void isOrderDeleted() {
        int id = 3;
        RestAssured.given().when()
        .get(apiPropertyFileLoader.getOrderUrl() + ""+id+"")
        .then().assertThat()
        .statusCode(200).body(StoreResponse.id.toString(), Matchers.equalTo(id));
    }

    @Test(priority = 4, description = "Verify getting inventory")
    public void isInventroyReturned() {
        RestAssured.given().when()
        .get(apiPropertyFileLoader.getInventoryOrderUrl())
        .then().assertThat().statusCode(200)
        .body(StoreResponse.unavailable.toString(), Matchers.equalTo(1))
        .body(StoreResponse.pending.toString(), Matchers.equalTo(4))
        .body(StoreResponse.нет.toString(), Matchers.equalTo(1))
        .body(StoreResponse.disponible.toString(), Matchers.equalTo(1))
        .body(StoreResponse.totvs1.toString(), Matchers.equalTo(1));
    }

    private enum StoreResponse {
        id, petId, quantity, shipDate, status, complete, sold, string,
        unavailable, pending, available, нет, peric, disponible, totvs1
    }
}
