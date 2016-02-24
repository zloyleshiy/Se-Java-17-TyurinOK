package ru.st.selenium.applogic1;

import java.util.List;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;

public class FilmHelper1 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Film> search(String title) {
    // TODO Auto-generated method stub
    return null;
  }

@Override
public int getCountMovie() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public String getFilmTitle() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int getErrorsAddFilm() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public void delete(int rndMovie) {
	// TODO Auto-generated method stub
	
}

}
