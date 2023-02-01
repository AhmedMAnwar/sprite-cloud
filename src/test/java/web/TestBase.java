package web;

import org.testng.annotations.AfterClass;

import drvier.WebDriverExecuter;

public class TestBase {
    WebDriverExecuter webDriver;

    @AfterClass
    public void closeWebDriver() {
        webDriver.getWebDriver().close();
    }
}
