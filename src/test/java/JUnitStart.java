import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
 /* Junit Test için kullanılan en temel Framework'tür. Eklemeyi pom.xml den yaparız.

 Junit main method kullanmadan test imkanı sağlar.. */

/*Junit Annotations -- @ işareti ile kullanılan notasyonlardır.Java Annotaion'ları ile her methodu ve testi ayrı ayrı
derleme(compile) imkanı olur.*/

/* Eğer BeforeClass ve AfterClass Methodlarını kullanıyorsak zorunlu olarak bu methoodları
*Junit static yaptırır. */

public class JUnitStart {
   static WebDriver driver;


    @Test
    public void titleTest() {

        //https://www.ebay.com/ a gidelim
        driver.get("https://www.ebay.com/");
        // title 'ın ebay içerip içermediğini kontrol edelim.
        driver.getTitle();

    }

    @Test
    public void logoTest() {

    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}

