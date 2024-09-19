package pageobjects;

import org.openqa.selenium.*;
import java.util.List;

public class ErrorsOrderFields {
    private final WebDriver driver;

    // Локаторы для баннера куки
    private static final By CookieBannerButton = By.className("App_CookieButton__3cvqF");

    // Локаторы для первой страницы
    private static final By OrderButtonHeader = By.xpath("//*[@id='root']/div/div[1]/div[1]/div[2]/button[1]");

    //private static final By OrderButtonDown = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");
    private static final By NameButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    private static final By SurnameButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    private static final By AddressButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    private static final By MetroButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div/input");
    private static final By TelButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    private static final By NextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");

    // Локаторы для сообщений об ошибках
    private static final By NameError = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div");
    private static final By SurnameError = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div");
    private static final By AddressError = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/div");
    private static final By MetroError = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div[2]");
    private static final By TelError = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/div");

    public ErrorsOrderFields(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для закрытия баннера куки
    public void closeCookieBanner() {
        driver.findElement(CookieBannerButton).click();
    }

    // Нажатие на верхнюю кнопку "Заказать"
    public void clickOrderButtonHeader() {
        driver.findElement(OrderButtonHeader).click();
    }

    // Метод для заполнения первой страницы заказа с ошибками
    public void enterDataFirstPageOrder(String name, String surname, String address, int metro, String phoneNumber) {
        driver.findElement(NameButton).sendKeys(name);  // Заполнение поля "Имя"
        driver.findElement(SurnameButton).sendKeys(surname);  // Заполнение поля "Фамилия"
        driver.findElement(AddressButton).sendKeys(address);  // Заполнение поля "Адрес"
        driver.findElement(MetroButton).click();  // Нажатие на поле "Станция метро"

        // Выбор станции метро из списка
        //By allMetroStation = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]/ul/li");
        By allMetroStation = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div[1]");
        List<WebElement> elements = driver.findElements(allMetroStation);
        //if (metro <= elements.size())
        if (metro > 0 && metro <= elements.size()) {
            elements.get(metro - 1).click();  // Выбор станции метро по индексу
        }

        driver.findElement(TelButton).sendKeys(phoneNumber);  // Заполнение поля "Телефон"
        driver.findElement(NextButton).click();  // Нажатие на кнопку "Далее"
    }

    // Метод для проверки появления ошибок
    public boolean isNameErrorVisible() {
        return driver.findElement(NameError).isDisplayed();
    }

    public boolean isSurnameErrorVisible() {
        return driver.findElement(SurnameError).isDisplayed();
    }

    public boolean isAddressErrorVisible() {
        return driver.findElement(AddressError).isDisplayed();
    }

    public boolean isMetroErrorVisible() {
        return driver.findElement(MetroError).isDisplayed();
    }

    public boolean isTelErrorVisible() {
        return driver.findElement(TelError).isDisplayed();
    }
}


/*package pageobjects;
import org.openqa.selenium.*;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ErrorsOrderFields {
    private final WebDriver driver;

    // Локаторы для баннера куки
    private static final By CookieBannerButton = By.className("App_CookieButton__3cvqF");

    // Локаторы для первой страницы
    private static final By OrderButtonHeader = By.xpath("//*[@id='root']/div/div[1]/div[1]/div[2]/button[1]");
    private static final By OrderButtonDown = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");
    private static final By NameButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    private static final By SurnameButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    private static final By AddressButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    private static final By MetroButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div/input");
    private static final By TelButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    private static final By NextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");

    // Локаторы для второй страницы
    private static final By DateButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div/div/input");
    private static final By PeriodButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div");
    private static final By BlackButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/label[1]/input");
    private static final By GreyButton = By.xpath("//*[@id='grey']");
    private static final By CommentButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input");
    private static final By SubmitButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");
    private static final By PopapButton = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[1]");
    private static final By YesButton = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");

    public ErrorsOrderFields(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для закрытия баннера куки
    public void closeCookieBanner() {
        driver.findElement(CookieBannerButton).click();
    }

    //Скролл до элемента кнопки "Заказать"
    public void scrollPageOrder() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(OrderButtonDown));
    }

    // Нажатие на нижнюю кнопку "Заказать"
    public void clickOrderButtonDown() {
        driver.findElement(OrderButtonDown).click();
    }

    // Нажатие на верхнюю кнопку "Заказать"
    public void clickOrderButtonHeader() {
        driver.findElement(OrderButtonHeader).click();
    }

    // Заполнение первой страницы заказа
    public void enterDataFirstPageOrder(String name, String surname, String address, int metro, String phoneNumber) {
        driver.findElement(NameButton).sendKeys(name);  // Заполнение поля "Имя"
        driver.findElement(SurnameButton).sendKeys(surname);  // Заполнение поля "Фамилия"
        driver.findElement(AddressButton).sendKeys(address);  // Заполнение поля "Адрес"
        driver.findElement(MetroButton).click();  // Нажатие на поле "Станция метро"

        // Выбор станции метро из списка
        By allMetroStation = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]/ul/li");
        List<WebElement> elements = driver.findElements(allMetroStation);
        elements.get(metro - 1).click();  // Выбор станции метро по индексу

        driver.findElement(TelButton).sendKeys(phoneNumber);  // Заполнение поля "Телефон"
        driver.findElement(NextButton).click();  // Нажатие на кнопку "Далее"
    }

    // Заполнение второй страницы заказа
    public void enterDataSecondPageOrder(String color, String date, int rentalDays, String comment) {
        // Выбор цвета самоката
        if ("черный".equals(color)) {
            driver.findElement(BlackButton).click();
        } else if ("серый".equals(color)) {
            driver.findElement(GreyButton).click();
        }

        // Выбор даты
        driver.findElement(DateButton).sendKeys(date);
        driver.findElement(DateButton).sendKeys(Keys.RETURN);

        // Выбор срока аренды
        driver.findElement(PeriodButton).click();
        By allDayForOrder = By.className("Dropdown-option");
        List<WebElement> elements = driver.findElements(allDayForOrder);
        elements.get(rentalDays - 1).click();  // Выбор срока аренды

        driver.findElement(CommentButton).sendKeys(comment);  // Заполнение поля "Комментарий"
        driver.findElement(SubmitButton).click();  // Нажатие на кнопку "Заказать"
        driver.findElement(YesButton).click();  // Подтверждение заказа в попапе
    }

    // Попап подтверждения оформления заказа
    public boolean successfullyText() {
        String successfullOrder = driver.findElement(PopapButton).getText();
        return successfullOrder.contains("Заказ оформлен");
    }
}*/
