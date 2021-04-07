import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BuyTheGoods {
    WebDriver driver;
    WebDriverWait wait;
    Config config = new Config("config.properties");
    Config amazonConfig = new Config("amazon.config.properties");
    Config fustConfig = new Config("fust.config.properties");
    Config proshopConfig = new Config("proshop.config.properties");

    public BuyTheGoods(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void digitec() {
        boolean purchasedSuccessfully = false;
        do {
            try {
                driver.get(config.productPage);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addToCartButton")));
                while (!driver.findElement(By.id("addToCartButton")).isEnabled()) {
                    Thread.sleep(1000);
                    driver.navigate().refresh();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addToCartButton")));
                }
                driver.findElement(By.id("addToCartButton")).sendKeys(Keys.RETURN);
                driver.get(config.cartPage);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Jetzt kaufen']")));
                driver.findElement(By.xpath("//button[text()='Jetzt kaufen']")).sendKeys(Keys.RETURN);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Deine Bestellung war erfolgreich.')]")));
                if (driver.getPageSource().contains("Deine Bestellung war erfolgreich.")) {
                    purchasedSuccessfully = true;
                }
            } catch (NoSuchElementException | TimeoutException | InterruptedException e) {
            }
        } while (!purchasedSuccessfully);
        System.out.println("done");
    }

    public void amazon() {
        boolean purchasedSuccessfully = false;
        do {
            try {
                driver.get(amazonConfig.productPage);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wishListMainButton-announce")));
                while (driver.findElements(By.id("buy-now-button")).size() == 0) {
                    driver.navigate().refresh();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wishListMainButton-announce")));
                }
                driver.findElement(By.id("buy-now-button")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[value='Jetzt in CHF bezahlen.']")));
                driver.findElement(By.cssSelector("[value='Jetzt in CHF bezahlen.']")).click();
                purchasedSuccessfully = true;
            } catch (NoSuchElementException | TimeoutException e) {
            }
        } while (!purchasedSuccessfully);
    }

    public void proshop() {
        boolean purchasedSuccessfully = false;
        do {
            try {
                driver.get(proshopConfig.productPage);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("site-currency-wrapper")));
                while (driver.findElements(By.className("site-btn-addToBasket-lg")).size() == 0) {
                    driver.navigate().refresh();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("site-currency-wrapper")));
                }
                driver.findElement(By.className("site-btn-addToBasket-lg")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Zur Kasse']")));
                driver.findElement(By.xpath("//*[text()='Zur Kasse']")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("traidConditionsAnswer")));
                driver.findElement(By.id("traidConditionsAnswer")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[value='Nächste']")));
                driver.findElement(By.cssSelector("[value='Nächste']")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[value='82c8f09d-bd62-4414-ac66-758c4846d197']")));
                driver.findElement(By.cssSelector("[value='82c8f09d-bd62-4414-ac66-758c4846d197']")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[value='fdsfsdf']")));
                purchasedSuccessfully = true;
            } catch (NoSuchElementException | TimeoutException e) {
            }
        } while (!purchasedSuccessfully);
    }

    public void fust() {
        boolean purchasedSuccessfully = false;
        do {
            try {
                driver.get(fustConfig.productPage);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addbasket")));
                driver.findElement(By.id("addbasket")).click();
                driver.get(fustConfig.cartPage);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("deleteShopItemGVL")));
                if (driver.findElements(By.className("deleteShopItemGVL")).size() > 0) {
                    driver.findElement(By.className("deleteShopItemGVL")).click();
                }
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-deleteTransportInsurance")));
                if (driver.findElements(By.className("js-deleteTransportInsurance")).size() > 0) {
                    driver.findElement(By.className("js-deleteTransportInsurance")).click();
                }
                driver.findElement(By.cssSelector("[title='Zur Kasse']")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("labelFormyPaymentOption_cc")));
                driver.findElement(By.id("labelFormyPaymentOption_cc")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prepareOrderSubmit")));
                Thread.sleep(1000);
                driver.findElement(By.id("prepareOrderSubmit")).click();
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[starts-with(@alt, 'MasterCard')]")));
                Thread.sleep(5000);


                List<WebElement> li = driver.findElements(By.className("icon"));
                li.get(4).click();
                // driver.findElement(By.xpath("//img[starts-with(@alt, 'MasterCard')]")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myPaymentOptifdsfdsfon_cc")));


                purchasedSuccessfully = true;
            } catch (NoSuchElementException | TimeoutException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } while (!purchasedSuccessfully);

    }


}
