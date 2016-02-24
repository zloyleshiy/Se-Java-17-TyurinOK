package ru.st.selenium.applogic;

import ru.st.selenium.applogic2.MathHelper;

public interface ApplicationManager {

	UserHelper getUserHelper();
	FilmHelper getFilmHelper();
	NavigationHelper getNavigationHelper();
	MathHelper getMathHelper();

  void stop();

}
