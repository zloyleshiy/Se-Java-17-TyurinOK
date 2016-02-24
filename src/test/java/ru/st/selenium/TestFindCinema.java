package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestFindCinema extends TestBase {

	@Test
	public void testUntitled() throws Exception {

		String findText;
		int countMovie = 0;
		int rndMovie = 0;
		// ���� � �������
		app.getUserHelper().loginAs(User.ADMIN);
		// ������� ���������� ��������� �������
		countMovie = app.getFilmHelper().getCountMovie();
		if (countMovie == 0)
			Assert.fail("��� ������� ��� ������");
		else {

			// �������� ����� ��� �������� (���������)
			rndMovie = (int) (Math.random() * (countMovie + 1));
			findMovie = allMovie.get(rndMovie);

			// ����� ��� ������
			findText = findMovie.findElement(By.className("title")).getText();
			// ���� ���� - ������ �������

			driver.findElement(By.id("q")).clear();
			driver.findElement(By.id("q")).sendKeys(findText + Keys.RETURN);

			allMovie = driver.findElements(By.className("movie_box"));
			if (allMovie.size() > 0)
				System.out.println("����� �������");
			else
				System.out.println("����� ����� �� ���, ��� ������ ������");

			// ���� ���� - �� ������ �������
			driver.findElement(By.id("q")).clear();
			findText = "������ �� �������";
			driver.findElement(By.id("q")).sendKeys(findText + Keys.RETURN);

			if (driver.findElement(By.className("content")).getText().equals("No movies where found."))
				System.out.println("����� ������� �� �������");
			else
				System.out.println("����� ����� �� ���, ��� ������ ������, ������� �� ������ ��� �������");
		}

	}

}
