package db.spring.springboot.service;

import db.spring.springboot.dao.UserDAO;
import db.spring.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User showUserByID(int id) {
        return userDAO.showUserByID(id);
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public User update(User user, int id) {

        return userDAO.update(user, id);

    }

    @Override
    @Transactional
    public void delete(int id) {

        userDAO.delete(id);
    }

}
