package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Registration extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(TestBase.app.getUser().isLogged()){
            TestBase.app.getUser().logout();
        }
    }

    @Test
    public void successRegistrationTest(){
        int i= (int) (System.currentTimeMillis()/1000)%3600;
        String email = "noa"+i+"@gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " +email);

        TestBase.app.getUser().openLoginRegistrationForm();
        TestBase.app.getUser().fillLoginRegistrationForm(email,password);
        TestBase.app.getUser().submitRegistrationForm();
        Assert.assertTrue(app.getUser().isLogged());
        //Assert.assertTrue(TestBase.app.getUser().isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }

    @Test
    public void negativeRegistrationTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "noa" + i + "gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " + email);

        TestBase.app.getUser().openLoginRegistrationForm();
        TestBase.app.getUser().fillLoginRegistrationForm(email,password);
        TestBase.app.getUser().submitRegistrationForm();
        TestBase.app.getUser().pause(5000);
        //Assert.assertFalse(app.getUser().isLogged());
        Assert.assertTrue(TestBase.app.getUser().isWrongFormatPresent());
    }
}
