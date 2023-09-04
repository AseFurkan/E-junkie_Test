package US4;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US4 extends BaseDriver {
    @Test
    public void Test4() {
        driver.get("https://e-junkie.com/wiki/demo/");
        MyFunc.bekle(1);
        Actions aksiyonlar = new Actions(driver);

        WebElement addTOCart = driver.findElement(By.xpath("//a[text()='Add to Cart']"));
        addTOCart.click();

        driver.switchTo().frame(0);

        MyFunc.bekle(1);
        WebElement debitCard = driver.findElement(By.cssSelector("[data-option='CC']"));
        debitCard.click();

        MyFunc.bekle(1);
        WebElement email = driver.findElement(By.xpath("//input[@type='email' and @placeholder='Email']"));
        email.sendKeys("my@gmail.com");


        aksiyonlar.sendKeys(Keys.TAB).sendKeys("my@gmail.com").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("mustafa").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("+90564 473 37 44").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("TechnoStudy").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Aziziye Cad. No:13").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("COLOMBIA").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Utah").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("COLOMBIA").build().perform();

        WebElement country = driver.findElement(By.xpath("(//*[@class='Countries-List'])[1]"));
        Select sec1 = new Select(country);
        sec1.selectByValue("CO");

        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Bogota").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("42000").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Thanks").build().perform();

        WebElement cardType = driver.findElement(By.xpath("//*[@class='Card-Type']/select"));
        Select sec2 = new Select(cardType);
        sec2.selectByIndex(0);

        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("4242 4242 4242 4242").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("12/23").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("000").build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(5));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' your order is confirmed. Thank you!']")));
        WebElement complete = driver.findElement(By.xpath("//*[text()=' your order is confirmed. Thank you!']"));

        Assert.assertTrue("Siparişiniz tamamlanmadı", complete.getText().contains("your order is confirmed"));


        BekleVeKapat();
    }
}
