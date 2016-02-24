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

	// корректное добавление фильма
	@Test
	public void testAddCinemaOK() throws Exception {

		int countMovie = 0;
		Film newFilm = new Film();
		String title = "title" + System.currentTimeMillis();
		String imdb = "imdb";
		int yearsValue = app.getMathHelper().getRandomInt(1900, 2016);
		String notes = "notes";

		// Вход в систему
		app.getUserHelper().loginAs(User.ADMIN);

		// считаем количество имеющихся фильмов
		countMovie = app.getFilmHelper().getCountMovie();
		// заполняем данными фильм
		newFilm.setTitle(title);// генерируем
								// уникальный
								// титл
		newFilm.setImdb(Integer.toString(countMovie));
		newFilm.setYear(Integer.toString(yearsValue));
		newFilm.setNotes("какието записки о фильма" + countMovie);

		// переход на страницу добавления
		app.getNavigationHelper().gotoAddFilmPage();
		app.getFilmHelper().create(newFilm);
		assertTrue(app.getFilmHelper().getFilmTitle().contains(newFilm.getTitle()));

		// проверка что отображается созданный фильм
		app.getNavigationHelper().gotoHomePage();

		assertTrue(app.getFilmHelper().getCountMovie() > countMovie);
		if (app.getFilmHelper().getCountMovie() > countMovie)
			System.out.println("новый фильм добавлен");
		else
			Assert.fail("чтото пошло не так, при добавлении фильма");
		
		//app.getUserHelper().logout();
	}

	// НЕкорректное добавление
	
	
	@Test
	public void TestAddCinemaFail() throws Exception{
		app.getUserHelper().loginAs(User.ADMIN);
		// переход на страницу добавления
		app.getNavigationHelper().gotoAddFilmPage();

		//готовим данные
		int countMovie = 0;
		Film newFilm = new Film();
		String title = "";
		String imdb = "imdb";
		int yearsValue = app.getMathHelper().getRandomInt(1900, 2016);
		String notes = "notes";
		
		app.getFilmHelper().create(newFilm);
		assertTrue(app.getFilmHelper().getErrorsAddFilm() > 0);
		if (app.getFilmHelper().getErrorsAddFilm() > 0)
			System.out.println("НЕ корректный новый фильм НЕ добавлен");
		else
			System.out.println("чтото пошло не так, при НЕ корректном добавлении фильма");
		
		//app.getUserHelper().logout();

	}
	
}
