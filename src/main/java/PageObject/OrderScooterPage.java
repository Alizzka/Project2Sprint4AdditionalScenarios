//Ванин код измененный
/*Задание: Заказ самоката. Нужно проверить весь флоу позитивного сценария с двумя наборами данных.
Проверить точки входа в сценарий, их две: кнопка «Заказать» вверху страницы и внизу.
Из чего состоит позитивный сценарий:
- Нажать кнопку «Заказать». На странице две кнопки заказа.
- Заполнить форму заказа.
- Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.*/

package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderScooterPage {
    private final WebDriver driver;

    //Локаторы для первой страницы

    //Локатор для кнопки "Заказать" в верхней части страницы:
    private static final By OrderButtonHeader = By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/button[1]");
    //Локатор для кнопки "Заказать" в нижней части страницы:
    private static final By OrderButtonDown = By.className("Button_UltraBig__UU3Lp");
    //Локатор для поля "Имя":
    private static final By NameButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    //Локатор для поля "Фамилия":
    private static final By SurnameButton = By.xpath("//div[2]/input");
    //Локатор для поля "Адрес: куда привезти заказ":
    private static final By AddressButton = By.xpath("//div[3]/input");
    //Локатор для поля "Станция метро":
    private static final By MetroButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");
    //Локатор для поля "Телефон: на него позвонит курьер":
    private static final By TelButton = By.xpath("//div[5]/input");
    //Локатор для кнопки "Далее":
    private static final By NextButton = By.className("Button_Middle__1CSJM");

    //Локаторы для второй страницы

    //Локатор для поля "*Когда привезти самокат":
    private static final By DateButton = By.className("Input_Responsible__1jDKN");
    //Локатор для поля "*Срок аренды":
    private static final By PeriodButton = By.className("Dropdown-placeholder");
    //Локатор для поля "Цвет самоката", с выбором цвета черный жемчуг:
    private static final By BlackButton = By.className("Checkbox_Input__14A2w");
    //Локатор для поля "Цвет самоката", с выбором цвета серая безысходность:
    private static final By GreyButton = By.id("grey");
    //Локатор для поля "Комментарий для курьера":
    private static final By CommentButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    //Локатор для кнопки "Заказать":
    private static final By SubmitButton = By.xpath("/html/body/div[1]/div/div[2]/div[3]/button[2]");
    //Локатор для попапа "Хотите оформить заказ?":
    private static final By PopapButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]");
    //Локатор для кнопки "Да":
    private static final By YesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    public OrderScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение первой страницы заказа:
    public void enterDataFirstPageOrder(String name, String surname, String address, int metro, String phoneNumber) {
        driver.findElement(OrderButtonHeader).click();
        driver.findElement(NameButton).sendKeys(name);
        driver.findElement(SurnameButton).sendKeys(surname);
        driver.findElement(AddressButton).sendKeys(address);
        driver.findElement(MetroButton).click();
        By allMetroStation = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li");
        //Список станций метро:
        List<WebElement> elements = driver.findElements(allMetroStation);
        elements.get(metro - 1).click();
        driver.findElement(TelButton).sendKeys(phoneNumber);
        driver.findElement(NextButton).click();
    }

    //Заполнение второй страницы заказа:
    public void enterDataSecondPageOrder(String color, String date, int rentalDays, String comment) {
        if ("черный".equals(color)) {
            driver.findElement(BlackButton).click();
        }
        if ("серый".equals(color)) {
            driver.findElement(GreyButton).click();
        }
        //Выбор даты:
        driver.findElement(DateButton).sendKeys(date);
        driver.findElement(DateButton).sendKeys(Keys.RETURN);
        driver.findElement(PeriodButton).click();
        By allDayForOrder = By.className("Dropdown-option");
        //Список из 7 суток аренды:
        List<WebElement> elements = driver.findElements(allDayForOrder);
        elements.get(rentalDays - 1).click();
        driver.findElement(CommentButton).sendKeys(comment);
        driver.findElement(SubmitButton).click();
        driver.findElement(YesButton).click();
    }

    //Попап подтверждения оформления заказа:
    public boolean successfullyText() {
        String successfullOrder = driver.findElement(PopapButton).getText();
        return successfullOrder.contains("Заказ оформлен");
    }
}

