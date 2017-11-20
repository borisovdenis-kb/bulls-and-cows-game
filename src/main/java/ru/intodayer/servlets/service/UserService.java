package ru.intodayer.servlets.service;

import ru.intodayer.servlets.entity.User;
import ru.intodayer.servlets.utility.JPAUtility;
import javax.persistence.EntityManager;
import java.util.List;


public class UserService extends BaseEntityService {
    public User getUserByUsernameAndPassword(String username, String password) {
        EntityManager entityManager = JPAUtility.getEntityManager();

        List res = entityManager.createNamedQuery("User.getUserByUsernameAndPassword")
            .setParameter("username", username)
            .setParameter("password", password)
            .getResultList();

        if (res.isEmpty()) {
            return null;
        }
        return (User) res.get(0);
    }
}
