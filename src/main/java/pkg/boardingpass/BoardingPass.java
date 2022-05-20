package pkg.boardingpass;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Creates boarding pass from input data
 * Stores all information in a file
 */
public class BoardingPass {
    private final String filePath = "src/main/resources/pkg/boardingpass/Tickets/";
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
    private LocalDateTime eta;
    private String price;

    public BoardingPass(String name, String email, String phoneNum, String gender, String age, LocalDate date,
                        String destination, LocalDateTime departure, LocalDateTime eta, String price) {
        origin = "JFK";
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.destination = destination;
        this.departure = departure;
        this.eta = eta;
        this.price = price;
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

    /**
     * Writes data to file named after boarding pass number
     * Each field is on a new line
     * Date time fields separated by ',' as:
     * year,month,day,hour,minute
     */
    public void writeData() {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            Files.write(Paths.get(filePath + passID),
                    (passID + "\n" +
                            origin + "\n" +
                            name + "\n" +
                            email + "\n" +
                            phoneNum + "\n" +
                            gender + "\n" +
                            age + "\n" +
                            date.format(dateFormat) + "\n" +
                            destination + "\n" +
                            departure.format(timeFormat) + "\n" +
                            eta.format(timeFormat) + "\n" +
                            price).getBytes());
        }
        catch (IOException e) {
            System.err.println("Could not create Ticket.");
        }
    }

    /**
     * Reads data from file and creates user readable version of that file
     * Currently stores in a text file named passID + .txt
     */
    public void printTicket() {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try (BufferedReader input = new BufferedReader(new FileReader(filePath + passID))){
            Files.write(Paths.get(filePath + passID + ".txt"),
                    ("ID:  " + input.readLine() + "\n" +
                            "Origin:  " + input.readLine() + "\n" +
                            "Name:  " + input.readLine() + "\n" +
                            "Email:  " + input.readLine() + "\n" +
                            "Phone Number:  " + input.readLine() + "\n" +
                            "Gender:  " + input.readLine() + "\n" +
                            "Age:  " + input.readLine() + "\n" +
                            "Date of Purchase:  " + input.readLine() + "\n" +
                            "Destination:  " + input.readLine() + "\n" +
                            "Departure Date:  " + input.readLine() + "\n" +
                            "Estimated Time of Arrival:  " + input.readLine() + "\n" +
                            "Price:  " + input.readLine()).getBytes());
        }
        catch (IOException e) {
            System.err.println("Could not print Ticket.");
        }
    }

    private String dateToStr(LocalDateTime date) {
        return date.getYear() + "," + date.getMonth() + "," + date.getDayOfMonth() + "," + date.getHour() + "," + date.getMinute();
    }


}
