package webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Class presenting resources tab web elements.
 */
public class ResourcesWebElement {

    private static final By CONTAINER_SECTION_SELECTOR
        = By.xpath("(//div[@class='container'])[1]");
    private static final By CONTAINER_HEADER_SELECTOR = By.tagName("h3");
    private static final By SUB_HEADER_SELECTOR = By.tagName("h4");
    private static final By SUB_LINKS_SELECTOR = By.tagName("a");

    final WebDriver webDriver;

    final WebElement containerWebElement;

    public ResourcesWebElement(WebDriver webDriver) {
        if(webDriver == null)
            throw new IllegalArgumentException();

        this.webDriver = webDriver;
        this.containerWebElement
            = webDriver.findElement(CONTAINER_SECTION_SELECTOR);
    }

    public String getResourcePageHeader() {
        return containerWebElement.findElement(CONTAINER_HEADER_SELECTOR)
            .getText();
    }

    public List<WebElement> getSubHeaders(){
        return containerWebElement.findElements(SUB_HEADER_SELECTOR);
    }

    public List<WebElement> getSubLinks() {
        return containerWebElement.findElements(SUB_LINKS_SELECTOR);
    }
}
