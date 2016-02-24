package ru.st.selenium;

import org.testng.annotations.*;
import static org.junit.Assert.*;

import ru.st.selenium.model.User;

public class LoginTest extends ru.st.selenium.pages.TestBase {

  @BeforeMethod  
  public void mayBeLogout() {
    if (app.getUserHelper().isNotLoggedIn()) {
      return;
    }
    app.getUserHelper().logout();
  }
  
  @Test
  public void testLoginOK() throws Exception {
    app.getUserHelper().loginAs(User.ADMIN);
    assertTrue(app.getUserHelper().isLoggedInAs(User.ADMIN));
  }

  @Test
  public void testLoginFailed() throws Exception {
    User user = new User().setLogin("admin").setPassword("wrong");
    app.getUserHelper().loginAs(user);
    // assertFalse(app.getUserHelper().isLoggedIn());
    assertTrue(app.getUserHelper().isNotLoggedIn());
  }

}
