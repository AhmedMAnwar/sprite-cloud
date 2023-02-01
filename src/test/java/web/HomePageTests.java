package web;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drvier.WebDriverExecuter;
import webelement.HomeWebElement;

public class HomePageTests extends TestBase{
    HomeWebElement homeWebElement;

    @BeforeClass
    public void openPageURL() throws IOException {
       webDriver = new WebDriverExecuter();
       webDriver.openHomePage();
       homeWebElement = new HomeWebElement(webDriver.getWebDriver());
    }

    @Test(priority = 1, description = "Veryfing that button id is not changed")
    public void isDyanmicIdButtonChanged() {
        String buttonId
            = homeWebElement.clickOnDynamicIdLink().getDynamicButtonId();
        homeWebElement.clickOnDynamicIdButton();
        assertEquals(homeWebElement.getDynamicButtonId(), buttonId);
    }

    @Test(priority = 2, description = "Veryfing if the alert is closed")
    public void isAlertPopUpClosed() {
        homeWebElement.clickOnClassAttributeLink().clickOnBlueButton();
        assertEquals(homeWebElement.isAlertClosed(), true);
    }

    @Test(priority = 3, description = "Veryfing the green button is not clickable")
    public void isGreenButtonNotClickable() {
        boolean isbuttonClickable;
        homeWebElement.clickOnHiddenLayerButton().clickOnGreenButton()
            .clickOnGreenBlueButton();
        try {
            homeWebElement.clickOnGreenButton();
            isbuttonClickable = true;
        } catch (ElementClickInterceptedException e) {
            isbuttonClickable = false;;
        }
        assertFalse(isbuttonClickable);
    }

    @Test(priority = 4, description = "Veryfing the button apperance after dealy")
    public void isButtonDispalyedAfterDealy() {
        homeWebElement.clickOnLoadDelayButton();
        assertTrue(homeWebElement.isButtonAppearAfterDelayDisplayed());
    }

    @Test(priority = 5, description = "Veryfing the apperance of AJAX data")
    public void isAjaxDataLoaded() {
        homeWebElement.clickOnAjaxDelayButton().clickOnAjaxButtonTriggerDelay();
        assertTrue(homeWebElement.isAjaxDataLoaded());
    }

    @Test(priority = 6, description = "Veryfing action over button ignoring click")
    public void isButtonIgnoringActionClicked() {
        homeWebElement.clickOnTheClickButton().clickOnButtonIgnoringDomClick();
        assertTrue(homeWebElement.isButtonIgnoringActionClicked());
    }

    @Test(priority = 7, description = "Veryfing added text in text field")
    public void isTextAddedToField() {
        String text = "Test Data";
        homeWebElement.clickOnTextInputLink().setTextInput(text);
        assertEquals(homeWebElement.clickOnbuttonChangedToTextAndGetText(), text);
    }

    @Test(priority = 8, description = "Veryfing matching between CPU cell value"
                                    + " and chrome CPU value")
    public void isCpuValueMatchChromeCpuValue() {
        homeWebElement.clickOnDyanmicTableLink();
        assertEquals(homeWebElement.getCellCpuValueOfName("Chrome"),
                     homeWebElement.getChromeCpuValue());
    }

    @Test(priority = 9, description = "Veryfing the time of progress bar updates")
    private void trackProgressBarUpdate() {
        long startTime
            = homeWebElement.clickOnProgressBarButton().clickOnStartButton();
        long endTime = homeWebElement.trackProgressBarUpdateValueOf(75);
        homeWebElement.clickOnStopButton();
        assertTrue((endTime - startTime) < 15000); // 15000 means 15 sec
    }

    @AfterMethod
    public void forwardBackToHomePage() {
        homeWebElement.forwardBackToHomePage();
    }
}
