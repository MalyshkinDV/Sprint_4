package questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikumServices.qaScooter.POM.main.AccordionPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestAccordion {
    private WebDriver driver;
    private final int indexQuestion;
    private final int indexAnswer;
    private final String expectedTextAnswer;

    public TestAccordion(int indexQuestion, int indexAnswer, String expectedTextAnswer) {
        this.indexQuestion = indexQuestion;
        this.indexAnswer = indexAnswer;
        this.expectedTextAnswer = expectedTextAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] setValues() {
        return new Object[][] {
                {0, 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    /*public void startUp() {
        WebDriverManager.firefoxdriver().setup();
    }*/

    @Test
    public void testListOfQuestions() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/"); // открыли сайт
        AccordionPage objAccordionPage = new AccordionPage(driver);
        objAccordionPage.clickButtonAcceptCookies();
        objAccordionPage.scrollToImportantQuestions();
        objAccordionPage.waitButtonForQuestions();
        objAccordionPage.clickButtonForQuestions(indexQuestion);
        assertEquals("Ошибка, не соответствие требованиям!", expectedTextAnswer, objAccordionPage.getTextAnswers(indexAnswer));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}