import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//This example is for student who keep going to learn selenium
public class ZeroWebappsecurityComTest
{
    public static void main(String[] args) throws InterruptedException {
        // 1. http://zero.webappsecurity.com sayfasina gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://zero.webappsecurity.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        // 2. click to sign in button
        driver.findElement(By.xpath("//i[@class='icon-signin']")).click();

        // 3. Write “username” on login
        driver.findElement(By.id("user_login")).sendKeys("username");
        Thread.sleep(3000);
        // 4. Write for password “password”
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.id("user_remember_me")).click();
        Thread.sleep(3000);
        // 5. Click to Sign in
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.findElement(By.id("primary-button")).click();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        // 6. Go Pay Bills page
        driver.findElement(By.id("pay_bills_link")).click();

        // 7.Write any price for Amount
        driver.findElement(By.id("sp_amount")).sendKeys("3000");

        // 8. Write “2020-09-10” for date
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        //Write for description "Hasan"
        driver.findElement(By.id("sp_description")).sendKeys("Hasan");
        // 9. click  Pay button
        driver.findElement(By.id("pay_saved_payees")).click();
        // 10. control the message like “The payment was successfully submitted.”
        String message="The payment was successfully submitted.";
        WebElement text=driver.findElement(By.id("alert_content"));
        if (message.equals(text.getText())) {

            System.out.println("Test PASSED");
        } else  System.out.println("Test FAILED");

        driver.close();

    }
}
