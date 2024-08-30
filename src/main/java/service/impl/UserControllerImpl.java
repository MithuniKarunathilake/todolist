package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.User;
import service.UserService;

import java.sql.*;

public class UserControllerImpl implements UserService {
    @Override
    public ObservableList<User> getAll() {
        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        try {
            String SQL = "SELECT * FROM UncompletedTasks";
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDoList", "root", "12345");
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
//                        resultSet.getString("Uncompleted_tasks"),
//                        resultSet.getString("Completed_tasks")
                );
                userObservableList.add(user);
            }
            return userObservableList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public boolean addTask(User user){
        try {
            String SQL = "INSERT INTO UncompletedTasks VALUES(?,?)";
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDoList", "root", "12345");
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setObject(1,user.getUncompletedTasks());
            return statement.executeUpdate()>0;

        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION.ERROR).show();
        }
        return false;
    }
}
