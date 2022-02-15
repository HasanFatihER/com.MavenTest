import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
        /* 1. Bir class oluşturun : RadioButton
        2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        - https://www.facebook.com adresine gidin
        - Cookies’i kabul edin
        - “Create an Account” button’una basin
        - “radio buttons” elementlerini locate edin
        - Secili degilse cinsiyet butonundan size uygun olani secin */

import java.time.Duration;

public class RadioButton {
    static  WebDriver driver;

    @BeforeClass
    public static void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");


    }    @Test
    public void facebookTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Hasan");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ER");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("abc@gmail.com");
        Thread.sleep(300);
        driver.findElement(By.xpath("//input[@value='2']")).click();

    }


    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }
}
