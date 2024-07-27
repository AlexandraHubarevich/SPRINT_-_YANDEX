import PageObject.mainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import LocatorsALL.*;


public class QuestionsTest extends LocatorsALL {
    private WebDriver driver;

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void CompareTestQuestion() {
        driver = new ChromeDriver();
        mainPage pageDropDown = new mainPage(driver);
        pageDropDown.openPageScrollTillQuestion();//здесь заключены методы, которые открывают урл и крутят до первого вопроса
        //Здесь я сравниваю массив вопросов полученных с помощью поиска по локаторам с ожидаемым массивом вопросов
        Assert.assertArrayEquals(ExpectedQuestions, pageDropDown.getTextFromQuestions());
        //Здесь я сравниваю массив ответов полученных с помощью поиска по локаторам с ожидаемым массивом ответов
        Assert.assertArrayEquals(ExpectedReplies, pageDropDown.getTextFromDropDownReplies());
    }
}