import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertTrue;

public class LogoYandexScooterTest {
    private WebDriver driver;
    private pageobjects.LogoYandexScooter logoYandexScooter;
    private final String mainTestPageUrl = "https://qa-scooter.praktikum-services.ru";

    @Before
    public void begin() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(mainTestPageUrl);

        logoYandexScooter = new pageobjects.LogoYandexScooter(driver);
    }

    @Test
    public void testYandexMainPage() {
        logoYandexScooter.clickheaderLogoYandex();
        // Проверяем, что главная страница Яндекса открыта
        logoYandexScooter.checkMainPageLoaded();
    }

    @Test
    public void testScooterLogoPage() {
        logoYandexScooter.clickOnHeaderOrderButton();
        logoYandexScooter.clickheaderLogoScooter();
        // Проверяем, что главная страница Яндекса открыта
        logoYandexScooter.checkScooterPageLoaded();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

/*
//Другой вариант теста логотипа "Яндекс" и "Самокат"

    // Тест: Логотип Яндекс ведет на главную страницу Яндекс
    // Логика: берем из логотипа ссылку и сравниваем с тестовой
    @Test
    public void checkYandexLogoLinkIsCorrect() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoad();
        String actualLink = objMainPage.getHeaderLogoYandexLink();
        String mainYandexUrl = "yandex.ru";
        Assert.assertTrue("Ссылка в логотипе Яндекса некорректна", actualLink.contains(mainYandexUrl));
    }

    // Тест: клик по логотипу Яндекс открывает главную страницу Яндекс в новой вкладке
    // Логика: берем из логотипа атрибут "target" если он "_blank", то ссылка открывается в новой вкладке
    @Test
    public void checkIsHeaderLogoYandexLinkOpenedInNewTab() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoad();
        boolean isOpenedInNewTab = objMainPage.isHeaderLogoYandexLinkOpenedInNewTab();
        Assert.assertTrue("Ссылка логотипа Яндекс не открывается в новой вкладке", isOpenedInNewTab);
    }
    //Тест: Логотип Самокат ведет на главную страницу ЯндексСамокат
    // Логика: берем из логотипа ссылку и сравниваем с тестовой
    @Test
    public void checkScooterLogoLinkIsCorrect() {
        LogoYandex objLogoYandex = new LogoYandex(driver);
        objLogoYandex.waitForLoad();
        String actualLink = objLogoYandex.getHeaderLogoScooterLink();
        Assert.assertTrue("Ссылка в логотипе Самокат некорректна", actualLink.contains(mainTestPageUrl));

    }*/
