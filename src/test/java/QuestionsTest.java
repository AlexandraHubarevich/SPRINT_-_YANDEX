import org.junit.*;
import org.junit.rules.ErrorCollector;
import pageobject.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import locatorsall.*;


import static org.hamcrest.CoreMatchers.equalTo;


public class QuestionsTest extends LocatorsALL {
    @Rule
    public ErrorCollector collector = new ErrorCollector();
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
    public void compareTestQuestion() {
        MainPage pageDropDown = new MainPage(driver);
        pageDropDown.openPageScrollTillQuestion();//здесь заключены методы, которые открывают урл и крутят до первого вопроса
        //Здесь я проверяю, что вопросы с сайта совпадают с вопросами, которые должны быть
        collector.checkThat(ExpectedQuestions, equalTo(pageDropDown.getTextFromQuestions()));
        //Здесь я проверяю, что ответы с сайта совпадают с ответами, которые должны быть
        collector.checkThat(ExpectedReplies, equalTo(pageDropDown.getTextFromDropDownReplies()));


    }
}