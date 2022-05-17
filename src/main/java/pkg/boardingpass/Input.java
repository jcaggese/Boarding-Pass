package pkg.boardingpass;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class manages user input.
 * For now, does so through console.
 */
public class Input extends Application {
    private String name;
    private String email;
    private String phoneNum;
    private String gender;
    private String age;
    private String date; //Change to LocalDateTime if necessary
    private String destination;
    private String departure; //Change to LocalDateTime if necessary

    public Input(){

    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene form = new Scene(FXMLLoader.load(getClass().getResource("form.fxml")));
        stage.setTitle("Boarding Pass Registration");
        stage.setScene(form);
        stage.show();
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
