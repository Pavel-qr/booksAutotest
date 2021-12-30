package com.demoqa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * определение локатора имени пользователя
     */
    @FindBy(xpath = "//*[@id=\"userName-value\"]")
    private WebElement userName;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement logoutBtn;

    /**
     * метод для получения имени пользователя
     */
    public String getUserName() {
        String user = userName.getText();
        return user;
    }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click();
    }
}