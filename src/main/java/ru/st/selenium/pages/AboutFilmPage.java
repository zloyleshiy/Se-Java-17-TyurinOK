package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AboutFilmPage extends InternalPage {

	public AboutFilmPage(PageManager pages) {
		super(pages);
	}


	@FindBy(xpath = "/html/body/div/div/div/section/nav/ul/li[4]/div/div/a/img")
	private WebElement deleteFilmButton;

	
	@FindBy(className = "maininfo_full")
	private WebElement aboutFilm;
	
	public String getFilmHeader(){
		return aboutFilm.findElement(By.tagName("h2")).getText();
	}
	
	
	public void clickDeleteFilmButton(){
		deleteFilmButton.click();
		System.out.println("тыркнул кнопку удалить");
		assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
		System.out.println("ассерт закрыли");
	}


	public AboutFilmPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.xpath("/html/body/div/div/div/section/nav/ul/li[4]/div/div/a/img"))).isDisplayed();
		return this;
	}
}
