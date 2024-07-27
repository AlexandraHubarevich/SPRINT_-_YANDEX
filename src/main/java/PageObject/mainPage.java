package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class mainPage {
    private WebDriver driver;

    public mainPage(WebDriver driver) {
        this.driver = driver;
    }

    //адрес первой страницы
    private static final String FirstPageUrl = "https://qa-scooter.praktikum-services.ru/";

    //Локатор для обнаружения кнопки Заказ вверху
    private static final By UpButton = By.xpath(".//*[@class='Button_Button__ra12g']");

    //Локатор для обнаружения кнопки Заказ внизу
    private static final By DownButton = By.xpath(".//*[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор для обнаружения кнопки Куки, которая мешает проводить тесты
    private static final By cookie = By.xpath(".//*[@class='App_CookieButton__3cvqF']");

    //Локатор кнопки с первым вопросом, до сюда я скроллю
    private static final By QuestionBlock = By.xpath(".//*[@id= 'accordion__heading-0']");

    //Локатор, по которому ищем все вопросы, после эти локаторы помещаются в Лист ВебЭлемент
    private static final By Question = By.xpath(".//*[@class= 'accordion__heading']");

    //Локатор, по которому ищем все ответы
    private static final By Reply = By.xpath(".//*[@class='accordion__panel']/p");

    //Это массив строк-вопросов, которые должны быть на сайте
    public String[] ExpectedQuestions = {"Сколько это стоит? И как оплатить?",
            "Хочу сразу несколько самокатов! Так можно?",
            "Как рассчитывается время аренды?",
            "Можно ли заказать самокат прямо на сегодня?",
            "Можно ли продлить заказ или вернуть самокат раньше?",
            "Вы привозите зарядку вместе с самокатом?",
            "Можно ли отменить заказ?",
            "Я жизу за МКАДом, привезёте?"
    };
    //Это массив строк-ответов, которые должны быть на сайте
    public String[] ExpectedReplies = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };
    //Локатор для логотипа самокат
    private static final By ScooterLogo = By.xpath(".//*[@alt ='Scooter']");
    //Локатор для логотипа яндекса
    private static final By YandexLogo = By.xpath(".//*[@alt ='Yandex']");


    //Локатор для кнопки GO
    private static final By GoButton = By.xpath(".//*[@class='Button_Button__ra12g Header_Button__28dPO']");

    //Локатор для картинки нет такого заказа
    private static final By NoOrderPage = By.xpath(".//*[@alt='Not found']");

    //Локатор для кнопки Статус зазаза
    private static final By OrderStatusButton = By.xpath("//*[@class='Header_Link__1TAG7']");
    //Локатор для поля, в которое вводится несуществующий заказ
    private static final By incorrectVal = By.xpath(".//*[@class='Input_Input__1iN_Z Header_Input__xIoUq']");


    //Открытие главной странцы
    public mainPage open() {
        driver.get(FirstPageUrl);
        return this;
    }

    //Нажимаю кнопку куки, тк если ее не нажать, кнопка куки лезет на последний вопрос и  драйвер не находит последний вопрос по локатору
    public mainPage clickCookie() {
        driver.findElement(cookie).click();
        return this;
    }

    //Проматываю до блока с вопросами
    public mainPage scrollToQuestionBlock() {
        WebElement element = driver.findElement(QuestionBlock);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    //Этот метод проверяет совпадает ли текст актуальных вопросов с сайта с текстом ожидаемых вопросов
    public String[] getTextFromQuestions() {
        List<WebElement> values = driver.findElements(Question);
        String[] ActualQuestions = new String[values.size()];//Пустой массив, куда я буду складывать текст с локаторов вопросов
        for (int i = 0; i < values.size(); i++) {
            ActualQuestions[i] = values.get(i).getText();
        }
        return ActualQuestions;
    }

    //Этот метод проверяет совпадает ли текст актуальных ответов с сайта с текстом ожидаемых ответов
    public String[] getTextFromDropDownReplies() {
        List<WebElement> values = driver.findElements(Question);//Получаем лист с локаторами вопросов
        List<WebElement> values2 = driver.findElements(Reply);//Получаем лист с локаторами ответов
        String[] ActualReplies = new String[values2.size()]; //Пустой массив, сюда я буду класть текст, полученный из листа с локаторами ответов
        for (int i = 0; i < values.size(); i++) {
            values.get(i).click(); //Нажимаю на локатор вопроса
            for (int j = 0; j < values2.size(); j++) {
                values2.get(j).getText(); //Получаю текст с каждого локатора ответа
            }
            ActualReplies[i] = values2.get(i).getText();//Здесь я в пустой массив кладу тексты из листа
        }
        return ActualReplies;
    }

    // Метод, который кликает на кнопку Заказать, расположенную внизу
    public mainPage clickDownButton() {
        WebElement element = driver.findElement(DownButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return this;
    }

    // Метод, который кликает на кнопку Заказать, расположенную вверху
    public mainPage clickUpperButton() {
        driver.findElement(UpButton).click();
        return this;

    }

    // Метод, который находит поле для статуса заказа и кликает по нему
    public mainPage clickOnStatusButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(OrderStatusButton).click();
        return this;


    }

    // Метод, который находит поле для введения заказа и вводит несуществующий заказ
    public mainPage enterOrderNumber() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.findElement(incorrectVal).sendKeys("rfgtgy");
        return this;
    }

    // Метод, который находит и кликает кнопку Go
    public mainPage clickGo() {
        driver.findElement(GoButton).click();
        return this;
    }

    //Метод, который проверяет, что несуществующй заказ не создан
    public boolean isIncorrectOrderExist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement imageFound =
                wait.until(ExpectedConditions.visibilityOfElementLocated(NoOrderPage));
        return imageFound.isDisplayed();
    }

    // Метод, который находит и кликает лого самоката
    public mainPage clickScooterLogo() {
        driver.findElement(ScooterLogo).click();
        return this;
    }

    // Метод, который находит и кликает яндекс лого
    public mainPage clickYandexLogo() {
        driver.findElement(YandexLogo).click();
        return this;
    }

    //Метод который в начале проверки открывает странцу, убирает куки и скроллит до вопросов о важном
    public mainPage openPageScrollTillQuestion() {
        open();
        clickCookie();
        scrollToQuestionBlock();
        return this;
    }

    //Метод который в начале проверки открывает странцу, убирает куки и кликает на верхнюю кнопку заказать
    public mainPage openPageToOrderUseUpperButton() {
        open();
        clickCookie();
        clickUpperButton();
        return this;
    }

    //Метод который в начале проверки открывает странцу, убирает куки и кликает на нижнюю кнопку заказать
    public mainPage openPageToOrderUseDownButton() {
        open();
        clickCookie();
        clickDownButton();
        return this;
    }
}
