package ru.st.selenium.applogic2;

import org.openqa.selenium.WebDriver;

import ru.st.selenium.applogic.ApplicationManager;
import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.applogic.NavigationHelper;
import ru.st.selenium.applogic.UserHelper;
import ru.st.selenium.util.Browser;
import ru.st.selenium.util.PropertyLoader;
import ru.st.selenium.webdriver.WebDriverFactory;

public class ApplicationManager2 implements ApplicationManager {

  private UserHelper userHelper;
  private FilmHelper filmHelper;
  private NavigationHelper navHelper;

  private WebDriver driver;
  private String baseUrl;
  private MathHelper mathHelper;
  
  public ApplicationManager2() {
    baseUrl = PropertyLoader.loadProperty("site.url");
    String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

    Browser browser = new Browser();
    browser.setName(PropertyLoader.loadProperty("browser.name"));
    browser.setVersion(PropertyLoader.loadProperty("browser.version"));
    browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

    String username = PropertyLoader.loadProperty("user.username");
    String password = PropertyLoader.loadProperty("user.password");
    
    driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
    // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    userHelper = new UserHelper2(this);
    filmHelper = new FilmHelper2(this);
    navHelper = new NavigationHelper2(this);
    mathHelper = new MathHelper(this);

    getNavigationHelper().openMainPage();
  }
  
  @Override
  public UserHelper getUserHelper() {
    return userHelper;
  }

  @Override
  public FilmHelper getFilmHelper() {
    return filmHelper;
  }

  @Override
  public NavigationHelper getNavigationHelper() {
    return navHelper;
  }
  
  @Override
  public MathHelper getMathHelper(){
	  return mathHelper;
  }

  protected WebDriver getWebDriver() {
    return driver;
  }

  protected String getBaseUrl() {
    return baseUrl;
  }

  @Override
  public void stop() {
    if (driver != null) {
      driver.quit();
    }
  }

}
