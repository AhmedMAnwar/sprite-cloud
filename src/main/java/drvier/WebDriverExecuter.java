package drvier;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fileloader.PropertyFileLoader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverExecuter {

    PropertyFileLoader propertyFile;

    final WebDriver chromeDriver;

    public WebDriverExecuter() throws IOException {
        WebDriverManager.chromedriver().setup();
        this.chromeDriver = new ChromeDriver();
        this.propertyFile = new PropertyFileLoader();
    }

    public WebDriver getWebDriver() {
        return chromeDriver;
    }

    public void openUiTapPage() {
        chromeDriver.get(propertyFile.getUiTapUrl());
    }

    public void openHomePage() {
        chromeDriver.get(propertyFile.getHomeUrl());
    }

    public void openResourcesPage() {
        chromeDriver.get(propertyFile.getResourcesUrl());
    }
}
