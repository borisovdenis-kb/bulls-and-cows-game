package ru.intodayer.servlets.service;

import ru.intodayer.servlets.entity.User;
import ru.intodayer.servlets.utility.JPAUtility;
import javax.persistence.EntityManager;


public class UserAttemptService extends BaseEntityService {
    public Integer getAvgAttemptAmount(User user) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        Double avgAttemptAmount = (Double) entityManager.createNamedQuery("UserAttempt.getAvgAttemptAmount")
            .setParameter("user", user)
            .getSingleResult();
        return avgAttemptAmount.intValue();
    }
}
