package ru.praktikumServices.qaScooter.POM.main;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;//
    private final By buttonAcceptCookies = By.className("App_CookieButton__3cvqF");// кнопка "Мы уже привыкли"
    private final By topButtonOrder = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text() = 'Заказать']");// Верхняя кнопка "Заказать"
    private final By bottomButtonOrder = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text() = 'Заказать']");// Нижняя кнопка "Заказать"
    private final By elementForScroll = By.className("Home_FinishButton__1_cWm");// элемент к которой идет скролл для доступа к нижней кнопке "Заказать"

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
        if (buttonOrder == "bottom button") {
            scrollToElementForScroll();
            waitToElementForScroll();
            driver.findElement(bottomButtonOrder).click();
        } else {
            driver.findElement(topButtonOrder).click();
        }
    }
}


