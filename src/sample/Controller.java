package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    private ObservableList<String> observableList;
    String[] friend = {"Маруська", "Тимоха", "Андрей", "Великан", "Пуговка"};

    @FXML
    private ResourceBundle resourceBundle;

    @FXML
    private URL location;

    @FXML
    private TextField inputTxt;

    @FXML
    private Button btnSend;
    @FXML
    private ListView<String> listFriend = new ListView<>();
    ObservableList<String> listFr = FXCollections.observableArrayList(friend);

    @FXML
    private ListView<String> chat = new ListView<>();

    @FXML
    void sendEnter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            chat.getItems().add(person() + " : " + inputTxt.getText());
            inputTxt.setText(" ");
        }
    }
    private String person(){
        if(listFriend.getSelectionModel().getSelectedItem()==null) {
            return "I";
        }
        return listFriend.getSelectionModel().getSelectedItem();
    }

    @FXML
    void initialize(){
        listFriend.setItems(listFr);
        assert chat !=null : "fx:id=\"chat\" was not injected: check your FXML file 'sample.fxml'.";
        assert inputTxt !=null : "fx:id=\"inputTxt\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSend !=null : "fx:id=\"btnSend\" was not injected: check your FXML file 'sample.fxml'.";
        assert listFriend !=null : "fx:id=\"listFriend\" was not injected: check your FXML file 'sample.fxml'.";
    }

    public void sendButton (javafx.event.ActionEvent actionEvent){
        chat.getItems().add(person() + " : " + inputTxt.getText());
        inputTxt.setText(" ");
    }

}