//1 прверка
/*/*Задание: Заказ самоката. Нужно проверить весь флоу позитивного сценария с двумя наборами данных.
Проверить точки входа в сценарий, их две: кнопка «Заказать» вверху страницы и внизу.
Из чего состоит позитивный сценарий:
- Нажать кнопку «Заказать». На странице две кнопки заказа.
- Заполнить форму заказа.
- Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.*/

/*package pageobjects;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

        import java.util.List;

public class PageOrder {
    private final WebDriver driver;

    //Локаторы для первой страницы

    //Локатор для кнопки "Заказать" в верхней части страницы:
    private static final By OrderButtonHeader = By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/button[1]");
    //Локатор для кнопки "Заказать" в нижней части страницы:
    private static final By OrderButtonDown = By.className("Button_UltraBig__UU3Lp");
    //Локатор для поля "Имя":
    private static final By NameButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    //Локатор для поля "Фамилия":
    private static final By SurnameButton = By.xpath("//div[2]/input");
    //Локатор для поля "Адрес: куда привезти заказ":
    private static final By AddressButton = By.xpath("//div[3]/input");
    //Локатор для поля "Станция метро":
    private static final By MetroButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");
    //Локатор для поля "Телефон: на него позвонит курьер":
    private static final By TelButton = By.xpath("//div[5]/input");
    //Локатор для кнопки "Далее":
    private static final By NextButton = By.className("Button_Middle__1CSJM");

    //Локаторы для второй страницы

    //Локатор для поля "*Когда привезти самокат":
    private static final By DateButton = By.className("Input_Responsible__1jDKN");
    //Локатор для поля "*Срок аренды":
    private static final By PeriodButton = By.className("Dropdown-placeholder");
    //Локатор для поля "Цвет самоката", с выбором цвета черный жемчуг:
    private static final By BlackButton = By.className("Checkbox_Input__14A2w");
    //Локатор для поля "Цвет самоката", с выбором цвета серая безысходность:
    private static final By GreyButton = By.id("grey");
    //Локатор для поля "Комментарий для курьера":
    private static final By CommentButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    //Локатор для кнопки "Заказать":
    private static final By SubmitButton = By.xpath("/html/body/div[1]/div/div[2]/div[3]/button[2]");
    //Локатор для попапа "Хотите оформить заказ?":
    private static final By PopapButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]");
    //Локатор для кнопки "Да":
    private static final By YesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    public PageOrder(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение первой страницы заказа:
    public void enterDataFirstPageOrder(String name, String surname, String address, int metro, String phoneNumber) {
        driver.findElement(OrderButtonHeader).click();
        driver.findElement(NameButton).sendKeys(name);
        driver.findElement(SurnameButton).sendKeys(surname);
        driver.findElement(AddressButton).sendKeys(address);
        driver.findElement(MetroButton).click();
        By allMetroStation = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li");
        //Список станций метро:
        List<WebElement> elements = driver.findElements(allMetroStation);
        elements.get(metro - 1).click();
        driver.findElement(TelButton).sendKeys(phoneNumber);
        driver.findElement(NextButton).click();
    }

    //Заполнение второй страницы заказа:
    public void enterDataSecondPageOrder(String color, String date, int rentalDays, String comment) {
        if ("черный".equals(color)) {
            driver.findElement(BlackButton).click();
        }
        if ("серый".equals(color)) {
            driver.findElement(GreyButton).click();
        }
        //Выбор даты:
        driver.findElement(DateButton).sendKeys(date);
        driver.findElement(DateButton).sendKeys(Keys.RETURN);
        driver.findElement(PeriodButton).click();
        By allDayForOrder = By.className("Dropdown-option");
        //Список из 7 суток аренды:
        List<WebElement> elements = driver.findElements(allDayForOrder);
        elements.get(rentalDays - 1).click();
        driver.findElement(CommentButton).sendKeys(comment);
        driver.findElement(SubmitButton).click();
        driver.findElement(YesButton).click();
    }

    //Попап подтверждения оформления заказа:
    public boolean successfullyText() {
        String successfullOrder = driver.findElement(PopapButton).getText();
        return successfullOrder.contains("Заказ оформлен");
    }
}*/

//исправленный код без параметризации

/*Задание: Заказ самоката. Нужно проверить весь флоу позитивного сценария с двумя наборами данных.
Проверить точки входа в сценарий, их две: кнопка «Заказать» вверху страницы и внизу.
Из чего состоит позитивный сценарий:
- Нажать кнопку «Заказать». На странице две кнопки заказа.
- Заполнить форму заказа.
- Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.*/

