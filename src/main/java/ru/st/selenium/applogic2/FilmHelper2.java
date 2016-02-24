package ru.st.selenium.applogic2;

import java.util.List;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

	public FilmHelper2(ApplicationManager2 manager) {
		super(manager.getWebDriver());
	}

	@Override
	public void create(Film film) {
		// TODO Auto-generated method stub
		pages.addFilmPage.setImdbidValue(film.getImdb());
		pages.addFilmPage.setTitleValue(film.getTitle());
		pages.addFilmPage.setYearsValue(film.getYear());
		pages.addFilmPage.setNotesValue(film.getNotes());
		pages.addFilmPage.clickSubmitButton();
	}

	@Override
	public void delete (int rndMovie) {
		pages.homePage.ensurePageLoaded().clickAboutFilm(rndMovie);
		pages.aboutFilmPage.ensurePageLoaded().clickDeleteFilmButton();
	}

	@Override
	public List<Film> search(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountMovie() {
		return pages.homePage.ensurePageLoaded().countAllMovie();
	}

	@Override
	public String getFilmTitle() {
		return pages.aboutFilmPage.ensurePageLoaded().getFilmHeader();
	}

	@Override
	public int getErrorsAddFilm() {
		return pages.addFilmPage.ensurePageLoaded().getErrorsCount();
	}


}
