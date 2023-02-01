package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Class presenting the navigation bar web elements.
 */
public final class NavBarWebElement {

    private static final By NAV_BAR_SELECTOR = By.tagName("nav");
    private static final By UITAP_BUTTON_SELECTOR = By.linkText("UITAP");
    private static final By HOME_BUTTON_SELECTOR = By.linkText("Home");
    private static final By RESOURCES_BUTTON_SELECTOR = By.linkText("Resources");

    final WebDriver webDriver;
    final WebElement navBarWebElement;

    public NavBarWebElement(WebDriver webDriver) {
        if (webDriver == null)
            throw new IllegalArgumentException();

        this.webDriver = webDriver;
        this.navBarWebElement = webDriver.findElement(NAV_BAR_SELECTOR);
    }

    public HomeWebElement getUiTapWebElement() {
        navBarWebElement.findElement(UITAP_BUTTON_SELECTOR).click();
        return new HomeWebElement(webDriver);
    }

    public HomeWebElement getHomeWebElement() {
        navBarWebElement.findElement(HOME_BUTTON_SELECTOR).click();
        return new HomeWebElement(webDriver);
    }

    public ResourcesWebElement getResourcesWebElement() {
        navBarWebElement.findElement(RESOURCES_BUTTON_SELECTOR).click();
        return new ResourcesWebElement(webDriver);
    }
}
