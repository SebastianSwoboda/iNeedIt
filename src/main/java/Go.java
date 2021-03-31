import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;

public class Go {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromeDriver/chromedriver.exe");
        Config config = new Config("config.properties");
        boolean clickable = false;

        ChromeOptions options = new ChromeOptions();
        String chromeProfile = "C:\\Users\\sebas\\AppData\\Local\\Google\\Chrome\\ThirdUserData";
        options.addArguments("user-data-dir=" + chromeProfile);
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);


        WebDriverWait wait = new WebDriverWait(driver, 100);
        BuyTheGoods buyTheGoods = new BuyTheGoods(driver, wait);


        try {

            switch (config.store) {
                case "digitec":
                    buyTheGoods.digitec();
                    break;
                case "amazon":
                    buyTheGoods.amazon();
                    break;
                case "fust":
                    buyTheGoods.fust();
                case "proshop":
                    buyTheGoods.proshop();


            }

            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formControl-loginEmail-input")));


           /*Microspot Login
            driver.get(config.loginPage);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formControl-loginEmail-input")));
            WebElement username = driver.findElement(By.id("formControl-loginEmail-input"));
            WebElement password = driver.findElement(By.id("formControl-loginPassword-input"));
            username.sendKeys(config.username);
            password.sendKeys(config.password);
            driver.findElement(By.id("formControl-login-button")).click();*/
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hsdfjdshf")));


        } finally {
            driver.quit();
        }
    }

}
