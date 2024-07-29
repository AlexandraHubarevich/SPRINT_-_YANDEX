import org.junit.Before;
import pageobject.MainPage;
import pageobject.OrderPageFirst;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class SubWayTest {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();

    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void pageFirstTestUseUpperButton()  {
        MainPage subwayTestOpenPage = new MainPage(driver);
        subwayTestOpenPage.openPageToOrderUseUpperButton();

        OrderPageFirst subWayPage = new OrderPageFirst(driver);
        subWayPage.checkSubway();
        assertEquals("Subways AreNotEqual", "Крылатское", subWayPage.checkSubway());
    }
}

