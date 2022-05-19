package pkg.boardingpass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Creates boarding pass from input data
 * Stores all information in a file
 */
public class BoardingPass {
    private String origin;
    private String name;
    private String email;
    private String phoneNum;
    private String gender;
    private String age;
    private LocalDate date;
    private String destination;
    private LocalDateTime departure;
    private String passID;
    private LocalDateTime ETA;

    public BoardingPass(String name, String email, String phoneNum, String gender, String age, LocalDate date,
                        String destination, LocalDateTime departure) {
        origin = "JFK";
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.destination = destination;
        this.departure = departure;
        passID = generateID();
    }

    /**
     * Uses UUID to generate unique ID for boarding pass
     * Uses hashcode to turn that UUID into a number
     * Could use BigInteger, if hashing collisions are a problem
     * but the smaller size of an int is preferred for readability
     * @return
     */
    private String generateID() {
        return UUID.randomUUID().hashCode() + "";
    }


}
