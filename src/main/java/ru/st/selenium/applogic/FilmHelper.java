package ru.st.selenium.applogic;

import java.util.List;

import ru.st.selenium.model.Film;

public interface FilmHelper {

	void create(Film film);
	void delete(int rndMovie);
	List<Film> search(String title);
	int getCountMovie();
	String getFilmTitle();
	int getErrorsAddFilm();

}
