package web;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import drvier.WebDriverExecuter;
import fileloader.PropertyFileLoader;
import webelement.NavBarWebElement;

/*
 * Nav bar test cases.
 */
public class NavBarTests extends TestBase{

    PropertyFileLoader propertyFile;
    NavBarWebElement navBarWebElement;

    @BeforeClass
    public void openPageURL() throws IOException {
       webDriver = new WebDriverExecuter();
       propertyFile = new PropertyFileLoader();
       webDriver.openUiTapPage();
    }

    @BeforeMethod
    private void initiateNavBarWebElement() {
        navBarWebElement = new NavBarWebElement(webDriver.getWebDriver());
    }

    @Test(priority = 1, description = "Veryfing switching to home tab")
    public void isHomePageOpened() {
        assertEquals(navBarWebElement.getHomeWebElement().getPageURL(),
                     propertyFile.getHomeUrl());
    }

    @Test(priority = 2, description = "Veryfing switching to resources tab")
    public void isResourcePageOpened() {
        assertEquals(navBarWebElement.getResourcesWebElement()
            .getResourcePageHeader(), "Resources");
    }

    @Test(priority = 3, description = "Veryfing switching to UI tab")
    public void isUiTabPageOpened() {
        assertEquals(navBarWebElement.getUiTapWebElement().getPageURL(),
                     propertyFile.getUiTapUrl());
    }
}
