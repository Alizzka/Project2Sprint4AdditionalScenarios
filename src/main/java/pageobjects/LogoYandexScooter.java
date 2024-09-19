package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import static org.junit.Assert.assertEquals;

// Класс для главной страницы
public class LogoYandexScooter {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локатор логотипа Яндекс
    private final By headerLogoYandex = By.className("Header_LogoYandex__3TSOI");

    // Локатор логотипа Самокат
    private final By headerLogoScooter = By.className("Header_LogoScooter__3lsAR");

    // Локатор кнопки "Заказать" в хэддере страницы
    private final By headerOrderButton = By.className("Button_Button__ra12g");

    // Конструктор класса LogoYandex
    public LogoYandexScooter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Метод клика по логотипу "Яндекс"
    public void clickheaderLogoYandex() {
        driver.findElement(headerLogoYandex).click();
    }

    //Метод для проверки открытия в новой вкладке ссылки главной страницы яндекса после клика на логотип "Яндекс"
    public void checkMainPageLoaded() {
        // Получаем список всех открытых окон/вкладок
        Set<String> allWindows = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();  // Сохраняем текущую вкладку
        // Переключаемся на новую вкладку
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Проверяем, что текущий URL соответствует ожидаемому
        String expectedUrl = "https://dzen.ru/?yredirect=true";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));  // Ожидание загрузки нужного URL
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Главная страница Яндекса не открылась!", expectedUrl, actualUrl);
        // Возвращаемся на исходную вкладку после проверки
        driver.close();  // Закрываем новую вкладку
        driver.switchTo().window(originalWindow);  // Переключаемся обратно на исходную вкладку
    }

    // Метод клика по кнопке "Заказать" в хэддере
    public void clickOnHeaderOrderButton() {
        // Ожидание в 3 секунды перед кликом на кнопку
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(headerOrderButton).click();
    }

    //Метод клика на логотип "Самокат"
    public void clickheaderLogoScooter() {
        // Ожидание в 3 секунды перед кликом на логотип
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(headerLogoScooter).click();
    }

    //Метод для проверки открытия в новой вкладке ссылки страницы яндекс самоката после клика на логотип "Самокат"
    public void checkScooterPageLoaded() {
        // Получаем список всех открытых окон/вкладок
        Set<String> allWindows = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();  // Сохраняем текущую вкладку

        // Ожидание в 3 секунды перед переключением на новую вкладку
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Переключаемся на новую вкладку
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Ожидание в 3 секунды перед проверкой URL
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Проверяем, что текущий URL соответствует ожидаемому
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));  // Ожидание загрузки нужного URL
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Главная страница ЯндексСамоката не открылась!", expectedUrl, actualUrl);
        // Ожидание в 3 секунды перед переключением обратно на исходную вкладку
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Возвращаемся на исходную вкладку после проверки
        driver.switchTo().window(originalWindow);  // Переключаемся обратно на исходную вкладку
    }
}

/*
//Другой вариант теста логотипа "Яндекс" и проверки перехода на главную страницу яндекса

    // Метод получения ссылки из логотипа Яндекс
    public String getHeaderLogoYandexLink() {
        return driver.findElement(headerLogoYandex).getAttribute("href");
    }

    // Метод проверки открытия главной страницы Яндекс в новом окне при клике
    public boolean isHeaderLogoYandexLinkOpenedInNewTab() {
        String target = driver.findElement(headerLogoYandex).getAttribute("target");
        return "_blank".equals(target);
    }

    // Метод получения ссылки из логотипа Самокат
    public String getHeaderLogoScooterLink() {
        return driver.findElement(headerLogoScooter).getAttribute("href");
    }*/
