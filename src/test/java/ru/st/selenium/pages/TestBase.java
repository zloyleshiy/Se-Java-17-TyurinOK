package ru.st.selenium.pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ru.st.selenium.applogic.ApplicationManager;
import ru.st.selenium.applogic0.ApplicationManager0;
import ru.st.selenium.applogic1.ApplicationManager1;
import ru.st.selenium.applogic2.ApplicationManager2;

public class TestBase {

  protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager2();
		
	}
	
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			return;
		}
		app.getUserHelper().logout();
	}
	
	@AfterSuite
	public void stop() {
	  app.stop();
	}

}
