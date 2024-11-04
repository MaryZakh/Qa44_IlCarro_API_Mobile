package api_tests.rest;

import api.CarController;
import dto.CarDto;
import dto.CarsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCarTestRest extends CarController {

    @Test
    public void deleteCarByIdPositiveTest(){
        CarDto [] arrayCar = getAllCarsResponse(tokenDto.getAccessToken()).getBody()
                        .as(CarsDto.class)
                                .getCars();


        Assert.assertEquals(deleteCarByIdResponse(tokenDto.getAccessToken(),arrayCar[0]
                .getSerialNumber()).getStatusCode(),200);

    }

    @Test
    public void deleteCarByIdNegativeTest_WrongSerialNumber(){
        CarDto [] arrayCar = getAllCarsResponse(tokenDto.getAccessToken()).getBody()
                .as(CarsDto.class)
                .getCars();


        Assert.assertEquals(deleteCarByIdResponse(tokenDto.getAccessToken(),"123456").getStatusCode(),400);

    }
}
