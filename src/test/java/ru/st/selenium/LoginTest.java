package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

/*@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
    baseUrl = "http://localhost";
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }*/

  @Test
  
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    WebElement usernameField = driver.findElement(By.id("username"));
	usernameField.clear();
    usernameField.sendKeys("admin");
    WebElement paswordField = driver.findElement(By.name("password"));
	paswordField.clear();
    paswordField.sendKeys("admin");
    driver.findElement(By.name("submit")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
