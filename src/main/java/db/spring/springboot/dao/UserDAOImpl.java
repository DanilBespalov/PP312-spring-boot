package db.spring.springboot.dao;

import db.spring.springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> userTypedQuery = entityManager.createQuery("from User", User.class);
        return userTypedQuery.getResultList();
    }

    @Override
    public User showUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User update(User user, int id) {
        User userToUpdate = showUserByID(id);
        userToUpdate.setId(user.getId());
        userToUpdate.setName(Objects.requireNonNull(user.getName(),"Cant be null"));
        userToUpdate.setSurname(Objects.requireNonNull(user.getSurname(), "Cant be null"));
        return entityManager.merge(userToUpdate);

    }

    @Override
    public void delete(int id) {
        User userToDelete = showUserByID(id);
        entityManager.remove(userToDelete);
    }
}
