package fileloader;

import java.io.IOException;

/*
 * Class presenting API URLs.
 */
public class ApiPropertyFileLoader extends PropertyFileLoader{

    private final static String urlPath = "/api/apiurls.properties";

    public ApiPropertyFileLoader() throws IOException {
        super(urlPath);
    }

    public String getBaseUrl() {
        return properties.getProperty("BASE_URL");
    }

    public String getOrderUrl() {
        return properties.getProperty("PLACE_ORDER_URL");
    }

    public String getInventoryOrderUrl() {
        return properties.getProperty("GET_INVENTORY_URL");
    }

}
