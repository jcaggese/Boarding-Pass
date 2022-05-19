package pkg.boardingpass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ETATest {
    ETA time;

    @BeforeEach
    void setUp() {
        time = new ETA();
    }



    @Test
    void calculate()
    {
        LocalDateTime test = LocalDateTime.now();
        System.out.println(time.Calculate(test, "LAX"));
    }

    @AfterEach
    void tearDown() {
    }
}