package ru.praktikumServices.qaScooter.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
    protected static WebDriver driver;// переменная WebDriver
    protected static String url;//переменная хранящая url

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();// открываем cайт
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        url = "https://qa-scooter.praktikum-services.ru/";
        driver.get(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
