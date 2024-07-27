import PageObject.mainPage;
import PageObject.orderPage1;
import PageObject.orderPage2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



@RunWith(Parameterized.class)
public class orderPage1Test {
    private WebDriver driver;

    private final String name;
    private final String surName;
    private final String address;
    private final String subway;
    private final String phone;
    private final String color;
    private final String date;
    private final String rent;
    private final String comment;
    public orderPage1Test(String name, String surName, String address, String subway, String phone, String date, String color, String rent, String comment) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.subway = subway;
        this.phone = phone;
        this.date = date;
        this.color = color;
        this.rent = rent;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Игорь", "Игорев", "Москва, пер.Конюшенный, д. 23", "Черкизовская", "975477885871", "01.08.2024", "серая безысходность", "пятеро суток", "LookingForward"},
                {"Иван", "Иванов", "Москва, Третья улица Строителей.д. 6", "Сокол", "975477885071", "02.08.2024", "черный жемчуг", "семеро суток", "ASAP"}
        };
    }

    @After
    public void after() {
        driver.quit();
    }
    //Тест для проверкки всех кейсов, запуск с кнопки заказать, что расположена вверху
    @Test
    public void pageFirstTestUseUpperButton() {
        driver = new ChromeDriver();
        mainPage openPage = new mainPage(driver);
        openPage.openPageToOrderUseUpperButton();

        orderPage1 orderPage1Test = new orderPage1(driver);
        orderPage1Test.loginFirstPage(name, surName, address, subway, phone);

        orderPage2 orderPage2Test = new orderPage2(driver);
        orderPage2Test.loginSecondPage(date, color, rent, comment);
        Assert.assertTrue(orderPage2Test.isOrderExistDisplayed());
    }
    //Тест для проверкки всех кейсов, запуск с кнопки заказать, что расположена внизу
    @Test
    public void pageFirstTestUseDownButton() {
        driver = new ChromeDriver();
        mainPage openPage = new mainPage(driver);
        openPage.openPageToOrderUseDownButton();

        orderPage1 orderPage1Test = new orderPage1(driver);
        orderPage1Test.loginFirstPage(name, surName, address, subway, phone);

        orderPage2 orderPage2Test = new orderPage2(driver);
        orderPage2Test.loginSecondPage(date, color, rent, comment);
        Assert.assertTrue(orderPage2Test.isOrderExistDisplayed());
    }
    //Те же методы, но уже в Файерфоксе
    @Test
    public void pageFirstTestUseUpperButtonFirefox() {
        driver = new FirefoxDriver();
        mainPage openPage = new mainPage(driver);
        openPage.openPageToOrderUseUpperButton();

        orderPage1 orderPage1Test = new orderPage1(driver);
        orderPage1Test.loginFirstPage(name, surName, address, subway, phone);

        orderPage2 orderPage2Test = new orderPage2(driver);
        orderPage2Test.loginSecondPage(date, color, rent, comment);
        Assert.assertTrue(orderPage2Test.isOrderExistDisplayed());
    }
    @Test
    public void pageFirstTestUseDownButtonFirefox() {
        driver = new FirefoxDriver();
        mainPage openPage = new mainPage(driver);
        openPage.openPageToOrderUseDownButton();

        orderPage1 orderPage1Test = new orderPage1(driver);
        orderPage1Test.loginFirstPage(name, surName, address, subway, phone);

        orderPage2 orderPage2Test = new orderPage2(driver);
        orderPage2Test.loginSecondPage(date, color, rent, comment);
        Assert.assertTrue(orderPage2Test.isOrderExistDisplayed());
    }

}
