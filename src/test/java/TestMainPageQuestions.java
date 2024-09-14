//Ванин код измененный
import PageObject.MainPageQuestions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestMainPageQuestions {

    private WebDriver driver;
    private MainPageQuestions generalPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        generalPage = new MainPageQuestions(driver);  // Инициализация MainPageQuestions
    }

    @Test
    public void checkFirstQuestion() {
        generalPage.scrollMainPageQuestions();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                generalPage.getAnswer(MainPageQuestions.Question_1));
    }

    @Test
    public void checkSecondQuestion() {
        generalPage.scrollMainPageQuestions();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                        "можете просто сделать несколько заказов — один за другим.",
                generalPage.getAnswer(MainPageQuestions.Question_2));
    }

    @Test
    public void checkThirdQuestion() {
        generalPage.scrollMainPageQuestions();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                generalPage.getAnswer(MainPageQuestions.Question_3));
    }

    @Test
    public void checkFourthQuestion() {
        generalPage.scrollMainPageQuestions();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                generalPage.getAnswer(MainPageQuestions.Question_4));
    }

    @Test
    public void checkFifthQuestion() {
        generalPage.scrollMainPageQuestions();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить " +
                        "в поддержку по красивому номеру 1010.",
                generalPage.getAnswer(MainPageQuestions.Question_5));
    }

    @Test
    public void checkSixthQuestion() {
        generalPage.scrollMainPageQuestions();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
                        "даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                generalPage.getAnswer(MainPageQuestions.Question_6));
    }

    @Test
    public void checkSeventhQuestion() {
        generalPage.scrollMainPageQuestions();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, " +
                        "объяснительной записки тоже не попросим. Все же свои.",
                generalPage.getAnswer(MainPageQuestions.Question_7));
    }

    @Test
    public void checkEighthQuestion() {
        generalPage.scrollMainPageQuestions();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                generalPage.getAnswer(MainPageQuestions.Question_8));
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


//1 проверка
/*import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FaqTest {

    private WebDriver driver;
    private MainPage generalPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        generalPage = new MainPage(driver);  // Инициализация MainPage
    }

    @Test
    public void checkFirstQuestion() {
        generalPage.scrollMainPage();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                generalPage.getAnswer(MainPage.Question_1));
    }

    @Test
    public void checkSecondQuestion() {
        generalPage.scrollMainPage();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                        "можете просто сделать несколько заказов — один за другим.",
                generalPage.getAnswer(MainPage.Question_2));
    }

    @Test
    public void checkThirdQuestion() {
        generalPage.scrollMainPage();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                generalPage.getAnswer(MainPage.Question_3));
    }

    @Test
    public void checkFourthQuestion() {
        generalPage.scrollMainPage();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                generalPage.getAnswer(MainPage.Question_4));
    }

    @Test
    public void checkFifthQuestion() {
        generalPage.scrollMainPage();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить " +
                        "в поддержку по красивому номеру 1010.",
                generalPage.getAnswer(MainPage.Question_5));
    }

    @Test
    public void checkSixthQuestion() {
        generalPage.scrollMainPage();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
                        "даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                generalPage.getAnswer(MainPage.Question_6));
    }

    @Test
    public void checkSeventhQuestion() {
        generalPage.scrollMainPage();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, " +
                        "объяснительной записки тоже не попросим. Все же свои.",
                generalPage.getAnswer(MainPage.Question_7));
    }

    @Test
    public void checkEighthQuestion() {
        generalPage.scrollMainPage();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                generalPage.getAnswer(MainPage.Question_8));
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}*/