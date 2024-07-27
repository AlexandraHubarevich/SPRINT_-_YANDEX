package PageObject;

import org.openqa.selenium.*;

import java.util.List;


//Класс для странцы которая открывается после нажатия кнопки Заказать
public class orderPage1 {


    private WebDriver driver;

    public orderPage1(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для поля Имя
    private static By nameloc = By.xpath(".//*[@placeholder='* Имя']");
    //Локатор для поля Фамилия
    private static By surNameloc = By.xpath(".//*[@placeholder='* Фамилия']");
    //Локатор для поля Адрес
    private static By addressloc = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор для поля Метро
    private static By subwayButton = By.xpath(".//*[@placeholder= '* Станция метро']");
    //Локатор для поля Телефон
    private static By phoneloc = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для выбора метро при тестировании кейса заказа с Верхней кнопкой
    private static By subwaySelectUpButton = By.xpath(".//*[text()='Сокол']");
    //Локатор для выбора метро при тестировании кейса заказа с Нижней кнопкой
    public static By subwaySelectDownButton = By.xpath(".//*[text()='Черкизовская']");
    //Локатор для кнопки Далее
    private static By fButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор для списка станций метро, где есть буква к
    private static By listOfSubways = By.cssSelector("li[class=select-search__row]");


    //Метод для заполнения поля Имя
    public orderPage1 setUsername(String name) {
        driver.findElement(nameloc).sendKeys(name);
        return this;
    }

    //Метод для заполнения поля Фамилия
    public orderPage1 setSurName(String surName) {
        driver.findElement(surNameloc).sendKeys(surName);
        return this;
    }

    //Метод для заполнения поля адрес
    public orderPage1 setAddressDown(String address) {
        driver.findElement(addressloc).sendKeys(address);
        return this;
    }

    //Метод для заполнения поля метро
    public String selectSubway(String subway) {
        driver.findElement(subwayButton).click();
        if (subway.equals("Черкизовская")) {
            WebElement element = driver.findElement(subwaySelectDownButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        } else if (subway.equals("Сокол")) {
            WebElement element = driver.findElement(subwaySelectUpButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
        return subway;
    }

    //Метод для заполнения поля Телефон
    public orderPage1 setPhone(String phone) {
        driver.findElement(phoneloc).sendKeys(phone);
        return this;
    }

    // Метод для нажатия кнопки Далее
    public orderPage1 clickFButtonDown() {
        driver.findElement(fButton).click();
        return this;
    }
    // Метод для проверк поля Метро, при вводе буквы К должны выводиться станции,содержащие К, среди них я выбираю любую, содержащую К, Крылатское
    public String checkSubway() {
        driver.findElement(subwayButton).click();
        driver.findElement(subwayButton).sendKeys("К");
        driver.findElements(listOfSubways);
        List<WebElement> values = driver.findElements(listOfSubways);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).getText().equals("Крылатское")) {
                values.get(i).click();
                break;
            }
        }
        String subway = driver.findElement(subwayButton).getAttribute("value");
        return subway;
    }

    //Конструктор для использования параметризации
    public orderPage1 loginFirstPage(String name, String surName, String address, String subway, String phone) {
        setUsername(name);
        setSurName(surName);
        setAddressDown(address);
        selectSubway(subway);
        setPhone(phone);
        clickFButtonDown();
        return this;
    }
}
