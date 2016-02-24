package ru.st.selenium.applogic;

public interface NavigationHelper {

	void openMainPage();

	void openRelativeUrl(String url);

	void gotoUserProfilePage();

	void gotoUserManagementPage();

	void gotoAddFilmPage();

	void gotoHomePage();

	void gotoAboutFilmPage(int filmId);

}
