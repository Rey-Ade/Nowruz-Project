package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sbu.cs.genius.account.Account;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.account.User;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    Label usernameAlert, passwordAlert;

    @FXML
    TextField usernameTextField, passwordTextField;

    public void login(ActionEvent event) throws IOException {
        // search through allAccounts arraylist
        Account currentAccount = null;
        boolean usernameFound = false;
        boolean correctPass = false;
        for (Account account : Account.allAccounts) {
            if (account.getUsername().equals(usernameTextField.getText())) {
                usernameAlert.setVisible(false);
                usernameFound = true;
                if (account.getPassword().equals(passwordTextField.getText())) {
                    passwordAlert.setVisible(false);
                    correctPass = true;
                    currentAccount = account;
                }
            }
        }
        if (!usernameFound) {
            usernameAlert.setVisible(true);
            return;
        }
        else if (!correctPass) {
            passwordAlert.setVisible(true);
            return;
        }
        else {
            usernameAlert.setVisible(false);
            passwordAlert.setVisible(false);
            if (currentAccount instanceof User) {
                User.setUser((User) currentAccount);
            }
            else if (currentAccount instanceof Artist) {
                Artist.setArtist((Artist) currentAccount);
            }
            else {
                // instance of admin
            }
            Account.account = currentAccount;
        }
        // switch to home scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sbu/cs/genius/home-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        System.out.println("-> switched to home scene");
    }
}
