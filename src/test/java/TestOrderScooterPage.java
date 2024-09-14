//Ванин код измененный
//import PageObject.MainPageQuestions;
import PageObject.OrderScooterPage;
import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestOrderScooterPage {

    private WebDriver driver;

    private OrderScooterPage generalPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        generalPage = new OrderScooterPage(driver);  // Инициализация OrderScooterPage
    }

    @Test
    public void testOrderScooterOne() {
        enterDataFirstPageOrder("Галина", "Петровна", "Луга", 3, "+79667653344");
        enterDataSecondPageOrder("черный", "16.09.2024", 7, "Позвоните за 30 минут");
        //Assert.assertTrue(successfullyText());
    }

    /*private boolean successfullyText() {
        // Здесь необходимо реализовать логику проверки успешного текста
        return true;
    }*/

    private void enterDataSecondPageOrder(String цвет, String дата, int срок, String комментарий) {
        // Реализовать ввод данных на второй странице
    }

    private void enterDataFirstPageOrder(String имя, String фамилия, String адрес, int номерКвартиры, String телефон) {
        // Реализовать ввод данных на первой странице
    }

    @Test
    public void testOrderScooterTwo() {
        enterDataFirstPageOrder("Роман", "Максимов", "Москва", 15, "+79541112233");
        enterDataSecondPageOrder("серый", "18.10.2024", 5, "");
        //Assert.assertTrue(successfullyText());
    }

    @Test
    public void testOrderScooterThree() {
        enterDataFirstPageOrder("Петр", "Первый", "Санкт-Петербург", 10, "+75126778894");
        enterDataSecondPageOrder("черный", "27.09.2024", 3, "Оставить около двери");
        //Assert.assertTrue(successfullyText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

//1 проверка
/*import pageobjects.PageOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OrderScooterTest {

    private WebDriver driver;

    private PageOrder generalPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        generalPage = new PageOrder(driver);  // Инициализация PageOrder
    }

    @Test
    public void testOrderScooterOne() {
        enterDataFirstPageOrder("Галина", "Петровна", "Луга", 3, "+79667653344");
        enterDataSecondPageOrder("черный", "16.09.2024", 7, "Позвоните за 30 минут");
        //Assert.assertTrue(successfullyText());
    }

    /*private boolean successfullyText() {
        // Здесь необходимо реализовать логику проверки успешного текста
        return true;
    }*/

   /* private void enterDataSecondPageOrder(String цвет, String дата, int срок, String комментарий) {
        // Реализовать ввод данных на второй странице
    }

    private void enterDataFirstPageOrder(String имя, String фамилия, String адрес, int номерКвартиры, String телефон) {
        // Реализовать ввод данных на первой странице
    }

    @Test
    public void testOrderScooterTwo() {
        enterDataFirstPageOrder("Роман", "Максимов", "Москва", 15, "+79541112233");
        enterDataSecondPageOrder("серый", "18.10.2024", 5, "");
        //Assert.assertTrue(successfullyText());
    }

    @Test
    public void testOrderScooterThree() {
        enterDataFirstPageOrder("Петр", "Первый", "Санкт-Петербург", 10, "+75126778894");
        enterDataSecondPageOrder("черный", "27.09.2024", 3, "Оставить около двери");
        //Assert.assertTrue(successfullyText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}*/




//исправленный код без параметризации
/*import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.PageOrder;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class OrderScooterTest {

    private WebDriver driver;
    private PageOrder pageOrder;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        pageOrder = new PageOrder(driver);

        // Закрытие баннера с cookie, если он есть
        pageOrder.closeCookieBanner();
    }

    @Test
    public void testOrderScooter3() {
        // Например, добавим логирование состояния
        System.out.println("Начинается тест на заказ самоката");

        // Ожидание элемента на странице (если необходимо)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement orderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Заказать']")));

        assertTrue("Кнопка заказа должна быть видимой", orderButton.isDisplayed());

    }

    @Test
    public void testOrderScooterOne() {
        pageOrder.enterDataFirstPageOrder("Галина", "Петровна", "Москва", 3, "+79667653344");
        pageOrder.enterDataSecondPageOrder("черный", "16.09.2024", 7, "Позвоните за 30 минут");
        assertTrue(pageOrder.successfullyText());
    }

    @Test
    public void testOrderScooterTwo() {
        pageOrder.enterDataFirstPageOrder("Роман", "Максимов", "Москва", 15, "+79541112233");
        pageOrder.enterDataSecondPageOrder("серый", "18.10.2024", 5, "");
        assertTrue(pageOrder.successfullyText());
    }

    @Test
    public void testOrderScooterThree() {
        pageOrder.enterDataFirstPageOrder("Петр", "Первый", "Санкт-Петербург", 10, "+75126778894");
        pageOrder.enterDataSecondPageOrder("черный", "27.09.2024", 3, "Оставить около двери");
        assertTrue(pageOrder.successfullyText());
    }


    @After
    public void teardown() {
        driver.quit();
    }
}*/
