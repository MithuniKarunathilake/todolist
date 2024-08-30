package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.User;
import service.UserService;
import service.impl.UserControllerImpl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public JFXTextField txtAddTask;
    public TableColumn colUncompletedTasks;
    public TableView tblUncompletedTasks;
    public JFXTextField txtSelectedTask;
    public JFXTextField txtDone1;
    public JFXTextField txtDone2;
    public JFXTextField txtDone3;
    public JFXTextField txtDone4;
    public JFXTextField txtDone5;
    public JFXTextField txtDone6;
    public JFXTextField txtDone7;
    public JFXTextField txtDone8;
    public JFXTextField txtDone9;
    public JFXTextField txtDone10;

    private List<User> userList;

    UserService service = new UserControllerImpl();

    public void btnViewOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/view_history.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnAddOnAction(ActionEvent actionEvent) {

//        User user = new User(
//                txtAddTask.getText());
//        System.out.println(user);

        User user = new User(txtAddTask.getText(),txtSelectedTask.getText());//
        userList.add(user);//

        loadTable();
        clearText();
    }
    public void clearText(){
        txtAddTask.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        colUncompletedTasks.setCellValueFactory(new PropertyValueFactory<>("uncompletedTasks"));
//
//        tblUncompletedTasks.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
//            setTextToValues((User) newValue);
//        }));

        userList = DBConnection.getInstance().getConnection();

        colUncompletedTasks.setCellValueFactory(new PropertyValueFactory<>("uncompletedTasks"));
        loadTable();
        tblUncompletedTasks.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->{
            populateFields((User) newValue);
        }
        ));

    }

    private void populateFields(User user){
        txtSelectedTask.setText(user.getUncompletedTasks());
    }

    public void loadTable(){
//        ObservableList<User> userObservableList = service.getAll();
//        tblUncompletedTasks.setItems(userObservableList);

        tblUncompletedTasks.setItems(FXCollections.observableArrayList(userList));
    }

    public void btnOnActionDone1(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone1.setText(text);
    }

    public void btnOnActionDone2(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone2.setText(text);
    }

    public void btnOnActionDone3(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone3.setText(text);
    }

    public void btnOnActionDone4(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone4.setText(text);
    }

    public void btnOnActionDone5(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone5.setText(text);
    }

    public void btnOnActionDone6(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone6.setText(text);
    }

    public void btnOnActionDone7(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone7.setText(text);
    }

    public void btnOnActionDone8(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone8.setText(text);
    }

    public void btnOnActionDone9(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone9.setText(text);
    }

    public void btnOnActionDone10(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);

        txtDone10.setText(text);
    }

    public void btnOnActionDone11(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);
    }

    public void btnOnActionDone12(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);
    }

    public void btnOnActionDone13(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);
    }


    public void btnOnActionDone14(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);
    }

    public void btnOnActionDone15(ActionEvent actionEvent) {
        String text = txtSelectedTask.getText();
        System.out.println(text);
    }
}
