package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import sbu.cs.genius.account.Account;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.account.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField nameTextField, ageTextField, usernameTextField, emailTextField, passwordTextField;

    @FXML
    private Label ageMessage, passwordAlert, passwordMessage, roleMessage;

    @FXML
    private ChoiceBox<String> choiceBox;

    private final String[] role = {"User", "Artist"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(role);
    }

    public void signUp(ActionEvent event) throws IOException {
        // check if password is valid
        if (!Account.validPassword(passwordTextField.getText())) {
            passwordAlert.setText("Invalid password");
            passwordAlert.setTextFill(Color.RED);
            passwordAlert.setOpacity(1.0);
            passwordMessage.setOpacity(0.5);
            return;
        }
        else {
            passwordAlert.setText("Valid password");
            passwordAlert.setTextFill(Color.GREEN);
            passwordAlert.setOpacity(1.0);
            passwordMessage.setOpacity(0.0);
        }
        // check if age is entered in number form
        try {
            Integer.parseInt(ageTextField.getText());
            ageMessage.setText("");
        }
        catch (NumberFormatException e) {
            ageMessage.setText("Enter numbers only");
            ageMessage.setTextFill(Color.RED);
            return;
        }
        // check if a Role is chosen
        if (choiceBox.getValue() == null) {
            roleMessage.setText("Please choose a role");
            roleMessage.setTextFill(Color.RED);
            return;
        }
        else {
            roleMessage.setText("");
        }
        // if "User" is chosen
        if (choiceBox.getValue().compareTo("User") == 0) {
            User.setUser(new User(nameTextField.getText(), usernameTextField.getText(), emailTextField.getText(),
                         passwordTextField.getText(), Integer.parseInt(ageTextField.getText())));
        }
        // if "Artist" is chosen
        else if (choiceBox.getValue().compareTo("Artist") == 0) {
            Artist.setArtist(new Artist(nameTextField.getText(), usernameTextField.getText(), emailTextField.getText(),
                             passwordTextField.getText(), Integer.parseInt(ageTextField.getText())));
        }
    }
}