package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    //protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void startLogger(Method m){
      logger.info("Test name ----->" +m.getName());
    }
    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m) {
        logger.info("Test end" + m.getName());
    }

    @BeforeSuite
    public void setUp(){
        app.init();
    }
    @AfterSuite
    public void tearDown(){
        app.stop();
    }
}