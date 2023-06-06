package com.restful.booker.bookinginfo;

import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class BookingCRUDTestWithSteps extends TestBase {
    static String firstname = "Kiara" + TestUtils.getRandomValue();
    static String lastname = "Parikh" + TestUtils.getRandomValue();
    static int totalprice = 1199;
    static boolean depositpaid = true;
    static String additionalneeds = "Breakfast";
    static String username = "admin";
    static String password = "password123";
    static String checkin = "2024-08-20";
    static String checkout = "2024-09-10";
    static int id;
    @Steps
    BookingSteps bookingSteps;

    @Title("This will create a new token")
    @Test
    public void Test1() {
        bookingSteps.createToken(username, password);
    }

    @Title("This will create a new booking")
    @Test
    public void Test2() {
        ValidatableResponse response = bookingSteps.createBooking(firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds);
        id = response.extract().path("bookingid");
    }

    @Title("Verify if the booking was added to the application")
    @Test
    public void Test3() {
        ValidatableResponse bookingMap = bookingSteps.getBookingByFirstName(id);
        String bookingId = bookingMap.extract().path("firstname");
        Assert.assertTrue(bookingId.contains(firstname));
    }

    @Title("Update the booking information and verify the updated information")
    @Test
    public void Test4() {
        bookingSteps.updatBooking(id);

    }

    @Title("Delete the booking and verify if the booking is deleted")
    @Test
    public void Test5() {
        bookingSteps.deleteBooking(id);
        bookingSteps.getStudentById(id);
    }

}
