package pkg.boardingpass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ETATest {
    ETA eta;

    @BeforeEach
    void setUp() {
        eta = new ETA();
    }



    @Test
    void calculate()
    {
        System.out.println("ETA calculation test! \n");
        LocalDateTime test = LocalDateTime.now();
        System.out.println(eta.CalculateETA(test, "LAX"));
        System.out.println("Flight duration is: " + eta.GetDuration());
    }

    @Test
    void calculatePrice()
    {
        System.out.println("Calculate price test! \n");
        String nonexistent = "0";
        String young = "12";
        String adult = "18";
        String old = "60";
        String time = "370";
        String boy = "Male";
        String girl = "Female";
        System.out.println(eta.CalculatePrice(nonexistent, time, boy));
        System.out.println(eta.CalculatePrice(young, time, girl));
        System.out.println(eta.CalculatePrice(adult, time, girl));
        System.out.println(eta.CalculatePrice(old, time, girl));
    }

    @AfterEach
    void tearDown() {
    }
}