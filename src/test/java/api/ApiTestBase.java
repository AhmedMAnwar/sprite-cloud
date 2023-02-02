package api;

import java.io.IOException;

import org.testng.annotations.BeforeTest;

import fileloader.ApiPropertyFileLoader;
import io.restassured.RestAssured;

public class ApiTestBase {

    ApiPropertyFileLoader apiPropertyFileLoader;

    @BeforeTest
    public void preConfiguration() throws IOException {
        apiPropertyFileLoader = new ApiPropertyFileLoader();
        RestAssured.baseURI = apiPropertyFileLoader.getBaseUrl();
    }
}
