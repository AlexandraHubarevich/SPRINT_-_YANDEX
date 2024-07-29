import org.junit.Before;
import pageobject.MainPage;
import pageobject.OrderPageFirst;
import pageobject.OrderPageSecond;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Parameterized.class)
public class OrderPageTestChrome {

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

    public OrderPageTestChrome(String name, String surName, String address, String subway, String phone, String date, String color, String rent, String comment) {
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
    @Before
    public void start(){
        driver = new ChromeDriver();

    }

    @After
    public void after() {
        driver.quit();
    }

    //Тест для проверкки всех кейсов, запуск с кнопки заказать, что расположена вверху
    @Test
    public void pageFirstTestUseUpperButton() {
        MainPage openPage = new MainPage(driver);
        openPage.openPageToOrderUseUpperButton();

        OrderPageFirst orderPage1Test = new OrderPageFirst(driver);
        orderPage1Test.loginFirstPage(name, surName, address, subway, phone);

        OrderPageSecond orderPage2Test = new OrderPageSecond(driver);
        orderPage2Test.loginSecondPage(date, color, rent, comment);
        Assert.assertTrue(orderPage2Test.isOrderExistDisplayed());
    }

    //Тест для проверкки всех кейсов, запуск с кнопки заказать, что расположена внизу
    @Test
    public void pageFirstTestUseDownButton() {
        MainPage openPage = new MainPage(driver);
        openPage.openPageToOrderUseDownButton();
        OrderPageFirst orderPage1Test = new OrderPageFirst(driver);
        orderPage1Test.loginFirstPage(name, surName, address, subway, phone);

        OrderPageSecond orderPage2Test = new OrderPageSecond(driver);
        orderPage2Test.loginSecondPage(date, color, rent, comment);
        Assert.assertTrue(orderPage2Test.isOrderExistDisplayed());
    }

}
