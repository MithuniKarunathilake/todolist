package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;
import service.UserService;
import service.impl.UserControllerImpl;

import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class ViewHistoryController implements Initializable{
    public TableView tblViewTasks;
    public TableColumn colTask;
    public TableColumn colStatus;

    private List<User> userList;

    UserService service = new UserControllerImpl();

    public void btnReloadOnAction(ActionEvent actionEvent) {
        loadTable();
        addData();

    }

    private void addData(){
        userList.add(new User("Water Plants","Feed the pets"));
        userList.add(new User("Study","Listen to music"));
        userList.add(new User("Dance",""));

    }

    private void loadTable(){
        ObservableList<User> customerObservableList =service.getAll();
        tblViewTasks.setItems(customerObservableList);

        tblViewTasks.setItems(FXCollections.observableArrayList(userList));

        try {
            String SQL = "SELECT *FROM view";
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "12345");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                User customer = new User(
                        resultSet.getString("completedTasks"),
                        resultSet.getString("uncompletedTasks")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userList = DBConnection.getInstance().getConnection();
        colTask.setCellValueFactory(new PropertyValueFactory<>("completedTasks"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("umcompletedTasks"));

        loadTable();
        addData();
    }
}
