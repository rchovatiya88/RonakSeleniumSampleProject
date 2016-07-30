import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/**
 * Created by Ronak on 5/2/16.
 *
 * Selenium Webdriver test to navigate to Google, Verify that Google Title is present then take a screenshot!
 *
 */
public class BrowserNavigation {

    public static WebDriver driver;

//Before class to call on driver with multiple @test methods

    @BeforeClass

    public static void startDriver() {
        driver  = new FirefoxDriver();
    }

    //@Test to manipulate the driver into performing various tasks such navigate to base url.

    @Test

    public void Navigate() throws IOException {


        String BaseURL = "http://www.google.com/?gws_rd=ssl";

        driver.navigate().to(BaseURL);
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(), BaseURL);

        System.out.println(BaseURL);
        System.out.println(driver.getCurrentUrl());
    }


    @Test
    public void takeScreenshot(){

        //A part of Junit test to take a screenshot of the driver navigation


        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("/Users/Ronak/Desktop/Work/Study/googlesearch.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //print statement in the console
        System.out.print("Google Screenshot  is captured and stored in the path you specified ");


    }
//To close the browser after all the Test are performed otherwise the firefox browser will stay open
        @AfterClass
        public static void stopDriver (){
         driver.quit();

        }

}

