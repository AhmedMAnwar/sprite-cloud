package fileloader;

import java.io.IOException;

/*
 * Class presenting the web URLs.
 */
public class WebPropertyFileLoader extends PropertyFileLoader{

    private final static String urlPath = "/web/weburls.properties";

    public WebPropertyFileLoader() throws IOException {
        super(urlPath);
    }

    public String getUiTapUrl() {
        return properties.getProperty("UI_TAP_URL");
    }

    public String getHomeUrl() {
        return properties.getProperty("HOME_URL");
    }

    public String getResourcesUrl() {
        return properties.getProperty("RESOURCES_URL");
    }

}
