package web;

import org.testng.annotations.AfterClass;

import drvier.WebDriverExecuter;

/*
 * Base class of test cases.
 */
public class TestBase {
    WebDriverExecuter webDriver;

    @AfterClass
    public void closeWebDriver() {
        webDriver.getWebDriver().close();
    }
}
