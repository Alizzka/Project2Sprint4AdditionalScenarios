import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.ErrorsOrderFields;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ErrorsOrderFieldsTest {

    private WebDriver driver;
    private ErrorsOrderFields errorsOrderFields;

    // Параметры теста
    @Parameterized.Parameter(0)
    public String name;
    @Parameterized.Parameter(1)
    public String surname;
    @Parameterized.Parameter(2)
    public String address;
    @Parameterized.Parameter(3)
    public int metro;
    @Parameterized.Parameter(4)
    public String phoneNumber;
    @Parameterized.Parameter(5)
    public boolean expectNameError;
    @Parameterized.Parameter(6)
    public boolean expectSurnameError;
    @Parameterized.Parameter(7)
    public boolean expectAddressError;
    @Parameterized.Parameter(8)
    public boolean expectMetroError;
    @Parameterized.Parameter(9)
    public boolean expectTelError;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        errorsOrderFields = new ErrorsOrderFields(driver);

        // Закрытие баннера с cookie, если он есть
        errorsOrderFields.closeCookieBanner();
    }

    // Тест для проверки отображения ошибок
    @Test
    public void testErrorMessages() {
        errorsOrderFields.clickOrderButtonHeader();
        errorsOrderFields.enterDataFirstPageOrder(name, surname, address, metro, phoneNumber);

        if (expectNameError) {
            assertTrue("Ошибка имени не отображается", errorsOrderFields.isNameErrorVisible());
        } else {
            assertTrue("ВОшибка имени отображается", !errorsOrderFields.isNameErrorVisible());
        }

        if (expectSurnameError) {
            assertTrue("Ошибка фамилии не отображается", errorsOrderFields.isSurnameErrorVisible());
        } else {
            assertTrue("Ошибка фамилии отображается", !errorsOrderFields.isSurnameErrorVisible());
        }

        if (expectAddressError) {
            assertTrue("Ошибка адреса не отображается", errorsOrderFields.isAddressErrorVisible());
        } else {
            assertTrue("Ошибка адреса отображается", !errorsOrderFields.isAddressErrorVisible());
        }

        if (expectMetroError) {
            assertTrue("Ошибка метро не отображается", errorsOrderFields.isMetroErrorVisible());
        } else {
            assertTrue("Ошибка метро отображается", !errorsOrderFields.isMetroErrorVisible());
        }

        if (expectTelError) {
            assertTrue("Ошибка телефона не отображается", errorsOrderFields.isTelErrorVisible());
        } else {
            assertTrue("Ошибка телефона отображается", !errorsOrderFields.isTelErrorVisible());
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"", "", "", 0, "", true, true, true, true, true},
                {"Галина", "", "", 0, "", false, true, true, true, true},
                {"Галина", "Петровна", "", 0, "", false, false, true, true, true},
                {"Галина", "Петровна", "Москва", 0, "", false, false, false, true, true},
                {"Галина", "Петровна", "Москва", 3, "", false, false, false, false, true},
                {"Галина", "Петровна", "Москва", 3, "+79667653344", false, false, false, false, false}
        });
    }
}


/*import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.ErrorsOrderFields;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ErrorsOrderFieldsTest {

    private WebDriver driver;
    private ErrorsOrderFields errorsOrderFields;

    // Параметры теста
    @Parameterized.Parameter(0)
    public String name;
    @Parameterized.Parameter(1)
    public String surname;
    @Parameterized.Parameter(2)
    public String address;
    @Parameterized.Parameter(3)
    public int metro;
    @Parameterized.Parameter(4)
    public String phoneNumber;
    @Parameterized.Parameter(5)
    public String color;
    @Parameterized.Parameter(6)
    public String date;
    @Parameterized.Parameter(7)
    public int rentalDays;
    @Parameterized.Parameter(8)
    public String comment;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        errorsOrderFields = new ErrorsOrderFields(driver);

        // Закрытие баннера с cookie, если он есть
        errorsOrderFields.closeCookieBanner();
    }

    //Заказ по верхней кнопке:
    @Test
    public void testOrderScooterThroughHeaderButton() {
        errorsOrderFields.clickOrderButtonHeader(); // Нажатие на верхнюю кнопку "Заказать"
        errorsOrderFields.enterDataFirstPageOrder(name, surname, address, metro, phoneNumber);
        errorsOrderFields.enterDataSecondPageOrder(color, date, rentalDays, comment);
        assertTrue(errorsOrderFields.successfullyText());
    }

    //для заказа по нижней кнопке:
    @Test
    public void testOrderScooterThroughDownButton() {
        errorsOrderFields.scrollPageOrder(); // Скролим страницу
        errorsOrderFields.clickOrderButtonDown(); // Нажатие на нижнюю кнопку "Заказать"
        errorsOrderFields.enterDataFirstPageOrder(name, surname, address, metro, phoneNumber);
        errorsOrderFields.enterDataSecondPageOrder(color, date, rentalDays, comment);
        assertTrue(errorsOrderFields.successfullyText());
    }


    @After
    public void teardown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Галина", "Петровна", "Москва", 3, "+79667653344", "черный", "16.09.2024", 7, "Позвоните за 30 минут"},
                {"Роман", "Максимов", "Москва", 15, "+79541112233", "серый", "18.10.2024", 5, ""},
                {"Петр", "Первый", "Санкт-Петербург", 10, "+75126778894", "черный", "27.09.2024", 3, "Оставить около двери"}
        });
    }
}*/