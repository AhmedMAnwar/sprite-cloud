package webelement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Class presenting home tab web element.
 */
public class HomeWebElement {

    private static final By DESCRIPTION_SECTION_SELECTOR = By.id("description");
    private static final By DESCRIPTION_TITLE_SELECTOR = By.id("title");
    private static final By OVERVIEW_SECTION_SELECTOR = By.id("overview");
    private static final By DYNAMIC_LINK_SELECTOR
        = By.xpath("//a[@href='/dynamicid']");
    private static final By DYNAMIC_ID_BUTTON_SELECTOR
        = By.xpath("//button[contains(@class,'btn-primary')]");
    private static final By CLASS_ATTRIBUTE_SELECTOR
        = By.xpath("//a[@href='/classattr']");
    private static final By BLUE_BUTTON_SELECTOR
        = By.xpath("//button[contains(@class, 'btn') "
                   + "and contains(@class, 'btn-primary')]");
    private static final By HIDDEN_LAYER_LINK_SELECTOR
        = By.xpath("//a[@href='/hiddenlayers']");
    private static final By GREEN_BUTTON_SELECTOR = By.id("greenButton");
    private static final By GREEN_BLUE_BUTTON_SELECTOR = By.id("blueButton");
    private static final By LOAD_DELAY_LINK_SELECTOR
        = By.xpath("//a[@href='/loaddelay']");
    private static final By SPINNER_SELECTOR = By.id("spinner");
    private static final By AJAX_LINK_SELECTOR = By.xpath("//a[@href='/ajax']");
    private static final By AJAX_BUTTON_TRIGGER_DELAY_SELECTOR
        = By.id("ajaxButton");
    private static final By AJAX_DATA_LOADED_SELECTOR = By.className("bg-success");
    private static final By CLICK_LINK_SELECTOR = By.xpath("//a[@href='/click']");
    private static final By IGNORE_DOM_CLICK_BUTTON_SELECTOR = By.id("badButton");
    private static final By TEXT_INPUT_LINK_SELECTOR
        = By.xpath("//a[@href='/textinput']");
    private static final By TEXT_INPUT_SELECTOR = By.id("newButtonName");
    private static final By BUTTON_CHANGED_TO_TEXT_SELECTOR
        = By.id("updatingButton");
    private static final By DYNAMIC_TABLE_LINK_SELECTOR
        = By.xpath("//a[@href='/dynamictable']");
    private static final By TABLE_HEADER_SELECTOR
        = By.xpath("//span[@role='columnheader']");
    private static final By TABLE_CELL_SELECTOR = By.xpath("//span[@role='cell']");
    private static final By CHROME_CPU_SELECTOR = By.className("bg-warning");
    private static final By PROGRESS_BAR_LINK_SELECTOR
        = By.xpath("//a[@href='/progressbar']");
    private static final By START_BUTTON_SELECTOR = By.id("startButton");
    private static final By STOP_BUTTON_SELECTOR = By.id("stopButton");

    final WebDriver webDriver;
    final WebElement descriptionSectionWebEle;
    final WebElement overviewSectionWebEle;

    public HomeWebElement(WebDriver webDriver) {
        if(webDriver == null)
            throw new IllegalArgumentException();

        this.webDriver = webDriver;
        this.descriptionSectionWebEle
            = webDriver.findElement(DESCRIPTION_SECTION_SELECTOR);
        this.overviewSectionWebEle
            = webDriver.findElement(OVERVIEW_SECTION_SELECTOR);
    }

    public String getHomPageDescription() {
        return descriptionSectionWebEle.findElement(DESCRIPTION_TITLE_SELECTOR)
            .getText();
    }

    public String getPageURL() {
        return webDriver.getCurrentUrl();
    }

    public HomeWebElement clickOnDynamicIdLink() {
        overviewSectionWebEle.findElement(DYNAMIC_LINK_SELECTOR).click();
        return this;
    }

    public String getDynamicButtonId() {
        return webDriver.findElement(DYNAMIC_ID_BUTTON_SELECTOR)
            .getAttribute("id");
    }

    public void clickOnDynamicIdButton() {
        webDriver.findElement(DYNAMIC_ID_BUTTON_SELECTOR).click();
    }

    public HomeWebElement clickOnClassAttributeLink() {
        overviewSectionWebEle.findElement(CLASS_ATTRIBUTE_SELECTOR).click();
        return this;
    }

    public HomeWebElement clickOnBlueButton() {
        webDriver.findElement(BLUE_BUTTON_SELECTOR).click();
        return this;
    }

