package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (TestBase.app.getUser().isLogged()) {
            TestBase.app.getUser().logout();
        }
    }

    @Test
    public void fillLoginFormTest() {
        User user = User.builder()
                .email("noa@gmail.com")
                .password("Nnoa12345$")
                .build();

        TestBase.app.getUser().openLoginRegistrationForm();
        TestBase.app.getUser().fillLoginRegistrationForm(user);
        TestBase.app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());
    }


    @Test
    public void negativeLoginTest() {
        String email = "noagmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " + email);

        TestBase.app.getUser().openLoginRegistrationForm();
        TestBase.app.getUser().fillLoginRegistrationForm(email, password);
        TestBase.app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isWrongFormatPresent());
    }
}