package pkg.boardingpass;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Class manages user input.
 * For now, does so through console.
 */
public class Input {
    private String name;
    private String email;
    private String phoneNum;
    private String gender;
    private String age;
    private String date; //Change to LocalDateTime if necessary
    private String destination;
    private String departure; //Change to LocalDateTime if necessary

    public Input(){
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your name: ");
            name = in.nextLine();
            System.out.println("Enter your email: ");
            email = in.nextLine();
            System.out.println("Enter your phone number: ");
            phoneNum = in.nextLine();
            System.out.println("Enter your gender: ");
            gender = in.nextLine();
            System.out.println("Enter your age: ");
            age = in.nextLine();
            System.out.println("Enter the current date: "); //assumes correct input (if using gui might not matter)
            date = in.nextLine();
            System.out.println("Enter your destination: ");
            destination = in.nextLine();
            System.out.println("Enter the date of departure: "); //assumes correct input (if using gui might not matter)
            departure = in.nextLine();
        } catch (Exception e) {
            System.err.println("Could not get user input.");
        }
    }

    /**
     * Constructor with provided inputs
     * Primary use is for testing without needing to actually input to console every time.
     * @param vals
     */
    public Input(String[] vals){
        name = vals[0];
        email = vals[1];
        phoneNum = vals[2];
        gender = vals[3];
        age = vals[4];
        date = vals[5];
        destination = vals[6];
        departure = vals[7];
    }

    /**
     * @return all fields: [name, email, phone, gender, age, date, destination, departure]
     */
    public Object[] getAll() {
        Object[] retArray = {name, email, phoneNum, gender, age, date, destination, departure};
        return retArray;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }
}
