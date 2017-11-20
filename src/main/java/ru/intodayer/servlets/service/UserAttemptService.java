package ru.intodayer.servlets.service;

import ru.intodayer.servlets.entity.UserAttempt;
import ru.intodayer.servlets.utility.JPAUtility;
import javax.persistence.EntityManager;


public class UserAttemptService {
    public void save(UserAttempt userAttempt) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(userAttempt);
        entityManager.getTransaction().commit();
        entityManager.close();
//        JPAUtility.close();
    }
}
