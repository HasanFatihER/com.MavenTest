import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/* @BeforeClass ve @AfterClass her run da 1 kere çalışır */
/* @Before ve @After her test methodundan önce çalışır */

public class JUnitAnnotations {
    static WebDriver driver;
    static  WebElement search;
    static  WebElement sonucSayisi;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //amazon.com a gidelim
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        search = driver.findElement(By.id("twotabsearchtextbox"));


    }

    @Test
    public void urunAraPhone() {

        search.sendKeys("phone" + Keys.ENTER);
        String arananKelime="phone";
        sonucSayisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucSayisi.getText());
        if(sonucSayisi.getText().contains(arananKelime)){
            System.out.println("Test PASSED");
        }
        else System.out.println("Test FAILED");


    }
    @Test public void urunAradrum() {
        search = driver.findElement(By.id("twotabsearchtextbox"));
        search.clear();
        search.sendKeys("drum" + Keys.ENTER);


    }

    @AfterClass

    public static void tearDown() {
        driver.quit();
    }

}



