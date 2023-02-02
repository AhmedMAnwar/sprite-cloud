package web;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drvier.WebDriverExecuter;
import webelement.ResourcesWebElement;

/*
 * Resources test cases.
 */
public class ResourcesTests extends WebTestBase{
    ResourcesWebElement resourcesWebElement;

    String[] subHeaders = {"Learning", "Standards", "Articles", "Community"};
    String[] subLinks = {"w3schools.com", "MDN", "Learn regex the easy way",
                         "devhints.io", "W3C", "Test Pyramid",
                         "Where do our flaky tests come from?",
                         "Ministry of Testing", "uTest", "Software Testing Help",
                         "DZone", "StackOverflow"};

    @BeforeClass
    public void openPageURL() throws IOException {
       webDriver = new WebDriverExecuter();
       webDriver.openResourcesPage();
       resourcesWebElement = new ResourcesWebElement(webDriver.getWebDriver());
    }

    @Test(priority = 1, description = "Veryfing resources page having all headers")
    public void isResourcesPageHeadersPresented() {
        List<WebElement> subHeadersWebElements
            = resourcesWebElement.getSubHeaders();
        assertTrue(isSubWebElementsPresented(subHeadersWebElements, subHeaders));
    }

    @Test(priority = 2, description = "Veryfing resource page having all links")
    private void isResourcePageLinksPresented() {
        List<WebElement> subLinksWebElements
            = resourcesWebElement.getSubLinks();
        assertTrue(isSubWebElementsPresented(subLinksWebElements, subLinks));
    }

    //private method
    public Boolean isSubWebElementsPresented(List<WebElement> subWebElements,
                                             String[] subArray) {
        int index = 0;
        for (WebElement webElement : subWebElements) {
            if(webElement.getText().equals(subArray[index])) {
                index++;
                continue;
            }
            else
                return false;
        }
        return true;
    }
}
