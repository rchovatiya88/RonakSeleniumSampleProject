import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.Is.is;


/**
 * Created by Ronak on 5/13/16.
 */
public class GetTitleandSource {

    public static WebDriver driver;

    @BeforeClass
    public static void newDriver(){

        driver = new FirefoxDriver();
    }

    @Test
    public void newTest(){
        String newURL = "http://www.ornait.com";
        driver.navigate().to(newURL);
        driver.manage().window().maximize();
        String gettitle = driver.getTitle();
        System.out.print(gettitle);
        Assert.assertEquals(driver.getTitle(),gettitle);
        Assert.assertThat(driver.getTitle(), is(gettitle));
        String getpagesource = driver.getPageSource();
        System.out.print(getpagesource);

    }

    @AfterClass
    public static void quitDriver(){
        driver.close();

    }
}