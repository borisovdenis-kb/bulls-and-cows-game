package ru.intodayer.servlets.services;


import ru.intodayer.servlets.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;


public class UserService {
    public User getUser(String username, String password) {
        EntityManager entityManager = Persistence
            .createEntityManagerFactory("bullsAndCows")
            .createEntityManager();

        List res = entityManager.createNamedQuery("User.findOneByUsernameAndPassword")
            .setParameter("username", username)
            .setParameter("password", password)
            .getResultList();

        if (res.isEmpty()) {
            return null;
        }
        return (User) res.get(0);
    }
}
