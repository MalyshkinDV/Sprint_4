package order;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikumServices.qaScooter.pom.BaseTest;
import ru.praktikumServices.qaScooter.pom.main.MainPage;
import ru.praktikumServices.qaScooter.pom.order.OrderPagePart1;
import ru.praktikumServices.qaScooter.pom.order.OrderPagePart2;

@RunWith(Parameterized.class)
public class TestOrder extends BaseTest {
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String station;
    private final String phone;
    private final String buttonOrder;
    private final String rentalDate;
    private final int indexRentalPeriod;
    private final String colorOfScooter;
    private final String comment;

    public TestOrder(String firstName, String secondName, String address, String station, String phone, String buttonOrder, String rentalDate, int indexRentalPeriod, String colorOfScooter, String comment) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.buttonOrder = buttonOrder;
        this.rentalDate = rentalDate;
        this.indexRentalPeriod = indexRentalPeriod;
        this.colorOfScooter = colorOfScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] setValues() {
        return new Object[][] {
                {"Анатоля", "Коситполя", "Арбат", "Спортивная", "79009009090", "bottom button", "08.12.2022", 0, "чёрный жемчуг", "Жду Вас"},
                {"Ержан", "Конейжарев", "Новая", "Лубянка", "79009009091", "top button", "20.12.2022", 4, "оба цвета выбраны", "Буду дома вечером"},
        };
    }

    @Test
    public void testOfOrder() {
        MainPage objMainPage = new MainPage(driver);
        OrderPagePart1 objPagePart1 = new OrderPagePart1(driver);
        OrderPagePart2 objOrderPart2 = new OrderPagePart2(driver);
        objMainPage.clickButtonAcceptCookies();
        objMainPage.clickButtonsOrder(buttonOrder);
        objPagePart1.setWhoIsTheScooterFor(firstName, secondName, address, station, phone);
        objOrderPart2.setRentalDate(rentalDate);
        objOrderPart2.clickFieldRentalPeriod();
        objOrderPart2.clickArrowFieldRentalPeriod(indexRentalPeriod);
        objOrderPart2.chooseCheckBox(colorOfScooter);
        objOrderPart2.setComment(comment);
        objOrderPart2.confirmOrder();
        objOrderPart2.checkSuccessWindow();
    }
}
