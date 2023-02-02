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

    public String getUserArrayUrl() {
        return properties.getProperty("CREATE_USER_ARRAY_URL");
    }

    public String getUserListUrl() {
        return properties.getProperty("CREATE_USER_LIST_URL");
    }

    public String getUesrNameUrl() {
        return properties.getProperty("USERNAME_URL");
    }
}
