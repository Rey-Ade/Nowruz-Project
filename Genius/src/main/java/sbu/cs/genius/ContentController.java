package sbu.cs.genius;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ContentController implements Initializable {

    @FXML
    private Label heading, subheading, label1, label2, label3, label4, label5, content1, content2, content3, content4, content5;

    @FXML
    private ListView<String> listView;

    private Object selectedItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getItem(Object item) {
        selectedItem = item;
    }

}
