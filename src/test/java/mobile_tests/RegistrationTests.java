package mobile_tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000)+1000;
        UserDTO user = UserDTO.builder()
                .username("john"+i+"@gmail.com")
                .password("John123456$")
                .firstName("John")
                .lastName("Silver")
                .build();

        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .fillRegistrationForm(user)
                .clickCheckBox()
                .clickBtnYallaPositive()
                .isElementPresent_popUpMessageSuccess("Registration success!"));

    }
}
