package ru.praktikumServices.qaScooter.POM.order;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class OrderPagePart1 {
    private final WebDriver driver;
    private final By fieldFirstName = By.xpath(".//input[contains(@placeholder, 'Имя')]");// Поле "Имя"
    private final By fieldSecondName = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");// Поле "Фамилия"
    private final By fieldAddressForOrder = By.xpath(".//input[contains(@placeholder, 'Адрес')]");// Поле "Адрес"
    private final By fieldMetroStation = By.className("select-search__input");//"Поле "Станция метро"
    private final By fieldPhoneNumber = By.xpath(".//input[contains(@placeholder, 'Телефон')]");// Поле "Телефон"
    private final By buttonNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");// кнопка "Далее"

    public OrderPagePart1(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(fieldFirstName).sendKeys(firstName);
    }

    public void setSecondName(String secondName) {
        driver.findElement(fieldSecondName).sendKeys(secondName);
    }

    public void setAddressForOrder(String address) {
        driver.findElement(fieldAddressForOrder).sendKeys(address);
    }

    public void clickMetroStation() {
        driver.findElement(fieldMetroStation).click();
    }

    public void chooseMetroStation(String station) {
        driver.findElement(fieldMetroStation).sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setPhoneNumber(String phone) {
        driver.findElement(fieldPhoneNumber).sendKeys(phone);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void setWhoIsTheScooterFor(String firstName, String secondName, String address, String station, String phone) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAddressForOrder(address);
        clickMetroStation();
        chooseMetroStation(station);
        setPhoneNumber(phone);
        clickButtonNext();
    }
}
