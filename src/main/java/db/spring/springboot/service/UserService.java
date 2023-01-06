package db.spring.springboot.service;

import db.spring.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User showUserByID(int id);
    void add(User user);

    User update(User user, int id);

    void delete(int id);
}
