package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//Класс для второй страницы пр кейсе заказ с кнопки Вверх
public class orderPage2 {
    private WebDriver driver;

    public orderPage2(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для поля Когда привезти самокат
    private static By DateButton = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    //Локатор для поля Срок аренды
    private static By rentDays = By.xpath(".//*[text()='* Срок аренды']");
    //Локатор для выбора срока аренды при тестировании первого набора данных
    private static By selectRentFive = By.xpath(".//*[text()='пятеро суток']");
    //Локатор для выбора срока аренды при тестировании второго набора данных
    private static By selectRentSeven = By.xpath(".//*[text()='семеро суток']");
    //Локатор для выбора цвета при тестировании второго набора данных
    private static By colorBlack = By.xpath(".//*[@id='black']");
    //Локатор для выбора цвета при тестировании кейса заказа с Нижней кнопкой
    private static By colorGrey = By.xpath(".//*[@id='grey']");
    //Локатор для поля Комментарий для курьера
    private static By Comment = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    //Локатор для кнопки Заказать на второй странице
    private static By ButtonOrder = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка на всплывающем окне "Хотите оформить заказ"
    private static By YesButton = By.xpath(".//*[text()='Да']");
    //Окно, которое появляется, когда нажимаешь Да на окне "Хотите оформить заказ"
    private static By OrderExist = By.xpath(".//*[text()= 'Заказ оформлен']");
    //Локатор даты 03.08.2024
    private static By selD = By.xpath(".//*[@aria-label='Choose суббота, 3-е августа 2024 г.']");

    //Метод проверки дейтпикер
    public String checkDatepicker() {
        driver.findElement(DateButton).click();
        driver.findElement(selD).click();
        String dateinBox = driver.findElement(DateButton).getAttribute("value");
        return dateinBox;
    }

    //Метод который вводит даты в строковом формате и сохраняет их в указанном поле
    public String chooseDate(String date) {
        if (date.equals("01.08.2024")) {
            WebElement dateBox = driver.findElement(DateButton);
            dateBox.sendKeys("01.08.2024");
            dateBox.sendKeys(Keys.ENTER);
        } else if (date.equals("02.08.2024")) {
            WebElement dateBox = driver.findElement(DateButton);
            dateBox.sendKeys("02.08.2024");
            dateBox.sendKeys(Keys.ENTER);
        }
        return date;
    }

    //Метод который выбирает количество дней аренды
    public String chooseRent(String rent) {
        driver.findElement(rentDays).click();
        if (rent.equals("пятеро суток")) {
            WebElement element = driver.findElement(selectRentFive);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        } else if (rent.equals("семеро суток")) {
            WebElement element = driver.findElement(selectRentSeven);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
        return rent;
    }

    //Метод который выбирает цвет самоката
    public String chooseColorSecond(String color) {
        if (color.equals("серая безысходность")) {
            driver.findElement(colorGrey).click();
        } else if (color.equals("черный жемчуг")) {
            driver.findElement(colorBlack).click();
        }
        return color;
    }

    //Метод который пишет комментарий
    public orderPage2 CommentSecond(String comment) {
        driver.findElement(Comment).sendKeys(comment);
        return this;
    }

    //Метод для нажатия кнопки Заказать
    public orderPage2 clickButtonOrderDown() {
        driver.findElement(ButtonOrder).click();
        return this;
    }

    //В окне хотите оформить заказ нажимаем Да
    public orderPage2 ClickYes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(YesButton).click();
        return this;

    }

    //Проверяем появляется ли окно об успешном создании заказа
    public boolean isOrderExistDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement OrderExistWindow =
                wait.until(ExpectedConditions.visibilityOfElementLocated(OrderExist));
        return OrderExistWindow.isDisplayed();
    }

    public orderPage2 loginSecondPage(String date, String color, String rent, String comment) {
        chooseDate(date);
        chooseRent(rent);
        chooseColorSecond(color);
        CommentSecond(comment);
        clickButtonOrderDown();
        ClickYes();
        return this;
    }
}
