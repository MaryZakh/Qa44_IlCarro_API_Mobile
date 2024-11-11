package api_tests.rest;

import api.AuthenticationController;
import dto.ErrorMessageDtoString;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTestsRest extends AuthenticationController {

    @Test
    public void registrationPositiveTest() {

        int i = new Random().nextInt(1000) + 1000;

        UserDTO registrationBodyDto = UserDTO.builder()
                .username("john_doe" + i + "@gmail.com")
                .password("Jjohn123456$")
                .firstName("John")
                .lastName("Doe")
                .build();
        Assert.assertEquals(registrationLogin(registrationBodyDto, REGISTRATION_URL).getStatusCode(), 200);
    }

    @Test
    public void registrationNegativeTest_EmptyPassword() {

        int i = new Random().nextInt(1000) + 1000;

        UserDTO registrationBodyDto = UserDTO.builder()
                .username("john_doe" + i + "@gmail.com")
                .password("")
                .firstName("John")
                .lastName("Doe")
                .build();
        Assert.assertEquals(registrationLogin(registrationBodyDto, REGISTRATION_URL).getBody()
                .as(ErrorMessageDtoString.class)
                .getError(), "Bad Request");
        Assert.assertEquals(registrationLogin(registrationBodyDto, REGISTRATION_URL).getBody()
                .as(ErrorMessageDtoString.class)
                .getStatus(), 400);

    }
}
