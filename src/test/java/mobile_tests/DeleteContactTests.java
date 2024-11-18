package mobile_tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreen;

public class DeleteContactTests extends AppiumConfig {

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

    @Test
    public void deleteFirstCar() {
        searchScreen.clickBtnDots()
                .clickBtnMyCars()
                .deleteFirstCar()
                .isListOfCarsLessOnOne();

    }
}
