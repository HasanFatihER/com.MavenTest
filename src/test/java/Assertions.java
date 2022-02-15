import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
// Java Öğrencileri için Örnek Çalışmalar

/*  1) Bir class oluşturun: Assertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
    ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    ○ titleTest => Sayfa başlığının “Test” içermediğini(contains) test edin
    ○ logoTest => BestBuy logosunun görüntülendigini test edin
    */

public class Assertions {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();


    }

    @Test
    public void urlTest() {
        String url = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";
        Assert.assertEquals("Url Test FAILED", expectedUrl, url);

        /* Mesaj test başarısız olduğunda vermesini istedğiniz mesaj olmalı.
        Eğer test başarısız olursa exception fırlatır. Bu da testi durdurur.
        Exception verdikten sonra kod devam etmez.Bu testNG de biraz farklı.
        */
    }

    @Test
    public void titleTest() {
        String actualTitle=driver.getTitle();
        String deger="Test";
        Assert.assertFalse("Title Test FAILED ",actualTitle.contains(deger));

    }
    @Test
    public void logoTest() {
       WebElement actualLogo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("Logo Test FAILED ",actualLogo.isDisplayed());

    }

   @AfterClass
    public static void tearDown() {
        driver.quit();


    }
}