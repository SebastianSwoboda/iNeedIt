import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    InputStream inputStream;

    String homePage;
    String loginPage;
    String password;
    String username;
    String productPage;
    String cartPage;
    String store;

    public Config(String configFile) {
        getConfigValues(configFile);
    }

    void getConfigValues(String configFile) {
        try {
            Properties prop = new Properties();
            String propFileName = configFile;


            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            this.homePage = prop.getProperty("homePage");
            this.loginPage = prop.getProperty("loginPage");
            this.password = prop.getProperty("password");
            this.username = prop.getProperty("username");
            this.productPage = prop.getProperty("productPage");
            this.cartPage = prop.getProperty("cartPage");
            this.store = prop.getProperty("store");
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Error loading config: " + e.getMessage());
        }
    }
}
