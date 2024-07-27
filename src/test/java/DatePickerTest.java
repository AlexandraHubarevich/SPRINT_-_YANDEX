import PageObject.mainPage;
import PageObject.orderPage1;
import PageObject.orderPage2;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class DatePickerTest {

    private WebDriver driver;
    String dateExpected = "03.08.2024";
    private final String name;
    private final String surName;
    private final String address;
    private final String subway;
    private final String phone;

    public DatePickerTest(String name, String surName, String address, String subway, String phone) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.subway = subway;
        this.phone = phone;
    }

    // использовала для доступа ко второй странице заказа
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Игорь", "Игорев", "Москва, пер.Конюшенный, д. 23", "Черкизовская", "975477885871"},
        };
    }

    @After
    public void after() {
        driver.quit();
    }

    //Метод проверяет, что выбранная в календаре дата сохраняется в правильном формате
    @Test
    public void datePickerTest() {
        driver = new ChromeDriver();
        mainPage DatePick = new mainPage(driver);
        DatePick.openPageToOrderUseUpperButton();
        orderPage1 DatePick1 = new orderPage1(driver);
        DatePick1.loginFirstPage(name, surName, address, subway, phone);
        orderPage2 DatePick2 = new orderPage2(driver);
        DatePick2.checkDatepicker();
        assertEquals("DatesAreEqual", dateExpected, DatePick2.checkDatepicker());
    }

}