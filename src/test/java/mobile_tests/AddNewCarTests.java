package mobile_tests;

import config.AppiumConfig;
import dto.CarDto;
import dto.Fuel;
import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

public class AddNewCarTests extends AppiumConfig {


    SearchScreen searchScreen;

    @BeforeMethod
    public void login() {
        UserDTO user = UserDTO.builder()
                .username("margo1@gmail.com")
                .password("Mmar123456$")
                .build();
        searchScreen = new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginFormPositive(user)
        ;
    }

    @Test(invocationCount = 3)
    public void addNewCarPositiveTest() {
        int i = new Random().nextInt(1000)+1000;
        CarDto car = CarDto.builder()
                .serialNumber("777-"+i)
                .manufacture("Tesla")
                .model("Model X")
                .year("2024")
                .fuel(Fuel.ELECTRIC.getFuel())
                .seats(4)
                .carClass("B")
                .pricePerDay(1.23)
                .city("Haifa")
                .about("My Car")
                .build();



        searchScreen.clickBtnDots()
                .clickBtnMyCars()
                .clickBtnAddNewCar()
                .typeAddNewCarForm(car)
                .clickBtnAddCarPositived()
                .isElementPresent_popUpMessageSuccess("Car was added!");
    }
}
