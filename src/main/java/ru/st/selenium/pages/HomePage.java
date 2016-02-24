package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends InternalPage {

	public HomePage(PageManager pages) {
		super(pages);
	}

	@FindBy(className = "movie_box")
	private List<WebElement> allMovie;

	@FindBy(css = "nav a[href $= '?go=add']")
	private WebElement addFilmButton;

	@FindBy(css = "nav a[href $= '?go=imdbupdate']")
	private WebElement imdbUpdateButton;

	@FindBy(css = "nav a[href $= '?go=export']")
	private WebElement exportButton;

	@FindBy(className = "searchbox")
	private WebElement searchBoxField;

	public AddFilmPage clickAddFilmButton() {
		addFilmButton.click();
		return pages.addFilmPage;
	}
	
	public AboutFilmPage clickAboutFilm(int rndMovie) {
		WebElement aboutMovie = allMovie.get(rndMovie);
		aboutMovie.click();
		System.out.println("тыркнул в фильм");
		pages.aboutFilmPage.waitPageLoaded();
		return pages.aboutFilmPage.ensurePageLoaded();
		
	}
	
	public int countAllMovie(){
		if (this.allMovie.size()>0) return this.allMovie.size();
		else return 0;
	}

	public HomePage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("search")));
		return this;
	}

	
}
