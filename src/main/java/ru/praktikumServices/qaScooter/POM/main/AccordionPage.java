package ru.praktikumServices.qaScooter.POM.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class AccordionPage {
    private final WebDriver driver;
    private final By buttonAcceptCookies = By.className("App_CookieButton__3cvqF");// Кнопка "Мы уже привыкли"
    private final By importantQuestions = By.className("accordion");// "Вопросы о важном"
    private final By buttonForQuestions = By.className("accordion__button");// Кнопка выбора вопроса
    private final By textOfAnswer =By.xpath(".//div[@class='accordion__panel']/p");// Текст ответа на вопрос

    public AccordionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonAcceptCookies() {
        driver.findElement(buttonAcceptCookies).click();
    }

    public void scrollToImportantQuestions() {
        WebElement element = driver.findElement(importantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
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
