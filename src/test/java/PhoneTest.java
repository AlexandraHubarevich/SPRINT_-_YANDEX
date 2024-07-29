import org.junit.Before;
import pageobject.MainPage;
import pageobject.OrderPageFirst;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

//В этом тесте я проверяю, что при вводе некорректных данных в поле Телефон появляется сообщение об ошибке
@RunWith(Parameterized.class)
public class PhoneTest {
    private WebDriver driver;
    //Локатор для сообщения об ошибке при вводе некорректного номера телефона
    private static By incorrectNumberMessage = By.xpath(".//*[text()='Введите корректный номер']");
    //Здесь в конструкторе я ввела переменную number, она будет выводится в сообщении с ошибкой, будет указывать на номер кейса, где ошибка
    private final String phone;
    private final boolean isCorrect;
    private final int number;

    public PhoneTest(String phone, boolean isCorrect, int number) {
        this.phone = phone;
        this.isCorrect = isCorrect;
        this.number = number;

    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"975477885871", false, 1},
                {"hyhyj", true, 2},
                {"9", true, 3},
                {"97547788587124", true, 4},
                {"", true, 5},
                {"%^&*(", true, 6}
        };
    }

    @Before
    public void start() {
        driver = new ChromeDriver();

    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void pageFirstTestUseUpperButton() {
        MainPage phoneTestOpenPage = new MainPage(driver);
        phoneTestOpenPage.openPageToOrderUseUpperButton();
        OrderPageFirst phoneTestOpenPage2 = new OrderPageFirst(driver);
        phoneTestOpenPage2.setPhone(phone);
        phoneTestOpenPage2.clickFButtonDown();
        assertEquals("Error in " + number, isCorrect, driver.findElement(incorrectNumberMessage).isDisplayed());
    }
}
