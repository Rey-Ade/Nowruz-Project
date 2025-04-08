package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import sbu.cs.genius.account.Account;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.account.User;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField nameTextField, ageTextField, usernameTextField, emailTextField, passwordTextField;

    @FXML
    private Label ageMessage, roleMessage, usernameAlert, usernameMessage, emailMessage, passwordAlert, passwordMessage;

    @FXML
    private ChoiceBox<String> choiceBox;

    private final String[] role = {"User", "Artist"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(role);
        System.out.println("-> signup-view is initialized");
    }

    @FXML
    public void signUp(ActionEvent event) throws IOException {
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
        // check if username is valid
        if (!Account.validUsername(usernameTextField.getText())) {
            usernameAlert.setText("Invalid username");
            usernameAlert.setTextFill(Color.RED);
            usernameAlert.setOpacity(1.0);
            usernameMessage.setOpacity(0.5);
            return;
        }
        else {
            usernameAlert.setText("Valid username");
            usernameAlert.setTextFill(Color.GREEN);
            usernameAlert.setOpacity(1.0);
            usernameMessage.setOpacity(0.0);
        }
        // check if email is valid
        if (!Account.validEmail(emailTextField.getText())) {
            emailMessage.setText("Invalid email");
            emailMessage.setTextFill(Color.RED);
            return;
        }
        else {
            emailMessage.setText("");
        }
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
        // if "User" is chosen
        if (choiceBox.getValue().compareTo("User") == 0) {
            User.setUser(new User(nameTextField.getText(), usernameTextField.getText(), emailTextField.getText(),
                         passwordTextField.getText(), Integer.parseInt(ageTextField.getText())));
            System.out.println("-> User is created");
        }
        // if "Artist" is chosen
        else {
            Artist.setArtist(new Artist(nameTextField.getText(), usernameTextField.getText(), emailTextField.getText(),
                             passwordTextField.getText(), Integer.parseInt(ageTextField.getText())));
            System.out.println("-> Artist is created");
            Artist.addArtistToArtists(Artist.getArtist());
            System.out.println("-> Artist is added to Artists arraylist");
        }

        // switch to home view
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sbu/cs/genius/home-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        System.out.println("-> switched to home scene");
    }
}