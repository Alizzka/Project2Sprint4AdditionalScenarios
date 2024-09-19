package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Класс для главной страницы
public class MainPageCheckOrder {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //Локатор кнопки "Статус заказа" в хэддере страницы
    private final By headerOrderStatusButton = By.className("Header_Link__1TAG7");

    // Локатор поля "Введите номер заказа"
    private final By inputTrack = By.xpath(".//input[contains(@placeholder,'Введите')]");

    // Локатор кнопки "Go!"
    private final By goButton = By.xpath(".//button[contains(@class,'Header_Button__28dPO')]");

    // Локатор для картинки "Номер заказа не найден"
    public final By trackNotFound = By.xpath(".//img[@src='/assets/not-found.png']");

    // Локатор картинки самоката (для ожидания загрузки)
    private final By scooterImage = By.xpath(".//img[@src='/assets/blueprint.png']");

    // Конструктор класса LogoYandex
    public MainPageCheckOrder(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Метод для ожидания загрузки???
    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(scooterImage));
    }

    // Метод клика по кнопке "Статус заказа"
    public void clickOnHeaderOrderStatusButton() {
        driver.findElement(headerOrderStatusButton).click();
    }

    //Метод для ввода номера заказа
    public void setInputTrack(String track) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(inputTrack)).click();
        driver.findElement(inputTrack).sendKeys(track);
    }

    // Метод для клика по кнопке "Go!" c ожиданием
    public void clickOnGoButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(goButton)).click();
    }

    // Метод для ожидания загрузки
    public void waitForLoadNotFoundPic() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(trackNotFound));
    }
}