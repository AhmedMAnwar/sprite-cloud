package fileloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;


public class PropertyFileLoader {

        private final static String urlPath = "/weburls.properties";
        private final Properties properties;

        public PropertyFileLoader() throws IOException {
            URL url = PropertyFileLoader.class.getResource(urlPath);
            InputStream inputStream = new FileInputStream(url.getPath());
            this.properties = new Properties();
            properties.load(inputStream);
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
