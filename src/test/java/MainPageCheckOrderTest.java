//Для FireFox:
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobjects.MainPageCheckOrder;
import static org.junit.Assert.*;

public class MainPageCheckOrderTest {
    private WebDriver driver;
    private final String mainTestPageUrl = "https://qa-scooter.praktikum-services.ru";
    private final String inputTrack = "5859565759";
    @Before
    public void begin() {
        // Настройка FirefoxOptions
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

        // Инициализация FirefoxDriver
        driver = new FirefoxDriver(options);
        driver.get(mainTestPageUrl);
    }
    @Test
    public void wrongTrackNotFound() {
        MainPageCheckOrder objMainPageCheckOrder = new MainPageCheckOrder(driver);
        objMainPageCheckOrder.waitForLoad();
        objMainPageCheckOrder.clickOnHeaderOrderStatusButton();
        objMainPageCheckOrder.setInputTrack(inputTrack);
        objMainPageCheckOrder.clickOnGoButton();
        objMainPageCheckOrder.waitForLoadNotFoundPic();

        assertTrue(driver.findElement(objMainPageCheckOrder.trackNotFound).isDisplayed());
    }
    @After
    public void teardown() {
        driver.quit();
    }
}

//Для Chrome:
/*import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.MainPageCheckOrder;
import static org.junit.Assert.*;

public class MainPageCheckOrderTest {
    private WebDriver driver;
    private final String mainTestPageUrl = "https://qa-scooter.praktikum-services.ru";
    private final String inputTrack = "5859565759";

    @Before
    public void begin() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(mainTestPageUrl);
    }

    // Тест: ввод неверного номера заказа ведет на страницу "Такого заказа нет"
    // Логика: кликаем по кнопке статус заказа, вводим несуществующий номер заказа и ждем загрузки картинки
    @Test
    public void wrongTrackNotFound () {
        MainPageCheckOrder objMainPageCheckOrder = new MainPageCheckOrder(driver);
        objMainPageCheckOrder.waitForLoad();
        objMainPageCheckOrder.clickOnHeaderOrderStatusButton();
        objMainPageCheckOrder.setInputTrack(inputTrack);
        objMainPageCheckOrder.clickOnGoButton();
        objMainPageCheckOrder.waitForLoadNotFoundPic();

        assertTrue(driver.findElement(objMainPageCheckOrder.trackNotFound).isDisplayed());

    }

    @After
    public void teardown() {
        driver.quit();
    }
}*/

//Для теста на браузере FireFox, через WebDriverManager
/*import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

    @Before
    public void begin() {
        // Настройка WebDriverManager для Firefox
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(mainTestPageUrl);
    }

//Для теста на браузере FireFox, с указанием пути к папке с вебдрайвером
//когда есть путь в переменной окружения:
import org.openqa.selenium.firefox.FirefoxDriver;

    @Before
    public void begin() {
        // Указываем путь к скачанному geckodriver
        System.setProperty("webdriver.gecko.driver", "C:/path/to/your/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(mainTestPageUrl);
    }
 */


