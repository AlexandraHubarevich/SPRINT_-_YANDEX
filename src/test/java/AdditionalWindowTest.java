import PageObject.mainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class AdditionalWindowTest {
    private WebDriver driver;

    @After
    public void after() {
        driver.quit();
    }

    //Допзадание 2
//Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    @Test
    public void checkClickOnYandexLogo() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        mainPage checkClickOnYandexLogo = new mainPage(driver);
        checkClickOnYandexLogo.open();
        checkClickOnYandexLogo.clickYandexLogo();
        if (driver.getWindowHandles().size() == 2) {//Здесь я проверяю, что новое окно открылось, по количеству окон
            Set<String> handles = driver.getWindowHandles();//Помещаю все айди оконо в лист формата стринг
            Iterator<String> it = handles.iterator();
            String parentWindowId = it.next();//главное окно в котором активен драйвер я помещаю в первую строку листа
            String childWindow = it.next();//открывшееся окно я помещаю во вторую строку листа
            driver.switchTo().window(childWindow); //переключаю драйвер на второе окно
            String url = driver.getCurrentUrl(); //получаю его урл
            assertEquals("https://dzen.ru/?yredirect=true", url);
        } else {
            System.out.println("Exception in checkClickOnYandexLogo: New window doesn`t appear");
        }
    }

    //Доп.задание 1
    // Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
    @Test
    public void checkClickOnScooterLogo() {
        driver = new ChromeDriver();
        mainPage checkClickOnScooterLogo = new mainPage(driver);
        checkClickOnScooterLogo.open();
        checkClickOnScooterLogo.clickScooterLogo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        if (driver.getWindowHandles().size() != 1) {
            Set<String> handles1 = driver.getWindowHandles();
            Iterator<String> it1 = handles1.iterator();
            String parentWindowId = it1.next();
            String childWindow = it1.next();
            driver.switchTo().window(childWindow);
            String url = driver.getCurrentUrl();
            assertEquals("https://go.yandex/ru_ru/lp/rides/scooter", url);
        } else {
            System.out.println("Exception in checkClickOnScooterLogo: New window doesn`t appear");
        }
    }

    //Доп.задание 1
    // Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    //Здесь я сравнивала по атрибуту хреф, и он равен https://yandex.ru/, что ранее было главной страницей яндекса, а сейчас это дзен
    @Test
    public void checkClickOnYandexLogoSearchByAttribute() {
        driver = new ChromeDriver();
        mainPage checkClickOnYandexLogoSearchByAttribute = new mainPage(driver);
        checkClickOnYandexLogoSearchByAttribute.open();
        String url = driver.findElement(By.xpath(".//*[@class='Header_LogoYandex__3TSOI']")).getAttribute("href");
        assertEquals("https://dzen.ru/?yredirect=true", url);
    }

    //Доп.задание 1
    // Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
    //Здесь я сравнивала по атрибуту хреф, у лого самоката его не было
    @Test
    public void checkClickOnScooterSearchByAttribute() {
        driver = new ChromeDriver();
        mainPage checkOrder = new mainPage(driver);
        checkOrder.open();
        String url = driver.findElement(By.xpath(".//*[@alt ='Scooter']")).getAttribute("href");
        assertEquals("https://go.yandex/ru_ru/lp/rides/scooter", url);
    }

    //Доп.задание 4
//Проверить: если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет.
    @Test
    public void checkOrderTest() {
        driver = new ChromeDriver();
        mainPage checkOrder = new mainPage(driver);
        checkOrder.open();
        checkOrder.clickOnStatusButton();
        checkOrder.enterOrderNumber();
        checkOrder.clickGo();
        checkOrder.isIncorrectOrderExist();
        Assert.assertTrue(checkOrder.isIncorrectOrderExist());
    }
}