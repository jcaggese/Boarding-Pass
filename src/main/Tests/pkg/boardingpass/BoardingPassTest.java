package pkg.boardingpass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {
    BoardingPass pass;

    @BeforeEach
    void setUp() {
        BoardingPass pass = new BoardingPass("Tester", "Tester@test.com", "0987654321",
                "Test", "85", LocalDate.of(2012, 12, 11), "LAX",
                LocalDateTime.of(2013, 4, 10, 8, 30),
                LocalDateTime.of(2013, 4, 10, 9, 45),
                "$3.50");
    }
}