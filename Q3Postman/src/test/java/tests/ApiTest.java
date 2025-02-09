package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.io.IOException;
import static io.restassured.RestAssured.given;

public class ApiTest {

    @DataProvider(name = "excelTestData")
    public Object[][] getTestData() throws IOException {
        String filePath = "src/test/resources/RestAssuredQ3Excel.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtil.getTestData(filePath, sheetName);
    }

    @Test(dataProvider = "excelTestData")
    public void excelDataTesting(String sl, String language){

        System.out.println(sl+" "+language);

        RestAssured.baseURI = "https://restcountries.com/v3.1/translation";

        Response response = given().when().get("/"+language).then().extract().response();
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}