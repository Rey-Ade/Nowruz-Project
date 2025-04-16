package sbu.cs.genius;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sbu.cs.genius.account.Account;
import sbu.cs.genius.account.Artist;
import sbu.cs.genius.account.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    AnchorPane anchorPane;

    @FXML
    ScrollPane scrollPane;

    @FXML
    Label name, username, age, email, info, oldPass, newPass, oldPassAlert, newPassMessage, newPassAlert, followingLabel;

    @FXML
    TextField oldPassTextField, newPassTextField, nameTextField, usernameTextField, ageTextField, emailTextField;

    @FXML
    TextArea infoTextArea;

    @FXML
    ListView<String> followingListView;

    @FXML
    Button editButton, changePassButton, cancelButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(Account.account.getName());
        username.setText(Account.account.getUsername());
        age.setText(String.valueOf(Account.account.getAge()));
        email.setText(Account.account.getEmail());
        // if user is an Artist
        if (Artist.getArtist() != null) {
            // add artist's info
            info.setVisible(true);
            Text artistInfo = new Text(Artist.getArtist().getInfo());
            artistInfo.setLayoutX(200);
            artistInfo.setLayoutY(250);
            anchorPane.getChildren().add(artistInfo);
        }
        else {
            followingLabel.setVisible(true);
            scrollPane.setVisible(true);
            for (Artist following : User.getUser().getFollowingList()) {
                followingListView.getItems().add(following.toString());
            }
            followingListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    int index = followingListView.getSelectionModel().getSelectedIndex();
                    System.out.println("-> selected " + followingListView.getSelectionModel().getSelectedItem());
                    // load artist controller
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/artist-view.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    ArtistController artistController = loader.getController();
                    artistController.setScene(User.getUser().getFollowingList().get(index), "/sbu/cs/genius/profile-view.fxml");
                    // switch scenes
                    Stage stage = (Stage) followingListView.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    System.out.println("-> switched to artist scene");
                }
            });
        }
        System.out.println("-> profile scene is set");
    }

    public void edit(ActionEvent event) {
        name.setVisible(false);
        nameTextField.setVisible(true);
        nameTextField.setText(name.getText());
        username.setVisible(false);
        usernameTextField.setVisible(true);
        usernameTextField.setText(username.getText());
        age.setVisible(false);
        ageTextField.setVisible(true);
        ageTextField.setText(age.getText());
        email.setVisible(false);
        emailTextField.setVisible(true);
        emailTextField.setText(email.getText());
        // if user is an Artist
        if (Artist.getArtist() != null) {
            // remove artistInfo text
            anchorPane.getChildren().removeLast();
            infoTextArea.setVisible(true);
            infoTextArea.setText(Artist.getArtist().getInfo());
        }
        editButton.setText("Submit");
        editButton.setLayoutX(395);
        editButton.setLayoutY(25);
        editButton.setOnAction(this::submit);
    }

    private void submit(ActionEvent event) {
        name.setVisible(true);
        nameTextField.setVisible(false);
        name.setText(nameTextField.getText());
        Account.account.setName(nameTextField.getText());
        username.setVisible(true);
        usernameTextField.setVisible(false);
        username.setText(usernameTextField.getText());
        Account.account.setUsername(usernameTextField.getText());
        age.setVisible(true);
        ageTextField.setVisible(false);
        age.setText(ageTextField.getText());
        Account.account.setAge(Integer.parseInt(ageTextField.getText()));
        email.setVisible(true);
        emailTextField.setVisible(false);
        email.setText(emailTextField.getText());
        Account.account.setEmail(emailTextField.getText());
        // if user is an Artist
        if (Artist.getArtist() != null) {
            Text artistInfo = new Text(infoTextArea.getText());
            artistInfo.setLayoutX(200);
            artistInfo.setLayoutY(250);
            anchorPane.getChildren().add(artistInfo);
            infoTextArea.setVisible(false);
            Artist.getArtist().setInfo(infoTextArea.getText());
        }
        editButton.setText("Edit");
        editButton.setPrefWidth(65);
        editButton.setPrefHeight(30);
        editButton.setOnAction(this::edit);
    }

    public void changePassword(ActionEvent event) {
        oldPass.setVisible(true);
        newPass.setVisible(true);
        oldPassTextField.setVisible(true);
        newPassTextField.setVisible(true);
        newPassAlert.setVisible(true);
        changePassButton.setText("Reset Password");
        changePassButton.setPrefWidth(130);
        changePassButton.setPrefHeight(30);
        changePassButton.setOnAction(this::resetPassword);
        cancelButton.setVisible(true);
    }

    private void resetPassword(ActionEvent event) {
        // check it old password is incorrect
        if (!oldPassTextField.getText().equals(Account.account.getPassword())) {
            oldPassAlert.setVisible(true);
            return;
        }
        else {
            oldPassAlert.setVisible(false);
            // check if new password is invalid
            if (!Account.validPassword(newPassTextField.getText())) {
                newPassAlert.setText("Invalid password");
                newPassAlert.setTextFill(Color.RED);
                newPassAlert.setOpacity(1.0);
                newPassMessage.setVisible(true);
                return;
            }
            else {
                Account.account.setPassword(newPassTextField.getText());
                newPassAlert.setVisible(false);
                newPassMessage.setVisible(false);
            }
        }
        oldPass.setVisible(false);
        newPass.setVisible(false);
        oldPassTextField.setVisible(false);
        newPassTextField.setVisible(false);
        // successfully changed password
        changePassButton.setText("Change Password");
        changePassButton.setOnAction(this::changePassword);
    }

    public void cancel(ActionEvent event) {
        oldPass.setVisible(false);
        newPass.setVisible(false);
        oldPassAlert.setVisible(false);
        newPassAlert.setVisible(false);
        newPassMessage.setVisible(false);
        oldPassTextField.setVisible(false);
        newPassTextField.setVisible(false);
        cancelButton.setVisible(false);
        changePassButton.setText("Change Password");
        changePassButton.setPrefWidth(130);
        changePassButton.setPrefHeight(30);
        changePassButton.setOnAction(this::changePassword);
    }

    public void home(ActionEvent event) throws IOException {
        // switch to home scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sbu/cs/genius/home-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        System.out.println("-> switched to home scene");
    }
}
