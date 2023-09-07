package US2;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class US2 extends BaseDriver {
    @Test
    public void test1(){
        driver.get("https://e-junkie.com/wiki/demo/");
        MyFunc.bekle(1);

        WebElement addToCart= driver.findElement(By.xpath("//a[text()='Add to Cart']"));
        addToCart.click();

        driver.switchTo().frame(0);

        MyFunc.bekle(1);
        WebElement debitCard = driver.findElement(By.cssSelector("[data-option='CC']"));
        debitCard.click();

        MyFunc.bekle(1);
        WebElement paying = driver.findElement(By.xpath("//*[text()='Pay 0.01 USD']"));
        paying.click();

        MyFunc.bekle(1);
        WebElement invalidEmail = driver.findElement(By.xpath("//span[text()='Invalid Email']"));

        Assert.assertTrue(invalidEmail.getText().contains("Invalid Email"));

        BekleVeKapat();




    }
}