package drvier;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fileloader.WebPropertyFileLoader;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Class presenting web driver executer.
 */
public class WebDriverExecuter {

    WebPropertyFileLoader webPropertyFileLoader;

    final WebDriver chromeDriver;

    public WebDriverExecuter() throws IOException {
        WebDriverManager.chromedriver().setup();
        this.chromeDriver = new ChromeDriver();
        this.webPropertyFileLoader = new WebPropertyFileLoader();
    }

    public WebDriver getWebDriver() {
        return chromeDriver;
    }

    public void openUiTapPage() {
        chromeDriver.get(webPropertyFileLoader.getUiTapUrl());
    }

    public void openHomePage() {
        chromeDriver.get(webPropertyFileLoader.getHomeUrl());
    }

    public void openResourcesPage() {
        chromeDriver.get(webPropertyFileLoader.getResourcesUrl());
    }
}
