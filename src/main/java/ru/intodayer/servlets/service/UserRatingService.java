package ru.intodayer.servlets.service;

import ru.intodayer.servlets.entity.UserRating;
import ru.intodayer.servlets.utility.JPAUtility;
import javax.persistence.EntityManager;
import java.util.List;


public class UserRatingService {
    public List<UserRating> getAllUserRatings() {
        EntityManager entityManager = JPAUtility.getEntityManager();
        return entityManager.createNamedQuery("UserRecord.getAllUserRatings").getResultList();
    }
}
