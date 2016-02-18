package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAddCinema extends TestBase {
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

/*  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }*/

  @Test
  public void testUntitled() throws Exception {
    
    String imdbidValue = "IMDb Number";
    String titleValue = "Title";
    String aka = "Also known as";
    String yearsValue = "1900";
    String surationValue = "180";
    String ratingValue = "1";
    String notesValue = "personal notes";
    String taglineValue = "taglines";
	String plotoutlineValue = "plot outline";
    String plotsValue = "plots";
    String languageValue = "Languages";
    String subtitlesValue = "Subtitles";
    String audioValue = "audio";
    String videoValue = "video";
    String countryValue = "country";
    String genresValue = "Genres";
    String directorValue = "Director";
    String writerValue = "Writer";
    String producerValue = "Producer";
    String musicValue = "Music";
    String castValue = "Cast";
    List<WebElement> allMovie;
    int countMovie = 0;
    
    //Вход в систему
    driver.get(baseUrl + "/php4dvd/");
    WebElement usernameField = driver.findElement(By.id("username"));
	usernameField.clear();
    usernameField.sendKeys("admin");
    WebElement paswordField = driver.findElement(By.name("password"));
	paswordField.clear();
    paswordField.sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    
    //считаем количество имеющихся фильмов
  	allMovie = driver.findElements(By.className("movie_box"));
    countMovie = allMovie.size();  
    titleValue +=(countMovie+1);//увеличиваем число в титле
    
    //корректное добавление
    //переход на страницу добавления    
	driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click(); 
	
	    
    driver.findElement(By.name("imdbid")).clear();
    driver.findElement(By.name("imdbid")).sendKeys(imdbidValue);
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys(titleValue); //увеличиваем число в титле
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys(aka);
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys(yearsValue);
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys(surationValue);
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys(ratingValue);
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys(notesValue);
    driver.findElement(By.name(taglineValue)).clear();
    driver.findElement(By.name(taglineValue)).sendKeys(taglineValue);
    driver.findElement(By.name("plotoutline")).clear();
    driver.findElement(By.name("plotoutline")).sendKeys(plotoutlineValue);
    driver.findElement(By.name(plotsValue)).clear();
    driver.findElement(By.name(plotsValue)).sendKeys(plotsValue);
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys(languageValue);
    driver.findElement(By.name("subtitles")).clear();
    driver.findElement(By.name("subtitles")).sendKeys(subtitlesValue);
    driver.findElement(By.name(audioValue)).clear();
    driver.findElement(By.name(audioValue)).sendKeys(audioValue);
    driver.findElement(By.name(videoValue)).clear();
    driver.findElement(By.name(videoValue)).sendKeys(videoValue);
    driver.findElement(By.name(countryValue)).clear();
    driver.findElement(By.name(countryValue)).sendKeys(countryValue);
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys(genresValue);
    driver.findElement(By.name("director")).clear();
    driver.findElement(By.name("director")).sendKeys(directorValue);
    driver.findElement(By.name("writer")).clear();
    driver.findElement(By.name("writer")).sendKeys(writerValue);
    driver.findElement(By.name("producer")).clear();
    driver.findElement(By.name("producer")).sendKeys(producerValue);
    driver.findElement(By.name("music")).clear();
    driver.findElement(By.name("music")).sendKeys(musicValue);
    driver.findElement(By.name("cast")).clear();
    driver.findElement(By.name("cast")).sendKeys(castValue);
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.name("imdbid")).clear();
    driver.findElement(By.name("imdbid")).sendKeys(ratingValue);
    driver.findElement(By.id("submit")).click();
    
    //проверка что отображается созданный элемент
    driver.findElement(By.linkText("Home")).click();
    
    allMovie = driver.findElements(By.className("movie_box"));
        
    if (allMovie.size()> countMovie) System.out.println("новый фильм добавлен");
    else System.out.println("чтото пошло не так, при добавлении фильма");
    
    
    //НЕкорректное добавление
    //переход на страницу добавления    
	driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click(); 
		    
    driver.findElement(By.name("imdbid")).clear();
    driver.findElement(By.name("imdbid")).sendKeys(imdbidValue);
    driver.findElement(By.name("name")).clear();
    //Незаполняем title
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys(aka);
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys(yearsValue);
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys(surationValue);
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys(ratingValue);
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys(notesValue);
    driver.findElement(By.name(taglineValue)).clear();
    driver.findElement(By.name(taglineValue)).sendKeys(taglineValue);
    driver.findElement(By.name("plotoutline")).clear();
    driver.findElement(By.name("plotoutline")).sendKeys(plotoutlineValue);
    driver.findElement(By.name(plotsValue)).clear();
    driver.findElement(By.name(plotsValue)).sendKeys(plotsValue);
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys(languageValue);
    driver.findElement(By.name("subtitles")).clear();
    driver.findElement(By.name("subtitles")).sendKeys(subtitlesValue);
    driver.findElement(By.name(audioValue)).clear();
    driver.findElement(By.name(audioValue)).sendKeys(audioValue);
    driver.findElement(By.name(videoValue)).clear();
    driver.findElement(By.name(videoValue)).sendKeys(videoValue);
    driver.findElement(By.name(countryValue)).clear();
    driver.findElement(By.name(countryValue)).sendKeys(countryValue);
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys(genresValue);
    driver.findElement(By.name("director")).clear();
    driver.findElement(By.name("director")).sendKeys(directorValue);
    driver.findElement(By.name("writer")).clear();
    driver.findElement(By.name("writer")).sendKeys(writerValue);
    driver.findElement(By.name("producer")).clear();
    driver.findElement(By.name("producer")).sendKeys(producerValue);
    driver.findElement(By.name("music")).clear();
    driver.findElement(By.name("music")).sendKeys(musicValue);
    driver.findElement(By.name("cast")).clear();
    driver.findElement(By.name("cast")).sendKeys(castValue);
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.name("imdbid")).clear();
    driver.findElement(By.name("imdbid")).sendKeys(ratingValue);
    driver.findElement(By.id("submit")).click();
    
    if (driver.findElement(By.id("submit")).isEnabled())System.out.println("НЕ корректный новый НЕ фильм добавлен");
    else System.out.println("чтото пошло не так, при НЕ корректном добавлении фильма");
    
  }

  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
