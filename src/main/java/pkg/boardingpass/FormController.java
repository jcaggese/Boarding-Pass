package pkg.boardingpass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

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
    protected void submit() throws IOException {
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
}