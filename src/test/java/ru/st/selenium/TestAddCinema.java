package ru.st.selenium;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.junit.Assert.*;

import ru.st.selenium.model.*;

public class TestAddCinema extends ru.st.selenium.pages.TestBase {

	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			return;
		}
		app.getUserHelper().logout();
	}

	// ���������� ���������� ������
	@Test
	public void testAddCinemaOK() throws Exception {

		int countMovie = 0;
		Film newFilm = new Film();
		String title = "title" + System.currentTimeMillis();
		String imdb = "imdb";
		int yearsValue = app.getMathHelper().getRandomInt(1900, 2016);
		String notes = "notes";

		// ���� � �������
		app.getUserHelper().loginAs(User.ADMIN);

		// ������� ���������� ��������� �������
		countMovie = app.getFilmHelper().getCountMovie();
		// ��������� ������� �����
		newFilm.setTitle(title);// ����������
								// ����������
								// ����
		newFilm.setImdb(Integer.toString(countMovie));
		newFilm.setYear(Integer.toString(yearsValue));
		newFilm.setNotes("������� ������� � ������" + countMovie);

		// ������� �� �������� ����������
		app.getNavigationHelper().gotoAddFilmPage();
		app.getFilmHelper().create(newFilm);
		assertTrue(app.getFilmHelper().getFilmTitle().contains(newFilm.getTitle()));

		// �������� ��� ������������ ��������� �����
		app.getNavigationHelper().gotoHomePage();

		assertTrue(app.getFilmHelper().getCountMovie() > countMovie);
		if (app.getFilmHelper().getCountMovie() > countMovie)
			System.out.println("����� ����� ��������");
		else
			Assert.fail("����� ����� �� ���, ��� ���������� ������");
		
		//app.getUserHelper().logout();
	}

	// ������������ ����������
	
	
	@Test
	public void TestAddCinemaFail() throws Exception{
		app.getUserHelper().loginAs(User.ADMIN);
		// ������� �� �������� ����������
		app.getNavigationHelper().gotoAddFilmPage();

		//������� ������
		int countMovie = 0;
		Film newFilm = new Film();
		String title = "";
		String imdb = "imdb";
		int yearsValue = app.getMathHelper().getRandomInt(1900, 2016);
		String notes = "notes";
		
		app.getFilmHelper().create(newFilm);
		assertTrue(app.getFilmHelper().getErrorsAddFilm() > 0);
		if (app.getFilmHelper().getErrorsAddFilm() > 0)
			System.out.println("�� ���������� ����� ����� �� ��������");
		else
			System.out.println("����� ����� �� ���, ��� �� ���������� ���������� ������");
		
		//app.getUserHelper().logout();

	}
	
}
