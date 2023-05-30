package com.restful.booker.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    public static String basePath;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    }
}
