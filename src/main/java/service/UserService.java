package service;

import javafx.collections.ObservableList;
import model.User;

public interface UserService {
    ObservableList<User> getAll();

    boolean addTask(User user);
}
