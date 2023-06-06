package com.restful.booker.bookinginfo;

import com.restful.booker.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
@Concurrent(threads = "4x")
@UseTestDataFrom("src/test/java/resources/testdata/studentinfo.csv") //content root os csvfile
@RunWith(SerenityParameterizedRunner.class)

public class CreateBookingDataDrivenTest extends TestBase {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private Date bookingdates;
    private String additionalneeds;
    private String checkin;
    private String checkout;

        @Steps
       BookingSteps bookingSteps;
        @Title("Data driven test for adding multiple booking to the application")
        @Test
        public void createMultipleStudents(){
            bookingSteps.createBooking(firstname,lastname,totalprice,depositpaid,checkin,checkout,additionalneeds);
        }
}
