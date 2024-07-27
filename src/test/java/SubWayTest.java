import PageObject.mainPage;
import PageObject.orderPage1;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class SubWayTest {
    private WebDriver driver;
    @After
    public void after() {
        driver.quit();
    }
    @Test
    public void pageFirstTestUseUpperButton() throws InterruptedException {
        driver = new ChromeDriver();
        mainPage subwayTestOpenPage = new mainPage(driver);
        subwayTestOpenPage.openPageToOrderUseUpperButton();

        orderPage1 subWayPage = new orderPage1(driver);
        subWayPage.checkSubway();
        assertEquals("DatesAreNotEqual", "Крылатское", subWayPage.checkSubway());
    }
}

