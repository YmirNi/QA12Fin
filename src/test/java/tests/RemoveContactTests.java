package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if (!app.getUser().isLogged()) {
            app.getUser().login(User.builder()
                    .email("noa@gmail.com")
                    .password("Nnoa12345$")
                    .build());
        }
    }
    @Test
    public void removeOneContact(){
        //countStart
        app.contact().removeOneContact();
        //countEnd
        //Assert countStart - countEnd ====== >=1
    }
    @Test
    public void removeAllContacts(){
        //countStart
        app.contact().removeAllContacts();
        //countEnd
        //Assert countStart - countEnd ====== >=1
    }
}