/*package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageOrder {
    private final WebDriver driver;

    // Локаторы для баннера куки
    private static final By CookieBannerButton = By.className("App_CookieButton__3cvqF");

    // Локаторы для первой страницы

    // Локатор для кнопки "Заказать" в верхней части страницы:
    private static final By OrderButtonHeader = By.xpath("//*[@id='root']/div/div[1]/div[1]/div[2]/button[1]");
    // Локатор для кнопки "Заказать" в нижней части страницы:
    private static final By OrderButtonDown = By.className("Button_UltraBig__UU3Lp");
    // Локатор для поля "Имя":
    private static final By NameButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    // Локатор для поля "Фамилия":
    private static final By SurnameButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    // Локатор для поля "Адрес: куда привезти заказ":
    private static final By AddressButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    // Локатор для поля "Станция метро":
    private static final By MetroButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div/input");
    // Локатор для поля "Телефон: на него позвонит курьер":
    private static final By TelButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    // Локатор для кнопки "Далее":
    private static final By NextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");

    // Локаторы для второй страницы

    // Локатор для поля "*Когда привезти самокат":
    private static final By DateButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div/div/input");
    // Локатор для поля "*Срок аренды":
    private static final By PeriodButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div");
    // Локатор для поля "Цвет самоката", с выбором цвета черный жемчуг:
    private static final By BlackButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/label[1]/input");
    // Локатор для поля "Цвет самоката", с выбором цвета серая безысходность:
    private static final By GreyButton = By.xpath("//*[@id='grey']");
    // Локатор для поля "Комментарий для курьера":
    private static final By CommentButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input");
    // Локатор для кнопки "Заказать":
    private static final By SubmitButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");
    // Локатор для попапа "Хотите оформить заказ?":
    private static final By PopapButton = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[1]");
    // Локатор для кнопки "Да":
    private static final By YesButton = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");

    public PageOrder(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для закрытия баннера куки
    public void closeCookieBanner() {
        driver.findElement(CookieBannerButton).click();
    }

    // Заполнение первой страницы заказа:
    public void enterDataFirstPageOrder(String name, String surname, String address, int metro, String phoneNumber) {
        //closeCookieBanner();  // Закрытие баннера куки
        driver.findElement(OrderButtonHeader).click();  // Нажатие на кнопку "Заказать"
        driver.findElement(NameButton).sendKeys(name);  // Заполнение поля "Имя"
        driver.findElement(SurnameButton).sendKeys(surname);  // Заполнение поля "Фамилия"
        driver.findElement(AddressButton).sendKeys(address);  // Заполнение поля "Адрес"
        driver.findElement(MetroButton).click();  // Нажатие на поле "Станция метро"

        // Выбор станции метро из списка:
        By allMetroStation = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]/ul/li");
        List<WebElement> elements = driver.findElements(allMetroStation);
        elements.get(metro - 1).click();  // Выбор станции метро по индексу

        driver.findElement(TelButton).sendKeys(phoneNumber);  // Заполнение поля "Телефон"
        driver.findElement(NextButton).click();  // Нажатие на кнопку "Далее"
    }

    // Заполнение второй страницы заказа:
    public void enterDataSecondPageOrder(String color, String date, int rentalDays, String comment) {
        // Выбор цвета самоката:
        if ("черный".equals(color)) {
            driver.findElement(BlackButton).click();
        } else if ("серый".equals(color)) {
            driver.findElement(GreyButton).click();
        }

        // Выбор даты:
        driver.findElement(DateButton).sendKeys(date);
        driver.findElement(DateButton).sendKeys(Keys.RETURN);

        // Выбор срока аренды:
        driver.findElement(PeriodButton).click();
        By allDayForOrder = By.className("Dropdown-option");
        List<WebElement> elements = driver.findElements(allDayForOrder);
        elements.get(rentalDays - 1).click();  // Выбор срока аренды

        driver.findElement(CommentButton).sendKeys(comment);  // Заполнение поля "Комментарий"
        driver.findElement(SubmitButton).click();  // Нажатие на кнопку "Заказать"
        driver.findElement(YesButton).click();  // Подтверждение заказа в попапе
    }

    // Попап подтверждения оформления заказа:
    public boolean successfullyText() {
        String successfullOrder = driver.findElement(PopapButton).getText();
        return successfullOrder.contains("Заказ оформлен");
    }
}*/
