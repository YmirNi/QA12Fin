package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContract extends TestBase{

    @BeforeMethod
    public void preConditions() {
        if (!app.getUser().isLogged()) {
            app.getUser().login(User.builder()
                    .email("noa@gmail.com")
                    .password("Nnoa12345$")
                    .build());
        }
    }

    @Test(invocationCount = 3)
    public void addNewContactSuccess(){
        int countStart = app.contact().countOfContacts();
        logger.info("The test 'Add new contact starts with count of contact---->"+countStart );
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println();
        Contact contact = Contact.builder().build()
                .withName("Zoa")
                .withLastName("Snow")
                .withPhone("1234567890" + i)
                .withEmail("zoa" + i + "@gmail.com")
                .withAddress("Haifa")
                .withDescription("friend");

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();

        int countEnd = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' ends with count of contact in the end --->"+countEnd);


        app.contact().pause(2000);
//        Assert.assertTrue(isContactPageDisplayed());
        Assert.assertEquals(countEnd-countStart,1);
        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName())); //if list contact with name + phone
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));
    }
}
