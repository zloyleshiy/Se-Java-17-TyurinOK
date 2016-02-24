package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.Page;
import ru.st.selenium.pages.TestBase;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDeleteCinema extends TestBase {
	

	@Test
	public void TestDeleteCinemaOK() throws Exception {

		int countMovie = 0;
		int rndMovie = 0;

		// ���� � �������
		app.getUserHelper().loginAs(User.ADMIN);

		// ������� ���������� ��������� �������
		countMovie = app.getFilmHelper().getCountMovie();
		
		if (countMovie == 0)
			Assert.fail("��� ������� ��� ��������");
		else {

			// �������� ����� ��� �������� (���������)
			rndMovie = app.getMathHelper().getRandomInt(0, countMovie);
			app.getFilmHelper().delete(rndMovie);
			
			if (app.getFilmHelper().getCountMovie() < countMovie)
				System.out.println("����� ��������");
			else
				Assert.fail("����� ����� �� ���, ��� �������� ������");
		}
	}

}
