package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    //WebDriver wd;

    @BeforeSuite
    public void setUp(){
        app.init();
//        wd = new ChromeDriver();
//        wd.manage().window().maximize();
//        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
//        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterSuite
    public void tearDown(){
        app.stop();
 //       wd.quit();
    }


}