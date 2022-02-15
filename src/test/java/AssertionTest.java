import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AssertionTest {
    /*
        1) Bir class oluşturun: YoutubeAssertions
        2) https://www.youtube.com adresine gidin
        3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.youtube.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @Test
    public void titleTest(){
     String acctualTitle=driver.getTitle();
     String expectedTitle="YouTube";
        Assert.assertTrue("Title Test FAILED",acctualTitle.contains(expectedTitle));
    }
    @Test
    public void imageTest(){
       Assert.assertTrue(driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-logo']")).isDisplayed());

    }
    @Test
    public void searchBoxTest(){
        Assert.assertTrue(driver.findElement(By.xpath(" //input[@id='search']")).isEnabled());

    }
    @Test
    public void wrongTitleTest(){
        String acctualTitle=driver.getTitle();
        String expectedTitle="youTube";
        Assert.assertFalse("wrongTitleTest FAILED",acctualTitle.equals(expectedTitle));
        System.out.println(acctualTitle);
    }




    @AfterClass
    public static void tearDown(){

    } 
}
