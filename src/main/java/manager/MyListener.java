package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver){
        super.beforeFindBy(by, element, driver);
        System.out.println("Hello");
        logger.info("Start search element by locator --->" +by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element with locator --->" +by+ "was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException (throwable, driver);
        logger.info("Something went wrong!");
        logger.info(throwable.getMessage());
        logger.info(String.valueOf(throwable.fillInStackTrace()));    }
    // screenshot  + info("screenoo5.png")

    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    String link = "src/test/screenshots/screenshot-"+i+".png";
    HelperBase helperBase = new HelperBase(driver);
    helperBase.takeScreenshot(link);
    logger.info("Error screenshot link --->"+link);





    public MyListener() {

    }
}
