package com.demoqa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class LoginTest extends Assert{
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static BooksPage booksPage;
    public static WebDriver driver;
    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        booksPage = new BooksPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void profileTest() {
        driver.get(ConfProperties.getProperty("loginPage"));
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
        profilePage.userLogout();
    }
    /**
     * тестовый метод для проверки страницы Book Store
     */
    @Test
    public void bookStoreTest() {
        driver.get(ConfProperties.getProperty("bookPage"));
        booksPage.changeRowList(ConfProperties.getProperty("rowCount"));
        String rowCount = booksPage.rowQuantity();
        Assert.assertEquals(ConfProperties.getProperty("rowCount"), rowCount);
        booksPage.inputSearch(ConfProperties.getProperty("search"));
        String search = booksPage.getSearchResult();
        booksPage.clickNext();
        booksPage.clickPrevious();
    }
    /**
     * закрытие окна браузера
     */
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
