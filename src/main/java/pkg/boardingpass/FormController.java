package pkg.boardingpass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormController {
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    TextField phone;
    @FXML
    SplitMenuButton gender;
    @FXML
    TextField age;
    @FXML
    DatePicker date;
    @FXML
    SplitMenuButton destination;
    @FXML
    DatePicker departure;
    @FXML
    TextField departTime;
    @FXML
    Label error;

    @FXML
    protected void submit() throws IOException {
        //check if all fields filled out properly
        if(name.getText().isBlank())
            error.setText("Please input your name");
        else if(!checkEmail(email.getText()))
            error.setText("Incorrect email format. Should be xxx@yyy.com.");
        else if(!checkPhone(phone.getText()))
            error.setText("Incorrect Phone Number. Format should be ten numbers.");
        else if(gender.getText().equals("Select"))
            error.setText("Please select a gender.");
        else if(!checkAge(age.getText()))
            error.setText("Please input a number for age.");
        else if (date.getValue() == null)
            error.setText("Please select the current date.");
        else if (destination.getText().equals("Select"))
            error.setText("Please select a destination.");
        else if (!checkDeparture(departure.getValue(), departTime.getText()))
            error.setText("Please select a date of departure after the current date with time in format: (XX:XX).");
        else {
            error.setText("");
            //run BoardingPass functions from here
            System.out.println(name.getText());
            System.out.println(email.getText());
            System.out.println(phone.getText());
            System.out.println(gender.getText());
            System.out.println(age.getText());
            System.out.println(date.getValue());
            System.out.println(destination.getText());
            System.out.println(departure.getValue());
        }
    }

    @FXML
    protected void changeValGen(ActionEvent e) throws IOException {
        MenuItem choice = (MenuItem) e.getSource();
        gender.setText(choice.getText());
    }

    @FXML
    protected void changeValDest(ActionEvent e) throws IOException {
        MenuItem choice = (MenuItem) e.getSource();
        destination.setText(choice.getText());
    }

    private boolean checkEmail(String email) {
        if (email.isBlank())
            return false;
        Matcher match = Pattern.compile("\\w+@\\w+.com").matcher(email);
        if (match.matches())
            return true;
        return false;
    }

    private boolean checkPhone(String phone) {
        Matcher match = Pattern.compile("\\d{10}").matcher(phone);
        if (match.find())
            return true;
        return false;
    }

    private boolean checkAge(String age) {
        if (age.isBlank())
            return false;
        Matcher match = Pattern.compile("\\d+").matcher(age);
        if (match.matches())
            return true;
        return false;
    }

    private boolean checkDeparture(LocalDate departure, String departTime) {
        if (departure == null)
            return false;
        Matcher match = Pattern.compile("\\d\\d:\\d\\d").matcher(departTime);
        if (!match.matches())
            return false;
        String[] time = departTime.split(":");
        if (Integer.parseInt(time[0]) > 23 || Integer.parseInt(time[1]) > 59)
            return false;
        if (departure.compareTo(date.getValue()) >= 0) //depart after current date
            return true;
        return false;
    }
}