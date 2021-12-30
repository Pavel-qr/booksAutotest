package com.demoqa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BooksPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public BooksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * определение локатора поля для поиска
     */
    @FindBy(xpath = "//*[@id=\"searchBox\"]")
    private WebElement searchField;
    /**
     * определение локатора выпадющего списка
     */
    @FindBy(xpath = "//*[@aria-label=\"rows per page\"]")
    private WebElement selectElement;
    /**
     * определение локатора кнопки "Previous"
     */
    @FindBy(xpath = "//*[@class=\"-previous\"]/button")
    private WebElement previousBtn;
    /**
     * определение локатора кнопки "Next"
     */
    @FindBy(xpath = "//*[@class=\"-next\"]/button")
    private WebElement nextBtn;
    /**
     * метод для ввода поискового запроса
     */
    public void inputSearch(String search) {
        searchField.sendKeys(search);
    }
    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getSearchResult() {
        String search = searchField.getText();
        return search;
    }
    /**
     * метод для нажатия на кнопку списка
     */
    public void changeRowList(String rowCount) {
        Select rowList = new Select(selectElement);
        rowList.selectByValue(rowCount);
    }
    /**
     * метод для подсчета книг на странице
     */
    public String rowQuantity() {
        WebElement element = driver.findElement(By.className("rt-tbody"));
        String count = element.getAttribute("childElementCount");
        return count;
    }
    /**
     * метод для нажатия кнопки "Previous"
     */
    public void clickPrevious() {
        previousBtn.click();
    }
    /**
     * метод для нажатия кнопки "Next"
     */
    public void clickNext() {
        nextBtn.click();
    }
}