    public boolean isAlertClosed() {
        try {
            webDriver.switchTo().alert().accept();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public HomeWebElement clickOnHiddenLayerButton() {
        overviewSectionWebEle.findElement(HIDDEN_LAYER_LINK_SELECTOR).click();
        return this;
    }

    public HomeWebElement clickOnGreenButton() {
        webDriver.findElement(GREEN_BUTTON_SELECTOR).click();
        return this;
    }

    public HomeWebElement clickOnGreenBlueButton() {
        webDriver.findElement(GREEN_BLUE_BUTTON_SELECTOR).click();
        return this;
    }

    public HomeWebElement clickOnLoadDelayButton() {
        webDriver.findElement(LOAD_DELAY_LINK_SELECTOR).click();
        waitTillInVisibilityOfSpinner();
        return this;
    }

    public boolean isButtonAppearAfterDelayDisplayed() {
        return webDriver.findElement(BLUE_BUTTON_SELECTOR).isDisplayed();
    }

    public HomeWebElement clickOnAjaxDelayButton() {
        overviewSectionWebEle.findElement(AJAX_LINK_SELECTOR).click();
        return this;
    }

    public void clickOnAjaxButtonTriggerDelay() {
        webDriver.findElement(AJAX_BUTTON_TRIGGER_DELAY_SELECTOR).click();
        waitTillInVisibilityOfSpinner();
    }

    public boolean isAjaxDataLoaded() {
        return webDriver.findElement(AJAX_DATA_LOADED_SELECTOR).isDisplayed();
    }

    public HomeWebElement clickOnTheClickButton() {
        overviewSectionWebEle.findElement(CLICK_LINK_SELECTOR).click();
        return this;
    }

    public void clickOnButtonIgnoringDomClick() {
        webDriver.findElement(IGNORE_DOM_CLICK_BUTTON_SELECTOR).click();
    }

    public boolean isButtonIgnoringActionClicked() {
        WebElement buttonIgnoringDomClick
            = webDriver.findElement(IGNORE_DOM_CLICK_BUTTON_SELECTOR);
        if(buttonIgnoringDomClick.getAttribute("class").contains("btn-success"))
            return true;

        else
            return false;
    }

    public HomeWebElement clickOnTextInputLink() {
        overviewSectionWebEle.findElement(TEXT_INPUT_LINK_SELECTOR).click();
        return this;
    }

    public void setTextInput(String text) {
        webDriver.findElement(TEXT_INPUT_SELECTOR).sendKeys(text);
    }

    public String clickOnbuttonChangedToTextAndGetText() {
        WebElement buttonChangedToText
            =  webDriver.findElement(BUTTON_CHANGED_TO_TEXT_SELECTOR);
        buttonChangedToText.click();
        return buttonChangedToText.getText();
    }

    public HomeWebElement clickOnDyanmicTableLink() {
        overviewSectionWebEle.findElement(DYNAMIC_TABLE_LINK_SELECTOR).click();
        return this;
    }

    public String getCellCpuValueOfName(String name) {
        List<WebElement> tableHeaders
             = webDriver.findElements(TABLE_HEADER_SELECTOR);
        int index = 0;
        for(int i = 0; i < tableHeaders.size(); i++) {
            if(tableHeaders.get(i).getText().equals("CPU"))
                index = i;
        }
        List<WebElement> tableCells = webDriver.findElements(TABLE_CELL_SELECTOR);
        WebElement cellNameWebElement = null;
        for (WebElement webElement : tableCells) {
            if(webElement.getText().equals(name))
                cellNameWebElement = webElement;
        }
        return cellNameWebElement.findElement
            (By.xpath("./following-sibling::span["+index+"]")).getText();
    }

    public String getChromeCpuValue() {
        String[] chromeCpuValue = webDriver.findElement(CHROME_CPU_SELECTOR)
            .getText().split(":");
        // index 1 has a value with extra space
        return chromeCpuValue[1].trim();
    }

    public HomeWebElement clickOnProgressBarButton() {
        overviewSectionWebEle.findElement(PROGRESS_BAR_LINK_SELECTOR).click();
        return this;
    }

    public long clickOnStartButton() {
        webDriver.findElement(START_BUTTON_SELECTOR).click();
        return System.currentTimeMillis();
    }

    public void clickOnStopButton() {
        webDriver.findElement(STOP_BUTTON_SELECTOR).click();
    }

    public long trackProgressBarUpdateValueOf(int value) {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(webDriver)
            .withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(1))
            .ignoring(Exception.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated
             (By.xpath("//div[@aria-valuenow="+value+"]")));
        return System.currentTimeMillis();
    }

    public void forwardBackToHomePage() {
        webDriver.navigate().back();
    }

    //private methods

    public void waitTillInVisibilityOfSpinner() {
        WebDriverWait driverWait = new WebDriverWait(webDriver, 20);
        driverWait.until(ExpectedConditions
            .invisibilityOfElementLocated(SPINNER_SELECTOR));
    }
}
