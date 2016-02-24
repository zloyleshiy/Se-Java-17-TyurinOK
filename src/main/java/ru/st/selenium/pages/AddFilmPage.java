package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddFilmPage extends InternalPage {

	public AddFilmPage(PageManager pages) {
		super(pages);
	}

	@FindBy(name = "imdbid")
	private WebElement imdbidValue;
	
	@FindBy(name = "name")
	private WebElement titleValue;
	
	@FindBy(name = "aka")
	private WebElement aka;
	
	@FindBy(name = "year")
	private WebElement yearsValue;
	
	@FindBy(name = "duration")
	private WebElement surationValue;
	
	@FindBy(name = "rating")
	private WebElement ratingValue;
	
	@FindBy(id="own_no")
	private WebElement ownNowCheck;
	
	@FindBy(id="seen_no")
	private WebElement seenNoCheck;
	
	@FindBy(name = "notes")
	private WebElement notesValue;
	
	@FindBy(name = "taglineValue")
	private WebElement taglineValue;
	
	@FindBy(name = "plotoutline")
	private WebElement plotoutlineValue;
	
	@FindBy(name = "plotsValue")
	private WebElement plotsValue;
	
	@FindBy(id = "text_languages_0")
	private WebElement languageValue;
	
	@FindBy(name = "subtitles")
	private WebElement subtitlesValue;
	
	@FindBy(name = "audioValue")
	private WebElement audioValue;
	
	@FindBy(name = "videoValue")
	private WebElement videoValue;
	
	@FindBy(name = "countryValue")
	private WebElement countryValue;
	
	@FindBy(name = "genres")
	private WebElement genresValue;
	
	@FindBy(name = "director")
	private WebElement directorValue;
	
	@FindBy(name = "writer")
	private WebElement writerValue;
	
	@FindBy(name = "producer")
	private WebElement producerValue;
	
	@FindBy(name = "music")
	private WebElement musicValue;
	
	@FindBy(name = "cast")
	private WebElement castValue;

	@FindBy(id = "submit")
	private WebElement submitButton;
	
	@FindBy (className = "error")
	private List<WebElement> errors;
	
	public String getImdbidValue() {
		return imdbidValue.getText();
	}
	
	public AddFilmPage setImdbidValue(String text) {
		imdbidValue.sendKeys(text);
		return this;
	}
	
	public String getTitleValue() {
		return titleValue.getText();
	}
	
	public AddFilmPage setTitleValue(String text) {
		titleValue.sendKeys(text);
		return this;
	}
	
	public String getAka() {
		return aka.getText();
	}
	
	public AddFilmPage setAka(String text) {
		aka.sendKeys(text);
		return this;
	}
	
	public String getYearsValue() {
		return yearsValue.getText();
	}
	
	public AddFilmPage setYearsValue(String text) {
		yearsValue.sendKeys(text);
		return this;
	}
	
	public String getSurationValue() {
		return surationValue.getText();
	}
	
	public AddFilmPage setSurationValue(String text) {
		surationValue.sendKeys(text);
		return this;
	}
	
	public String getRatingValue() {
		return ratingValue.getText();
	}
	
	public AddFilmPage setRatingValue(String text) {
		ratingValue.sendKeys(text);
		return this;
	}
	
	public boolean getOwnNowCheck() {
		return ownNowCheck.isSelected();
	}
	
	public AddFilmPage setOwnNowCheck() {
		ownNowCheck.click();
		return this;
	}
	
	public boolean getSeenNoCheck() {
		return seenNoCheck.isSelected();
	}
	
	public AddFilmPage setSeenNoCheck() {
		seenNoCheck.click();
		return this;
	}
	
	public String getNotesValue() {
		return notesValue.getText();
	}
	
	public AddFilmPage setNotesValue(String text) {
		notesValue.sendKeys(text);
		return this;
	}
	
	public String getTaglineValue() {
		return taglineValue.getText();
	}
	
	public AddFilmPage setTaglineValue(String text) {
		taglineValue.sendKeys(text);
		return this;
	}
	
	public String getPlotoutlineValue() {
		return plotoutlineValue.getText();
	}
	
	public AddFilmPage setPlotoutlineValue(String text) {
		plotoutlineValue.sendKeys(text);
		return this;
	}
	
	public String getPlotsValue() {
		return plotsValue.getText();
	}
	
	public AddFilmPage setPlotsValue(String text) {
		plotsValue.sendKeys(text);
		return this;
	}
	
	public String getLanguageValue() {
		return languageValue.getText();
	}
	
	public AddFilmPage setLanguageValue(String text) {
		languageValue.sendKeys(text);
		return this;
	}
	
	public String getSubtitlesValue() {
		return subtitlesValue.getText();
	}
	
	public AddFilmPage setSubtitlesValue(String text) {
		subtitlesValue.sendKeys(text);
		return this;
	}
	
	public String getAudioValue() {
		return audioValue.getText();
	}
	
	public AddFilmPage setAudioValue(String text) {
		audioValue.sendKeys(text);
		return this;
	}
	
	public String getVideoValue() {
		return videoValue.getText();
	}
	
	public AddFilmPage setVideoValue(String text) {
		videoValue.sendKeys(text);
		return this;
	}
	
	public String getCountryValue() {
		return countryValue.getText();
	}
	
	public AddFilmPage setCountryValue(String text) {
		countryValue.sendKeys(text);
		return this;
	}
	
	public String getGenresValue() {
		return genresValue.getText();
	}
	
	public AddFilmPage setGenresValue(String text) {
		genresValue.sendKeys(text);
		return this;
	}
	
	public String getDirectorValue() {
		return directorValue.getText();
	}
	
	public AddFilmPage setDirectorValue(String text) {
		directorValue.sendKeys(text);
		return this;
	}
	
	public String getWriterValue() {
		return writerValue.getText();
	}
	
	public AddFilmPage setWriterValue(String text) {
		writerValue.sendKeys(text);
		return this;
	}
	
	public String getProducerValue() {
		return producerValue.getText();
	}
	
	public AddFilmPage setProducerValue(String text) {
		producerValue.sendKeys(text);
		return this;
	}
	
	public String getMusicValue() {
		return musicValue.getText();
	}
	
	public AddFilmPage setMusicValue(String text) {
		musicValue.sendKeys(text);
		return this;
	}
	
	public String getCastValue() {
		return castValue.getText();
	}
	
	public AddFilmPage setCastValue(String text) {
		castValue.sendKeys(text);
		return this;
	}
	
	public String getSubmitButtonText() {
		return submitButton.getText();
	}
	
	public AddFilmPage clickSubmitButton() {
		submitButton.click();
		return this;
	}
	
	public int getErrorsCount() {
		return errors.size();
	}

	public AddFilmPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("imdbsearchform")));
		return this;
	}
}
