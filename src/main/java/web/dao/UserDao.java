package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void saveUser(User user);

    User getUser(int id);

    User update(User updatedUser);

    void deleteUser(User user);

    void deleteById(int id);
}
