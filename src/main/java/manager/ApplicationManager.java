package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
        WebDriver wd;
        HelperUser user;
        HelperContact contact;

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        user = new HelperUser(wd);
        contact = new HelperContact(wd);
    }

    public void stop(){
        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperContact contact() {
        return contact;
    }
}
