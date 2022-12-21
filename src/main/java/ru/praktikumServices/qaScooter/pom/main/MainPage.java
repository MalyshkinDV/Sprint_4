package ru.praktikumServices.qaScooter.pom.main;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;//
    private final By buttonAcceptCookies = By.className("App_CookieButton__3cvqF");// кнопка "Мы уже привыкли"
    private final By topButtonOrder = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text() = 'Заказать']");// Верхняя кнопка "Заказать"
    private final By bottomButtonOrder = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text() = 'Заказать']");// Нижняя кнопка "Заказать"
    private final By elementForScroll = By.className("Home_FinishButton__1_cWm");// элемент к которой идет скролл для доступа к нижней кнопке "Заказать" и блоку "Вопросы о важном"
    private final By buttonForQuestions = By.className("accordion__button");// Кнопка выбора вопроса
    private final By textOfAnswer =By.xpath(".//div[@class='accordion__panel']/p");// Текст ответа на вопрос


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonAcceptCookies() {
        driver.findElement(buttonAcceptCookies).click();
    }

    public void scrollToElementForScroll() {
        WebElement element = driver.findElement(elementForScroll);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitToElementForScroll() {
        WebElement element = driver.findElement(elementForScroll);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickButtonsOrder(String buttonOrder) {
        if (buttonOrder.equals("bottom button")) {
            scrollToElementForScroll();
            waitToElementForScroll();
            driver.findElement(bottomButtonOrder).click();
        } else {
            driver.findElement(topButtonOrder).click();
        }
    }

    public void waitButtonForQuestions() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(buttonForQuestions));
    }

    public void clickButtonForQuestions(int indexQuestion) {
        List<WebElement> questions = driver.findElements(buttonForQuestions);
        questions.get(indexQuestion).click();
    }

    public String getTextAnswers(int indexAnswer) {
        List<WebElement> answers = driver.findElements(textOfAnswer);
        return answers.get(indexAnswer).getText();
    }
}


