package ru.intodayer.servlets.service;

import ru.intodayer.servlets.entity.User;
import ru.intodayer.servlets.entity.UserRating;
import ru.intodayer.servlets.utility.JPAUtility;
import javax.persistence.EntityManager;
import java.util.List;


public class UserRatingService extends BaseEntityService {
//    public void save(UserRating userRating) {
//        EntityManager entityManager = JPAUtility.getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(userRating);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }

    public List<UserRating> getAllUserRatings() {
        EntityManager entityManager = JPAUtility.getEntityManager();
        return entityManager.createNamedQuery("UserRating.getAllUserRatings").getResultList();
    }

    public UserRating getUserRatingByUser(User user) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        return (UserRating) entityManager.createNamedQuery("UserRating.getUserRatingByUser")
            .setParameter("user", user)
            .getSingleResult();
    }

    public void updateAvgAttemptAmount(User user, Integer newAvg) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        /* Duplication of code is necessary because if we will get UserRating entity
         * in any outer scope this entity will not be in persistence context.
         * */
        UserRating userRating = (UserRating) entityManager.createNamedQuery("UserRating.getUserRatingByUser")
            .setParameter("user", user)
            .getSingleResult();

        entityManager.getTransaction().begin();
        userRating.setAvgAttemptAmount(newAvg);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
