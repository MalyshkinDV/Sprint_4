package ru.praktikumServices.qaScooter.pom.order;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OrderPagePart2 {
    private final WebDriver driver;
    private final By fieldRentalDate = By.xpath(".//div[@class = 'react-datepicker__input-container']/input");
    private final By fieldRentalPeriod = By.xpath(".//span[@class = 'Dropdown-arrow']");
    private final By rentalPeriods = By.className("Dropdown-option");
    private final By checkboxGrey = By.id("grey");
    private final By checkboxBlack = By.id("black");
    private final By fieldForComment = By.xpath(".//input[contains(@placeholder, 'Комментарий')]");
    private final By buttonForOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    private final By buttonYes = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[text()='Да']");
    private final By successWindow = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPagePart2(WebDriver driver) {
        this.driver = driver;
    }

    public void setRentalDate (String rentalDate) {
        driver.findElement(fieldRentalDate).sendKeys(rentalDate, Keys.ENTER);
    }

    public void clickFieldRentalPeriod() {
        driver.findElement(fieldRentalPeriod).click();
    }

    public void clickArrowFieldRentalPeriod (int indexRentalPeriod) {
        List<WebElement> listOfRentalPeriods = driver.findElements(rentalPeriods);
        listOfRentalPeriods.get(indexRentalPeriod).click();
    }

    public void chooseCheckBox(String colorOfScooter) {
        if(colorOfScooter.equals("чёрный жемчуг")) {
            driver.findElement(checkboxBlack).click();
        } else if (colorOfScooter.equals("серая безысходность")) {
            driver.findElement(checkboxGrey).click();
        } else {
            driver.findElement(checkboxBlack).click();
            driver.findElement(checkboxGrey).click();
        }
    }

    public void setComment(String comment) {
        driver.findElement(fieldForComment).sendKeys(comment);
    }

    public void clickButtonForOrder() {
        driver.findElement(buttonForOrder).click();
    }

    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    public void confirmOrder() {
        clickButtonForOrder();
        clickButtonYes();
    }

    public void checkSuccessWindow() {
        driver.findElement(successWindow).isDisplayed();
    }
}
