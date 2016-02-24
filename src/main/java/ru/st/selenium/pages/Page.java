package ru.st.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Abstract class representation of a Page in the UI. Page object pattern
 * 
 * @author Sebastiano Armeli-Battana
 */
public abstract class Page {

	private boolean acceptNextAlert = true;
	protected WebDriver driver;
  protected WebDriverWait wait;
  protected PageManager pages;

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(PageManager pages) {
	  this.pages = pages;
    driver = pages.getWebDriver();
    wait= new WebDriverWait(driver, 10); 
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public Page ensurePageLoaded() {
	  return this;
	}

  public boolean waitPageLoaded() {
    try {
      ensurePageLoaded();
      return true;
    } catch (TimeoutException to) {
      return false;
    }
  }
  
  public String closeAlertAndGetItsText() {
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
