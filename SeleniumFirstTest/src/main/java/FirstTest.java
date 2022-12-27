import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.sql.Driver;
import java.time.Duration;

public class FirstTest {

/* 1. get - переход на страницу
        //driver.get("https://next.privat24.ua/mobile");

 * 2. navigate().to - переход на страницу
       driver.navigate().to("https://next.privat24.ua/money-transfer/card");
 * 3. back - переход назад
      driver.navigate().back();
 * 4. forward - переход вперед
       driver.navigate().forward();
 * 5. refresh - обновление страницы
       driver.navigate().refresh();
 * 6. close - закрыть окно, если крайне то и браузер
      driver.close();
 * 7. quit - закрыть окно, если крайне то и браузер
      driver.quit();
 */

    WebDriver driver = new ChromeDriver();
    //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

    //TEST DATA
    String BASE_URL="https://next.privat24.ua/money-transfer/card";
    String cardNumberFromExample = "4004 1591 1544 9003";


    // UI ELEMENTS
    By cardNumberFrom = By.xpath(".//input[@data-qa-node='numberdebitSource']");
    By expDate = By.xpath(".//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath(".//input[@data-qa-node='cvvdebitSource']");
    By nameFrom = By.xpath(".//input[@data-qa-node='firstNamedebitSource']");
    By surnameFrom = By.xpath(".//input[@data-qa-node='lastNamedebitSource']");
    By cardNumberTo = By.xpath(".//input[@data-qa-node='numberreceiver']");
    By nameTo = By.xpath(".//input[@data-qa-node='firstNamereceiver']");
    By surnameTo = By.xpath(".//input[@data-qa-node='lastNamereceiver']");
    By amount = By.xpath(".//input[@data-qa-node='amount']");
    By toggleComment = By.xpath(".//span[@data-qa-node='toggle-comment']");
    By comment = By.xpath(".//textarea[@data-qa-node='comment']");
    By btnAddToBasket = By.xpath(".//button[@type='submit']");

@Disabled
    @Test
        public void checkAddToBasketMinPaymentSum() {

    //pre-condition: ожидать отображения перечисленных элементов
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get(BASE_URL);
    driver.findElement(cardNumberFrom).sendKeys(cardNumberFromExample);
    driver.findElement(expDate).sendKeys("0725");
    driver.findElement(cvv).sendKeys("123");
    driver.findElement(nameFrom).sendKeys("Taras");
    driver.findElement(surnameFrom).sendKeys("Tarasov");
    driver.findElement(cardNumberTo).sendKeys("5309233034765085");
    driver.findElement(nameTo).sendKeys("Petr");
    driver.findElement(surnameTo).sendKeys("Petrov");
    driver.findElement(amount).sendKeys("500");
    driver.findElement(toggleComment).click();
    driver.findElement(comment).sendKeys("TEST COMMENT HILLEL");
    driver.findElement(btnAddToBasket).submit();

    Assertions.assertEquals(cardNumberFromExample, driver.findElement(By.xpath(".//span[@data-qa-node='payer-card']")).getText());


    //driver.close();
}

    //TEST DATA MOB
    String MOB_URL="https://next.privat24.ua/mobile";
    String amountExample = "1";
    By phoneNumber = By.xpath(".//input[@data-qa-node='phone-number']");

    @Test
    public void addMinSumMob() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(MOB_URL);
        driver.findElement(phoneNumber).sendKeys("502768980");
        driver.findElement(By.xpath(".//input[@data-qa-value='120']")).clear();
        driver.findElement(amount).sendKeys("1");
        driver.findElement(cardNumberFrom).sendKeys(cardNumberFromExample);
        driver.findElement(expDate).sendKeys("0725");
        driver.findElement(cvv).sendKeys("123");
        driver.findElement(btnAddToBasket).submit();

    Assertions.assertEquals(amountExample, driver.findElement(By.xpath(".//div[@data-qa-node='amount']")).getText());


 }
}






