package fileloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/*
 * Base of property files.
 */
public class PropertyFileLoader {

        protected Properties properties;

        public PropertyFileLoader(String urlPath) throws IOException {
            URL url = PropertyFileLoader.class.getResource(urlPath);
            InputStream inputStream = new FileInputStream(url.getPath());
            this.properties = new Properties();
            properties.load(inputStream);
        }

}
