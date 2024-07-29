package locatorsall;

import org.openqa.selenium.By;

public class LocatorsALL {

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

    //Локатор для поля Имя
    private static By nameloc = By.xpath(".//*[@placeholder='* Имя']");
    //Локатор для поля Фамилия
    private static By surNameloc = By.xpath(".//*[@placeholder='* Фамилия']");
    //Локатор для поля Адрес
    private static By addressloc = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор для поля Метро
    private static By subwayButton = By.xpath(".//*[@placeholder= '* Станция метро']");
    //Локатор для поля Телефон
    private static By phoneloc = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для выбора метро при тестировании кейса заказа с Верхней кнопкой
    private static By subwaySelectUpButton = By.xpath(".//*[text()='Сокол']");
    //Локатор для выбора метро при тестировании кейса заказа с Нижней кнопкой
    public static By subwaySelectDownButton = By.xpath(".//*[text()='Черкизовская']");
    //Локатор для кнопки Далее
    private static By fButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор для списка станций метро, где есть буква к
    private static By listOfSubways = By.cssSelector("li[class=select-search__row]");

    //Локатор для поля Когда привезти самокат
    private static By DateButton = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    //Локатор для поля Срок аренды
    private static By rentDays = By.xpath(".//*[text()='* Срок аренды']");
    //Локатор для выбора срока аренды при тестировании первого набора данных
    private static By selectRentFive = By.xpath(".//*[text()='пятеро суток']");
    //Локатор для выбора срока аренды при тестировании второго набора данных
    private static By selectRentSeven = By.xpath(".//*[text()='семеро суток']");
    //Локатор для выбора цвета при тестировании второго набора данных
    private static By colorBlack = By.xpath(".//*[@id='black']");
    //Локатор для выбора цвета при тестировании кейса заказа с Нижней кнопкой
    private static By colorGrey = By.xpath(".//*[@id='grey']");
    //Локатор для поля Комментарий для курьера
    private static By Comment = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    //Локатор для кнопки Заказать на второй странице
    private static By ButtonOrder = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка на всплывающем окне "Хотите оформить заказ"
    private static By YesButton = By.xpath(".//*[text()='Да']");
    //Окно, которое появляется, когда нажимаешь Да на окне "Хотите оформить заказ"
    private static By OrderExist = By.xpath(".//*[text()= 'Заказ оформлен']");
    //Локатор даты 03.08.2024
    private static By selD = By.xpath(".//*[@aria-label='Choose суббота, 3-е августа 2024 г.']");

}
