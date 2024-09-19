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

    //Тест для проверки отображения ошибок. С ожиданием после заполнения полей
    @Test
    public void testErrorMessages() throws InterruptedException {
        errorsOrderFields.clickOrderButtonHeader();

        // Заполнение полей с ожиданием
        errorsOrderFields.enterDataFirstPageOrder(name, surname, address, metro, phoneNumber);

        // Ожидание после заполнения каждого поля
        Thread.sleep(3000); // Ожидание 3 секунды

        if (expectNameError) {
            assertTrue("Ошибка имени не отображается", errorsOrderFields.isNameErrorVisible());
        } else {
            assertTrue("Ошибка имени отображается", !errorsOrderFields.isNameErrorVisible());
        }

        Thread.sleep(3000); // Ожидание 3 секунды

        if (expectSurnameError) {
            assertTrue("Ошибка фамилии не отображается", errorsOrderFields.isSurnameErrorVisible());
        } else {
            assertTrue("Ошибка фамилии отображается", !errorsOrderFields.isSurnameErrorVisible());
        }

        Thread.sleep(3000); // Ожидание 3 секунды

        if (expectAddressError) {
            assertTrue("Ошибка адреса не отображается", errorsOrderFields.isAddressErrorVisible());
        } else {
            assertTrue("Ошибка адреса отображается", !errorsOrderFields.isAddressErrorVisible());
        }

        Thread.sleep(3000); // Ожидание 3 секунды

        if (expectMetroError) {
            assertTrue("Ошибка метро не отображается", errorsOrderFields.isMetroErrorVisible());
        } else {
            assertTrue("Ошибка метро отображается", !errorsOrderFields.isMetroErrorVisible());
        }

        Thread.sleep(3000); // Ожидание 3 секунды

        if (expectTelError) {
            assertTrue("Ошибка телефона не отображается", errorsOrderFields.isTelErrorVisible());
        } else {
            assertTrue("Ошибка телефона отображается", !errorsOrderFields.isTelErrorVisible());
        }
    }

    // Тест для проверки отображения ошибок
    /*@Test
    public void testErrorMessages() {
        errorsOrderFields.clickOrderButtonHeader();
        errorsOrderFields.enterDataFirstPageOrder(name, surname, address, metro, phoneNumber);

        if (expectNameError) {
            assertTrue("Ошибка имени не отображается", errorsOrderFields.isNameErrorVisible());
        } else {
            assertTrue("Ошибка имени отображается", !errorsOrderFields.isNameErrorVisible());
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
    }*/

    @After
    public void teardown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"dnfdtsm", "srhrsth", "srthah", 0, "thsrhtrh", true, true, true, true, true},
                {"Галина", "arharhr", "arthhrh", 0, "aehehea", false, true, true, true, true},
                {"Галина", "Петровна", "aesheh", 0, "ahrahr", false, false, true, true, true},
                {"Галина", "Петровна", "Москва", 0, "aehrhtrah", false, false, false, true, true},
                {"Галина", "Петровна", "Москва", 3, "aharhrh", false, false, false, false, true},
                {"Галина", "Петровна", "Москва", 3, "+79667653344", false, false, false, false, false}
        });
    }
}


