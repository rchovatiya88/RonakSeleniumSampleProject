import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.Is.is;

/**
 * Created by Ronak on 7/26/16.
 */
public class logintoGmail {

    public static WebDriver driver;

    @BeforeClass
    public static void newDriver(){

        driver = new FirefoxDriver();
    }

    @Test
    public void newTest(){
        String newURL = "http://www.gmail.com";
        driver.navigate().to(newURL);
        driver.manage().window().maximize();
        String gettitle = driver.getTitle();
        driver.findElement(By.id("Email")).sendKeys("rchovatiya88");
        driver.findElement(By.id("next")).click();

       // System.out.print(gettitle);
        Assert.assertEquals(driver.getTitle(),gettitle);
        Assert.assertThat(driver.getTitle(), is(gettitle));
        driver.quit();
        //String getpagesource = driver.getPageSource();
       // System.out.print(getpagesource);

    }
}
