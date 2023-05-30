package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.lessThan;
import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {

    @Test
    public void partiallyUpdateBooking() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Raja");
        bookingPojo.setLastname("Soni");

        Response response = given()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Content-Type", "application/json")
                .header("Cookie", "token=1f8f6bb72e6f21c")
                .pathParam("id", 2)
                .body(bookingPojo)
                .when()
                .patch("/booking/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}
