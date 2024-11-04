package api_tests.rest;

import api.CarController;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllCarsTestRest extends CarController {

    @Test
    public void getAllCarsPositiveTest(){
        Assert.assertEquals(getAllCarsResponse(tokenDto.getAccessToken())
                .getStatusCode(),200);
    }
}
