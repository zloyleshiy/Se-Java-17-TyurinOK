package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestFindCinema extends TestBase {
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	/*
	 * @BeforeClass(alwaysRun = true) public void setUp() throws Exception {
	 * driver = new FirefoxDriver(); baseUrl = "http://localhost/";
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); }
	 */

	@Test
	public void testUntitled() throws Exception {

		List<WebElement> allMovie;
		WebElement findMovie;
		String findText;
		int countMovie = 0;
		int rndMovie = 0;

		// Вход в систему
		driver.get(baseUrl + "/php4dvd/");
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.clear();
		usernameField.sendKeys("admin");
		WebElement paswordField = driver.findElement(By.name("password"));
		paswordField.clear();
		paswordField.sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// считаем количество имеющихся фильмов
		allMovie = driver.findElements(By.className("movie_box"));
		if (allMovie.size() == 0)
			System.out.println("нет фильмов для поиска");
		else {

			// выбираем фильм для удаления (случайный)
			rndMovie = (int) (Math.random() * (countMovie + 1));
			findMovie = allMovie.get(rndMovie);

			// текст для поиска
			findText = findMovie.findElement(By.className("title")).getText();
			// Ищем кино - должно найтись

			driver.findElement(By.id("q")).clear();
			driver.findElement(By.id("q")).sendKeys(findText + Keys.RETURN);

			allMovie = driver.findElements(By.className("movie_box"));
			if (allMovie.size() > 0)
				System.out.println("Фильм нашелся");
			else
				System.out.println("чтото пошло не так, при поиске фильма");

			
			// Ищем кино - НЕ должно найтись
			driver.findElement(By.id("q")).clear();
			findText = "ничего не найдено";
			driver.findElement(By.id("q")).sendKeys(findText + Keys.RETURN);

			if (driver.findElement(By.className("content")).getText().equals("No movies where found."))
				System.out.println("Фильм успешно не нашелся");
			else
				System.out.println("чтото пошло не так, при поиске фильма, который не должен был найтись");
		}

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
